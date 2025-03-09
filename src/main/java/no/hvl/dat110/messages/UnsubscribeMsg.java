package no.hvl.dat110.messages;

public class UnsubscribeMsg extends Message {

	// message sent from client to unsubscribe on a topic
	private String topic;

    public UnsubscribeMsg(String user, String topic) {

    }

    public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "UnsubscribeMsg [topic=" + topic + "," + super.toString() + "]";
	}
}
