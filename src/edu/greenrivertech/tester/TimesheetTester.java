package edu.greenrivertech.tester;

import java.util.ArrayList;
import java.util.List;

import edu.greenrivertech.entities.Timesheet;
import edu.greenrivertech.model.IPayrollModel;
import edu.greenrivertech.payroll.PayrollCalculations;
import edu.greenrivertech.view.IPayrollView;
/**
 * This is a tester that connect a test model, test view, and payrollcalculations together.
 * When execute start method, the test loads common cases and compares it with the expected calculations.
 * Output calls view to display Pass or Fail
 * 
 * @author Casey Morris
 *
 */
public class TimesheetTester
{
	private IPayrollModel model;
	private IPayrollView view;
	private PayrollCalculations overtimeCalculation;
	
	/**
	 * Constructor that initializes model interface, view interface, and payrollcalculations
	 * 
	 * @param model
	 * @param view
	 */
	public TimesheetTester(IPayrollModel model, IPayrollView view){
		this.model = model;
		this.view = view;
		this.overtimeCalculation = new PayrollCalculations();
	}
	   
	/**
	 * Generic method to compare input calculate such has hours or pay with expected outcome.
	 * 
	 * @param inputReturned
	 * @param inputExpected
	 * @return boolean depending on if equals or not
	 */
	public <T> boolean assertEquals(T inputReturned, T inputExpected){
		if(inputReturned.equals(inputExpected)){
			return true;
		}else{
			return false;
		} 
	 }
	/**
	 * Starts the test by loading test examples, calculating their time and pay, then
	 * loops through each case to determine if correct or not
	 */
	public void start(){
		view.displayInput();
		model.loadTimesheets();
		// Calls PayrollCalculations to process overtime
		overtimeCalculation.calculateOvertime(model.getTimesheets());
		// Loops through TestInput enumerator and compares with expected test data. 
		for(TestInput expectedTestValue: TestInput.values()){
			 // Make it easier to read the view methods
			int index = expectedTestValue.ordinal();
			Timesheet singleTimesheet = model.getTimesheets().get(index);
			view.showSingleTimesheet(singleTimesheet);
			view.displayPassed(assertEquals(singleTimesheet.getTotalHours(),expectedTestValue.getTotalHours()));
			view.displayPassed(assertEquals(singleTimesheet.getTotalPay(),expectedTestValue.getTotalPay()));
		 }
	}
}
