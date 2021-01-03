package cinema;

import java.util.Scanner;

public class StageThree {
    private static Scanner sc;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int totalRow = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = sc.nextInt();
        sc.nextLine();
        System.out.println("Cinema:");
        for (int i = 0; i < totalRow + 1; i++) {
            for (int j = 0; j <= numberOfSeats; j++) {
                if (i == 0) {
                    if (j == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print(" " + j);
                    }

                } else {
                    if (j == 0) {
                        System.out.print(i + " ");
                    } else {
                        System.out.print("S ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Enter a row number:");
        int rowNumber = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = sc.nextInt();
        sc.nextLine();
        int totalSeats = totalRow * numberOfSeats;
        int ticketPrice;
        if (totalSeats <= 60) {
            ticketPrice = 10;
        } else if (rowNumber < (totalRow - (totalRow / 2))) {
            ticketPrice = 10;
        } else {
            ticketPrice = 8;
        }
        System.out.println();
        System.out.println("Ticket price: $" + ticketPrice);
        System.out.println();
        System.out.println("Cinema:");
        for (int i = 0; i < totalRow + 1; i++) {
            for (int j = 0; j <= numberOfSeats; j++) {
                if (i == 0) {
                    if (j == 0) {
                        System.out.print(" ");
                    } else {
                        System.out.print(" " + j);
                    }

                } else if (i == rowNumber && j == seatNumber) {
                    System.out.print("B ");
                } else {
                    if (j == 0) {
                        System.out.print(i + " ");
                    } else {
                        System.out.print("S ");
                    }
                }

            }
            System.out.println();
        }

    }
}