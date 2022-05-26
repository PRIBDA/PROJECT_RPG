package AbstractClasses;

import Interfaces.AbleToFight;

public class Entity implements AbleToFight {
    private String name;
    private int hp;
    private int arm;
    private int mana;
    private int dmg;
    private int money;
    private Location location;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setDmg(int dmg){
        this.dmg = dmg;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getArm() {
        return arm;
    }

    public void setArm(int arm) {
        this.arm = arm;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getDmg() {
        return dmg;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void attack(Entity enemy) {
        enemy.setHp(enemy.getHp() - getDmg());
    }
}
