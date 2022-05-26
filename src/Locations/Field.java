package Locations;

import AbstractClasses.Location;
import Characters.Slime;

import java.io.IOException;

import static Logic.BattleLogic.battle;
import static Logic.Main.*;
import static Logic.SaveLogic.sExit;

public class Field extends Location {
    @Override
    public void toDo() throws IOException {
        hero.setLocation(field);
        printParameters();
        System.out.println("�����: ����");
        System.out.println("""
                ----����� ��������----
                1. ��������� �� �������
                2. ��������� � ������� �������
                3. ��������� � �����
                """);

        switch (playerInputInt(hero)){
            case 1 -> {
                Slime slime = new Slime();
                battle(hero, slime);
            }
            case 2 -> aincrad.toDo();
            case 3 -> sExit();
        }
    }
}
