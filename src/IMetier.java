import java.util.List;

public interface IMetier<T> {
    public void add(T o);
    public List<T> getAll();

    public T findById(Long id);
    public void delete(Long id);


}
