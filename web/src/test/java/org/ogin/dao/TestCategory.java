package org.ogin.dao;

import fri.util.database.jpa.commons.DbSession;
import fri.util.database.jpa.tree.nestedsets.NestedSetsTreeDao;
import fri.util.database.jpa.tree.nestedsets.NestedSetsTreeNode;
import fri.util.database.jpa.tree.nestedsets.uniqueconstraints.UniqueWholeTreeConstraintImpl;
import fri.util.database.jpa.tree.uniqueconstraints.UniqueConstraintViolationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.ogin.model.treedao.Category;
import org.ogin.util.DBSessionJpaImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Jabrik on 22/11/2014.
 */
public class TestCategory {
    private EntityManagerFactory emf;
    private EntityManager em;
    private final String UNIT = "kingbaraja-category";
    private DbSession session;

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory(UNIT);
        em = emf.createEntityManager();
        this.session = new DBSessionJpaImpl(em);
    }
    @After
    public void tear() {
        emf.close();
    }


    public void clean() {
        em.getTransaction().begin();
        final NestedSetsTreeDao dao = new NestedSetsTreeDao(Category.class, session);
        dao.removeAll();
        em.getTransaction().commit();
    }
    @Test
    public void add() throws UniqueConstraintViolationException {
        clean();
        em.getTransaction().begin();
        final NestedSetsTreeDao dao = new NestedSetsTreeDao(Category.class, session);
        dao.setUniqueTreeConstraint(new UniqueWholeTreeConstraintImpl(new String[][] {{"name"}}, false));

        final Category electronics = (Category) dao.createRoot(new Category("Electronic"));
        assertEquals(1, dao.getRoots().size());

        Category television = (Category) dao.addChild(electronics, new Category("Television"));

        Category portable_electronics = (Category) dao.addChild(electronics, new Category("Portable Electronics"));
        assertEquals(3, dao.size(electronics));

        // add children to a child

        final Category tube = (Category) dao.addChildAt(television, new Category("Tube"),1);
        final Category lcd = (Category) dao.addChildAt(television, new Category("LCD"), 2);
        final Category plasma = (Category) dao.addChild(television, new Category("PLASMA"));

        assertEquals(6, dao.size(electronics));
        assertEquals(4, dao.size(television));


        // retrieve children lists
        final List<NestedSetsTreeNode> childrenOfElectronics = dao.getChildren(electronics);
        assertEquals(2, childrenOfElectronics.size());
        assertEquals(television, childrenOfElectronics.get(0));
        assertEquals(portable_electronics, childrenOfElectronics.get(1));


        List<Category> list = null;
        List<NestedSetsTreeNode> node = dao.getRoots();
        Category listOfElectronics = (Category) node.get(0);
        assertEquals("Electronic", listOfElectronics.getName());

        em.getTransaction().commit();
    }
}
