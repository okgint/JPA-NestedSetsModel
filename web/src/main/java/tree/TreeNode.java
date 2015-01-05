package tree;

import java.io.Serializable;

/**
 * Created by Jabrik on 20/11/2014.
 */
public interface TreeNode extends Cloneable {
    Serializable getId();
    TreeNode clone();
}
