package tree;

import tree.uniqueconstraints.UniqueConstraintViolationException;
import tree.uniqueconstraints.UniqueTreeConstraint;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Jabrik on 20/11/2014.
 */
public interface TreeDao<N extends  TreeNode> {
    int UNDEFINED_POSITION = -1;

    boolean isPersistent(N entity);

    N find(Serializable id);
    void update(N entity) throws UniqueConstraintViolationException;

    boolean isRoot(N entity);

    N createRoot(N root) throws UniqueConstraintViolationException;

    int size(N tree);
    List<N> getRoots();
    void removeAll();

    List<N> getTree(N parent);

    List<N> getTreeCacheable(N parent);

    List<N> findSubTree(N parent, List<N> treeCacheable);

    List<N> findDirectChildren(List<N> treeCacheable);

    boolean isLeaf(N node);

    int getChildCount(N parent);

    List<N> getChildren(N parent);

    N getRoot(N node);

    N getParent(N node);

    List<N> getPath(N node);

    int getLevel(N node);

    boolean isEqualToOrChildOf(N child, N parent);

    boolean isChildOf(N child, N parent);

    N addChild(N parent, N child) throws UniqueConstraintViolationException;

    N addChildAt(N parent, N child, int position) throws UniqueConstraintViolationException;

    N addChildBefore(N sibling, N child) throws UniqueConstraintViolationException;

    void remove(N node);

    void move(N node, N newParent) throws UniqueConstraintViolationException;

    void moveTo(N node, N parent, int position) throws UniqueConstraintViolationException;

    void moveBefore(N node, N sibling) throws UniqueConstraintViolationException;

    void moveToBeRoot(N child) throws UniqueConstraintViolationException;

    N copy (N node, N parent, N copiedNodeTemplate) throws UniqueConstraintViolationException;

    N copyTo(N node, N parent, int position, N copiedNodeTemplate) throws UniqueConstraintViolationException;

    N copyBefore(N node, N sibling, N copiedNodeTemplate) throws UniqueConstraintViolationException;

    N copyToBeRoot(N node, N copiedNodeTemplate) throws UniqueConstraintViolationException;

    public interface CopiedNodeRenamer<N extends TreeNode> {
       public void renameCopiedNode(N node);
    }

    void setCopiedNodeRenamer(CopiedNodeRenamer<N> copiedNodeRenamer);

    List<N> find(N parent, Map<String, Object> criteria);

    void setUniqueTreeConstraint(UniqueTreeConstraint<N> uniqueTreeConstraint);

    void setCheckUniqueConstraintUpdate(boolean checkUniqueConstraintUpdate);

void checkUniqueConstraint(N cloneOfExistingNodeWithNewValues, N root, N originalNode) throws UniqueConstraintViolationException;


}
