package hostelManagement.bo.custom;

import hostelManagement.bo.SuperBO;
import hostelManagement.dto.StudentDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AddStudentBO extends SuperBO {
    String generateNewID() throws SQLException, ClassNotFoundException;
    boolean saveStudent(StudentDTO dto)throws SQLException, ClassNotFoundException;
    boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException ;
    StudentDTO serchStudent(String id)throws SQLException, ClassNotFoundException;
    ArrayList<StudentDTO> getAll() throws SQLException, ClassNotFoundException;
}
