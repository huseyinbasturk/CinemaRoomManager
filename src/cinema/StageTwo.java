package cinema;

import java.util.Scanner;

public class StageTwo {
    private static Scanner sc;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalIncome;
        int totalSeats;
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the number of seats in each row:");
        int seats = sc.nextInt();
        sc.nextLine();
        totalSeats = rows*seats;
        if (totalSeats < 60) {
            totalIncome = 10 * totalSeats;
        } else {
            totalIncome = (10 * (rows / 2)*seats) + (8 * (totalSeats - (rows/2)*seats));
        }

        System.out.println("Total income:");
        System.out.println("$"+totalIncome);

    }
}
