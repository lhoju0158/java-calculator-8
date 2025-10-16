package calculator.utils.splitter;

import java.util.ArrayList;
import java.util.List;

public class CustomInputSplitter implements InputSplitter {
    private final String SPLITTER = "\\n";

    @Override
    public List<String> split(String input) {
        List<String> result = new ArrayList<>();
        int lastIndex = input.lastIndexOf(SPLITTER);
        if (lastIndex == -1) {
            result.add("");
            result.add(input);
        } else {
            result.add(input.substring(0, lastIndex + 2));
            result.add(input.substring(lastIndex + 2));
        }
        return result;
    }
}
