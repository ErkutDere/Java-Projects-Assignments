package homework7;

import java.util.LinkedHashMap;

public class mergeSort {
    private LinkedHashMap<Character, info> originalMap;
    private LinkedHashMap<Character, info> sortedMap;
    private String[] aux;// this will keep keys in sorted order

    /**
     * Constructor for mergeSort class
     * 
     * @param originalMap
     */
    public mergeSort(LinkedHashMap<Character, info> originalMap) {
        this.originalMap = originalMap;
        // empty sortedMap
        this.sortedMap = new LinkedHashMap<Character, info>();
        // aux array
        this.aux = new String[this.originalMap.size()];
    }

    /**
     * Wrapper method for implementing merge sort
     * 
     * @param map
     */
    public void sort(LinkedHashMap<Character, info> map) {
        for (int i = 0; i < this.originalMap.size(); i++) {
            this.aux[i] = map.keySet().toArray()[i].toString();
        }
        sort(map, 0, map.size() - 1);
    }

    /**
     * Recursive method that that halves the map and calls merge method
     * 
     * @param map
     * @param low
     * @param high
     */
    public void sort(LinkedHashMap<Character, info> map, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(map, low, mid);
            sort(map, mid + 1, high);
            merge(map, low, mid, high);
        }
    }

    /**
     * Merge method is merges halves of the aux array and sorts them according to
     * the count of the letters in the map and while doing that it puts them into
     * aux array again.
     * By this way we can keep the keys in sorted order and we can use them to put
     * them into sortedMap.
     * 
     * @param map
     * @param low
     * @param mid
     * @param high
     */
    // Sort aux array according to the count value of each letter
    public void merge(LinkedHashMap<Character, info> map, int low, int mid, int high) {

        // Find sizes of two subarrays to be merged
        int n1 = mid - low + 1;
        int n2 = high - mid;
        String[] left = new String[n1];
        String[] right = new String[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; i++) {
            left[i] = this.aux[low + i];
        }
        for (int j = 0; j < n2; j++) {
            right[j] = this.aux[mid + 1 + j];
        }

        int i = 0, j = 0;
        int k = low;
        // Compare count of the letters in the map and sort them according to the count
        while (i < n1 && j < n2) {
            if (map.get(left[i].charAt(0)).getCount() <= map.get(right[j].charAt(0)).getCount()) {
                this.aux[k] = left[i];
                i++;
            } else {
                this.aux[k] = right[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of left array
        while (i < n1) {
            this.aux[k] = left[i];
            i++;
            k++;
        }
        // Copy remaining elements of right array
        while (j < n2) {
            this.aux[k] = right[j];
            j++;
            k++;
        }
    }

    /**
     * Create sorted map by using aux array and get count and words from original
     * map by using aux array
     */
    public void createSortedMap() {
        // Create sorted map by using aux array and get count and words from original
        // map by using aux array
        for (int i = 0; i < this.aux.length; i++) {
            this.sortedMap.put(this.aux[i].charAt(0), new info(this.originalMap.get(this.aux[i].charAt(0)).getCount(),
                    this.originalMap.get(this.aux[i].charAt(0)).getWords()));
        }
        // print sorted map by using toString method in mergeSort class
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
