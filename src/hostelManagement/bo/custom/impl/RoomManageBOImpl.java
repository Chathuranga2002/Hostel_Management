package hostelManagement.bo.custom.impl;

import hostelManagement.bo.custom.RoomManageBO;
import hostelManagement.dao.DAOFactory;
import hostelManagement.dao.custom.RoomDAO;
import hostelManagement.dto.RoomDTO;
import hostelManagement.entity.Room;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomManageBOImpl implements RoomManageBO {
     RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(RoomDTO dto) throws SQLException, ClassNotFoundException {
        return roomDAO.save(new Room(dto.getRoom_type_id(), dto.getType(), dto.getKey_money(), dto.getQty()));
    }

    @Override
    public boolean update(RoomDTO dto) throws SQLException, ClassNotFoundException {
        return roomDAO.update(new Room(dto.getRoom_type_id(), dto.getType(), dto.getKey_money(), dto.getQty()));
    }

    @Override
    public RoomDTO serch(String id) throws SQLException, ClassNotFoundException {
        Room all = roomDAO.search(id);
        return new RoomDTO(all.getRoom_id(), all.getType(), all.getKey_money(), all.getQty());

    }

    @Override
    public ArrayList<RoomDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Room> all = roomDAO.getAll();
        ArrayList<RoomDTO> allRoom = new ArrayList<>();
        for (Room room : all) {
            allRoom.add(new RoomDTO(room.getRoom_id(), room.getType(), room.getKey_money(), room.getQty()));
        }
        return allRoom;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return roomDAO.delete(id);
    }
}
