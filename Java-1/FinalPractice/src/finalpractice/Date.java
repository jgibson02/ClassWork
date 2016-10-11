package Date;

import java.util.GregorianCalendar;

/**
 * A date in the Gregorian calendar.
 * 
 * @author Austin Myers
 */
public class Date {
    private int day;
    private int month;
    private int year;
    
    /**
     * Initializes this date to the current date.
     */
    public Date() {
        GregorianCalendar cal = new GregorianCalendar();
        this.month = cal.get(GregorianCalendar.MONTH) + 1;
        this.day = cal.get(GregorianCalendar.DAY_OF_MONTH);
        this.year = cal.get(GregorianCalendar.YEAR);
    }
    
    /**
     * Initializes this date with a given month, day and year.
     * @param day
     * @param month
     * @param year 
     */
    public Date(int month, int day, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        
        if (month < 1 || month > 12 || !isValidDay() || year < 1582){
            throw new RuntimeException("Invalid Date");
        }
    }
    
    /**
     * Tells if the day given is valid
     * @return true if the day is valid.
     */
    private boolean isValidDay() {
        if (day < 1 || day > 31)
            return false;
        
        //Deal with February here
        if (month == 2 && isLeapYear()) 
            return day <= 29;
        
        //In a non-leap year, Februay has but 28 days
        if (month == 2) 
            return day <=28;
        
        //some months have 30 days and others have 31
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return day <= 30;
        
            return day <= 31;
    }
    
    /**
     * Decides if this year is a leap year
     * @return true if it is a leap year
     */
    public boolean isLeapYear() {
       // a leap year is one that is divisible by 400, Or divisible by 4 and 
       // not divisible by 400
        
        boolean divBy400 = (year % 400 == 0);
        boolean divBy4 = (year % 4 == 0);
        boolean divBy100 = (year % 100 == 0);
        
        return divBy400 || (divBy4 && !divBy100);
    }
    
    /**
     * Advances this date into the future
     * @param n the number of days to go in the future
     */
    public void tick(int n){
        for (int i = 0; i < n; i++) {
            tick();
        }
    }
    /**
     * advance this date one day into the future.
     */
    public void tick() {
        day++;
        if(!isValidDay()) {
            day = 1;
            month++;
        }
        
        if(month > 12){
            month =1;
            year++;
        }
    }
    
    /**
     * Gets a string description of this date
     * @return in format Friday, January 23rd, 2021
     */
    @Override 
    public String toString() {
        return getDayOfWeek() + ", " + getNameOfMonth() + " " + day + 
                getOrdinal() + ", " + year;
    }

    /**
     * Gets the day of the week.
     * @return the day of the week
     */
    private String getDayOfWeek() {
        // For Zeller's congruence, January and February are counted as months
        // 13 and 14 of the previous year. We calculate three values (a, b, c)
        // that depend on the date and are used by the congruence to detemine 
        // the day of the week.
        int a = month;
        if (month < 3) {
            a = month + 12;
            year--;
        }
        int b = year % 100;
        int c = year / 100;

        // Zeller's Congruence
        int x = (day + 26 * (a + 1) / 10 + b + b / 4 + c / 4 + 5 * c) % 7;

        if (x == 0) {
            return "Saturday";
        } else if (x == 1) {
            return "Sunday";
        } else if (x == 2) {
            return "Monday";
        } else if (x == 3) {
            return "Tuesday";
        } else if (x == 4) {
            return "Wednesday";
        } else if (x == 5) {
            return "Thursday";
        } else if (x == 6) {
            return "Friday";
        }

        return null; // unreachable
    }
    /**
     * Gets the English name of the month.
     * @return the name of the month
     */
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

    /**
     * Gets the ordinal number of the day.
     * @return the ordinal number of the day
     */
    private String getOrdinal() {
        if (day == 1 || day == 21 || day == 31)
            return "st";
        if (day == 2 || day == 22)
            return "nd";
        if (day == 3 || day == 23)
            return "rd";
        return "th";
    }
}
