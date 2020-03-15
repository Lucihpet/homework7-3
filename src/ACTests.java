import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class ACTests {

    @Test
    public void AutocompleteTestsGiven() {
        String[] str = {"hello", "high", "seattle", "seatac", "see", "hollow", "how"};

        String[] searchTerms = {"h", "se", "sea", "ho", "xyz"};

        String[][] expected = {
                {"hello", "high", "hollow", "how"},
                {"seatac", "seattle", "see"},
                {"seatac", "seattle"},
                {"hollow", "how"},
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

    @Test
    public void AutocmpleteTestsStates() {
        String[] str = {"Alabama", "Alaska", "American Samoa", "Arizona", "Arkansas", "California", "Colorado",
                "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia", "Guam", "Hawaii", "Idaho",
                "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts",
                "Michigan", "Minnesota", "Minor Outlying Islands", "Mississippi", "Missouri", "Montana", "Nebraska",
                "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota",
                "Northern Mariana Islands", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island",
                "South Carolina", "South Dakota", "Tennessee", "Texas", "U.S. Virgin Islands", "Utah", "Vermont",
                "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};

        String[] searchTerms = {"w", "al", "mis", "new", "x"};

        String[][] expected = {
                {"washington", "west virginia", "wisconsin", "wyoming"},
                {"alabama", "alaska"},
                {"mississippi", "missouri"},
                {"new hampshire", "new jersey", "new mexico", "new york"},
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
