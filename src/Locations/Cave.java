package Locations;

import AbstractClasses.Location;
import Characters.Skeleton;

import java.io.IOException;

import static Logic.BattleLogic.battle;
import static Logic.Main.*;
import static Logic.SaveLogic.sExit;

public class Cave extends Location {

    public void toDo() throws IOException {
        hero.setLocation(cave);
        printParameters();
        System.out.println("�����: ����");
        System.out.println("""
                ----����� ��������----
                1. ��������� �� ��������
                2. ��������� � ������� �������
                3. ��������� � �����
                """);

        switch (playerInputInt(hero)){
            case 1 -> {
                Skeleton skeleton = new Skeleton();
                battle(hero, skeleton);
            }
            case 2 -> aincrad.toDo();
            case 3 -> sExit();
        }
    }
}
