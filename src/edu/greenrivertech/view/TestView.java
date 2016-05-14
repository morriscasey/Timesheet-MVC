package edu.greenrivertech.view;

import java.util.Collection;

import edu.greenrivertech.entities.Timesheet;
/**
 * Displays content based on test model
 * @author Casey Morris
 *
 */
public class TestView implements IPayrollView
{

	@Override
	public void viewTimesheetTotal(Collection<Timesheet> timeSheets)
	{
		for(Timesheet singleTimesheet: timeSheets){
			showSingleTimesheet(singleTimesheet);
		}
		
	}

	@Override
	public void showSingleTimesheet(Timesheet singleTimesheet)
	{	
		System.out.println("Values:" + singleTimesheet.toString());
		System.out.printf("Total Pay: $%.2f\n", singleTimesheet.getTotalPay());
		System.out.println("Total Hours: " + singleTimesheet.getTotalHours());
		
	}

	@Override
	public void displayInput()
	{
		System.out.println("Testing Overtime Entities");
		
	}
	
	public void displayPassed(boolean answer){
		System.out.print("Test: "); 
		if(answer == true){
			System.out.println("PASSED");
		}else{
			System.out.println("FAILED");
		}
		
	}
	
	

}
