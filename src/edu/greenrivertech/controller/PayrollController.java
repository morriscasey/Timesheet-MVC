package edu.greenrivertech.controller;

import edu.greenrivertech.model.IPayrollModel;
import edu.greenrivertech.payroll.PayrollCalculations;
import edu.greenrivertech.view.IPayrollView;
/**
 * Payroll Controller manages how timesheet data received, where the calculations are processed, 
 * and how to display content
 * 
 * @author Casey Morris
 *
 */
public class PayrollController
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
	public PayrollController(IPayrollModel model, IPayrollView view){
		this.model = model;
		this.view = view;
		this.overtimeCalculation = new PayrollCalculations();
	}
	
	/**
	 * Starts the process of displaying prompt, loading data, calculating, and displaying
	 */
	public void start(){
		view.displayInput();
		// Loads times sheet from model interface. In this example using file input
		model.loadTimesheets();
		// Calls PayrollCalculations to process overtime
		overtimeCalculation.calculateOvertime(model.getTimesheets());
		
	    // Displays calculated pay based on the timesheets provided
		view.viewTimesheetTotal(model.getTimesheets());
		   
	}
}
