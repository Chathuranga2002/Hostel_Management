package hostelManagement.bo.custom.impl;

import hostelManagement.bo.custom.ResivationBO;
import hostelManagement.dao.DAOFactory;
import hostelManagement.dao.custom.ReserveDAO;
import hostelManagement.dao.custom.RoomDAO;
import hostelManagement.dao.custom.StudentDAO;
import hostelManagement.dto.ReservationDTO;
import hostelManagement.dto.RoomDTO;
import hostelManagement.dto.StudentDTO;
import hostelManagement.entity.Room;
import hostelManagement.entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public class ResivationBOImpl  implements ResivationBO {
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    ReserveDAO reserveDAO = (ReserveDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVE);
    @Override
    public StudentDTO serchStudent(String id) throws SQLException, ClassNotFoundException {
        Student all = studentDAO.search(id);
        return new StudentDTO(all.getStudent_id(), all.getName(), all.getAddress(), all.getContact_no(), all.getDob(),
                all.getGender()) ;
    }

    @Override
    public RoomDTO serchRoom(String id) throws SQLException, ClassNotFoundException {
        Room all = roomDAO.search(id);
        return new RoomDTO(all.getRoom_id(), all.getType(), all.getKey_money(), all.getQty());
    }

    @Override
    public boolean saveReservation(ReservationDTO reservation) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<StudentDTO> getAllStudents() throws SQLException, ClassNotFoundException {
        ArrayList<Student> all = studentDAO.getAll();
        ArrayList<StudentDTO> allStudent = new ArrayList<>();
        for (Student student : all) {
            allStudent.add(new StudentDTO(student.getStudent_id(), student.getName(), student.getAddress(), student.getContact_no(), student.getDob(), student.getGender()));
        }
        return allStudent;
    }

    @Override
    public ArrayList<RoomDTO> getAllRooms() throws SQLException, ClassNotFoundException {
        ArrayList<Room> all = roomDAO.getAll();
        ArrayList<RoomDTO> allRoom = new ArrayList<>();
        for (Room room : all) {
            allRoom.add(new RoomDTO(room.getRoom_id(), room.getType(), room.getKey_money(), room.getQty()));
        }
        return allRoom;
    }
}
