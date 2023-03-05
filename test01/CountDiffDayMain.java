package test01;

import java.util.Scanner;

import static test01.Funtion.countDate;
import static test01.Funtion.isValidDate;

public class CountDiffDayMain {
    public static void main(String[] args) {
        String startDate, endDate;
        Scanner sc = new Scanner(System.in);

        System.out.println("In put start date and end date with format yyyyMMdd: ");
        startDate = sc.nextLine();
        endDate = sc.nextLine();

        while (!isValidDate(startDate)) {
            System.out.println("Please input start date format yyyyMMdd again: ");
            startDate = sc.nextLine();
        }

        while (!isValidDate(endDate)) {
            System.out.println("Please input end  date format yyyyMMdd again:");
            endDate = sc.nextLine();
        }
        countDate(startDate,endDate);
    }
}
