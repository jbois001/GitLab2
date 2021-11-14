import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

/**
 * Test of the Vocabulary class
 */
public class VocabTest {
                  

    @Test
    public void testConstructor()
    {
        Vocabulary v = new Vocabulary();
        // A newly constructed vocabulary should have no starting words and no pairs.
        assertTrue (v.getStartingWords().isEmpty());
        assertThat(v.getNumStartingWords(), is(0));
        assertThat(v.getNumWordPairs(), is(0));
        assertTrue(v.getWordsThatCanFollow("the").isEmpty());
    }

    @Test
    public void testAddStartingWord() {
        Vocabulary v = new Vocabulary();
        v.addStartingWord("hello");
        // After adding one starting word, we should see that word but
        // the pairs should be unchanged.
        assertThat (v.getStartingWords().size(), is(1));
        assertThat (v.getStartingWords(), hasItem("hello"));
        assertThat(v.getNumStartingWords(), is(1));
        assertThat(v.getNumWordPairs(), is(0));
        assertTrue(v.getWordsThatCanFollow("hello").isEmpty());

        v.addStartingWord("goodbye");
        // After adding another starting word, we should see both words in
        // the order they were added, and the pairs should be unchanged.
        assertThat (v.getStartingWords().size(), is(2));
        assertThat (v.getStartingWords(), contains("hello", "goodbye"));
        assertThat(v.getNumStartingWords(), is(2));
        assertThat(v.getNumWordPairs(), is(0));
        assertTrue(v.getWordsThatCanFollow("hello").isEmpty());
        assertTrue(v.getWordsThatCanFollow("goodbye").isEmpty());

        v.addStartingWord("hello");
        // After adding another starting word, we should see three words in
        // the order they were added even if one word is the duplicate of one
        // of the earlier ones. The pairs should be unchanged.
        String[] expected = {"hello", "goodbye", "hello"};
        List<String> observed = v.getStartingWords();
        assertThat(observed, contains(expected));

        assertThat(v.getNumStartingWords(), is(3));
        assertThat(v.getNumWordPairs(), is(0));
        assertTrue(v.getWordsThatCanFollow("hello").isEmpty());

    }
  
/** 
    @Test
    public void testAddWordPair()
    {
        Vocabulary v = new Vocabulary();
        v.addWordPair("a", "b");
        assertTrue (v.getStartingWords().isEmpty());
        assertThat(v.getNumStartingWords(), is(0));
        assertThat(v.getNumWordPairs(), is(1));
        assertThat(v.getWordsThatCanFollow("a"), contains("b"));
        assertThat(v.getWordsThatCanFollow("b").isEmpty(), is(true));
        assertThat(v.getWordsThatCanFollow("c").isEmpty(), is(true));

        v.addWordPair("b", "c");
        assertTrue (v.getStartingWords().isEmpty());
        assertThat(v.getNumStartingWords(), is(0));
        assertThat(v.getNumWordPairs(), is(2));
        assertThat(v.getWordsThatCanFollow("a"), contains("b"));
        assertThat(v.getWordsThatCanFollow("b"), contains("c"));
        assertThat(v.getWordsThatCanFollow("c").isEmpty(), is(true));

        v.addWordPair("c", "c");
        assertTrue (v.getStartingWords().isEmpty());
        assertThat(v.getNumStartingWords(), is(0));
        assertThat(v.getNumWordPairs(), is(3));
        assertThat(v.getWordsThatCanFollow("a"), contains("b"));
        assertThat(v.getWordsThatCanFollow("b"), contains("c"));
        assertThat(v.getWordsThatCanFollow("c"), contains("c"));

        v.addWordPair("a", "c");
        assertTrue (v.getStartingWords().isEmpty());
        assertThat(v.getNumStartingWords(), is(0));
        assertThat(v.getNumWordPairs(), is(4));
        assertThat(v.getWordsThatCanFollow("a"), contains("b", "c"));
        assertThat(v.getWordsThatCanFollow("b"), contains("c"));
        assertThat(v.getWordsThatCanFollow("c"), contains("c"));

        v.addWordPair("b", "c");
        assertTrue (v.getStartingWords().isEmpty());
        assertThat(v.getNumStartingWords(), is(0));
        assertThat(v.getNumWordPairs(), is(5));
        assertThat(v.getWordsThatCanFollow("a"), contains("b", "c"));
        assertThat(v.getWordsThatCanFollow("b"), contains("c", "c"));
        assertThat(v.getWordsThatCanFollow("c"), contains("c"));
    }

*/

}
//This is from master
