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
//I = Interest Rate (double) (Monthly) Calculated by I / 12 then Monthly I / 100 to convert to decimal
//N = Loan Length (Monthly) (int) (multiply loan length in years by 12)
//Would display total monthly payment
//Would also display the total interest the user pays over the lifespan of the loan
//Mortgage function would take 3 parameters (P, I, N)
//calculate monthly payment amount by using aforementioned formula
//calculate total interest by multiplying M & N and then subtracting by P: (M * N) - P
//Print results for both monthly payment amount and total interest rate

//CD formula: FV = IB x (1+ (IR / 365)) ^ 365 x ND
//User will enter:
//IB = Initial balance (double)
//IR = interest rate (double) (divide rate by 100 to get decimal)
//ND = Number of years the cd is held (int)
//This function will take these three things as parameters as well
//NOTE: THIS CALCULATOR COMPOUNDS CD INTEREST DAILY!!
//print results for future value and total interest earned
//for total interest: TI = FV (Future Value) - IB

//Present Value Annuity Formula (will probably give this a shot)
//Present Value (PV) of Annuity = PMT × [(1 - (1 + r)^(-n)) / r]
//PMT = Annuity Payment (PER MONTH)
//N = Number of Periods (in years, multiply by 12 to get monthly period)
//R = interest rate per year (multiply by 12 then divide by 100)
//NOTE: CONVERT FROM YEARS TO MONTHS WHEN DOING ANNUITY PAYMENT
//will take 3 parameters (A in months, N, R)
//Print out results for the present value of annuity

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to our bank! What is your name?");

        Scanner input = new Scanner(System.in);

        String userName = input.nextLine();

        System.out.printf("So, %s, what calculator do you wish to use? \n", userName);

        System.out.println("""
                Select calculator:
                (MORTGAGE) Monthly Payment Amount
                (CD) Future Value
                (ANNUITY) Present Value
                """);

        String command = input.nextLine();

        switch (command.toUpperCase()){
            case "MORTGAGE":
                //have user input data

                System.out.println("What will be the principal (loan) amount?");
                double mPrincipalAmount = input.nextDouble();

                System.out.println("What will be your yearly interest rate?");
                double mInterestRate = input.nextDouble();

                System.out.println("How many years will you take to pay off this loan?");
                int mTermInYears = input.nextInt();

                //return monthly payment and total interest function

                double mMonthlyPayment = mortgageMonthlyPayment(mPrincipalAmount, mInterestRate, mTermInYears);
                double mTotalInterest = mortgageTotalInterest(mPrincipalAmount, mInterestRate, mTermInYears);

                System.out.println(userName + ", the amount you will pay each month is: " + mMonthlyPayment + ", and your total interest on the loan will be: " + mTotalInterest);

                break;

            case "CD":
                //have user input data

                System.out.println("What will be the initial deposit for the CD?");
                double cdInitialValue = input.nextDouble();

                System.out.println("What will be the annual interest rate?");
                double cdInterestRate = input.nextDouble();

                System.out.println("How many years will this CD be invested for?");
                int cdTermInYears = input.nextInt();

                //return future value of CD and total interest earned function

                double futureValue = cdFutureValue(cdInitialValue, cdInterestRate, cdTermInYears);
                double totalInterestCDResult = cdTotalInterest(cdInitialValue, cdInterestRate, cdTermInYears);

                System.out.println(userName + ", the future value of your CD will be: " + futureValue + ", and your total interest earned will be: " + totalInterestCDResult);

                break;

            case "ANNUITY":
                //have user input data

                System.out.println("What will be the monthly payout amount of the annuity?");
                double aMonthlyPayout = input.nextDouble();

                System.out.println("What will be your expected interest rate?");
                double aInterestRate = input.nextDouble();

                System.out.println("How many years will it take you to pay out?");
                int aTermInYears = input.nextInt();

                //return present value of annuity function

                double presentValue = annuityPresentValue(aMonthlyPayout, aInterestRate, aTermInYears);

                System.out.println(userName + ", the present value of your annuity will be: " + presentValue);

                break;

            default:
                System.out.println("Sorry, that isn't an option.");
                break;
        }

    }

    public static double mortgageMonthlyPayment(double mPrincipalAmount, double mInterestRate, double mTermInYears){

        double mTermInMonths = mTermInYears * 12;
        double mMonthlyInterestRate = (mInterestRate / 12) / 100;

        double mMonthlyPayment = mPrincipalAmount * (((mMonthlyInterestRate * Math.pow(1 + mMonthlyInterestRate, mTermInMonths))) /  ((Math.pow((1 + mMonthlyInterestRate), mTermInMonths)) - 1));

        return mMonthlyPayment;
    }

    public static double mortgageTotalInterest(double mPrincipalAmount, double mInterestRate, double mTermInYears){

        double mTermInMonths = mTermInYears * 12;
        double mMonthlyInterestRate = (mInterestRate / 12) / 100;

        double mMonthlyPayment = mPrincipalAmount * (((mMonthlyInterestRate * Math.pow(1 + mMonthlyInterestRate, mTermInMonths))) /  ((Math.pow((1 + mMonthlyInterestRate), mTermInMonths)) - 1));

        double mTotalInterest = (mMonthlyPayment * mTermInMonths) - mPrincipalAmount;

        return mTotalInterest;
    }

    public static double cdFutureValue(double cdInitialValue, double cdInterestRate, double cdTermInYears){

        double cdDecimalInterestRate = cdInterestRate / 100;

        double futureValue = cdInitialValue * Math.pow((1 + cdDecimalInterestRate / 365), (365 * cdTermInYears));

        return futureValue;
    }

    public static double cdTotalInterest(double cdInitialValue, double cdInterestRate, double cdTermInYears){

        double cdDecimalInterestRate = cdInterestRate / 100;

        double futureValue = cdInitialValue * Math.pow((1 + cdDecimalInterestRate / 365), (365 * cdTermInYears));

        double totalInterestCDResult = futureValue - cdInitialValue;

        return totalInterestCDResult;
    }

    public static double annuityPresentValue(double aMonthlyPayout, double aInterestRate, double aTermInYears){

        double aMonthlyInterestRate = (aInterestRate / 12) / 100;
        double aTotalMonthlyPayments = aTermInYears * 12;

        double onePlusaMonthlyInterestRate = Math.pow(1 + aMonthlyInterestRate, aTotalMonthlyPayments * -1);

        double presentValue = aMonthlyPayout * ((1 - onePlusaMonthlyInterestRate) / aMonthlyInterestRate);

        return presentValue;
    }
}