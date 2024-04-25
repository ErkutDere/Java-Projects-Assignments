package homework7;
import java.util.List;
public class info {
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
    public List<String> getWords() {
        return this.words;
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