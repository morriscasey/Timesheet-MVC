package edu.greenrivertech.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.greenrivertech.entities.Timesheet;

public class FromFileModel implements IPayrollModel
{
	private List<Timesheet> timesheets = new ArrayList<Timesheet>();
	private Scanner console;
	private int amountOfTimesheets = 0;

	public FromFileModel(){
		console = new Scanner(System.in);
	}

	@Override
	public List<Timesheet> getTimesheets()
	{
		return timesheets;
	}

	@Override
	public void loadTimesheets()
	{
	    String name = console.nextLine();
	    File file = new File(name);
	    Scanner fileIn = null;
	    try
	    {
	    	fileIn = new Scanner(file);
	    }
	    catch(FileNotFoundException s)
	    {
	      System.out.println("File does Not Exist Please Try Again: ");
	    }
	    
	    // Reads in rows to determine how many weeks to process
	    amountOfTimesheets = fileIn.nextInt();
        fileIn.nextLine();
       
        for (int i = 0; i < amountOfTimesheets; i++) 
        {
        	Timesheet tempTimesheet = new Timesheet();
        	for (int j = 0; j < 7; j++){
        	tempTimesheet.addHours(j, fileIn.nextInt());
        	}
        	this.timesheets.add(tempTimesheet);
        } 
	}
}
