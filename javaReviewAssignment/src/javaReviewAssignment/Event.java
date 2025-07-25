package javaReviewAssignment;

import java.lang.String;

public class Event {
	private Date date;
	private int start;
	private int end;
	private String description;

	public Event(Date date, int start, int end, String description) throws IllegalArgumentException {
		this.date = date;
		this.start = start;
		this.end = end;
		this.description = description;
		if (start < 0 || start > 23 || end < 0 || end > 23 || end < start) {
			throw new IllegalArgumentException("You must choose valid start and times");
		}
	}

	public Date getDate() {
		return date;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String newDescription) {
		description = newDescription;
	}

	public String toString() {
		return date.toString() + " " + start + "--" + end + ":" + description;
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		} else if (!(object instanceof Event)) {
			return false;
		}

		Event otherEvents = (Event) object;
		Date otherDate = otherEvents.getDate();
		int otherStart = otherEvents.getStart();
		int otherEnd = otherEvents.getEnd();
		String otherDescription = otherEvents.getDescription();

		if (date.equals(otherDate) && description.equals(otherDescription) && start == otherStart && end == otherEnd) {
			return true;
		} else {
			return false;
		}

	}
}