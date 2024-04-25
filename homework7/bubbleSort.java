package homework7;
import java.util.LinkedHashMap;
public class bubbleSort {
    private LinkedHashMap<Character, info> originalMap;
    private LinkedHashMap<Character, info> sortedMap;
    private String[] aux;

    /**
     * Constructor for bubbleSort class
     * @param originalMap
     */
    public bubbleSort(LinkedHashMap<Character, info> originalMap) {
        this.originalMap = originalMap;
        // empty sortedMap
        this.sortedMap = new LinkedHashMap<Character, info>();
        // aux array
        this.aux = new String[this.originalMap.size()];
    }

    /**
     * Bubble sort method
     * @param originalMap
     */
    public void sort(LinkedHashMap<Character, info> originalMap) {
        // copy original key to aux array
        for (int i = 0; i < this.originalMap.size(); i++) {
            this.aux[i] = originalMap.keySet().toArray()[i].toString();
        }
        // We check the last element of the array first, then the second last element
        for (int i = 0; i < this.aux.length - 1; i++) {
            for (int j = 0; j < this.aux.length - i - 1; j++) {
                // if the count of the first element is greater than the count of the second
                if (originalMap.get(this.aux[j].charAt(0)).getCount() > originalMap
                        .get(this.aux[j + 1].charAt(0)).getCount()) {
                    // swap arr[j+1] and arr[i]
                    String temp = this.aux[j];
                    this.aux[j] = this.aux[j + 1];
                    this.aux[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Create sorted map by using aux array and get count and words from original
     * map by using aux array
     */
    public void createSortedMap() {
        for (int i = 0; i < this.aux.length; i++) {
            this.sortedMap.put(this.aux[i].charAt(0), new info(this.originalMap.get(this.aux[i].charAt(0)).getCount(),
                    this.originalMap.get(this.aux[i].charAt(0)).getWords()));
        }
        // print sorted map by using toString method in bubbleSort class
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
