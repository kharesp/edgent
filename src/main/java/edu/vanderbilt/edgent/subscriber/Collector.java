package edu.vanderbilt.edgent.subscriber;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.zeromq.ZMQ;
import edu.vanderbilt.edgent.types.DataSample;
import edu.vanderbilt.edgent.types.DataSampleHelper;

public class Collector implements Runnable{
	private static final int POLL_INTERVAL_MILISEC=5000;

	//ZMQ context
	private ZMQ.Context context;
	//ZMQ socket at which Collector thread will receive data
	private ZMQ.Socket collectorSocket;
	//ZMQ socket at which Collector thread will receive control commands
	private ZMQ.Socket controlSocket;
	//ZMQ socket at which Collector thread will send commands to Subscriber container
	private ZMQ.Socket commandSocket;

	private String topicName;
	//Collector thread's socket connector at which it receives data 
	private String collectorConnector;
	//Subscriber container's socket connector at which control commands are issued 
	private String controlConnector;
	//Subscriber container's socket connector at which it receives control commands
	private String subQueueConnector;

	//field for maintaining current number of received sample count
	private int currCount;
	private int sampleCount;
	private Logger logger;

	public Collector(ZMQ.Context context,String topicName,
			String controlConnector,String subQueueConnector,String collectorConnector,
			int sampleCount){
		logger= LogManager.getLogger(this.getClass().getSimpleName());
		this.context=context;
		this.topicName=topicName;
		this.controlConnector=controlConnector;
		this.collectorConnector=collectorConnector;
		this.subQueueConnector=subQueueConnector;
		this.sampleCount=sampleCount;
		currCount=0;
		logger.debug("Collector initialized");
	}

	@Override
	public void run() {
		//create and bind socket endpoint at which Collector thread will receive data
		collectorSocket= context.socket(ZMQ.PULL);
		collectorSocket.bind(collectorConnector);
		
		//connect to Subscriber container's command socket to receive control messages 
		controlSocket= context.socket(ZMQ.SUB);
		controlSocket.connect(controlConnector);
		controlSocket.subscribe(topicName.getBytes());

		//connect to Subscriber container's queue socket to send control messages
		commandSocket= context.socket(ZMQ.PUSH);
		commandSocket.connect(subQueueConnector);

		//create poller to poll for both data and control messages
		ZMQ.Poller poller= context.poller(2);
		poller.register(collectorSocket,ZMQ.Poller.POLLIN);
		poller.register(controlSocket,ZMQ.Poller.POLLIN);

		logger.info("Collector thread:{} will start polling for data",
				Thread.currentThread().getName());
		while(!Thread.currentThread().isInterrupted()){
			poller.poll(POLL_INTERVAL_MILISEC);
			if(poller.pollin(0)){
				DataSample sample = DataSampleHelper.deserialize(collectorSocket.recv());
				currCount++;
				if(currCount%1000==0){
					logger.debug("Collector thread:{} received sample:{}",
							Thread.currentThread().getName(),sample.sampleId());
				}
				if(currCount==sampleCount){
					logger.info("Collector thread:{} received all {} messages",
							Thread.currentThread().getName(),sampleCount);
					commandSocket.send(Subscriber.SUBSCRIBER_EXIT_COMMAND);
					break;
				}
			}
			if(poller.pollin(1)){
				String command= controlSocket.recvStr();
				String[] args= command.split(" ");
				if(args[1]==Subscriber.SUBSCRIBER_EXIT_COMMAND){
					logger.info("Collector thread:{} received command:{}",
							Thread.currentThread().getName(),Subscriber.SUBSCRIBER_EXIT_COMMAND);
					break;
				}
			}
		}
		//set linger to 0
		collectorSocket.setLinger(0);
		controlSocket.setLinger(0);
		commandSocket.setLinger(0);

		//close sockets
		collectorSocket.close();
		controlSocket.close();
		commandSocket.close();
		logger.info("Collector thread:{} has exited",
				Thread.currentThread().getName());
	}
}
