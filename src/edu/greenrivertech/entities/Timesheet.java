package edu.greenrivertech.entities;

import java.util.Arrays;

/**
 * The class holds hours worked for a week
 * @author Casey Morris
 *
 */
public class Timesheet
{	
	// Total amount of hours
	private int totalHours;
	// Total pay for the week
	private double totalPay;
	
	// 7 days in the week
	private int[] timesheet;   

	// CONST Fields
    private final static int DAYS = 7;

	/**
	 * Constructor for Time Sheet that initializes three private variables timesheet, totalHours, and totalPay
	 */
    public Timesheet(){
    	this.timesheet = new int[DAYS];
    	this.totalHours = 0;
    	this.totalPay = 0.0;
    }
    /**
     * Constructor used for the possibilties of loading timesheets manually. Not used with file reader
     * @param newArray
     */
    public Timesheet(int[] newArray){
    	if(newArray.length <= 7){
    		this.timesheet = newArray;
        	this.totalHours = 0;
        	this.totalPay = 0.0;
    	}else{
    		this.timesheet = new int[DAYS];
        	this.totalHours = 0;
        	this.totalPay = 0.0;
    	}
    }
    
    /**
     * Adds hours for the give day. Days are based on numerical value
     * @param dayToAdd
     * @param hours
     */
    public void addHours(int dayToAdd,int hours){
    	this.timesheet[dayToAdd] = hours;
    }
    
    /**
     * Retrieves hours based on day given
     * @param day
     * @return
     */
    public int getHours(int day){
    	return timesheet[day]; 
    }
    
    /**
     * Retrieves total hours calculated
     * @return int 
     */
    public int getTotalHours(){
    	return this.totalHours;
    }
    
    /**
     * Adds current hours to the total hours for timesheet
     * @param newHours
     */
    public void setTotalHours(int newHours){
    	this.totalHours = newHours;
    }
    /**
     * Get total pay from timesheet
     * @return double
     */
    public double getTotalPay(){
    	return this.totalPay;
    };
    /**
     * Get timesheet as an array
     * @return int[]
     */
    public int[] getTimesheet(){
    	return this.timesheet;
    }
    /**
     * Set total pay manually
     * @param changePay
     */
    public void setTotalPay(double changePay){
    	this.totalPay = changePay;
    }
    
    /**
     * Instead of setting total hours the method adds too the hours 
     * @param additionalHours
     */
    public void updateExistingTotalHours(int additionalHours){
    	this.totalHours += additionalHours;
    }
    /**
     * Instead of setting total pay the method adds too the pay
     * @param additionalPay
     */
    public void updateExistingTotalPay(double additionalPay){
    	this.totalPay += additionalPay;
    }
    /**
     * Returns a string format of timesheet array
     */
    public String toString(){
		return Arrays.toString(this.timesheet);
    	
    }
    
    
    
    
    
    
    
    
    
}
