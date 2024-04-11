package org.example;

import java.util.Scanner;

//first of all--welcome message and initialize the scanner for user input
//Then, make them pick between two (or maybe 3) options for what calculator they want
//Do this by making them enter different string inputs for each option
//(M) Mortgage, (C) CD, (A) Annuity
//Then, make functions for each calculation

//Mortgage formula: M = P [ I(1 + I)N ] / [ (1 + I)N − 1]
//User will enter:
//M = Monthly Payment (double)
//P = Principal Amount (double)
//I = Interest Rate (double)
//N = Number Of Payments (Monthly) (int)
//Would display total monthly payment
//Would also display the total interest the user pays over the lifespan of the loan
//Mortgage function would take 3 parameters (P, I, N)
//calculate monthly payment amount by using aforementioned formula
//calculate total interest by multiplying P * I * N
//Print results for both monthly payment amount and total interest rate

//CD formula: IB x (1+ (IR / 365)) ^ 365 x ND
//User will enter:
//IB = Initial balance (double)
//IR = interest rate (double)
//ND = Number of years the cd is held
//This function will take these three things as parameters as well
//NOTE: THIS CALCULATOR COMPOUNDS CD INTEREST DAILY!!
//print results for future value and total interest earned
//for total interest: TI = IB * IR * ND

//Present Value Annuity Formula (will probably give this a shot)
//Present Value (PV) of Annuity = (A ÷ r) (1 – (1 ÷ (1 + r) ^ t))
//A = Annuity Payment (PER MONTH)
//T = Number of Periods (in years)
//R = Yield To Maturity (aka interest rate per year)
//NOTE: CONVERT FROM YEARS TO MONTHS WHEN DOING ANNUITY PAYMENT
//Maybe this will take 4 parameters? (A in months, A in years, T, R)
//Print out results for the present value of annuity

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi lol");
    }
}