package test01;

import java.text.ParseException;
import java.util.Scanner;

import static test01.Funtion.addMonths;
import static test01.Funtion.isValidDate;

public class NewDayMain {
    public static void main(String[] args) throws ParseException {
        String startDate;

        Scanner sc = new Scanner(System.in);
        System.out.println("In put start date and end date with format yyyyMMdd: ");
        startDate = sc.nextLine();

        while (!isValidDate(startDate)) {
            System.out.println("Please input start date format yyyyMMdd again: ");
            startDate = sc.nextLine();
        }

        System.out.println("Input month want to add: ");
        int monthAdd = sc.nextInt();
        addMonths(startDate, monthAdd);

    }

}
