package javaReviewAssignment;

public class Calendar {
	private static final int MAXEVENTS = 4;
	private Event[] events = new Event[MAXEVENTS];
	private int numEvents;

	public boolean addEvent(Event e) {
		if (numEvents == MAXEVENTS) {
			return false;
		} else {
			for(int i = 0; i <events.length; i++) {
				if(events[i] == null) {
					events[i] = e;
					numEvents++;
					break;					
				}
			}
			return true;
		}
	}

	public int findEvent(Event e) {
		if (e == null) {
			return -1;
		}
		for (int i = 0; i < events.length; i++) {
			if (e.equals(events[i])) {
				return i;
			}
		}
		return -1;
	}

	public boolean removeEvent(Event e) {
		int removedIndex = findEvent(e);
		if (removedIndex > -1) {
			events[removedIndex] = null;
			numEvents--;
			return true;
		}
		return false;
	}

	public void dump() {
//		System.out.print(events);
		for(int i = 0; i <events.length; i++) {
			if(events[i] != null) {
				System.out.println(events[i]);
			}
		}
	}
}