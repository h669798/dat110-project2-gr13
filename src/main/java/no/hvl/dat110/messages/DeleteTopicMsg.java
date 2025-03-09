package no.hvl.dat110.messages;

public class DeleteTopicMsg extends Message {

	// message sent from client to create topic on the broker
	
	private String topic;
	

    @Override
	public String toString() {
		return "DeleteTopicMsg [topic=" + topic + "," + super.toString() + "]";
	}


	public DeleteTopicMsg(String user, String topic) {
    	super(MessageType.DELETETOPIC,user);
    	this.setTopic(topic);

    }


	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}
    
    


}
