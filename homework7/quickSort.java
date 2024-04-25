package homework7;
import java.util.LinkedHashMap;
public class quickSort {
    private LinkedHashMap<Character, info> originalMap;
    private LinkedHashMap<Character, info> sortedMap;
    private String[] aux;

    /**
     * Constructor for quickSort class
     * @param originalMap
     */
    public quickSort(LinkedHashMap<Character, info> originalMap) {
        this.originalMap = originalMap;
        // empty sortedMap
        this.sortedMap = new LinkedHashMap<Character, info>();
        // aux array
        this.aux = new String[this.originalMap.size()];
    }

    /**
     * Wrapper method for quick sort
     * @param map
     */
    public void sort(LinkedHashMap<Character, info> map) {
        for (int i = 0; i < this.originalMap.size(); i++) {
            this.aux[i] = originalMap.keySet().toArray()[i].toString();
        }
        sort(map, 0, map.size() - 1);
    }
    /**
     * Quick sort method
     * @param map
     * @param low
     * @param high
     */
    public void sort(LinkedHashMap<Character, info> map, int low, int high) {
        // base case
        if (low < high) {
            int pi = partition(map, low, high);
            sort(map, low, pi - 1);
            sort(map, pi + 1, high);
        }
    }
    /**
     * Partition method
     * @param map
     * @param low
     * @param high
     * @return i + 1 (index of pivot)
     */
    public int partition(LinkedHashMap<Character, info> map, int low, int high) {
        // pivot is the last element
        String pivot = this.aux[high];
        // i is the index of smaller element
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            // if current element is smaller than pivot
            if (map.get(this.aux[j].charAt(0)).getCount() < map.get(pivot.charAt(0)).getCount()) {
                i++;
                // swap aux[i] and aux[j]
                String temp = this.aux[i];
                this.aux[i] = this.aux[j];
                this.aux[j] = temp;
            }
        }
        // swap aux[i + 1] and aux[high] (or pivot)
        String temp = this.aux[i + 1];
        this.aux[i + 1] = this.aux[high];
        this.aux[high] = temp;
        return i + 1;
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
        // print sorted map by using toString method in quickSort class
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
