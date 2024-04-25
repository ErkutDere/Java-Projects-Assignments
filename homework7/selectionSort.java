package homework7;

import java.util.LinkedHashMap;

public class selectionSort {
    private LinkedHashMap<Character, info> originalMap;
    private LinkedHashMap<Character, info> sortedMap;
    private String[] aux;

    /**
     * Constructor for mergeSort class
     * 
     * @param originalMap
     */
    public selectionSort(LinkedHashMap<Character, info> originalMap) {
        this.originalMap = originalMap;
        // empty sortedMap
        this.sortedMap = new LinkedHashMap<Character, info>();
        // aux array
        this.aux = new String[this.originalMap.size()];
    }

    /**
     * Selection sort method
     * @param map
     */
    public void sort(LinkedHashMap<Character, info> map) {
        // copy original key to aux array
        for (int i = 0; i < this.originalMap.size(); i++) {
            this.aux[i] = map.keySet().toArray()[i].toString();
        }
        // for each element in map
        for (int i = 0; i < map.size() - 1; i++) {
            // find the minimum element in unsorted map
            int min_in = i;
            for (int j = i + 1; j < map.size(); j++) {
                // if element at j is smaller than element at min_in
                if (map.get(this.aux[j].charAt(0)).getCount() < map.get(this.aux[min_in].charAt(0)).getCount()) {
                    // update min_in
                    min_in = j;
                }
            }
            // swap the found minimum element with the first element
            String temp = this.aux[min_in];
            this.aux[min_in] = this.aux[i];
            this.aux[i] = temp;
        }
    }

    public void createSortedMap() {
        // Create sorted map by using aux array and get count and words from original
        // map by using aux array
        for (int i = 0; i < this.aux.length; i++) {
            this.sortedMap.put(this.aux[i].charAt(0), new info(this.originalMap.get(this.aux[i].charAt(0)).getCount(),
                    this.originalMap.get(this.aux[i].charAt(0)).getWords()));
        }
        // print sorted map by using toString method in selectionSort class
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
