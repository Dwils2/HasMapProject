import org.junit.*;
import static org.junit.Assert.*;

/**
 * Testing the functions that run the array of ints.
 * 
 * @author Dylan Wilson
 * @version Feb 18, 2025
 */
public class WordFrequencyTest {
    // Object to be tested
    private WordFrequency runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new WordFrequency("Hello");
    }

    /**
     * Test the getWord() method.
     */
    @Test
    public void testGetWord() {
        assertEquals("Hello", runner.getWord());
    }

    /**
     * Test the getCount() method.
     */
    @Test
    public void testGetCount() {
        assertEquals(1, runner.getCount());
    }

    /**
     * Test the increment() method.
     */
    @Test
    public void testIncrement() {
        runner.increment();
        assertEquals(2, runner.getCount());
    }

    /**
     * Test the compareTo() method with the two words, different length.
     */
    @Test
    public void testCompareToSameCountDifferentWords() {
        WordFrequency wf1 = new WordFrequency("apple");
        WordFrequency wf2 = new WordFrequency("banana");
        int result1 = wf1.compareTo(wf2);
        int result2 = wf2.compareTo(wf1);
        assertEquals("Apple is smaller than banana", -1, result1);
        assertEquals("Banana is larger than apple", 1, result2);
    }

    /**
     * Test the compareTo() method with the same count.
     */
    @Test
    public void testCompareToDifferentCountDifferentWords() 
    {
        WordFrequency wf1 = new WordFrequency("banana");
        WordFrequency wf2 = new WordFrequency("apple");
        wf1.increment();
        wf1.increment();
        int result1 = wf1.compareTo(wf2);
        int result2 = wf2.compareTo(wf1);
        assertEquals("Banana has more than Apple", 1, result1);
        assertEquals("Apple has less than Banana", -1, result2);
        
    }

    /**
     * Test the compareTo() method with the same word and count.
     */
    @Test
    public void testCompareToSameWordSameCount() 
    {
        WordFrequency wf1 = new WordFrequency("apple");
        WordFrequency wf2 = new WordFrequency("Apple");
        int result1 = wf1.compareTo(wf2);
        int result2 = wf2.compareTo(wf1);
        assertEquals("Apple is the same as Apple", 0, result1);
        assertEquals("Apple is the same as Apple", 0, result2);
    }
}
