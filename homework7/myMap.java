package homework7;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
public class myMap {

    private LinkedHashMap<Character, info> mymap;
    private int mapSize;
    private String str;

    /**
     * 
     * @return mymap
     */
    public LinkedHashMap<Character, info> getMap() {
        return this.mymap;
    }

    /**
     * 
     * @return map size
     */
    public int getMapSize() {
        return this.mapSize;
    }

    /**
     * 
     * @return string that we got from user
     */
    public String getStr() {
        return this.str;
    }

    /**
     * Constructor for myMap
     * 
     * @param str
     */
    public myMap(String str) {
        this.mymap = new LinkedHashMap<Character, info>();
        this.str = str;
        String[] words = this.str.split("\\s+");
        for (String word : words) {
            for (char letter : word.toCharArray()) {
                if (!this.mymap.containsKey(letter)) {
                    List<String> newWord = new ArrayList<String>();
                    newWord.add(word);
                    this.mymap.put(letter, new info(1, newWord));
                    this.mapSize++;
                } else {
                    this.mymap.get(letter).push(word);
                }
            }
        }
    }

    /*
     * @Override toString method to print myMap class
     */
    @Override
    public String toString() {
        String result = "";
        for (char key : this.mymap.keySet()) {
            result += "Letter: " + key + " - Count: " + this.mymap.get(key).getCount() + " - Words:[";
            for (int i = 0; i < this.mymap.get(key).getCount(); i++) {
                if (i == this.mymap.get(key).getCount() - 1) {
                    result += this.mymap.get(key).getWords().get(i);
                    break;
                }
                result += this.mymap.get(key).getWords().get(i) + ", ";
            }
            result += "]";
            result += "\n";
        }
        return result;
    }
}