package prj.resources.mgmt.domain.comparators;


import java.util.Comparator;

import prj.resources.mgmt.domain.Message;

public class MessageComparator implements Comparator<Message> {
	
	public int compare(Message a, Message b) {
		if(a.getTopicId() < b.getTopicId())
			return -1;
		else if(a.getTopicId() > b.getTopicId())
			return 1;
		else
			return 0;
	}

}
