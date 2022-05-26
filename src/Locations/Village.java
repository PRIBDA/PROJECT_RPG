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
        System.out.println("Место: " + nameOfVillage);
        System.out.println("""
                ----Выбор действий----
                1. Пойти на поле
                2. Пойти в пещеру
                3. Поспать в таверне Айнуры  (-5 золота)
                4. Сохранить и выйти
                """);

        switch (playerInputInt(hero)){
            case 1 -> field.toDo();
            case 2 -> cave.toDo();
            case 3 -> {
                if(hero.getMoney() < 5){
                    System.out.println("Айнура: Уходи по хорошему...\n----У вас не хватает золота----");
                    hero.getLocation().toDo();
                }
                System.out.println("\nВы поспали и восстонавили полное здоровье");
                hero.setHp(hero.getSTART_HERO_HP());
                hero.setMoney(hero.getMoney() - 5);
                hero.getLocation().toDo();
            }
            case 4 -> sExit();
        }
    }
}
