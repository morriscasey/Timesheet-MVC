package edu.greenrivertech.tester;

import edu.greenrivertech.model.IPayrollModel;
import edu.greenrivertech.model.TestModel;
import edu.greenrivertech.view.IPayrollView;
import edu.greenrivertech.view.TestView;
/**
 * Used to start test with payrollcalculation logic
 * @author Casey Morris
 *
 */
public class TestDriver
{

	public static void main(String[] args)
	{
		IPayrollModel testModel = new TestModel();
		IPayrollView testView = new TestView();
		TimesheetTester testController = new TimesheetTester(testModel,testView);
		testController.start();
	}

}
