package finalproject.models.interfaces;

@FunctionalInterface
public interface MapFunction<E, T> {
    public T convert(E e);
}
