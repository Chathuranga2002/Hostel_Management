package hostelManagement.dao.custom.impl;


import hostelManagement.dao.custom.StudentDAO;
import hostelManagement.entity.Student;
import hostelManagement.util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {

        ArrayList<Student> allStudents;
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Student ");
        allStudents = (ArrayList<Student>) query.list();
        transaction.commit();
        session.close();
        return allStudents;
    }

    @Override
    public boolean save(Student student) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student student) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Student search(String id) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class,id );
        transaction.commit();
        session.close();
        return student;
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT student_id FROM Student WHERE student_id=:id");
        String id1 = (String) query.setParameter("id", id).uniqueResult();
        if (id1 != null) {
            return true;
        }
        transaction.commit();
        session.close();
        return false;
    }

//    @Override
//    public ObservableList<String> getAllStudentId() throws SQLException, ClassNotFoundException {
////        ObservableList<String> list = FXCollections.observableArrayList();
////        Session session = FactoryConfiguration.getInstance().getSession();
////        Transaction transaction = session.beginTransaction();
//////        Query id = session.createQuery("SELECT student_id FROM Student ");
////        Student student = session.get(Student.class,id );
////        transaction.commit();
////        session.close();
//
//
//        return null;
//    }
}
