package cinema;

public class StageOne {
    public static void main(String[] args) {
        System.out.println("Cinema:");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <= 8; j++) {
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
    }
}
