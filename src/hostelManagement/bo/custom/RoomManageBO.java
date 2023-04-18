package hostelManagement.bo.custom;

import hostelManagement.bo.SuperBO;
import hostelManagement.dto.RoomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface RoomManageBO extends SuperBO {
    String generateNewID() throws SQLException, ClassNotFoundException;
    boolean save(RoomDTO dto)throws SQLException, ClassNotFoundException;
    boolean update(RoomDTO dto) throws SQLException, ClassNotFoundException ;
    RoomDTO serch(String id)throws SQLException, ClassNotFoundException;
    ArrayList<RoomDTO> getAll() throws SQLException, ClassNotFoundException;
    boolean delete(String id) throws SQLException, ClassNotFoundException;
}
