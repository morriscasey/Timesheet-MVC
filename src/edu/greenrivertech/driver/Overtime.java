package edu.greenrivertech.driver;


import java.io.IOException;

import edu.greenrivertech.controller.PayrollController;
import edu.greenrivertech.model.FromFileModel;
import edu.greenrivertech.model.IPayrollModel;
import edu.greenrivertech.view.FromFileView;
import edu.greenrivertech.view.IPayrollView;


/**
 * Driver launches payroll controller, prompts user for a data file, and out puts the amount calculated on each time sheet
 * @author Casey Morris
 *
 */
public class Overtime
{
	
	public static void main(String[] args)throws IOException
	{
		IPayrollModel model = new FromFileModel();
		IPayrollView view = new FromFileView();
		PayrollController controller = new PayrollController(model,view);
		controller.start();

	}

}
