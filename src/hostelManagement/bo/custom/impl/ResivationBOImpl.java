package hostelManagement.bo.custom.impl;

import hostelManagement.bo.custom.ResivationBO;
import hostelManagement.dao.DAOFactory;
import hostelManagement.dao.custom.ReserveDAO;
import hostelManagement.dao.custom.RoomDAO;
import hostelManagement.dao.custom.StudentDAO;
import hostelManagement.dto.ReservationDTO;
import hostelManagement.dto.RoomDTO;
import hostelManagement.dto.StudentDTO;
import hostelManagement.entity.Reservation;
import hostelManagement.entity.Room;
import hostelManagement.entity.Student;
import hostelManagement.util.FactoryConfiguration;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ResivationBOImpl  implements ResivationBO {
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);
    ReserveDAO reserveDAO = (ReserveDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVE);


    @Override
    public ArrayList<ReservationDTO> getAllResivation() throws SQLException, ClassNotFoundException {
        ArrayList<Reservation> all = reserveDAO.getAll();
        ArrayList<ReservationDTO> allReserve = new ArrayList<>();
        for (Reservation r : all) {
            allReserve.add(new ReservationDTO(r.getRes_id(), r.getDate(), r.getStudent_id().getStudent_id(),
                    r.getRoom_id().getRoom_id(), r.getKey_money(), r.getStatus()));
        }
        return allReserve;

    }

    @Override
    public boolean saveReservation(ReservationDTO reservation) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, reservation.getStudent_id());
        Room room = session.get(Room.class, reservation.getRoom_type_id());

        Reservation reserve = new Reservation(reservation.getRes_id(), reservation.getDate(), student, room,
                reservation.getKey_money(), reservation.getStatus());
        session.save(reserve);

        room.setQty(room.getQty() - 1);
        session.update(room);

        transaction.commit();
        session.close();
        return true;
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
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return reserveDAO.generateNewId();
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
