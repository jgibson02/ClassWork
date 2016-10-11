/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Homework1;

import java.util.Date;

/**
 *
 * @author John
 */
public class DateDisplay {
    public static void main(String[] args) {
        Date today = new Date();
        String s = today.toString();
        System.out.println(s);
        
        System.out.println("The time is now "  + s.substring(11, 19) + ".");
        
        long x = today.getTime();
        long secs = x / 1000;
        long hrs = secs / 3600;
        long days = hrs / 24;
        
        System.out.println(days + " days since January 1, 1970.");
    }
}
