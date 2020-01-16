package kaboni.libertchan.dao;

public interface DAO<T> {
	
    Optional<T> get(int id);
    Collection<T> getAll();
    int save(T t);
    void update(T t);
    void delete(T t);

}
