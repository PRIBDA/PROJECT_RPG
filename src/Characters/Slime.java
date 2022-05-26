package Characters;

import AbstractClasses.Entity;
import AbstractClasses.Location;

import static Logic.Main.field;

public class Slime extends Entity{
    private final int SLIME_MONEY = 5;
    private final int SLIME_HP = 5;
    private final int SLIME_ARM = 0;
    private final int SLIME_MANA = 0;
    private final int SLIME_DMG = 1;
    private final Location location = field;

    @Override
    public Location getLocation() {
        return location;
    }

    public int getSLIME_MONEY() {
        return SLIME_MONEY;
    }

    public int getSLIME_HP() {
        return SLIME_HP;
    }

    public int getSLIME_ARM() {
        return SLIME_ARM;
    }

    public int getSLIME_MANA() {
        return SLIME_MANA;
    }

    public int getSLIME_DMG() {
        return SLIME_DMG;
    }

    public Slime() {
        setName("Слизь");
        setHp(SLIME_HP);
        setArm(SLIME_ARM);
        setDmg(SLIME_DMG);
        setMana(SLIME_MANA);
        setMoney(SLIME_MONEY);
    }
}
