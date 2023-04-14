package hostelManagement.bo.custom.impl;

import hostelManagement.bo.custom.AddStudentBO;
import hostelManagement.dao.DAOFactory;
import hostelManagement.dao.custom.StudentDAO;
import hostelManagement.dto.StudentDTO;
import hostelManagement.entity.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public class AddStudentBOImpl implements AddStudentBO {

    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean saveStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return studentDAO.save(new Student(dto.getStudent_id(),dto.getName(),dto.getAddress(),dto.getContact_no(),dto.getDob(),
                dto.getGender()));
    }

    @Override
    public boolean updateStudent(StudentDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public StudentDTO serchStudent(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<StudentDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
