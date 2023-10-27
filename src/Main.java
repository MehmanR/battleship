import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("||||||||||||||||||||- BATTLESHIP -||||||||||||||||||||");
        System.out.println();
        System.out.print("Please enter name : ");
        String name = scanner.nextLine();
        System.out.println(name.toUpperCase() + ", Welcome to game the BattleShip -) ");
        System.out.println();

        GameMap.printArr(GameMap.firstMap());
        int[][] ints = GameMap.addShipToMamp(GameMap.firstMap());

        int[][] finalMap = GameMap.addRandomShipToMamp(ints);
        System.out.println();

        for (int i = 3; i >= 1; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("\rGame start in " + i + " second");
        }
        System.out.println();


        ArrayList<Integer> battle = new ArrayList<>();
        for (int i = 0; i < finalMap.length; i++) {
            for (int j = 0; j < finalMap.length; j++) {
                battle.add(finalMap[i][j]);
            }
        }
//        System.out.println(battle); // Burani sil


        boolean hasShip = true;
        int countEnemyShip = 0;
        int counMyShip = 0;

        while (hasShip) {

            System.out.println("Choose location to ATTACK");
            int attackLocation = scanner.nextInt();

            if (battle.get(attackLocation - 1) != 100) {

                if (battle.get(attackLocation - 1) == 777) {
                    System.out.println("Enemy's ship founded");
                    battle.remove(attackLocation - 1);
                    battle.add(attackLocation - 1, 999);

                    countEnemyShip++;
                } else {
                    System.out.println("Location empty");
                    battle.remove(attackLocation - 1);
                    battle.add(attackLocation - 1, 0);
                }
            } else {
                System.out.println("That is location of your own ship");
                continue;
            }

            int randomLocation = random.nextInt(64) + 1;
            System.out.println("Enemy attack " + randomLocation);
            if (battle.get(randomLocation - 1) != 777) {

                if (battle.get(randomLocation - 1) == 100) {
                    System.out.println("Enemy found one of your ship");
                    battle.remove(randomLocation - 1);
                    battle.add(randomLocation - 1, 909);
                    counMyShip++;
                } else {
                    battle.remove(randomLocation - 1);
                    battle.add(randomLocation - 1, 0);
                }
            }

            int indexOfArrayList = 0;
            int normalSort = 1;
            for (int i = 0; i < finalMap.length; i++) {
                for (int j = 0; j < finalMap.length; j++) {
                    if (battle.get(indexOfArrayList) == 0 || battle.get(indexOfArrayList) == 909 || battle.get(indexOfArrayList) == 999) {
                        finalMap[i][j] = battle.get(indexOfArrayList);
                    } else {
                        finalMap[i][j] = normalSort;
                    }
                    indexOfArrayList++;
                    normalSort++;
                }
            }
            GameMap.printArr(finalMap);

            if (counMyShip == 3) {
                System.out.println();
                System.out.println("Unfortunately Enemy destroyed your all ship");
                hasShip = false;
            }
            if (countEnemyShip == 3) {
                System.out.println();
                System.out.println(name.toUpperCase() + ", Congratulations, Enemy's all ship destroyed 🎉🎉🎉");
                hasShip = false;
            }


        }


    }
}