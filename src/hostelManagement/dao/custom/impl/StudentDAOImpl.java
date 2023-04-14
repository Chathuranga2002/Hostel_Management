package hostelManagement.dao.custom.impl;

import hostelManagement.dao.custom.StudentDAO;
import hostelManagement.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public ArrayList<Student> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Student entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Student entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Student search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
