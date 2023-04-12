import java.util.*;
import java.io.*;

public class PicnicItemStore {
    Map<String, List<String>> hashMap;
    private Random rand = new Random();

    //Hashmap Constructor
    public PicnicItemStore() {
        hashMap = new HashMap<String, List<String>>();
    }

    //Hashmap from File Constructor
    public PicnicItemStore(String fileName) {
        hashMap = new HashMap<String, List<String>>();
        BufferedReader reader = null;
        // try open file, else throw and catch exception if file not found
        try {
            reader = new BufferedReader(new FileReader(fileName));
            List<String> linesList = new ArrayList<String>();
            // try iterating through file and reqad lines into linesList
            try {
                String contentLine = reader.readLine();
                while (contentLine != null) {
                    linesList.add(contentLine);
                    contentLine = reader.readLine();
                }       
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            // iterate through list of file lines and loads them as a list of Strings
            for (String s : linesList) {
                String line = s;
                //seperates the key and values pairs
                String[] keyVals = line.split(" ");
                String key = keyVals[0].substring(0, 1).toLowerCase();
                List<String> vals = new ArrayList<String>();
                for (int j = 0; j < keyVals.length; j++) {
                    vals.add(keyVals[j]);
                }
                //adds them to the hashmap using put method
                hashMap.put(key, vals);
            }
        } 
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            // try close reader
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // method to check if hashmap contains key
    public boolean containsKey(String key) {
        return hashMap.containsKey(key);
    }

    
    // method to put the key and value pair into the hashmap
    public void put(String key, String item) {
        // generate list of item values
        List<String> items = new ArrayList<String>();
        // add item to listy of item values
        items.add(item);
        //check if theres already a pair with the same key in hashmap
        if (hashMap.containsKey(key)) {
            //grab previous values of key from hashmap
            List<String> itemz = hashMap.get(key);
            //iterate through previous values from hashmap and add them to items list
            for (String s : itemz) {
                items.add(s);
            }
            // update the hashmap with the key and new list of items
            hashMap.put(key, items);
        }
        else {
            //add key and item value pair to hashmap
            hashMap.put(key, items);
        }
    }  

    public String getRandomItem(String key) {
        // make key lowercase
        key = key.toLowerCase();
        // grenrate list of values mapped to key
        List<String> list = hashMap.get(key);
        //if list is empty return null
        if (list == null) {
            return null;
        }
        //else store random value from list of values into a string 
        String random = list.get(rand.nextInt(list.size()));
        // seperate the string into substrings; make the first substring uppercase and then return with rest of the substrings to give capitalized string
        return random.substring(0, 1).toUpperCase() + random.substring(1);
    }

}
 