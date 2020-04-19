package pro.sisit.adapter;

public interface IOAdapter<T> {

    Object read(int index);

    int append(T entity);
}
