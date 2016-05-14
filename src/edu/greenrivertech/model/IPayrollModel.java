package edu.greenrivertech.model;

import java.util.List;

import edu.greenrivertech.entities.Timesheet;

public interface IPayrollModel
{
	public List<Timesheet> getTimesheets();
	
	public void loadTimesheets();
	
}
