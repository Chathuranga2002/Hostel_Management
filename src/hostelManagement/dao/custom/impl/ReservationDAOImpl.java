package hostelManagement.dao.custom.impl;

import hostelManagement.dao.custom.ReservationDAO;
import hostelManagement.entity.Reservation;

import java.sql.SQLException;
import java.util.ArrayList;

public class ReservationDAOImpl implements ReservationDAO {
    @Override
    public ArrayList<Reservation> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Reservation entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Reservation entity) throws SQLException, ClassNotFoundException {
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
    public Reservation search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
