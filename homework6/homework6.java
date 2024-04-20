import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class homework6 {

    public static void main(String[] args) {
        // take input from user and it can only contanins letter or spaces, not upper
        // case or other charachters
        String input = System.console().readLine("Enter a string: ");
        //error handling for empty string or string that only contains non letter
        if (input.length() == 0) {
            System.out.println("You entered an empty string!");
            System.exit(0);
        }
        //error handling for string that only contains non letter charachters
        if (input.replaceAll("[^a-z ]", "").length() == 0) {
            System.out.println("You entered a string that only contains non letter charachters!");
            System.exit(0);
        }
        System.out.println("\n\nOriginal string:        " + input);
        // convert the string to lower case
        input = input.toLowerCase();
        // Use regex to remove all non letter and non space charachters
        input = input.replaceAll("[^a-z ]", "");

        // print the processed string
        System.out.println("Preprocessed string:    "+input);

        // push the user string into the map class
        myMap map = new myMap(input);
        System.out.println("\n\nThe original (unsorted) map: ");
        System.out.println(map);

        // sort the map
        mergeSort sort = new mergeSort(map.mymap);
        sort.sort(map.mymap);
        
        // print the sorted map
        System.out.println("\n\nThe sorted map: ");
        sort.createSortedMap();
    }

    public static class myMap {

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
                result += "Letter: " + key + " - Count: " + this.mymap.get(key).count + " - Words:[";
                for (int i = 0; i < this.mymap.get(key).count; i++) {
                    if (i == this.mymap.get(key).count - 1) {
                        result += this.mymap.get(key).words.get(i);
                        break;
                    }
                    result += this.mymap.get(key).words.get(i) + ", ";
                }
                result += "]";
                result += "\n";
            }
            return result;
        }
    }

    public static class info {
        private int count;
        private List<String> words;

        /**
         * Constructor for info class
         * 
         * @param count
         * @param words
         */
        public info(int count, List<String> words) {
            this.count = count;
            this.words = words;
        }

        // push method for adding another word to the array
        /**
         * push method for pushing another string into word array
         * 
         * @param word
         */
        public void push(String word) {
            this.count++;
            this.words.add(word);
        }

        /**
         * 
         * @return number of words in words array
         */
        public int getCount() {
            return this.count;
        }

        /**
         * @Override for printing info class
         */
        public String toString() {
            String result = "";
            result += "Count: " + this.count + " - Words:[";
            for (int i = 0; i < this.count; i++) {
                if (i == this.count - 1) {
                    result += this.words.get(i);
                    break;
                }
                result += this.words.get(i) + ", ";
            }
            result += "]";
            return result;
        }

    }

    public static class mergeSort {
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
         * Merge method is merges halves of the aux array and sorts them according to the count of the letters in the map and while doing that it puts them into aux array again.
         * By this way we can keep the keys in sorted order and we can use them to put them into sortedMap.
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
                if (map.get(left[i].charAt(0)).count <= map.get(right[j].charAt(0)).count) {
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
         * Create sorted map by using aux array and get count and words from original map by using aux array
         */
        public void createSortedMap(){
            //Create sorted map by using aux array and get count and words from original map by using aux array
            for(int i = 0; i < this.aux.length; i++){
                this.sortedMap.put(this.aux[i].charAt(0), new info(this.originalMap.get(this.aux[i].charAt(0)).count, this.originalMap.get(this.aux[i].charAt(0)).words));
            }
            //print sorted map by using toString method in mergeSort class
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
                result += "Letter: " + key + " - Count: " + this.sortedMap.get(key).count + " - Words:[";
                for (int i = 0; i < this.sortedMap.get(key).count; i++) {
                    if (i == this.sortedMap.get(key).count - 1) {
                        result += this.sortedMap.get(key).words.get(i);
                        break;
                    }
                    result += this.sortedMap.get(key).words.get(i) + ", ";
                }
                result += "]";
                result += "\n";
            }
            return result;
        }

    }

}