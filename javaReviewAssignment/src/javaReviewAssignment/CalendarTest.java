package javaReviewAssignment;

/**
 * A test class for testing "Date" "Event", and "Calendar" classes
 * 
 * @author Elham S.Khorasani (Buxton)
 * @author Brian-Thomas Rogers (Updated and fixed)
 */
public class CalendarTest {
	public static void main(String[] args) {
		System.out.println("**********************Testing the Date class**********************: ");
		System.out.println("Testing the constructor");

		System.out.println("Trying invalid date--year");
		try {
			Date d1 = new Date(2012, 8, 28);
			System.out.println("****Fails-no Exception thrown");
		} catch (Exception e) {
			System.out.println("****passes");
		}
		System.out.println("Trying invalid date--month");
		try {
			Date d1 = new Date(2024, 13, 28);
			System.out.println("****Fails-no Exception thrown");
		} catch (Exception e) {
			System.out.println("****passes");
		}
		System.out.println("Trying invalid date--day");
		try {
			Date d1 = new Date(2024, 12, 0);
			System.out.println("****Fails-no Exception thrown");
		} catch (Exception e) {
			System.out.println("****passes");
		}

		System.out.println("Trying valid date");
		try {
			Date d1 = new Date(2025, 8, 28);
			System.out.println("****passes");
		} catch (Exception e) {
			System.out.println("****Fails-exception thrown");
		}
		System.out.println("Testing the equals method");
		Date d1 = new Date(2024, 8, 28);
		Date d2 = new Date(2024, 8, 28);
		System.out.println("Trying for two equal dates");
		if (d1.equals(d2))
			System.out.println("****passes");
		else
			System.out.println("****Fails");

		System.out.println("Trying for two unequal dates");
		d1 = new Date(2024, 8, 28);
		d2 = new Date(2024, 8, 16);
		if (d1.equals(d2))
			System.out.println("****fails");
		else
			System.out.println("****passes");

		System.out.println("Tesing the compareTo method");
		d1 = new Date(2025, 8, 28);
		d2 = new Date(2024, 8, 16);
		System.out.println("trying for different years");
		if (d1.compareTo(d2) > 0)
			System.out.println("****passes");
		else
			System.out.println("****fails");

		d1 = new Date(2024, 9, 28);
		d2 = new Date(2024, 8, 16);
		System.out.println("trying for equal years, but different months");
		if (d1.compareTo(d2) > 0)
			System.out.println("****passes");
		else
			System.out.println("****fails");

		d1 = new Date(2024, 8, 28);
		d2 = new Date(2024, 8, 16);
		System.out.println("trying for equal years and months, but different days");
		if (d1.compareTo(d2) > 0)
			System.out.println("****passes");
		else
			System.out.println("****fails");

		d1 = new Date(2024, 8, 28);
		d2 = new Date(2024, 8, 28);
		System.out.println("trying for equal years, month, and day");
		if (d1.compareTo(d2) == 0)
			System.out.println("****passes");
		else
			System.out.println("****fails");
        
        int months[] = {2, 4, 6, 9, 11};
        for(int month : months) {
            try {
                d1 = new Date(2025, month, 31);
                System.out.println("****fails: Did not catch improper day value 31 for month value " + month);
            } catch(IllegalArgumentException e) {
                System.out.println("****pass: Month " + month + " properly threw Illegal Argument Exception for a day beyond maximum days.");
            } catch(Exception e) {
                System.out.println("****fails: Some other exception was thrown for invalid days.");
            }
        }
        
        months = new int[] {1, 3, 5, 7, 8, 10, 12};
        for(int month : months) {
            try {
                d1 = new Date(2025, month, 31);
                System.out.println("****pass: Allowed day 31 for " + month);
            } catch(Exception e) {
                System.out.println("****fails: Month " + month + " improperly threw an Exception for a valid day of 31.");
            }
        }
        
        int years[] = {2025, 2027, 2029, 2069, 2073, 2300};
        for(int year : years) {
            try {
                d1 = new Date(year, 2, 29);
                System.out.println("****fails: Did not throw proper exception for day value 29 for non-leap year" + year + " with month value 2 (February)");
            } catch(IllegalArgumentException e) {
                System.out.println("****pass: Threw proper IllegalArgumentException for day value 29 of non-leap year " + year + " for month value 2 (February)");
            } catch(Exception e) {
                System.out.println("****fails: Threw incorrect exception for non-leap year value " + year + " of day value 29 for month value 2 (February)");
            }
        }
        
        years = new int[]{2052, 2052, 2080, 2400, 2460};
        for(int year : years) {
            try {
                d1 = new Date(year, 2, 29);
                System.out.println("****pass: Allowed leap year " + year + " month value 2 (February) to have a day value of 29.");
            } catch (Exception e) {
                System.out.println("****fails: Threw an excption for valid leap year " + year + " with month value 2 (February) and day value 29.");
            }
        }

		/**************************************************************************************************/
		System.out.println("**********************Testing the Event class*****************************");
		System.out.println("Testing the constructor");
		System.out.println("Trying invalid event start greater than end");
        
		d1 = new Date(2024, 8, 28);
		d2 = new Date(2024, 8, 28);
        
		try {
			Event e1 = new Event(d1, 14, 12, "some events");
			System.out.println("****Fails-no Exception thrown");
		} catch (Exception e) {
			System.out.println("****passes");
		}

		System.out.println("Testing the equals methdod");
		Event e1 = new Event(d1, 10, 12, "some events");
		Event e2 = new Event(d1, 10, 12, "some events");
		System.out.println("Trying for two equal events");
		if (e1.equals(e2))
			System.out.println("****passes");
		else
			System.out.println("****Fails");

		System.out.println("Trying for two unequal events");
		e1 = new Event(d1, 10, 12, "event 1");
		e2 = new Event(d1, 12, 14, "event 2");
		if (e1.equals(e2))
			System.out.println("****fails");
		else
			System.out.println("****passes");
		/*****************************************************************************************************/

		System.out.println("******************Testing the Calendar Class********************");
		System.out.println("Trying to add an event to an empty calendar");
		Calendar c = new Calendar();
		c.addEvent(e1);
		System.out.println("Your program should print:\n8/28/2024 10--12:event 1");

		System.out.println("This is what your program printed: ");
		c.dump();

		c.addEvent(e2);

		Event e3 = new Event(d1, 14, 15, "event 3");
		Event e4 = new Event(d2, 14, 15, "event 4");
		c.addEvent(e3);
		c.addEvent(e4);

		System.out.println("Trying to add to a full array");
		Event e5 = new Event(d2, 13, 14, "event 5");
		if (c.addEvent(e5))
			System.out.println("Fails. The arra is full but addEvent returns true");
		else
			System.out.println("Passes. addEvent returns false");

		System.out.println("Trying to find an existing event at the end of the array");
		if (c.findEvent(e4) == 3)
			System.out.println("Passes");
		else
			System.out.println("Failed");
		System.out.println("Trying to find an existing event at the beginning of the array");
		if (c.findEvent(e1) == 0)
			System.out.println("Passes");
		else
			System.out.println("Failed");
		System.out.println("Trying to find a non-existing existing event");
		if (c.findEvent(e5) < 0)
			System.out.println("Passes");
		else
			System.out.println("Failed");

		System.out.println("Trying to remove an existing event");
		if (c.removeEvent(e3))
			System.out.println("Passes");
		else
			System.out.println("Fails");

		System.out.println("tring to remove a non-existing event");
		if (c.removeEvent(e3))
			System.out.println("Fails");
		else
			System.out.println("Passes");

		System.out.println("Testing dump");
		System.out.println("your program should print:");
		System.out.println("8/28/2024 10--12:event 1\n8/28/2024 12--14:event 2\n8/28/2024 14--15:event 4");
		System.out.println("This is what your program printed: ");
		c.dump();

		System.out.println("Adding an event to a non-full calendar:");
		if (c.addEvent(e5))
			System.out.println("Passes");
		else
			System.out.println("Fails");

		System.out.println("Testing dump");
		System.out.println("your program should print:");
		System.out.println(
				"8/28/2024 10--12:event 1\n8/28/2024 12--14:event 2\n8/28/2024 13--14:event 5\n8/28/2024 14--15:event 4");
		System.out.println("This is what your program printed: ");
		c.dump();
	}
}
