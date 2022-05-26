package Logic;

import Characters.Hero;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static Logic.Main.*;

public class SaveLogic {
    public static void sExit() throws IOException {

        FileOutputStream saveWrite = new FileOutputStream(saveFile);
        FileOutputStream saveNameWrite = new FileOutputStream(saveName);
        FileOutputStream saveParametersWrite = new FileOutputStream(saveParameters);

        saveWrite.write(Integer.toString(1).getBytes());
        saveNameWrite.write(hero.getName().getBytes());
        saveParametersWrite.write(Integer.toString(hero.getHp()).getBytes());
        saveParametersWrite.write('\n');
        saveParametersWrite.write(Integer.toString(hero.getArm()).getBytes());
        saveParametersWrite.write('\n');
        saveParametersWrite.write(Integer.toString(hero.getMana()).getBytes());
        saveParametersWrite.write('\n');
        saveParametersWrite.write(Integer.toString(hero.getDmg()).getBytes());
        saveParametersWrite.write('\n');
        saveParametersWrite.write(Integer.toString(hero.getMoney()).getBytes());
        saveParametersWrite.write('\n');

        saveWrite.close();
        saveNameWrite.close();
        saveParametersWrite.close();

    }

    public static void saveLoad() throws IOException {
        StringBuilder savedName = new StringBuilder();
        StringBuilder savedPrm = new StringBuilder();
        int[] savedParameters = new int[5];
        int i = 0;
        int val;
        FileInputStream savedNameRead = new FileInputStream(saveName);
        FileInputStream savedParametersRead = new FileInputStream(saveParameters);

        while ((val = savedNameRead.read()) != -1){
            savedName.append((char) val);
        }

        while ((val = savedParametersRead.read()) != -1){
            if (((char) val == '\n')){
                savedParameters[i] = Integer.parseInt(savedPrm.toString());
                savedPrm = new StringBuilder();
                i++;
                continue;
            }
            savedPrm.append((char) val);
        }

        savedNameRead.close();
        savedParametersRead.close();

        hero = new Hero(savedName.toString(), savedParameters);
    }


}
