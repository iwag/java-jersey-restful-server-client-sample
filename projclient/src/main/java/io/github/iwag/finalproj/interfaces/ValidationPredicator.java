package io.github.iwag.finalproj.interfaces;


import java.util.regex.Pattern;

public interface ValidationPredicator<T> {
    public boolean evaluate(T e, Pattern p);
}
