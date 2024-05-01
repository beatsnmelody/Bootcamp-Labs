package org.example;

public class MoneyTransfer {

    public static double depositFunction(double depositAmount, double previousBalance){

        double currentBalance = previousBalance + depositAmount;
        return currentBalance;

    }

    public static double withdrawFunction(double withdrawalAmount, double previousBalance){

        double currentBalance = previousBalance - withdrawalAmount;
        return currentBalance;

    }
}
