package persistence;

public interface GenericRepository<T> {
    public void add(T entity);
    public T get(int id);
    public void update(T entity);
    public void delete(T entity);
    public int getSize();
}