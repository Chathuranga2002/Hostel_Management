package hostelManagement.bo.custom;

import hostelManagement.bo.SuperBO;
import hostelManagement.dto.ReservationDTO;
import hostelManagement.dto.RoomDTO;
import hostelManagement.dto.StudentDTO;
import javafx.collections.ObservableList;


import java.sql.SQLException;
import java.util.ArrayList;

public interface ResivationBO extends SuperBO {
    StudentDTO serchStudent(String id)throws SQLException, ClassNotFoundException;
    RoomDTO serchRoom(String id)throws SQLException, ClassNotFoundException;
     boolean saveReservation(ReservationDTO reservation) throws SQLException, ClassNotFoundException ;
    ArrayList<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException;
    ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException;
}
