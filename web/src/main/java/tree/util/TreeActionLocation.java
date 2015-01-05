package tree.util;

import tree.TreeNode;

/**
 * Created by Jabrik on 20/11/2014.
 */
public class TreeActionLocation<N extends TreeNode> {
    public enum RelatedNodeType {
        PARENT,
        SIBLING,
    }

    public enum ActionType {
        INSERT,
        UPDATE,
        COPY,
        MOVE,
    }

    public final N root;
    public final RelatedNodeType relatedNodeType;
    public final N relatedNode;

    public final ActionType actionType;

    public TreeActionLocation(N root, RelatedNodeType relatedNodeType, N relatedNode, ActionType actionType) {
        this.root = root;
        this.relatedNodeType = relatedNodeType;
        this.relatedNode = relatedNode;
        this.actionType = actionType;
    }
}
