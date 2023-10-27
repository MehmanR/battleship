import java.util.Random;
import java.util.Scanner;

public class GameMap {

    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static int[][] firstMap() {
        int[][] gameMapArr = new int[8][8];
        int k = 1;
        for (int i = 0; i < gameMapArr.length; i++) {
            for (int j = 0; j < gameMapArr.length; j++) {
                gameMapArr[i][j] = k++;
            }
        }
        return gameMapArr;
    }

    public static int[][] addShipToMamp(int[][] arr) {

        for (int l = 1; l <= 3; l++) {
            System.out.println();
            System.out.print("Please choose " + l + ". location of your ship: ");
            int location = scanner.nextInt();
            if (location <= 0 || location > 64) {
                System.out.println("Wrong location");
                l--;
            } else {
                for (int i = 0; i < arr.length; i++) {
                    for (int j = 0; j < arr.length; j++) {
                        if (location == arr[i][j]) {
                            arr[i][j] = 100;
                            System.out.println(l + ". ship added successfully");
                        }
                    }
                }
            }
        }
        return arr;
    }

    public static int[][] addRandomShipToMamp(int[][] arr) {

        for (int l = 1; l <= 3; l++) {
            int location = random.nextInt(64) + 1;

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {
                        if (location == arr[i][j] && arr[i][j] != 100) {
                            arr[i][j] = 777;
                    }if (location == arr[i][j] && arr[i][j]==100){
                            l--;
                    }
                }
            }
        }
        return arr;
    }


    public static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] < 9) {
                    System.out.print("[" + arr[i][j] + "]" + "  ");
                } else {
                    System.out.print("[" + arr[i][j] + "]" + " ");
                }
            }
            System.out.println();
        }
    }

}
