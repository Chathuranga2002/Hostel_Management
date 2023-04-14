package hostelManagement.dao.custom;


import hostelManagement.dao.CrudDAO;
import hostelManagement.entity.Reservation;

import java.sql.SQLException;

public interface ReserveDAO extends CrudDAO<Reservation, String> {

    String generateNewId() throws SQLException, ClassNotFoundException;

    boolean existStudent(String id) throws SQLException, ClassNotFoundException;
}
