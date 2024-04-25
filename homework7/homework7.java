package homework7;

public class homework7 {

    public static void main(String[] args) {
        // take input from user and it can only contanins letter or spaces, not upper
        // case or other charachters
        //best-case input
        String input1 = "xxxxyyyyzzzz";
        //average-case input
        String input2 = "yxyzzzzxxxxx";
        //worst-case input
        String input3 = "xzyxzxzxzxyx";
        best_case(input1);
        average_case(input2);
        worst_case(input3);
    }    
    public static void best_case(String input1){
        // error handling for empty string or string that only contains non letter
        if (input1.length() == 0) {
            System.out.println("You entered an empty string!");
            System.exit(0);
        }
        // error handling for string that only contains non letter charachters
        if (input1.replaceAll("[^a-z ]", "").length() == 0) {
            System.out.println("You entered a string that only contains non letter charachters!");
            System.exit(0);
        }
        System.out.println("\n\nOriginal string:        " + input1);
        // convert the string to lower case
        input1 = input1.toLowerCase();
        // Use regex to remove all non letter and non space charachters
        input1 = input1.replaceAll("[^a-z ]", "");

        // print the processed string
        System.out.println("Preprocessed string:    " + input1);

        // push the user string into the map class
        myMap map = new myMap(input1);
        System.out.println("\n\nThe original (unsorted) map: ");
        System.out.println(map);

        // sort the map
        mergeSort sort = new mergeSort(map.getMap());
        long start = System.nanoTime();
        sort.sort(map.getMap());
        long finish = System.nanoTime();
        
        // print the sorted map
        System.out.println("\n\nThe sorted map using merge sort: ");
        sort.createSortedMap();
        System.out.println("Time taken to sort the map using merge sort: " + (finish-start) + " milliseconds");

        // call selection sort
        System.out.println("\n\nThe sorted map using selection sort: ");
        selectionSort selection = new selectionSort(map.getMap());
        start = System.nanoTime();
        selection.sort(map.getMap());
        finish = System.nanoTime();
        selection.createSortedMap();
        System.out.println("Time taken to sort the map using selection sort: " + (finish-start) + " milliseconds");

        // call insertion sort
        System.out.println("\n\nThe sorted map using insertion sort: ");
        insertionSort insertion = new insertionSort(map.getMap());
        start = System.nanoTime();
        insertion.sort(map.getMap());
        finish = System.nanoTime();
        insertion.createSortedMap();
        System.out.println("Time taken to sort the map using insertion sort: " + (finish-start) + " milliseconds");


        // call bubble sort
        System.out.println("\n\nThe sorted map using bubble sort: ");
        bubbleSort bubble = new bubbleSort(map.getMap());
        start = System.nanoTime();
        bubble.sort(map.getMap());
        finish = System.nanoTime();
        bubble.createSortedMap();
        System.out.println("Time taken to sort the map using bubble sort: " + (finish-start) + " milliseconds");

        // call quick sort
        System.out.println("\n\nThe sorted map using quick sort: ");
        quickSort quick = new quickSort(map.getMap());
        start = System.nanoTime();
        quick.sort(map.getMap());
        finish = System.nanoTime();
        quick.createSortedMap();
        System.out.println("Time taken to sort the map using quick sort: " + (finish-start) + " milliseconds");
    }
    public static void average_case(String input2){
        // error handling for empty string or string that only contains non letter
        if (input2.length() == 0) {
            System.out.println("You entered an empty string!");
            System.exit(0);
        }
        // error handling for string that only contains non letter charachters
        if (input2.replaceAll("[^a-z ]", "").length() == 0) {
            System.out.println("You entered a string that only contains non letter charachters!");
            System.exit(0);
        }
        System.out.println("\n\nOriginal string:        " + input2);
        // convert the string to lower case
        input2 = input2.toLowerCase();
        // Use regex to remove all non letter and non space charachters
        input2 = input2.replaceAll("[^a-z ]", "");

        // print the processed string
        System.out.println("Preprocessed string:    " + input2);

        // push the user string into the map class
        myMap map = new myMap(input2);
        System.out.println("\n\nThe original (unsorted) map: ");
        System.out.println(map);

        // sort the map
        mergeSort sort = new mergeSort(map.getMap());
        long start = System.nanoTime();
        sort.sort(map.getMap());
        long finish = System.nanoTime();
        
        // print the sorted map
        System.out.println("\n\nThe sorted map using merge sort: ");
        sort.createSortedMap();
        System.out.println("Time taken to sort the map using merge sort: " + (finish-start) + " milliseconds");

        // call selection sort
        System.out.println("\n\nThe sorted map using selection sort: ");
        selectionSort selection = new selectionSort(map.getMap());
        start = System.nanoTime();
        selection.sort(map.getMap());
        finish = System.nanoTime();
        selection.createSortedMap();
        System.out.println("Time taken to sort the map using selection sort: " + (finish-start) + " milliseconds");

        // call insertion sort
        System.out.println("\n\nThe sorted map using insertion sort: ");
        insertionSort insertion = new insertionSort(map.getMap());
        start = System.nanoTime();
        insertion.sort(map.getMap());
        finish = System.nanoTime();
        insertion.createSortedMap();
        System.out.println("Time taken to sort the map using insertion sort: " + (finish-start) + " milliseconds");

        // call bubble sort
        System.out.println("\n\nThe sorted map using bubble sort: ");
        bubbleSort bubble = new bubbleSort(map.getMap());
        start = System.nanoTime();
        bubble.sort(map.getMap());
        finish = System.nanoTime();
        bubble.createSortedMap();
        System.out.println("Time taken to sort the map using bubble sort: " + (finish-start) + " milliseconds");

        // call quick sort
        System.out.println("\n\nThe sorted map using quick sort: ");
        quickSort quick = new quickSort(map.getMap());
        start = System.nanoTime();
        quick.sort(map.getMap());
        finish = System.nanoTime();
        quick.createSortedMap();
        System.out.println("Time taken to sort the map using quick sort: " + (finish-start) + " milliseconds");
    }
    public static void worst_case(String input3){
        // error handling for empty string or string that only contains non letter
        if (input3.length() == 0) {
            System.out.println("You entered an empty string!");
            System.exit(0);
        }
        // error handling for string that only contains non letter charachters
        if (input3.replaceAll("[^a-z ]", "").length() == 0) {
            System.out.println("You entered a string that only contains non letter charachters!");
            System.exit(0);
        }
        System.out.println("\n\nOriginal string:        " + input3);
        // convert the string to lower case
        input3 = input3.toLowerCase();
        // Use regex to remove all non letter and non space charachters
        input3 = input3.replaceAll("[^a-z ]", "");

        // print the processed string
        System.out.println("Preprocessed string:    " + input3);

        // push the user string into the map class
        myMap map = new myMap(input3);
        System.out.println("\n\nThe original (unsorted) map: ");
        System.out.println(map);

        // sort the map
        mergeSort sort = new mergeSort(map.getMap());
        long start = System.nanoTime();
        sort.sort(map.getMap());
        long finish = System.nanoTime();
        
        // print the sorted map
        System.out.println("\n\nThe sorted map using merge sort: ");
        sort.createSortedMap();
        System.out.println("Time taken to sort the map using merge sort: " + (finish-start) + " milliseconds");

        // call selection sort
        System.out.println("\n\nThe sorted map using selection sort: ");
        selectionSort selection = new selectionSort(map.getMap());
        start = System.nanoTime();
        selection.sort(map.getMap());
        finish = System.nanoTime();
        selection.createSortedMap();
        System.out.println("Time taken to sort the map using selection sort: " + (finish-start) + " milliseconds");

        // call insertion sort
        System.out.println("\n\nThe sorted map using insertion sort: ");
        insertionSort insertion = new insertionSort(map.getMap());
        start = System.nanoTime();
        insertion.sort(map.getMap());
        finish = System.nanoTime();
        insertion.createSortedMap();
        System.out.println("Time taken to sort the map using insertion sort: " + (finish-start) + " milliseconds");

        // call bubble sort
        System.out.println("\n\nThe sorted map using bubble sort: ");
        bubbleSort bubble = new bubbleSort(map.getMap());
        start = System.nanoTime();
        bubble.sort(map.getMap());
        finish = System.nanoTime();
        bubble.createSortedMap();
        System.out.println("Time taken to sort the map using bubble sort: " + (finish-start) + " milliseconds");

        // call quick sort
        System.out.println("\n\nThe sorted map using quick sort: ");
        quickSort quick = new quickSort(map.getMap());
        start = System.nanoTime();
        quick.sort(map.getMap());
        finish = System.nanoTime();
        quick.createSortedMap();
        System.out.println("Time taken to sort the map using quick sort: " + (finish-start) + " milliseconds");
    }
}