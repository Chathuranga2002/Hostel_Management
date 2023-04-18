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
        return studentDAO.update(new Student(dto.getStudent_id(), dto.getName(), dto.getAddress(), dto.getContact_no(),
                dto.getDob(), dto.getGender()));
    }

    @Override
    public StudentDTO serchStudent(String id) throws SQLException, ClassNotFoundException {
        Student all = studentDAO.search(id);
        return new StudentDTO(all.getStudent_id(), all.getName(), all.getAddress(), all.getContact_no(), all.getDob(),
                all.getGender()) ;


    }

    @Override
    public ArrayList<StudentDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<Student> all = studentDAO.getAll();
        ArrayList<StudentDTO> allStudent = new ArrayList<>();
        for (Student student : all) {
            allStudent.add(new StudentDTO(student.getStudent_id(), student.getName(), student.getAddress(),
                    student.getContact_no(), student.getDob(), student.getGender()));
        }
        return allStudent;
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.delete(id);
    }

    @Override
    public boolean existStudentID(String id) throws SQLException, ClassNotFoundException {
        return studentDAO.exist(id);
    }
}
