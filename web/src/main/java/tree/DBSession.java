package tree;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Jabrik on 20/11/2014.
 */
public interface DBSession {
    Object get(Class<?> entityClass, Serializable id);

    List<?> queryList(String queryText, Object[] parameters);

    int queryCount(String queryText, Object[] parameters);

    Object save(Object node);

    void refresh(Object node);

    void delete(Object node);

    void executeUpdate(String statement, Object[] parameters);
    void flush();

}
