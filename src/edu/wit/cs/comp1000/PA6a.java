package edu.wit.cs.comp1000;
import java.util.Scanner;

/**
 * PA6a
 * @author Miles Macchiaroli
 *
 */
public class PA6a {
	
	/**
	 * Error to output if year is not positive
	 */
	static final String E_YEAR = "The year must be positive!";
	
	/**
	 * Error to output if the day is not between 0 and 6
	 */
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	/**
	 * Determines if an input is a leap year
	 * 
	 * @param year year in question
	 * @return true if a leap year
	 */
	public static boolean isLeapYear(int year) {
		if ((year % 4 == 0)&&(year % 100 != 0)||(year % 400 == 0)) {return true;}// if mod 4 = 0 and mod 100 !=0 OR mod 400 = 0, Return true
		else {return false;}//if remainder not 0, return false
	}
	
	/**
	 * Outputs a month to the console
	 * 
	 * @param month title
	 * @param startDay 0=Sunday ... 6=Saturday
	 * @param numDays number of days in the month
	 * @return day of the week after the last day of the month
	 */
	public static int printMonth(String month, int startDay, int numDays) {
		int lastDay, day, current= 1;
		lastDay = startDay;
		numDays++;//add one to number of days
		System.out.printf("%s%n", month);//Print Month title
		for (day = startDay; day > 0; day--) {System.out.printf("   ");}//if week not complete, Insert 3 spaces for every offset start day
		do {if ((lastDay == 7)&&(current != 1)) {System.out.printf("%n");}if (lastDay == 7){lastDay = 0;}//carriage return when end of week, reset tracker
		if (current < 10) {System.out.printf("  %d", current);}//print 1-9
			else {System.out.printf(" %d", current);}//print 10-31
		current++;//increment counter
		lastDay++;//increment tally
		}while (current != numDays);//while current number does not equal number of days +1
		System.out.printf("%n%n");//Return carriage 
		if (lastDay == 7) {lastDay = 0;}//Ensure return is not out-of-bounds
		return lastDay;//return
	}

	/**
	 * Program execution point:
	 * input year, day of the week (0-6) of january 1
	 * output calendar for that year
	 * 
	 * @param args command-line arguments (ignored)
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);//call scanner
		//VARs
		int year, dow, totalDays, numMonth = 0;//Year, Day of Week, total Days in month, month numerical value
		String month = "";// month string
		//request
		System.out.printf("Enter the year: ");
		year = input.nextInt();
		System.out.printf("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		dow = input.nextInt();
		if (year < 0) {System.out.printf("The year must be positive!%n");}//Check Year pos
		else if ((dow < 0)||(dow > 6)){System.out.printf("The day of January 1st must be between 0 and 6!%n");}//Check days in range
		else {
			//RUN
			do {
			month = calcMonth(numMonth);//Get name of month
			totalDays = calcMonth(month, isLeapYear(year));//Get total days based on month and leap year
			dow = printMonth(month,dow,totalDays);// Request calendar month to print, return last day printed
			numMonth++;//increment month tally
			}while (!month.equals("December"));//stop after December
			
		}
	}
	//Set Month String
	public static String calcMonth(int n) {
		String month = "";
		if (n == 0) {month = "January";}
		else if (n == 1) {month = "February";}
		else if (n == 2) {month = "March";}
		else if (n == 3) {month = "April";}
		else if (n == 4) {month = "May";}
		else if (n == 5) {month = "June";}
		else if (n == 6) {month = "July";}
		else if (n == 7) {month = "August";}
		else if (n == 8) {month = "September";}
		else if (n == 9) {month = "October";}
		else if (n == 10) {month = "November";}
		else if (n == 11) {month = "December";}
		else {System.out.printf("calcMonth: INVALID MONTH CODE");System.exit(0);}
		return month;}
	
	//RETURN # of Days
	public static int calcMonth(String n, boolean loop) {
		int days;
		if ((n.equals("April"))||(n.equals("June"))||(n.equals("September"))||(n.equals("November"))){days = 30;}//Set Days to 30 if select months
		else if ((n.equals("February")&& (loop == true))){days = 29;}//Feb leap year
		else if ((n.equals("February")&& (loop == false))){days = 28;}//Feb no leap year
		else {days = 31;}//Set days to 31
		return days;}

}
