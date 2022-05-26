package Characters;

import AbstractClasses.Entity;
import AbstractClasses.Location;
import Interfaces.AbleToFight;

public class Hero extends Entity implements AbleToFight {
    private final int START_HERO_MONEY = 10;
    private final int START_HERO_HP = 20;
    private final int START_HERO_ARM = 5;
    private final int START_HERO_MANA = 20;
    private final int START_HERO_DMG = 2;

    public int getSTART_HERO_HP() {
        return START_HERO_HP;
    }

    public Hero(String name, Location location) {
        setName(name);
        setHp(START_HERO_HP);
        setArm(START_HERO_ARM);
        setMana(START_HERO_MANA);
        setDmg(START_HERO_DMG);
        setMoney(START_HERO_MONEY);
        setLocation(location);
    }

    public Hero(String name, int[] parameters) {
        setHp(parameters[0]);
        setArm(parameters[1]);
        setMana(parameters[2]);
        setDmg(parameters[3]);
        setMoney(parameters[4]);
        setName(name);
    }
}
