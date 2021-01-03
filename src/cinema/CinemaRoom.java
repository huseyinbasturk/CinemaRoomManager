package cinema;

import java.util.Scanner;

public class CinemaRoom {
/*
Description

Running a cinema theatre is not an easy business. To help our friends,
let's add statistics to your program. The stats will show the current income,
total income, the number of available seats, and the percentage of occupancy.

In addition, our friends asked you to take care of a small inconvenience:
it's not good when a user can buy a ticket that has already been purchased by another user. Let's fix this!

Objectives

Now your menu should look like this:

1. Show the seats
2. Buy a ticket
3. Statistics
0. Exit
When the item Statistics is chosen, your program should print the following information:

The number of purchased tickets;
The number of purchased tickets represented as a percentage. Percentages should be rounded to 2 decimal places;
Current income;
Total income that shows how much money the theatre will get if all the tickets are sold.
The rest of the menu items should work the same way as before, except the item Buy a ticket
shouldn't allow a user to buy a ticket that has already been purchased.

If a user chooses an already taken seat, print That ticket has already been purchased! and ask them
to enter different seat coordinates until they pick an available seat.
Of course, you shouldn't allow coordinates that are out of bounds. If this happens, print Wrong input!
 and ask to enter different seat coordinates until the user picks an available seat.
 */
        private static Scanner sc = new Scanner(System.in);
        static char[][] salon;
        static int totalRow;
        static int numberOfSeats;
        static int r;
        static int s;
        static int purchasedTicket;
        static int currentIncome;
        static int totalIncome;
        static int totalSeats;


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
            totalSeats = totalRow * numberOfSeats;
        }
        public static void showMenu() {
            boolean quit = false;

            while (!quit) {
                System.out.println("1. Show the seats " +
                        "\n2. Buy a ticket" +
                        "\n3. Statistics" +
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

                    case 3 :
                        statistics();
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
            do {
                System.out.println("Enter a row number:");
                r = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter a seat number in that row:");
                s = sc.nextInt();
                sc.nextLine();

            }while (!checkSeats(r,s));

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
            currentIncome += ticketPrice;
            allocateSeat(r,s);

        }

        public static void allocateSeat(int row, int seat) {
            salon[row-1][seat-1] = 'B';
            purchasedTicket++;

        }

        public static void statistics() {
            System.out.println("Number of purchased tickets: " + purchasedTicket);
            double percentage = calculatePercentage();
            System.out.println("Percentage: " + String.format("%.2f", percentage ) + "%");
            System.out.println("Current income: $" + currentIncome);
            System.out.println("Total income: $" + calculateTotalIncome());


        }

        public static int calculateTotalIncome() {
            if (totalSeats < 60) {
                totalIncome = 10 * totalSeats;
            } else {
                totalIncome = (10 * (totalRow / 2)*numberOfSeats) + (8 * (totalSeats - (totalRow/2)*numberOfSeats));
            }
            return totalIncome;
        }

        public static double calculatePercentage() {
            double perc;
            if(purchasedTicket == 0) {
                perc =  0;
            } else {
                perc = (purchasedTicket * 100.0f) / totalSeats;
            }
            return perc;
        }

        public static boolean checkSeats(int row, int seat) {

            boolean flag = false;
            if(row>totalRow || seat>numberOfSeats){
                System.out.println("Wrong input!");
            } else if(salon[row-1][seat-1] == 'B') {
                System.out.println("That ticket has already been purchased!");
            } else {
                flag = true;
            }

            return flag;
        }

    }
