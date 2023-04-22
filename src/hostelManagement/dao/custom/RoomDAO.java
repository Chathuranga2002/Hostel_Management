package hostelManagement.dao.custom;


import hostelManagement.dao.CrudDAO;
import hostelManagement.entity.Room;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface RoomDAO extends CrudDAO<Room,String> {

    String generateNewId() throws SQLException, ClassNotFoundException;
}
