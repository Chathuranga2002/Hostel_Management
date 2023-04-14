package hostelManagement.dao;


import hostelManagement.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return daoFactory == null ? daoFactory = new DAOFactory() : daoFactory;
    }

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl() ;
            case ROOM:
                return new RoomDAOImpl();
            case RESERVE:
                return new ReserveDAOImpl();
            case LOGIN:
                return new LoginDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        STUDENT, ROOM, RESERVE,LOGIN
    }
}
