package cinema;

import java.util.Scanner;

public class StageFour {
    private static Scanner sc = new Scanner(System.in);
    static char[][] salon;
    static int totalRow;
    static int numberOfSeats;
    static int r;
    static int s;

    public static void main(String[] args) {
        init();
        showMenu();

    }

    public static void init() {
        System.out.println("Enter the number of rows:");
        totalRow = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the number of seats in each row:");
        numberOfSeats = sc.nextInt();
        sc.nextLine();
        salon = new char[totalRow][numberOfSeats];
        for (int i=0; i<totalRow ;i++) {
            for(int j=0;j <numberOfSeats; j++) {
                salon[i][j] = 'S';

            }

        }

    }
    public static void showMenu() {
        boolean quit = false;

        while (!quit) {
            System.out.println("1. Show the seats " +
                    "\n2. Buy a ticket" +
                    "\n0. Exit");
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 1:
                    showTheSeats();
                    break;

                case 2:
                    buyATicket();
                    break;
                case 0:
                    quit = true;
                    break;

            }

        }

    }

    public static void showTheSeats() {
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
                        System.out.print(salon[i-1][j-1] + " ");
                    }
                }

            }
            System.out.println();
        }
        System.out.println();
    }

    public static void buyATicket() {
        System.out.println("Enter a row number:");
        r = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter a seat number in that row:");
        s = sc.nextInt();
        sc.nextLine();
        int totalSeats = totalRow * numberOfSeats;
        int ticketPrice;
        if (totalSeats <= 60) {
            ticketPrice = 10;
        } else if (r < (totalRow - (totalRow / 2))) {
            ticketPrice = 10;
        } else {
            ticketPrice = 8;
        }
        System.out.println();
        System.out.println("Ticket price: $" + ticketPrice);
        System.out.println();
        allocateSeat(r,s);

    }

    public static boolean allocateSeat(int row, int seat) {
        salon[row-1][seat-1] = 'B';

        return true;

    }
}

