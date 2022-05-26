package Characters;

import AbstractClasses.Entity;
import AbstractClasses.Location;

import static Logic.Main.cave;

public class Skeleton extends Entity{
    private final int SKELETON_MONEY = 20;
    private final int SKELETON_HP = 10;
    private final int SKELETON_ARM = 5;
    private final int SKELETON_MANA = 0;
    private final int SKELETON_DMG = 5;
    private final Location location = cave;

    @Override
    public Location getLocation() {
        return location;
    }

    public int getSKELETON_MONEY() {
        return SKELETON_MONEY;
    }

    public int getSKELETON_HP() {
        return SKELETON_HP;
    }

    public int getSKELETON_ARM() {
        return SKELETON_ARM;
    }

    public int getSKELETON_MANA() {
        return SKELETON_MANA;
    }

    public int getSKELETON_DMG() {
        return SKELETON_DMG;
    }

    public Skeleton() {
        setName("Скелет");
        setHp(SKELETON_HP);
        setArm(SKELETON_ARM);
        setDmg(SKELETON_DMG);
        setMana(SKELETON_MANA);
        setMoney(SKELETON_MONEY);
    }
}
