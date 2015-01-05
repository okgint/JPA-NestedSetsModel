package org.ogin.model.treedao;

import fri.util.database.jpa.tree.nestedsets.NestedSetsTreeNode;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Jabrik on 22/11/2014.
 */
@Entity
@Table(name = "nested_category")
@JsonIgnoreProperties({"topLevel"})
public class Category implements NestedSetsTreeNode {
    @Id
    @SequenceGenerator(name = "CategorySequence", sequenceName = "nested_category_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CategorySequence")
    @Column(name = "category_id")
    private Integer id; // primary key

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "top_level", nullable = true, referencedColumnName = "category_id")
    private NestedSetsTreeNode topLevel;

    @Column(name = "lft")
    private int lft;
    @Column(name = "rgt")
    private int rgt;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getLeft() {
        return lft;
    }

    @Override
    public void setLeft(int i) {
        this.lft = i;
    }

    @Override
    public int getRight() {
        return rgt;
    }

    @Override
    public void setRight(int i) {
        this.rgt = i;
    }

    @Override
    public NestedSetsTreeNode getTopLevel() {
        return topLevel;
    }

    @Override
    public void setTopLevel(NestedSetsTreeNode nestedSetsTreeNode) {
        this.topLevel = nestedSetsTreeNode;
    }

    @Override
    public Serializable getId() {
        return id;
    }

    @Override
    public Category clone() {
        return new Category(getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Category == false)
            return false;

        if (id != null)
            return id.equals(((Category) obj).getId());

        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        if (id != null)
            return id.hashCode();

        throw new IllegalStateException("Do not use hashCode() with tranisent POJOs, they could get lost in Maps!");
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "@" + System.identityHashCode(this) + ": id=" + getId() + ", name=" + getName();
    }
}
