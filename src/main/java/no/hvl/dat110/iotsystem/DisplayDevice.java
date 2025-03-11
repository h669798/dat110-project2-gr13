package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messages.PublishMsg;
import no.hvl.dat110.common.TODO;

import java.security.PublicKey;

public class DisplayDevice {
	
	private static final int COUNT = 10;
		
	public static void main (String[] args) {
		
		System.out.println("Display starting ...");
		
		// TODO - START

		String brokerHost = "localhost";
		int brokerPort = 8080;
		String topic = "temperature";

		// create a client object and use it to
		Client client = new Client("display", brokerHost, brokerPort);
		// - connect to the broker - use "display" as the username
		client.connect();
		// - create the temperature topic on the broker
		client.createTopic(topic);
		// - subscribe to the topic
		client.subscribe(topic);
		// - receive messages on the topic
		for (int i = 0; i < COUNT; i++) {
			Message msg = client.receive();

			if (msg instanceof PublishMsg) {
				System.out.println("Received: " + ((PublishMsg) msg).getMessage());
			} else {
				System.out.println("No message received");
			}
		}
		// - unsubscribe from the topic
		client.unsubscribe(topic);
		// - disconnect from the broker
		client.disconnect();
		
		// TODO - END
		
		System.out.println("Display stopping ... ");
		
		throw new UnsupportedOperationException(TODO.method());
		
	}
}
