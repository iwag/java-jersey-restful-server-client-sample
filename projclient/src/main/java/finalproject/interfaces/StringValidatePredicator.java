package finalproject.interfaces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidatePredicator implements ValidationPredicator<String> {

    @Override
    public boolean evaluate(String e, Pattern p) {
        Matcher m = p.matcher(e);
        return m.find();
    }
}
