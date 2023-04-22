package hostelManagement.util;


import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
    private static AnchorPane pane2;
    public static void navigate(Routes route, AnchorPane pane) throws IOException {
        Navigation.pane = pane;
        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case LOGIN:
                window.setTitle("LOGIN");
                initUI("LoginForm.fxml");
                break;

            case DASHBORD:
                initUI("DashbordForm.fxml");
                break;
            case ROOM:
                initUI("RoomManagementForm.fxml");
                break;
            case RESIVETION:
                initUI("ResivationForm.fxml");
                break;
            case STUDDENT:
                initUI("AddStudentForm.fxml");
                break;
            case RESIVETIONVIEW:
                initUI("FindKeyMonyForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }
    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                        .getResource("/hostelManagement/view/" + location)));
    }


}
