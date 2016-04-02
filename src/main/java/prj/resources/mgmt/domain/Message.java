package prj.resources.mgmt.domain;

import prj.resources.mgmt.domain.Meeting.MeetingBuilder;



public class Message implements Comparable<Message>{
	
	private int id;
	private int parentId;
	private int topicId;
	private String toUserName;
	private String fromUserName;
	private String message;
	private long datetime;
	private int fromStatus;
	private int toStatus;
	private String name;
	
	
	public int compareTo(Message src) {
		if(this.id < src.id)
			return -1;
		else if(this.id > src.id)
			return 1;
		else
			return 0;
	}
	
	public int getParentId() {
		return parentId;
	}
	public int getTopicId() {
		return topicId;
	}
	public int getId() {
		return id;
	}

	public String getToUserName() {
		return toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}

	public String getMessage() {
		return message;
	}
	
	public long getDatetime() {
		return datetime;
	}
	
	public int getFromStatus() {
		return fromStatus;
	}
	public int getToStatus() {
		return toStatus;
	}
	public String getName() {
		return name;
	}
	
	public Message(MessageBuilder builder) {
		this.id = builder.id;
		this.parentId = builder.parentId;
		this.topicId = builder.topicId;
		this.toUserName = builder.toUserName;
		this.fromUserName = builder.fromUserName;
		this.message = builder.message;
		this.datetime = builder.datetime;
		this.fromStatus = builder.fromStatus;
		this.toStatus = builder.toStatus;
		this.name = builder.name;
	}
	
	public static class MessageBuilder {
		private int id;
		private int parentId;
		private int topicId;
		private String toUserName;
		private String fromUserName;
		private String message;
		private long datetime;
		private int fromStatus;
		private int toStatus;
		private String name;
		
		public MessageBuilder id(int value) {
			this.id = value;
			return this;
		}
		
		public MessageBuilder name(String value) {
			this.name = value;
			return this;
		}
		public MessageBuilder parentId(int value) {
			this.parentId = value;
			return this;
		}
		
		public MessageBuilder topicId(int value) {
			this.topicId = value;
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
		

		
		public MessageBuilder message(String value) {
			this.message = value;
			return this;
		}
		
		public MessageBuilder dateTime(long value) {
			this.datetime = value;
			return this;
		}
		public MessageBuilder fromStatus(int value) {
			this.fromStatus = value;
			return this;
		}
		
		public MessageBuilder toStatus(int value) {
			this.toStatus = value;
			return this;
		}
		
		
		public Message build() {
			return new Message(this);
		}
		
	}
	
	
}
