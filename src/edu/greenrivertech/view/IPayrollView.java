package edu.greenrivertech.view;

import java.util.Collection;

import edu.greenrivertech.entities.Timesheet;
/**
 * Interface that allows a controller to replace view based on content wanting to display
 * @author Casey Morris
 *
 */
public interface IPayrollView
{
	/**
	 * Calls showSingleTimesheet looping through a Collection of timesheets
	 * @param timeSheets
	 */
	public void viewTimesheetTotal(Collection<Timesheet> timeSheets);
	/**
	 * Displays content and format for a single timesheet
	 * @param singleTimesheet
	 */
	public void showSingleTimesheet(Timesheet singleTimesheet);
	/**
	 * Displays content before a prompting or at launch of program
	 */
	public void displayInput();
	/**
	 * Used to display boolean values
	 * @param assertEquals
	 */
	public void displayPassed(boolean assertEquals);
	
}
