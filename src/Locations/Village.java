package Locations;

import AbstractClasses.Location;

import java.io.IOException;

import static Logic.Main.*;
import static Logic.SaveLogic.*;

public class Village extends Location {
    private final String nameOfVillage;

    public Village(String nameOfVillage) {
        this.nameOfVillage = nameOfVillage;
    }

    @Override
    public void toDo() throws IOException {
        hero.setLocation(aincrad);
        printParameters();
        System.out.println("�����: " + nameOfVillage);
        System.out.println("""
                ----����� ��������----
                1. ����� �� ����
                2. ����� � ������
                3. ������� � ������� ������  (-5 ������)
                4. ��������� � �����
                """);

        switch (playerInputInt(hero)){
            case 1 -> field.toDo();
            case 2 -> cave.toDo();
            case 3 -> {
                if(hero.getMoney() < 5){
                    System.out.println("������: ����� �� ��������...\n----� ��� �� ������� ������----");
                    hero.getLocation().toDo();
                }
                System.out.println("\n�� ������� � ������������ ������ ��������");
                hero.setHp(hero.getSTART_HERO_HP());
                hero.setMoney(hero.getMoney() - 5);
                hero.getLocation().toDo();
            }
            case 4 -> sExit();
        }
    }
}
