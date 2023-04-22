package hostelManagement.controller;
import hostelManagement.bo.BOFactory;
import hostelManagement.bo.custom.LoginBO;
import hostelManagement.dto.LoginDTO;
import hostelManagement.dto.StudentDTO;
import hostelManagement.entity.Loging;
import hostelManagement.util.FactoryConfiguration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginFormControler {
        @FXML
        private AnchorPane logging_pane;

        @FXML
        private TextField UserName_Id;

        @FXML
        private PasswordField Pasword_Id;

        @FXML
        private Label lblHide;
        LoginBO userBO = (LoginBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.LOGIN);
        @FXML
        void CancelOnAction(ActionEvent event) {
                 Pasword_Id.setText("");
                 UserName_Id.setText("");

//                 String userID="0001";
//                 String name="thisara";
//                 String address="miriisa";
//                String contact_no="0711650370";
//                 String Password="1234";
//                 String gender="male";
//                try {
//                        userBO.saveUser(new LoginDTO(userID, name, address, contact_no, Password, gender));
//
//                        new Alert(Alert.AlertType.CONFIRMATION, "Update Successful...!").show();
//
//                } catch (SQLException e) {
//                        new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
//                        e.printStackTrace();
//
//                } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                }

        }

        @FXML
        void LoggingOnAction(ActionEvent event) throws IOException {
//                Navigation.navigate(Routes.DASHBORD, logging_pane);
//                String contactText = UserName_Id.getText();
                String password="1234";
                String username="thisara";
//                try {
//                        LoginDTO dto = userBO.search(contactText);
//                        password=dto.getPassword();
//                        username=dto.getUserID();
//
//                } catch (Exception e) {
//                        new Alert(Alert.AlertType.CONFIRMATION, " went wrong...!").show();
//                        e.printStackTrace();
//                }
                System.out.println(password+"  "+Pasword_Id.getText());



                if(username.equals(UserName_Id.getText()) && Pasword_Id.getText().equals(password) ){

                        Parent root = FXMLLoader.load(getClass().getResource("/hostelManagement/view/DashbordForm.fxml"));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setMaximized(true);
                        stage.setTitle("");
                        stage.setScene(scene);
                        stage.show();

                } else {
                        new Alert(Alert.AlertType.CONFIRMATION, " went wrong...!").show();
                }





        }

        @FXML
        void hidePasswordOnMousePressedd(MouseEvent event) {
//                Image img = new Image("/hostelManagement/view/assests/Cloce_Eye1.png");
//                ImageView view = new ImageView(img);
//                view.setFitHeight(10);
//                view.setFitWidth(10);
//                lblHide.setGraphic(view);
//
//                Pasword_Id.setText(Pasword_Id.getPromptText());
//                Pasword_Id.setPromptText("");
//                Pasword_Id.setDisable(false);

        }

        @FXML
        void showPasswordOnMousePressed(MouseEvent event) {
//                Image img = new Image("/hostelManagement/view/assests/Open_Eye1.png");
//                ImageView view = new ImageView(img);
//                view.setFitHeight(10);
//                view.setFitWidth(10);
//                lblHide.setGraphic(view);
//
//                Pasword_Id.setPromptText(Pasword_Id.getText());
//                Pasword_Id.setText("");
//                Pasword_Id.setDisable(true);
//                Pasword_Id.requestFocus();

        }
}
