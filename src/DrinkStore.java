import java.util.*;
import java.io.*;

public class DrinkStore extends PicnicItemStore {

    public DrinkStore() {
        super();
    }

    public DrinkStore(String filename) {
        super(filename);
    }

    // add subclass of (strong wine) if alchol levels are more than 12, (wine) if they are more than 0, else (soft drink)
    @Override
    public String getRandomItem(String key) {
        // TODO Auto-generated method stub
        //Alexana Pinot Noir Dundee Hills Revana Vineyard 6
        key = key.toLowerCase();
        System.out.println(key);
        // get values and iterate to last value and grab it as it is the alcahol level
        String line = super.getRandomItem(key);
        String[] elements = line.split(" "); 
        int astaghfirullah = Integer.parseInt(elements[elements.length-1]);
        if (astaghfirullah >= 12) {
            return line + "(strong wine)";
        }
        else if (astaghfirullah > 0 && astaghfirullah < 12) {
            return line + "(wine)";
        }
        else{
            return line + "(soft drink)";
        }
    }



}
