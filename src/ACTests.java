import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
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
            List<String> expectedList = new ArrayList<>();

            for (int j = 0; j < expected[i].length; j++) {
                expectedList.add(expected[i][j]);
            }

            assertEquals(expectedList, ac.autocomplete(searchTerms[i]));
        }

    }

}
