package org.ogin.dao;

import org.junit.*;
import org.ogin.model.jpa.Klass;
import org.ogin.model.jpa.RegisteredStudent;
import org.ogin.model.jpa.Room;
import org.ogin.model.jpa.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Created by Jabrik on 21/11/2014.
 */
public class TestJpa {
    private EntityManager em;
    private EntityManagerFactory emf;
    private String unit = "kingbaraja-persistence";
    @Before
    public void initEm() {
        emf = Persistence.createEntityManagerFactory(unit);
        em = emf.createEntityManager();

    }
    @After
    public void cleanUp() {
       em.close();
    }

    @Test
    public void studentList() {
        List<Student> students;
        em.getTransaction().begin();
        Query q = em.createQuery("SELECT s from Student s");
        students = q.getResultList();
        assertEquals(11, students.size());
        em.getTransaction().commit();
    }

    @Test
    public void roomList() {
        List<Room> rooms;
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT r from Room r");
        rooms = query.getResultList();
        assertEquals(9, rooms.size());
        em.getTransaction().commit();
    }

    @Test
    public void klassList() {
        List<Klass> klasses;
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT k from Klass k");
        klasses = query.getResultList();
        assertEquals(8, klasses.size());
        em.getTransaction().commit();
    }

    @Test
    public void registeredStudentList() {
        List<RegisteredStudent> lists;
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT rs from RegisteredStudent rs");
        lists = query.getResultList();
        assertEquals(18, lists.size());
        em.getTransaction().commit();
    }

    @Test
    public void callStoredProc() {
        em.getTransaction().begin();
        Query query = em.createNativeQuery("call simple()");
        query.executeUpdate();
        em.getTransaction().commit();
    }
}
