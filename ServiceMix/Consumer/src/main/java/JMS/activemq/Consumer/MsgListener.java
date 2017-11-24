package JMS.activemq.Consumer;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.jms.Message;
import javax.jms.MessageListener;

public class MsgListener implements MessageListener {
	private final Random msgDelay = new Random();

	/*
	 * MessageListener object in JMS allows receiving and processing messages
	 * asynchronously, these messages are processed in separate thread
	 */
	public void onMessage(Message message) {
		try {
			int msgId = message.getIntProperty("MsgID");
			System.out.println("Consumer received the message: " + msgId);
			TimeUnit.MILLISECONDS.sleep(msgDelay.nextInt(100));
		} catch (Exception e) {
			System.out.println("Caught Exception");
		}
	}

}
