package edu.greenrivertech.payroll;

import java.util.List;

import edu.greenrivertech.entities.DaysOfWeek;
import edu.greenrivertech.entities.Timesheet;

public class PayrollCalculations
{
	
	// Constants
	private final int DAILYHOURS = 8;
	private final int HOURLYBASEPAY = 10;
	private final int HOURLYOVERTIMEPAY = 2;
	private final int WEEKLYOVERTIMEPAY = 4;
	private final double TIMEANDHALF = 1.5;
	private final double DOUBLETIME = 2.0;
	
	public PayrollCalculations(){
		//Intentionally left empty
	}
	/**
	 * Checks if any hours reported for specific day
	 * @param currentTimesheet
	 * @param currentDay
	 * @return
	 */
	private double calcBaseTime(Timesheet currentTimesheet, DaysOfWeek currentDay){
		// Checks if worked and calculates base pay
        if(currentTimesheet.getHours(currentDay.ordinal()) > 0){
            return(currentTimesheet.getHours(currentDay.ordinal())*HOURLYBASEPAY);
        } else {
        	return 0.0;
        }
	}
	/**
	 * Checks if hours over standard daily required hours for specific day. If over the standard required time,
	 * then any additional hour pay higher than base pay. See constant HOURLYOVERTIMEPAY for amount.
	 * @param currentTimesheet
	 * @param currentDay
	 * @return
	 */
	private double calcHourlyOvertime(Timesheet currentTimesheet, DaysOfWeek currentDay){
        if(currentTimesheet.getHours(currentDay.ordinal())> DAILYHOURS)
        {
            return((currentTimesheet.getHours(currentDay.ordinal()) - DAILYHOURS) * HOURLYOVERTIMEPAY);
        }else{
        	return 0.0;
        }
	}
	/**
	 * Checks if weekly hours over weekly hours. If over standard time, then any additional hours pay higher. 
	 * See constant WEEKLYOVERTIMEPAY for amount
	 * @param currentTotalHours
	 * @param currentMaxHours
	 * @return
	 */
	private double calcWeeklyOvertime(int currentTotalHours, int currentMaxHours){
			
	       return ((currentTotalHours - currentMaxHours) * WEEKLYOVERTIMEPAY) ;
	}
	
	/**
	 * Calculates a bonus based on day of the week(integer) and bonus amount
	 * @param dayAsOrdinal
	 * @param bonusAmount
	 * @return double
	 */
	private double calcBonus(DaysOfWeek currentday, DaysOfWeek dayOfBonus, double bonusAmount){
        if((currentday).ordinal() == (dayOfBonus).ordinal()){
            return bonusAmount;
        }else{
        	return 1.0;
        }
	}
	/**
	 * Calls private methods and calculates pay based on base pay, over daily, over weekly, and any additional bonuses
	 * @param timeSheets
	 */
	public void calculateOvertime(List<Timesheet> timeSheets){
		// Loops through timesheets loaded
		for(Timesheet singleTimesheet: timeSheets){
			int maxHrs = 40;
			
			// Loops through an enumerator of each day of the week
			for (DaysOfWeek currentDay : DaysOfWeek.values()) {
				// Temporary Variable to store pay while calculating overtime
	            double tempDailyPay = 0;
	               
	            // Determining hours from base pay
	            tempDailyPay += calcBaseTime(singleTimesheet,currentDay);
	               
	            // Add each days hours worked to TotalHours on Timesheet 
	            singleTimesheet.updateExistingTotalHours(singleTimesheet.getHours(currentDay.ordinal()));
	               
	            // Determining hourly overtime
	            tempDailyPay += calcHourlyOvertime(singleTimesheet,currentDay);
	               
		        // Starts with 40 hour and then sets max hours to hours already calculated.
	       	    if(singleTimesheet.getTotalHours() > maxHrs)
	       	    {
	       	    	// Determining weekly overtime
		            tempDailyPay += calcWeeklyOvertime(singleTimesheet.getTotalHours(), maxHrs);
	       	    	
		            // Adjusting the max hour past overtime
	                maxHrs = singleTimesheet.getTotalHours();
	       	    }
	           
	       	    // Calculate Bonus for Sunday
	       	    tempDailyPay *= calcBonus(currentDay, DaysOfWeek.SUNDAY, TIMEANDHALF);
	       	    
	       	    // Calculate Bonus for Sunday
	       	    tempDailyPay *= calcBonus(currentDay, DaysOfWeek.SATURDAY, DOUBLETIME);
	          
	       	    // Add total pay based on day
	       	    singleTimesheet.updateExistingTotalPay(tempDailyPay);
			}
		}
	}	
}
