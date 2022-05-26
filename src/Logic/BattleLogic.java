package Logic;

import AbstractClasses.Entity;
import Characters.Hero;

import java.io.IOException;

import static Logic.Main.*;

public class BattleLogic {
    public static void battle(Hero hero, Entity enemy) throws IOException {
        System.out.println("""
                \t\t\t----Бой----
                """);
        System.out.print(hero.getName() + "\tHP: " + hero.getHp() + "\t\t\t\t");
        System.out.println(enemy.getName() + "\tHP: " + enemy.getHp());
        System.out.println("\t\tMP: " + hero.getMana());
        System.out.println("\n1. Ударить (-" + hero.getDmg() + ')');
        System.out.println("2. Сбежать");

        switch (playerInputInt(hero)){
            case 1 -> {
                hero.attack(enemy);
                System.out.println(hero.getName() + " атаковал " + enemy.getName() + " и нанес " + hero.getDmg() + " урона");
                if (enemy.getHp() <= 0){
                    System.out.println("\n\t\t\t\t----Вы победили----\nПолучено:");
                    System.out.println(enemy.getMoney() + " золота\n");
                    hero.setMoney(hero.getMoney() + enemy.getMoney());
                    enemy.getLocation().toDo();
                }
                else {
                    System.out.println(enemy.getName() + " атаковал " + hero.getName() + " и нанес " + enemy.getDmg() + " урона");
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
