/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
        int Wanted_year = Integer.parseInt(args[0]);
		// Advances the date and the day-of-the-week from 1/1/1900 till 31/12/1999, inclusive.
	    // Prints each date dd/mm/yyyy in a separate line. If the day is a Sunday, prints "Sunday".
	    // The following variable, used for debugging purposes, counts how many days were advanced so far.
	    int debugDaysCounter = 0; 
	    //// Write the necessary initialization code, and replace the condition
	    //// of the while loop with the necessary condition 

	 	while (dayOfMonth != 31 || month != 12 || year != Wanted_year - 1) {
	 		advance();
	 		debugDaysCounter++;
        }
        dayOfMonth =1;
        month =1;
        while(year != Wanted_year+1){
            if(dayOfWeek == 1)
			{
				System.out.println(dayOfMonth + "/" + month + "/" + Wanted_year + " Sunday");
			}
            else{
                System.out.println(dayOfMonth + "/" + month + "/" + Wanted_year);
            }
			advance();
        }
	 }
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() {

		if(dayOfWeek == 7){
			dayOfWeek = 1;
		}
		else{
			dayOfWeek += 1;
		}

		if(dayOfMonth == nDaysInMonth(month,year)){
			dayOfMonth = 1;
			if(month == 12){
				year += 1;
				month =1;
			}
			else{
				month += 1;
			}
			nDaysInMonth = nDaysInMonth(month,year);
		}
		else{
			dayOfMonth += 1;
		}

	 } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		boolean isLeapYear = false;
		if((year % 400) == 0 || (year % 4 == 0 && year % 100 != 0)){
			isLeapYear = true;
		}
		return isLeapYear;
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	private static int nDaysInMonth(int month, int year) {
		int DaysInMonth = 0;
		if(month == 2){
			if(isLeapYear(year) == true){
				DaysInMonth = 29;
			}
			else{
				DaysInMonth = 28;
			}
		}
		else if(month == 4 || month == 6 || month == 9 || month == 11){
			DaysInMonth = 30;
		}
		else{
			DaysInMonth = 31;
		}
		return DaysInMonth;
	}
}
