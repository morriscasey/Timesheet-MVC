package edu.greenrivertech.model;

import java.util.ArrayList;
import java.util.List;
import edu.greenrivertech.entities.Timesheet;
import edu.greenrivertech.tester.TestInput;

/**
 * Test Model works similar to FromFileModel. The timesheet's values are test cases.
 * These cases are stored as an enumerator and added into the list of timesheets to test.
 * Example: Timesheet[7]= {24,24,24,24,24,24,24}
 * @author Casey Morris
 *
 */
public class TestModel implements IPayrollModel
{
	private List<Timesheet> listOfTimesheetsToTest;
	
	/*
	 * Initializes an array list to store timesheets
	 */
	public TestModel(){
		this.listOfTimesheetsToTest = new ArrayList<Timesheet>();	
	}
	
	@Override
	public List<Timesheet> getTimesheets()
	{
		return listOfTimesheetsToTest;
	}

	@Override
	public void loadTimesheets()
	{
		this.listOfTimesheetsToTest.add(new Timesheet(TestInput.ALLZEROS.getValues()));
		this.listOfTimesheetsToTest.add(new Timesheet(TestInput.ALL24HRS.getValues()));
		this.listOfTimesheetsToTest.add(new Timesheet(TestInput.ONLYWEEKENDS.getValues()));
		this.listOfTimesheetsToTest.add(new Timesheet(TestInput.ORIGINALTEST1.getValues()));
		this.listOfTimesheetsToTest.add(new Timesheet(TestInput.ORIGINALTEST2.getValues()));
		this.listOfTimesheetsToTest.add(new Timesheet(TestInput.ORIGINALTEST3.getValues()));
		
	}

}
