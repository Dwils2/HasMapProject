import org.junit.*;
import static org.junit.Assert.*;

/**
 * Testing the functions that run the array of ints.
 * 
 * @author Dylan Wilson
 * @version Feb 18, 2025
 */
public class HashDocumentTest {
    // Object to be tested
    private HashDocument runner;

    /**
     * setup() method, runs before each test method below.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new HashDocument("Gettysburg",
        "Four score and seven years ago our fathers brought forth, upon this continent, a new "
        + "nation, conceived in liberty, and dedicated to the proposition that \"all men are "
        + "created equal.\"\"\n"
        + "Now we are engaged in a great civil war, testing whether that nation, or any "
        + "nation so conceived, and so dedicated, can long endure. We are met on a great battle "
        + "field of that war. "
        + "We have come to dedicate a portion of it, as a final resting place for those "
        + "who died here, "
        + "that the nation might live. This we may, in all propriety do. But, in a larger sense, "
        + "we can not "
        + "dedicate -- we can not consecrate -- we can not hallow, this ground -- The brave men, "
        + "living and dead, who struggled here, have hallowed it, far above our poor power to "
        + "add or detract. "
        + "The world will little note, nor long remember what we say here; while it can never "
        + "forget what they did here.\n"
        + "It is rather for us, the living, to stand here, we here be dedicated to the great task "
        + "remaining before us -- that, from these honored dead we take increased devotion "
        + "to that cause "
        + "for which they here, gave the last full measure of devotion "
        + "-- that we here highly resolve these dead shall not have died in vain; "
        + "that the nation, shall have a new birth of freedom, and "
        + "that government of the people by the people for the people, shall not perish from the "
        + "earth.\n");
    }

    /**
     * Test the getTitle() method.
     */
    @Test
    public void testGetTitle() {
        String title = runner.getTitle();
        assertEquals("Gettysburg", title);
    }

    /**
     * Test the frequency() method.
     */
    @Test
    public void testFrequency() {
        int loc = runner.frequency("four");
        assertEquals(1, loc);
    }

    /**
     * Test the frequency() method.
     */
    @Test
    public void testFrequencyNotThere() {
        int loc = runner.frequency("billion");
        assertEquals(0, loc);
    }

    /**
     * Test the contains() method.
     */
    @Test
    public void testContains() {
        boolean loc = runner.contains("four");
        assertEquals(true, loc);
    }

    /**
     * Test the contains() method.
     */
    @Test
    public void testContainsNotThere() {
        boolean loc = runner.contains("billion");
        assertEquals(false, loc);
    }

    /**
     * Test the numOfUniqueWords() method.
     */
    @Test
    public void testNumOfUniqueWordsInTable() {
        int loc = runner.numUniqueWordsInTable();
        assertEquals(91, loc);
    }

    /**
     * Test the totalNumOfWords() method.
     */
    @Test
    public void testTotalNumOfWords() {
        int loc = runner.totalNumOfWords();
        assertEquals(135, loc);
    }

    /**
     * Test the mostCommonWord() method.
     */
    @Test
    public void testMostCommonWord() {
        String loc = runner.mostCommonWord();
        assertEquals("that", loc);
    }

    /**
     * Test the termFrequency() method.
     */
    @Test
    public void testTermFrequency() {
        double loc = runner.termFrequency("four");
        assertEquals(0.007407407407407408, loc, 0.0000000000000001);
    }

    /**
     * Test the termFrequency() method.
     */
    @Test
    public void testTermFrequencyNotThere() {
        double loc = runner.termFrequency("billion");
        assertEquals(0.0, loc, 0.0000000000000001);
    }
}