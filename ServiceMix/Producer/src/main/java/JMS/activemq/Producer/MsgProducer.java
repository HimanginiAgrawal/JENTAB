package JMS.activemq.Producer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MsgProducer {
	/* setup connection to the ActiveMq broker */
	private final String connUri = "tcp://localhost:61616";
	private ActiveMQConnectionFactory connFactory;
	private Connection conn;
	private Session sess;
	private Destination dest;

	public static void main(String[] args) {
		MsgProducer producer = new MsgProducer();
		System.out.println("\n Starting Producer \n");
		try {

			producer.connFactory = new ActiveMQConnectionFactory(producer.connUri);
			/*
			 * create JMS connection object by invoking the createConnection API.
			 */
			producer.conn = producer.connFactory.createConnection();
			producer.sess = producer.conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			producer.dest = producer.sess.createQueue("MSG.Queue");

			MessageProducer msgProducer = producer.sess.createProducer(producer.dest);

			/*
			 * create 1000 TextMessage objects and assign unique Msg ID and a simple message
			 * body.
			 */
			for (int i = 0; i < 1000; ++i) {
				TextMessage msg = producer.sess.createTextMessage("Msg number: " + i);
				msg.setIntProperty("MsgID", i);
				msgProducer.send(msg);
				System.out.println("Producer sent Message(" + i + ") successfully");
			}

			msgProducer.close();

			/*
			 * Close the connection object that was opened earlier
			 */
			if (producer.conn != null) {
				producer.conn.close();
			}

		} catch (Exception e) {
			System.out.println("Caught Exception: " + e.getMessage());
		}
		System.out.println("Finished sending messages from Producer.\n");

	}

}
