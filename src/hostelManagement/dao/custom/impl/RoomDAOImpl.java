package hostelManagement.dao.custom.impl;

import hostelManagement.dao.custom.RoomDAO;
import hostelManagement.entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomDAOImpl implements RoomDAO {
    @Override
    public ArrayList<Room> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(Room entity) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Room entity) throws SQLException, ClassNotFoundException {
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
    public Room search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
