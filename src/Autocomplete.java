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
            words.add(terms[i].toLowerCase());
        }

        Collections.sort(this.words);
    }

    public List<String> autocomplete (String search) {

        int[] bounds = findBounds(search);

        List<String> returnList = new ArrayList<>();

        for (int i = bounds[0]; i <= bounds[1]; i++) {
            returnList.add(words.get(i));
        }

        if (bounds[0] == bounds[1])
            return new ArrayList<>();

        return returnList;
    }

    public int[] findBounds(String str) {
        int begin = 0;
        int end = words.size() - 1;
        int mid = words.size()/2;

        while (!words.get(mid).contains(str)) {
            if (begin == end)
                break;

            if (words.get(mid).compareTo(str) > 0)
                end = mid - 1;
            if (words.get(mid).compareTo(str) < 0)
                begin = mid + 1;

            mid = (begin + end) / 2;

        }

        begin = mid;
        while (words.get(begin).contains(str) && begin > 0) {
            if(!words.get(begin - 1).contains(str))
                break;
            begin--;
        }

        end = mid;
        while (words.get(end).contains(str) && end < words.size() -1 ) {
            if (!words.get(end + 1).contains(str))
                break;
            end++;
        }

        return new int[]{begin, end};
    }

}
