package no.hvl.dat110.messages;

public class SubscribeMsg extends Message {

	// message sent from client to subscribe on a topic 
	
	private String topic;

    public SubscribeMsg(String user, String topic) {
    	
    	super(MessageType.SUBSCRIBE, user);
    	this.setTopic(topic);

    }

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	@Override
	public String toString() {
		return "SubscribeMsg [topic=" + topic + "," + super.toString() + "]";
	}
		
}
