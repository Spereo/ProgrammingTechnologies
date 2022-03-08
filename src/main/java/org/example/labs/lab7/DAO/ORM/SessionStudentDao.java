package org.example.labs.lab7.DAO.ORM;

import org.example.labs.lab7.DAO.StudentDao;
import org.example.labs.lab7.Entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SessionStudentDao implements StudentDao {
    private final SessionFactory sessionFactory;

    public SessionStudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Student findById(Long id) {
        Session session = sessionFactory.openSession();
        return session.get(Student.class, id);
    }

    public void save(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    public void update(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
    }

    public void delete(Student student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(student);
        transaction.commit();
        session.close();
    }

    public List<Student> findAll() {
        Session session = sessionFactory.openSession();
        return (List<Student>) session.createQuery("from Student").list();
    }
}
