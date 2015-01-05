package tree;

/**
 * Created by Jabrik on 20/11/2014.
 */
public interface NestedSetsTreeNode extends TreeNode {
    int getLeft();

    int setLeft(int left);
    int getRight();

    int setRight(int right);

    NestedSetsTreeNode getTopLevel();

    void setTopLevel(NestedSetsTreeNode topLevel);
    @Override
    NestedSetsTreeNode clone();
}
