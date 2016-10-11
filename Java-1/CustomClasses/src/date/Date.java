/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package date;

import java.util.GregorianCalendar;

/**
 * 
 * @author jhg95693
 */
public class Date {
    private int day;
    private int month;
    private int year;
    
    public Date() {
        GregorianCalendar cal = new GregorianCalendar();
        this.month = cal.get(GregorianCalendar.MONTH);
        this.day = cal.get(GregorianCalendar.DAY_OF_MONTH);
        this.year = cal.get(GregorianCalendar.YEAR);
    }
    
    /**
     * Initializes this date with a given month, day and year.
     * @param month
     * @param day
     * @param year 
     */
    public Date(int month, int day, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        if (month < 1 || month > 12 || year < 1582 || !isValidDay()) {
            throw new RuntimeException("Invalid Date");
        }
    }
    
    /**
     * Tell if the day of this date is valid.
     * @return true if the day is valid
     */
    private boolean isValidDay() {
        if (day < 1 || day > 31) {
            return false;
        }
        
        // Deal with February 29 here
        if (month == 2 && isLeapYear()) {
            return day <= 29;
        }
        // In a non-leap year, February has only 28 days.
        if (month == 2) {
            return day <= 28;
        }
        
        // Some months have 30 days and others have 31.
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        }
        return true; // the day is already ensured to be greater than 0 and less than 31.
        
    }
    
    /**
     * Decide if this year is a leap year.
     * @return true if this year is a leap year.
     */
    public boolean isLeapYear() {
        // A leap year is one that is divisible by 400.
        // or divisible by 4 and not by 100.
        boolean divBy400 = (year % 400 == 0);
        boolean divBy4 = (year % 4 == 0);
        boolean divBy100 = (year % 100 == 0);
        return divBy400 || (divBy4 && !divBy100);
    }
    
    public void tick(int n) {
        for (int i = 0; i < n; i++) {
            tick();
        }
    }
    
    public void tick() {
        day++;
        if (!isValidDay()) {
            day = 1;
            month++;
            if (month > 12) {
                month = 1;
                year++;
            }
        }
    }
    
    @Override
    public String toString() {
        return getDayOfWeek() + ", " + month + "/" + day + "/" + year;
    }
    
    /**
     * Gets the day of the week.
     * @return the day of the week
     */
    private String getDayOfWeek() {
        //For Zeller's congruence, January and February are counted as months
        // 13 and 14 of the previous year. We calculate three values (a, b, c)
        // that depend on the date and are used by the congruence to determine
        // the day of the week.
        int a = month;
        if (month < 3) {
            a = month + 12;
            year--;
        }
        int b = year % 100;
        int c = year / 100;
        
        //Zeller's congruence
        int x = (day + 26 * (a+1)/10 + b + b/4 + c/4 + 5*c) % 7;
        
        String dayOfWeek = null;
        if (x == 0) {
            dayOfWeek = "Saturday";
        }
        if (x == 1) {
            dayOfWeek = "Sunday";
        }
        if (x == 2) {
            dayOfWeek = "Monday";
        }
        if (x == 3) {
            dayOfWeek = "Tuesday";
        }
        if (x == 4) {
            dayOfWeek = "Wednesday";
        }
        if (x == 5) {
            dayOfWeek = "Thursday";
        }
        if (x == 6) {
            dayOfWeek = "Friday";
        }
        return dayOfWeek;
    }
    
    private String getNameOfMonth() {
        switch (month) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return null; // unreachable
        }
    }
    
    private String getOrdinal() {
        if (day == 1 || day == 21 || day == 31) {
            return "st";
        }
        if (day == 2 || day == 22) {
            return "nd";
        }
        if (day == 3 || day == 23) {
            return "rd";
        }
        return "th";
    }
}
