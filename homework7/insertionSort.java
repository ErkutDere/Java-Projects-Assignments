package homework7;
import java.util.LinkedHashMap;

public class insertionSort {
    private LinkedHashMap<Character, info> originalMap;
    private LinkedHashMap<Character, info> sortedMap;
    private String[] aux;

    /**
     * Constructor for insertion class
     * 
     * @param originalMap
     */
    public insertionSort(LinkedHashMap<Character, info> originalMap) {
        this.originalMap = originalMap;
        // empty sortedMap
        this.sortedMap = new LinkedHashMap<Character, info>();
        // aux array
        this.aux = new String[this.originalMap.size()];
    }

    /**
     * Quick sort method
     * @param originalMap
     */
    public void sort(LinkedHashMap<Character, info> originalMap) {
        // copy original key to aux array
        for (int i = 0; i < this.originalMap.size(); i++) {
            this.aux[i] = originalMap.keySet().toArray()[i].toString();
        }
        // for loop iterate through aux array
        for (int i = 1; i < this.aux.length; i++) {
            // key is the current element
            String key = this.aux[i];
            int j = i - 1;
            // move elements of aux[0..i-1], that are greater than key, to one position
            while (j >= 0 && originalMap.get(this.aux[j].charAt(0)).getCount() > originalMap.get(key.charAt(0)).getCount()) {
                this.aux[j + 1] = this.aux[j];
                j = j - 1;
            }
            // insert key to the right position
            this.aux[j + 1] = key;
        }
    }

    /**
     * Create sorted map by using aux array
     */
    public void createSortedMap() {
        for (int i = 0; i < this.aux.length; i++) {
            this.sortedMap.put(this.aux[i].charAt(0), new info(this.originalMap.get(this.aux[i].charAt(0)).getCount(),
                    this.originalMap.get(this.aux[i].charAt(0)).getWords()));
        }
        // print sorted map by using toString method in insertion class
        System.out.println(this.toString());
    }

    /**
     * @Override Overriding toString to print details of sortedMap
     * 
     */
    @Override
    public String toString() {
        String result = "";
        for (char key : this.sortedMap.keySet()) {
            result += "Letter: " + key + " - Count: " + this.sortedMap.get(key).getCount() + " - Words:[";
            for (int i = 0; i < this.sortedMap.get(key).getCount(); i++) {
                if (i == this.sortedMap.get(key).getCount() - 1) {
                    result += this.sortedMap.get(key).getWords().get(i);
                    break;
                }
                result += this.sortedMap.get(key).getWords().get(i) + ", ";
            }
            result += "]";
            result += "\n";
        }
        return result;
    }
}
