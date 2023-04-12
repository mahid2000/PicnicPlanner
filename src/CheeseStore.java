import java.util.*;
import java.io.*;

public class CheeseStore extends PicnicItemStore {

    public CheeseStore() {
        super();
    }

    public CheeseStore(String filename) {
        super(filename);
    }

    // update random item method to add (cheese) to each of the cheese items
    @Override
    public String getRandomItem(String key) {
        // TODO Auto-generated method stub
        key = key.toLowerCase();
        return super.getRandomItem(key) + "(cheese)";
    }

}
