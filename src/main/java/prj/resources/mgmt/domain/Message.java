package prj.resources.mgmt.domain;

public class Message {
	public static final int READ = 1;
	public static final int UNREAD = 0;
	
	private int id;
	private String toUserName;
	private String fromUserName;
	private String subject;
	private String message;
	private int status = UNREAD;
	
	public int getId() {
		return id;
	}
	
	public String getToUserName() {
		return toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public String getSubject() {
		return subject;
	}
	public String getMessage() {
		return message;
	}
	public int getStatus() {
		return status;
	}
	
	public Message(MessageBuilder builder) {
		this.id = builder.id;
		this.toUserName = builder.toUserName;
		this.fromUserName = builder.fromUserName;
		this.subject = builder.subject;
		this.message = builder.message;
		this.status = builder.status;
	}
	
	public static class MessageBuilder {
		private int id;
		private String toUserName;
		private String fromUserName;
		private String subject;
		private String message;
		private int status;
		
		public MessageBuilder id(int value) {
			this.id = value;
			return this;
		}
		
		public MessageBuilder toUserName(String value) {
			this.toUserName = value;
			return this;
		}
		
		public MessageBuilder fromUserName(String value) {
			this.fromUserName = value;
			return this;
		}
		
		public MessageBuilder subject(String value) {
			this.subject = value;
			return this;
		}
		
		public MessageBuilder message(String value) {
			this.message = value;
			return this;
		}
		
		
		public MessageBuilder status(int value) {
			this.status = value;
			return this;
		}
		
		public Message build() {
			return new Message(this);
		}
		
	}
	
	
}
