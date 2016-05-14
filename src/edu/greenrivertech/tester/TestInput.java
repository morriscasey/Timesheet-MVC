package edu.greenrivertech.tester;
/**
 * Enumerator that stores test values for timesheet, total hours expected, and total pay expected.
 * @author Casey Morris
 *
 */
public enum TestInput
{
	ALLZEROS(new int[] {0,0,0,0,0,0,0}, 0, 0.00),
	ALL24HRS(new int[] {24,24,24,24,24,24,24}, 168, 2920.00),
	ONLYWEEKENDS(new int[] {8,0,0,0,0,0,8}, 16, 280.00),
	ORIGINALTEST1(new int[] {0,8,8,8,10,6,0}, 40, 404.00),
	ORIGINALTEST2(new int[] {4,0,0,0,0,6,0}, 10, 120.00),
	ORIGINALTEST3(new int[] {8,7,6,7,8,7,6}, 49, 650.00);
	   

	    private final int[] values;
	    private final int totalHours;
	    private final double totalPay;
	    /**
	     * Initializes Enum content above
	     * @param values
	     * @param totalHours
	     * @param totalPay
	     */
	    private TestInput(int[] values, int totalHours, double totalPay) {
	        this.values = values;
	        this.totalHours = totalHours;
	        this.totalPay = totalPay;
	    }

	    public int[] getValues() {
	        return values;
	    }

	    public int getTotalHours() {
	        return totalHours;
	    }

	    public double getTotalPay(){
	        return totalPay;
	    }
}
