package hostelManagement.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormControler {
        @FXML
        private AnchorPane logging_pane;

        @FXML
        private TextField UserName_Id;

        @FXML
        private PasswordField Pasword_Id;

        @FXML
        private Label lblHide;

        @FXML
        void CancelOnAction(ActionEvent event) {

        }

        @FXML
        void LoggingOnAction(ActionEvent event) throws IOException {
//                Navigation.navigate(Routes.DASHBORD, logging_pane);
                Parent root = FXMLLoader.load(getClass().getResource("/hostelManagement/view/DashbordForm.fxml"));
                Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene=new Scene(root);
                stage.setMaximized(true);
                stage.setTitle("");
                stage.setScene(scene);
                stage.show();

        }

        @FXML
        void hidePasswordOnMousePressedd(MouseEvent event) {

        }

        @FXML
        void showPasswordOnMousePressed(MouseEvent event) {

        }
}
