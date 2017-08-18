package io.github.iwag.finalproj.models.interfaces;

@FunctionalInterface
public interface MapFunction<E, T> {
    public T convert(E e);
}
