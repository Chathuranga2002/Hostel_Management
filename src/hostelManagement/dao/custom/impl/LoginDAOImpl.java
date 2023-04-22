package hostelManagement.dao.custom.impl;

import hostelManagement.dao.custom.LoginDAO;
import hostelManagement.entity.Loging;
import hostelManagement.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDAOImpl implements LoginDAO {


    @Override
    public ArrayList<Loging> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(Loging loging) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(loging);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Loging loging) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Loging search(String s) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Loging login = session.get(Loging.class, s);
        transaction.commit();
        session.close();
        return login;
    }

    @Override
    public boolean exist(String s) throws SQLException, ClassNotFoundException {
        return false;
    }
}
