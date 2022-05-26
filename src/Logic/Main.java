package Logic;
import Characters.Hero;
import Locations.*;

import java.io.*;
import java.util.Scanner;

import static Logic.SaveLogic.*;

public class Main {
    public static Hero hero;
    public static Village aincrad = new Village("�������");
    public static Field field = new Field();
    public static Cave cave = new Cave();
    static Scanner sc = new Scanner(System.in);
    static File saveDir = new File("src/Save");
    static File saveFile = new File("src/Save/Save.txt");
    static File saveName = new File("src/Save/SaveName.txt");
    static File saveParameters = new File("src/Save/SaveParameters.txt");

    public static void gameInit() throws IOException {
        saveDir.mkdir();
        boolean s1 = saveFile.createNewFile();
        boolean s2 = saveName.createNewFile();
        boolean s3 = saveParameters.createNewFile();

        if (s1 && s2 && s3){
            System.out.println("""
                    ������ ������ �������
                    ����� ���������� � ������������� ����
                    ----RPG SAO M.I.L.F ETEK PROJECT NOT ONLINE----
                    
                                                          ----������----
                    ��� ��� 2 ���� ������������ �������� ���������� ������� ����������. � ������� �� ������� VR-������
                    ���������� ������� ���������� ���� ����������� ���� ������ ����������� � ������ ����� ���� ���
                    ������� ������������ ����� ���-��� �������� ���� ��� ��������� RPG SAO M.I.L.F ETEK PROJECT NOT ONLINE.
                    �� � ����� ����� ���� ������ �� ���� ����� ��� ����� � ������ ��� ������ � ���� �� ���� ��������� �� �����...
                    
                    ��� ��������� ������ � ������� ���� RPG SAO M.I.L.F ETEK PROJECT NOT ONLINE � ������ ���� ����� ��������� � ����������
                        
                        
                                                                                                                version beta 0.1
                    """);
        }
    }

    /////////////////////////////////////////////////////////
    //                 Player Input                        //
    public static int playerInputInt(){                    //
        System.out.print("Player: ");                      //
        return sc.nextInt();                               //
    }                                                      //
                                                           //
    public static int playerInputInt(Hero h){              //
        System.out.print(h.getName()+": ");                //
        return sc.nextInt();                               //
    }                                                      //
                                                           //
    public static String playerInputStr(){                 //
        System.out.print("Player: ");                      //
        return sc.next();                                  //
    }                                                      //
                                                           //
    public static String playerInputStr(Hero h){           //
        System.out.print(h.getName()+": ");                //
        return sc.next();                                  //
    }                                                      //
    /////////////////////////////////////////////////////////

    //      main       //
    public static void main(String[] args) throws IOException {
        gameInit();
        startMenu();
        aincrad.toDo();
    }


    //              Start Menu
    private static void startMenu() throws IOException {

        if (saveFile.length() == 0){
            System.out.println("""
                    1. ����� ����
                    2. �����
                    """);

            int ans = playerInputInt();
            switch (ans) {
                case 1 -> newPlayer();
                case 2 -> exit();
            }
        }
        else{
            System.out.println("""
                    1. ����������
                    2. ����� ����
                    3. �����
                    """);
            int ans = playerInputInt();
            switch (ans) {
                case 1 -> saveLoad();
                case 2 -> newPlayer();
                case 3 -> exit();
            }
        }
    }


    //      exit        //
    public static void exit(){
        System.out.println("����� ��������!");
        System.exit(0);
    }

    public static void gameOver(){
        System.out.println("\n�� ���������� � �� ������ ������ ����. ���� ����� �������� ���������� ������� �����������...\n\n\t\t\t\t----���� ��������----");
        saveFile.delete();
        saveName.delete();
        saveParameters.delete();
    }

    //      create new player   //
    public static void newPlayer() {
        System.out.println("������� ��� ���������: ");
        hero = new Hero(playerInputStr(), aincrad);
    }

    public static void printParameters(){
        System.out.println("\nHP: "+hero.getHp()+"\tMP: "+hero.getMana()+"\nARM: "+hero.getArm()+"\tMON: " + hero.getMoney() + '\n');
    }
}
