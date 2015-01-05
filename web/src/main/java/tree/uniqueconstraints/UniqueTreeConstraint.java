package tree.uniqueconstraints;

import tree.DBSession;
import tree.TreeDao;
import tree.TreeNode;
import tree.util.TreeActionLocation;

import java.util.List;

/**
 * Created by Jabrik on 20/11/2014.
 */
public interface UniqueTreeConstraint<N extends TreeNode> {
    boolean checkUniqueConstraint(List<N> candidates, TreeActionLocation<N> location);

    void setContext(DBSession session, TreeDao<N> dao, String nodeEntityName, String pathEntityName);

}
