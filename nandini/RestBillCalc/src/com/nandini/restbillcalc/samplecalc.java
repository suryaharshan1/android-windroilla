
package com.nandini.restbillcalc;

public class samplecalc 
{
    private double Num = 0;
    
    public samplecalc(double number)
    {
        Num = number;
    }
    
    public static String multNum(double x)
    {
        String re = "";
        
        double num = x * 5;
        
        re = num + "";
        
        return re;
    }
    
    public double multNum2()
    {
        double re = Num * 5;
        
        return re;
    }
}