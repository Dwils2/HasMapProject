import java.util.*;

/**
 * Testing the functions that run the array of ints.
 * 
 * @author Dylan Wilson
 * @version Feb 18, 2025
 */
public class HashDocument {
    private String title;
    private HashMap<String, WordFrequency> wordTable;
    private int totalWordCount;

    /**
     * Creates the hash document object.
     * @param title the title of the document
     * @param content the content of the document
     */
    public HashDocument(String title, String content)
    {
        this.title = title;
        this.wordTable = new HashMap<>();
        this.totalWordCount = 0;
        processWords(content);
    }

    /**
     * Returns the title of the document.
     * @return the title of the document
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * Breaks up content into words, skipping punctuations
     * and keeping only words that have more than 3 characters.
     * @param content - all the text from a file to be processed
     */
    private void processWords(String content) {
        // Use regular expression to pick up words only
        String[] words = content.split("\\W+");
        for (String word : words) {
            // and process only words longer than 3 characters
            if (word.length() > 3) {
                addWord(word.toLowerCase());
            }
        }
    }

    /**
     * Returns the frequency of a word in the document.
     * @param w the word to be counted
     * @return the frequency of the word
     */
    public int frequency(String w) {
        if (wordTable.containsKey(w))
        {
            return wordTable.get(w).getCount();
        }
        return 0;
    }

    /**
     * Adds a word to the document.
     * @param w the word to be added
     */
    public void addWord(String w) {
        if (wordTable.containsKey(w))
        {
            wordTable.get(w).increment();
        }
        else
        {
            wordTable.put(w, new WordFrequency(w));
        }
        totalWordCount++;
    }

    /**
     * Checks if the document contains a word.
     * @param w the word to be checked
     * @return if the document contains the word
     */
    public boolean contains(String w) {
        return wordTable.containsKey(w);
    }

    /**
     * Returns the number of unique words in the document.
     * @return the number of unique words in the document
     */
    public int numUniqueWordsInTable() {
        return wordTable.size();
    }

    /**
     * Returns the total number of words in the document.
     * @return the total number of words in the document
     */
    public int totalNumOfWords() {
        return totalWordCount;
    }

    /**
     * returns the most common word in the document.
     * @return the most common word in the document
     */
    public String mostCommonWord() {
        String mostCommon = null;
        int maxCount = 0;
        for (WordFrequency wf : wordTable.values()) {
            if (wf.getCount() > maxCount) {
                maxCount = wf.getCount();
                mostCommon = wf.getWord();
            }
        }
        return mostCommon;
    }

    /**
     * Calculates the term frequency of a word in the document.
     * @param w the word to be calculated
     * @return the term frequency of the word
     */
    public double termFrequency(String w) {
        if (!wordTable.containsKey(w)) 
        {
            return 0.0;
        }
        return (double) wordTable.get(w).getCount() / totalWordCount;
    }
}