package io.github.iwag.finalproj.interfaces;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberValidatePredicator implements ValidationPredicator<Integer> {
    @Override
    public boolean evaluate(Integer e, Pattern p) {
        return false;
    }
}
