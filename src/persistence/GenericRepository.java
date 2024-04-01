package persistence;

import exceptions.OperationNotSupportedException;

import java.util.ArrayList;

public interface GenericRepository<T> {
    public void add(T entity);
    public T get(int id) throws OperationNotSupportedException;
    public ArrayList<T> getAll() throws OperationNotSupportedException;
    public void update(T entity) throws OperationNotSupportedException;
    public void delete(T entity);
}