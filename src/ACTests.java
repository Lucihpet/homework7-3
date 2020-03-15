import org.junit.Test;
import java.util.List;

public class ACTests {

    @Test
    public void AutocompleteTestsGiven () {
        String[] str = {"hello", "high", "seattle", "seatac", "see", "hollow", "how"};

        String[] searchTerms = {"h", "se", "sea", "ho", "xyz"};

        String[][] expected = {
                {"hello", "high", "hollow", "how"},
                {"seattle","seatac", "see"},
                {"seattle", "seatac"},
                {"how"},
                {}
        };

        Autocomplete ac = new Autocomplete (str);

        for (int i = 0; i < expected.length; i++) {
            List<String> actual = ac.autocomplete(searchTerms[i]);

            assertTrue()
        }

    }

}
