package hostelManagement.bo;


import hostelManagement.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        LOGIN,STUDENT,ROOM,RESIVATION,DASHBORD
    }

    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case LOGIN:
                return new LoginBOImpl();
            case DASHBORD:
                return new DashbordBOImpl();
            case RESIVATION:
                return new ResivationBOImpl();
            case ROOM:
                return new RoomManageBOImpl();
            case STUDENT:
                return new AddStudentBOImpl();
            default:
                return null;
        }
    }

}
