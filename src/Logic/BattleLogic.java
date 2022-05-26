package Logic;

import AbstractClasses.Entity;
import Characters.Hero;

import java.io.IOException;

import static Logic.Main.*;

public class BattleLogic {
    public static void battle(Hero hero, Entity enemy) throws IOException {
        System.out.println("""
                \t\t\t----���----
                """);
        System.out.print(hero.getName() + "\tHP: " + hero.getHp() + "\t\t\t\t");
        System.out.println(enemy.getName() + "\tHP: " + enemy.getHp());
        System.out.println("\t\tMP: " + hero.getMana());
        System.out.println("\n1. ������� (-" + hero.getDmg() + ')');
        System.out.println("2. �������");

        switch (playerInputInt(hero)){
            case 1 -> {
                hero.attack(enemy);
                System.out.println(hero.getName() + " �������� " + enemy.getName() + " � ����� " + hero.getDmg() + " �����");
                if (enemy.getHp() <= 0){
                    System.out.println("\n\t\t\t\t----�� ��������----\n��������:");
                    System.out.println(enemy.getMoney() + " ������\n");
                    hero.setMoney(hero.getMoney() + enemy.getMoney());
                    enemy.getLocation().toDo();
                }
                else {
                    System.out.println(enemy.getName() + " �������� " + hero.getName() + " � ����� " + enemy.getDmg() + " �����");
                    enemy.attack(hero);
                    if (hero.getHp() <= 0){
                        gameOver();
                    }
                    else {
                        battle(hero, enemy);
                    }
                }
            }
            case 2 -> enemy.getLocation().toDo();
        }
    }
}
