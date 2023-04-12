import java.util.*;


public class PicnicPlanner{
    // initialise the food stores from the files
    static PicnicItemStore fruity = new PicnicItemStore("fruits.txt");
    static CheeseStore cheesy = new CheeseStore("cheeses.txt");
    static DrinkStore cheers = new DrinkStore("drinks.txt");

    // method to generate list of picnic items using string
    public static List<String> generate(String input) {
        // make input lowercase
        input = input.toLowerCase();

        //System.out.println(fruity.toString());
        //System.out.println(input);

        // initialise picnic list
        List<String> picnicList = new ArrayList<String>();

        // initialise counters of items
        int tuttiFruti = 0;
        int drunk  = 0;
        int cheezee = 0;
        
        // iterate over each character in the string and add random item from each store
        for (int i = 0; i < input.length(); i++) {
            picnicList.add(fruity.getRandomItem(Character.toString(input.charAt(i))));
            tuttiFruti += 1;
            if (picnicList.size() == 1) {
                picnicList.add(fruity.getRandomItem(Character.toString(input.charAt(i))));
                tuttiFruti += 1;
            }
            
            //picnicList.add(fruity.getRandomItem(Character.toString(input.charAt(i))));
            //tuttiFruti += 1;
            if (picnicList.size() >= 2) {
                picnicList.add(cheesy.getRandomItem(Character.toString(input.charAt(i))));
                cheezee += 1;
            }
            if (picnicList.size() >= 3) {
                picnicList.add(cheers.getRandomItem(Character.toString(input.charAt(i))));
                drunk += 1;
            }
            
	
            // make sure there are as many cheeses as drinks
            if (drunk < cheezee) {
                picnicList.add(cheers.getRandomItem(Character.toString(input.charAt(i))));
                drunk += 1;            
            } else if (cheezee < drunk) {
                picnicList.add(cheesy.getRandomItem(Character.toString(input.charAt(i))));
                cheezee += 1;           
            }
        }
        System.out.println(picnicList);
        return picnicList;

    }

    public static void main(String[] args) {
        // check if there is an input
        if (args.length > 0) {
            //grenrate list of picnic items from input
            List<String> picnicList = generate(args[0]);
            //print each item from picnic list
            for (int i  = 0; i < picnicList.size(); i++) {
                System.out.println(picnicList.get(i));
            }
        }
    }

}
