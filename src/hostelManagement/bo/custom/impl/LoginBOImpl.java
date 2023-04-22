package hostelManagement.bo.custom.impl;

import hostelManagement.bo.custom.LoginBO;
import hostelManagement.dao.DAOFactory;
import hostelManagement.dao.custom.LoginDAO;
import hostelManagement.dto.LoginDTO;
import hostelManagement.entity.Loging;

import java.sql.SQLException;
import java.util.ArrayList;

public class LoginBOImpl implements LoginBO {
    LoginDAO userDAO = (LoginDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.LOGIN);
    @Override
    public boolean saveUser(LoginDTO dto) throws SQLException, ClassNotFoundException {
        return userDAO.save(new Loging(dto.getUserID(), dto.getName(), dto.getAddress(), dto.getContact_no(),
                dto.getPassword(), dto.getGender()));
    }


    public ArrayList<LoginDTO> searchAllUser(String id) throws SQLException, ClassNotFoundException {
        Loging all = userDAO.search(id);
        ArrayList<LoginDTO> allUsersSearch = new ArrayList<>();
        allUsersSearch.add(new LoginDTO(all.getUserID(), all.getName(), all.getAddress(), all.getContact_no(), all.getPassword(), all.getGender()));
        return allUsersSearch;
    }

    @Override
    public LoginDTO search(String id) throws SQLException, ClassNotFoundException {
        Loging all = userDAO.search(id);
        return new LoginDTO(all.getUserID(), all.getName(), all.getAddress(), all.getContact_no(),
                all.getPassword(), all.getGender());
    }
}
