package no.hvl.dat110.iotsystem;

import no.hvl.dat110.client.Client;
import no.hvl.dat110.common.TODO;
import no.hvl.dat110.messagetransport.MessagingClient;
import org.apache.maven.surefire.api.event.StandardStreamOutEvent;

public class TemperatureDevice {

	private static final int COUNT = 10;

	public static void main(String[] args) {

		// simulated / virtual temperature sensor
		TemperatureSensor sn = new TemperatureSensor();

		// TODO - start

		String brokerHost = "localhost";
		int brokerPort = 8080;
		String topic = "temperature";

		// create a client object and use it to
		Client client = new Client("sensor", brokerHost, brokerPort);
		// - connect to the broker - user "sensor" as the username
		client.connect();

		client.createTopic(topic);
		// - publish the temperature(s)
		for (int i = 0; i < COUNT; i++) {
			int temperature = sn.read();
			client.publish(topic, String.valueOf(temperature));
			System.out.println("Published: " + temperature + "°C");

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// - disconnect from the broker
		client.disconnect();

		// TODO - end

		System.out.println("Temperature device stopping ... ");

		

	}
}
