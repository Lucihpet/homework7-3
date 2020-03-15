import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Autocomplete {
    private List<String> words;

    public Autocomplete(String[] terms) {
        addTerms(terms);
    }

    public void addTerms(String[] terms) {
        if (terms.length == 0)
            return;

        for (int i = 0; i < terms.length; i++) {
            words = new ArrayList<>();
            words.add(terms[i]);
        }

        Collections.sort(this.words);
    }

    public List<String> autocomplete (String search) {

    }
}
