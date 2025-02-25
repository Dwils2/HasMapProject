/**
 * Calculates the frequency of a word.
 * 
 * @author Dylan Wilson
 * @version Feb 18, 2025
 */
public class WordFrequency implements Comparable<WordFrequency> {
    private String word;
    private int count;
    /**
     * Counts the frequency of a word.
     * @param w the word to be counted
     */
    public WordFrequency(String w)
    {
        this.word = w;
        this.count = 1;
    }

    /**
     * returns the word of the object.
     * @return the word of the object
     */
    public String getWord()
    {
        return this.word;
    }

    /**
     * returns the count of the object.
     * @return the count of the object
     */
    public int getCount()
    {
        return this.count;
    }

    /**
     * Increments the count of the object.
     */
    public void increment()
    {
        this.count++;
    }

    /**
     * Compares the word frequency of two objects.
     * @param other the other object to be compared
     * @return the comparison of the two objects
     */
    public int compareTo(WordFrequency other)
    {
        int wordComparison = this.word.toLowerCase().compareTo(other.word.toLowerCase());
        
        if (wordComparison != 0)
        {
            return wordComparison;
        }
        return Integer.compare(this.count, other.count);
    }
}