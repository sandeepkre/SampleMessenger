package org.sandy.jersy.SampleMessenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.sandy.jersy.SampleMessenger.database.DatabaseClass;
import org.sandy.jersy.SampleMessenger.model.Messages;

public class MessageService {

	private Map<Long, Messages> messages = DatabaseClass.getMessages();

	public MessageService() {
		messages.put(1L, new Messages(1, "Hello World", "sandeep"));
		messages.put(2L, new Messages(2, "Hello Jersey", "koushik"));
		messages.put(3L, new Messages(3, "Hello Everyone", "everyone"));
	}

	public List<Messages> getAllMessages() {
		return new ArrayList<Messages>(messages.values());
	}

	public List<Messages> getAllMessagesForYear(int year) {
		List<Messages> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Messages message : messages.values()) {
			cal.setTime(message.getCreated());
			if (cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}

	public List<Messages> getAllMessagesPaginated(int start, int size) {
		ArrayList<Messages> list = new ArrayList<Messages>(messages.values());
		if (start + size > list.size())
			return new ArrayList<Messages>();
		return list.subList(start, start + size);
	}

	public Messages getMessage(long id) {
		return messages.get(id);
	}

	public Messages addMessage(Messages message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}

	public Messages updateMessage(Messages message) {
		if (message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Messages removeMessage(long id) {
		return messages.remove(id);
	}
}
