package tree.uniqueconstraints;

import tree.TreeNode;

/**
 * Created by Jabrik on 20/11/2014.
 */
public class UniqueConstraintViolationException extends Exception {
        private final TreeNode originator;

    public UniqueConstraintViolationException(String message, TreeNode originator) {
        super(message);
        this.originator = originator;
    }
    public TreeNode getOriginator() {
        return originator;
    }
}
