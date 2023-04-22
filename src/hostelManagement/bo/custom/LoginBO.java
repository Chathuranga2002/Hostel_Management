package hostelManagement.bo.custom;

import hostelManagement.bo.SuperBO;
import hostelManagement.dto.LoginDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface LoginBO extends SuperBO {
    boolean saveUser(LoginDTO dto) throws SQLException, ClassNotFoundException;
    ArrayList<LoginDTO> searchAllUser(String id) throws SQLException, ClassNotFoundException;
    LoginDTO search(String id) throws SQLException, ClassNotFoundException;
}
