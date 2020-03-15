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

        words = new ArrayList<>();

        for (int i = 0; i < terms.length; i++) {
            words.add(terms[i]);
        }

        Collections.sort(this.words);
    }

    public List<String> autocomplete (String search) {
        int[] bounds = findBounds(search);

        List<String> returnList = new ArrayList<>();

        for (int i = bounds[0]; i <= bounds[1]; i++) {
            returnList.add(words.get(i));
        }

        return returnList;
    }

    public int[] findBounds(String str) {
        int begin = 0;
        int end = words.size() - 1;
        int mid = words.size()/2;

        while (!words.get(mid).contains(str)) {
            if (words.get(mid).compareTo(str) > 0)
                end = mid - 1;
            if (words.get(mid).compareTo(str) < 0)
                begin = mid + 1;

            mid = (begin + end) / 2;
        }

        begin = mid;
        while (words.get(begin).compareTo(str) > 0 && begin > 0) {
            begin--;
        }

        end = mid;
        while (words.get(mid).compareTo(str) < 0 && end < words.size()) {
            end++;
        }

        return new int[]{begin, end};
    }

}
