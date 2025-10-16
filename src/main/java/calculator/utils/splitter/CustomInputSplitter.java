package calculator.utils.splitter;

import java.util.ArrayList;
import java.util.List;

public class InputSplitter implements DividersAndNumberSplitter {
    private String input;
    private final String SPLITTER = "\\\\n";

    InputSplitter(String input) {
        this.input = input;
    }

    @Override
    public List<String> split() {
        List<String> result = new ArrayList<>();
        int lastIndex = input.lastIndexOf(SPLITTER);
        if (lastIndex == -1) {
            result.add("");
            result.add(input);
        } else {
            result.add(input.substring(0, lastIndex + 3));
            result.add(input.substring(lastIndex + 3));
        }
        return result;
    }
}
