# HasMapProject
This project explores the use of hash tables and hash functions to store words from documents and compute some statistics on word frequencies. These are the basics used for identifying documents when you do search on keywords.

In this project you have to define and implement the class WordFrequency. This class will store a single word (String) and a count indicating the number of times the word appears on a document.

You have to build a second class, HashDocument. Imagine you are building a desktop search engine. The HashDocument class is intended to represent a document stored in your drive. This class will process the text stored in a document and store all of the words into a hash table that maps words to a WordFrequency object. As you process each word, you first look it up in the table. If found, you get the corresponding WordFrequency object and update its count. When done processing all the words and updating the hash table, you will have a frequency table of all the words in the file. Note that the code to process the words in the file is given to you. Recap: The HashDocument stores internally a HashMap that will use a word as key and an object of type WordFrequency as the value associated with the key.

For this project, you will have to write the class WordFrequency and its corresponding test case (WordFrequencyTest), the class HashDocument and its corresponding test case (HashDocumentTest). We have provided for you the code that process the content of a file. We have also provided a main program that is a driver to execute these classes, but that is not to be turned in. The driver is called Project2.

The section below provides more details for the implementation of these classes. We strongly suggest you work one class at a time and build the tests cases first, following the idea of test-driven development.

WordFrequency implements Comparable
This class has 2 instance variables, a word and a count. They should be defined as private members of the class. You should define the following methods (all of them are to be declared public):

WordFrequency(String w)
This is the constructor for the class. It should store the argument w into the instance variable word and initialize the count to 1.
public String getWord()
Getter returning the word stored in this object.
public int getCount()
Getter returning the count stored in this object.
public void increment()
A method that when called increments by 1 the count stored in this object.
public int compareTo(WordFrequency other)
This class implements the interface Comparable. That means that this class must also implement the compareTo() method. This method should return negative, 0 or positive according how the two words are compared. Refer to the line of code below to understand the explanation of the comparison rules shown below:
this.compareTo(other)
Compare this.getWord() with other.getWord() using the compareTo() defined in the String class. If the two strings are different (not 0), then return the value returned by the compareTo() of the two strings (that is, return negative or positive indicating which is larger).
If the two words are equal (i.e., compareTo() of the strings returns 0), then you must compare the frequency count associated with each word. Return 0 if the two counts (this.getCount() and other.getCount()) are equal. Return a negative value if this.getCount() is less than other.getCount(), return a positive number otherwise.
Write test cases for this class that verifies that all the methods work as expected. Your test cases should be stored in a file called WordFrequencyTest and call all methods in the WordFrequency class. The test cases should execute every line of the code in WordFrequency for you to get 100% on testing and coverage.

We strongly recommend you build the test cases for this class first, following the idea of test driven development, run them as you build the WordFrequency class and address the testing and coverage of this class.

HashDocument
This class represents a document and stores its content in a HashMap that uses String as key and WordFrequency as the value associated with the entry in the HashMap. Note that the key stored in the HashMap should be in lower case. This project should be case insensitive for all text processed.

You should define the following methods (all of them are to be declared public):

HashDocument(String title, String content)
Constructor for the class, creates the initial HashMap and calls the processWords(content) method (provided for you) with the content. The title argument should be stored in a private instance variable. It is intended to represent the name of the document where the content comes from.
getTitle()
Returns the title of the HashDocument as passed in the first argument of the constructor.
processWords(String content)
This method is provided for you, it breaks content into words, strips away punctuations, and ignores words of less than 3 characters. For the remaining words, it calls addWord(word). All you need to do is call this method from the constructor.
void addWord(String w)
This method implements the algorithm to add the word to the HashMap. This method is called from the processWords(content) method provided. The steps are as follows:
To add the word to the HashMap, the algorithm should check if the word already exits in the HashMap.
If it exits, it simply increments the count stored in the WordFrequency for that word and the work is done.
If the word is not on the HashMap, the algorithm should create a new WordFrequency object for the work and add it to the hash table.
boolean contains(String w)
Does this document contain this word (w)? Returns true if the word is in the HashMap, false otherwise.
int frequency(String w)
Returns the count of WordFrequency if the word (w) exists in the HashMap, returns 0 otherwise. Note that the count is the value stored the WordFrequency object. Just find the word (w) in the table and then getCount() from that object and return the value.
int numUniqueWordsInTable()
Return the number of unique words stored in the hash table. You could keep track of this number internally, rather than compute it when requested. Or simply use a method available in HashMap that tells you how many elements are stored in the table.
int totalNumOfWords()
This is different from numUniqueWordsInTable in a subtle way. Each word can appear multiple times in a document, but repeated words only appear once in the hash table with the appropriate frequency count increased. This method returns the total number of words, not just unique ones. So it returns the sum of all of the word counts in the table. This is a number that is best computed when words are added to the table. Increment a total by one for all words added, whether they are unique or not, and then return that count in this method.
String mostCommonWord()
This returns the word with the highest count of appearance in the table. You will have to search for this value in the hashTable when this method is called.
double termFrequency(String w)
There is a concept called term frequency and it refers to a measure that indicates how unique a term (or word) is in the particular collection of words represented by this table. It is computed as a ratio of the number of times a particular word appears divided by the total number of words in the document. This method returns the result of frequency(w) / totalNumOfWords(). If the word w is not on the HashMap, this method should return 0.
Write test cases for this class that verifies that all the methods work as expected. This is possibly the most complex class for which you have had to do testing so far, so don't ignore the complexity. Think carefully about your test cases and how to make sure you test your code exhaustively. Your test cases should be stored in a file called HashDocumentTest and call all methods in the HashDocument class and execute every line of code for you to get 100% on testing and coverage.

Be strategic on how you build this class and how you test it. 

📋 Testing
Test-driven development dictates that you should do some testing, then some development, then some testing again, and repeat until all of your code is written and it passes all of your tests. The table below shows some cases that you should consider as you understand this project specification.

Compute by hand what these calls evaluate to. Then write some JUnit test cases for them. Then write the code that implements your understanding of them. What other cases would you add? What happens when the table is full? What happens if you compute the hashkey of a non-existing word? How about a hashkey for a word all in uppercase?
