package hostelManagement.dao.custom.impl;

import hostelManagement.dao.custom.LoginDAO;
import hostelManagement.entity.Loging;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDAOImpl implements LoginDAO {
    @Override
    public ArrayList<Loging> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Loging entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Loging entity) throws SQLException, ClassNotFoundException {
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
    public Loging search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
