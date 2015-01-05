package org.ogin.util;

import java.io.Serializable;

/**
 * Created by Jabrik on 22/11/2014.
 */
public abstract class AbstractEntity {
    public abstract Serializable getId();

    @Override
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (other == null || other instanceof AbstractEntity == false)
            return false;

        final Serializable id = getId();
        if (id != null)
            return id.equals(((AbstractEntity) other).getId());

        return super.equals(other);
    }

    /**
     * @return the ID's hash-code (database primary key), when ID
     * is not null (persistent state), else delegates to <code>super.hashCode()</code>
     * which normally returns the object's memory address.
     */
    @Override
    public int hashCode() {
        final Serializable id = getId();
        if (id != null)
            return id.hashCode();

        throw new IllegalStateException("Do not use hashCode() with tranisent POJOs, they could get lost in Maps!");
    }
}
