import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class GameManagment {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    public static ArrayList<Integer> start(){

        System.out.println("||||||||||||||||||||||||||| BATTLESHIP ||||||||||||||||||||||||||||");
        System.out.println();
        System.out.println("Welcom to game the BattleShip -) ");
        System.out.println();

        int[][] ints = GameMap.addShipToMamp(GameMap.firstMap());

        int[][] finalMap = GameMap.addRandomShipToMamp(ints);

        System.out.println();

        for (int i = 3; i >=1; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("\rGame start in " + i +" second");
        }
        System.out.println();



        ArrayList<Integer> battle = new ArrayList<>();
        for (int i = 0; i < finalMap.length; i++) {
            for (int j = 0; j < finalMap.length; j++) {
                battle.add(finalMap[i][j]);
            }
        }
       return battle;
    }




}
