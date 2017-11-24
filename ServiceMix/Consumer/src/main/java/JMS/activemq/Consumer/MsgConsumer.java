package JMS.activemq.Consumer;

import java.util.concurrent.TimeUnit;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MsgConsumer {
	/* setup connection to the ActiveMq broker */
	private final String connUri = "tcp://localhost:61616?jms.prefetchPolicy.queuePrefetch=1";
	private ActiveMQConnectionFactory connFactory;
	private Connection conn;
	private Session sess;
	private Destination dest;

	public static void main(String[] args) {
		MsgConsumer producer = new MsgConsumer();
		System.out.println("Starting consumer\n");
		try {
			producer.connFactory = new ActiveMQConnectionFactory(producer.connUri);
			/*
			 * create JMS connection object by invoking the createConnection API.
			 */
			producer.conn = producer.connFactory.createConnection();
			producer.conn.start();
			producer.sess = producer.conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			producer.dest = producer.sess.createQueue("MSG.Queue");

			MessageConsumer consumer = producer.sess.createConsumer(producer.dest);
			/* call MsgListener to process the message */
			consumer.setMessageListener(new MsgListener());
			TimeUnit.MINUTES.sleep(5);
			producer.conn.stop();
			consumer.close();

			/*
			 * Close the connection object that was opened earlier
			 */
			if (producer.conn != null) {
				producer.conn.close();
			}

		} catch (Exception e) {
			System.out.println("caught exception: " + e.getMessage());
		}
		System.out.println("Consumer processed messages successfully.\n");

	}
}
