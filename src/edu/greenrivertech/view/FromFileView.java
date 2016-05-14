package edu.greenrivertech.view;

import java.util.Collection;

import edu.greenrivertech.entities.Timesheet;

/**
 * Displays input and out information for time sheet based on reading input from a file.
 * @author Casey Morris
 *
 */
public class FromFileView implements IPayrollView
{
	public void viewTimesheetTotal(Collection<Timesheet> timeSheets){
		for(Timesheet singleTimesheet: timeSheets){
			showSingleTimesheet(singleTimesheet);
		}
	}
	
	public void showSingleTimesheet(Timesheet singleTimesheet)
	{
		System.out.printf("$%.2f\n", singleTimesheet.getTotalPay());
	}
	
	
	public void displayInput(){
		System.out.print("Filename: ");
	}

	@Override
	public void displayPassed(boolean assertEquals)
	{
		//Intentially left blank
		
	}
	
}
