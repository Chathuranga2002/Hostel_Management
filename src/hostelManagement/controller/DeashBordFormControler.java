package hostelManagement.controller;
import com.jfoenix.controls.JFXButton;
import hostelManagement.util.DateAndTime;
import hostelManagement.util.Navigation;
import hostelManagement.util.Routes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class DeashBordFormControler implements Initializable {


        public JFXButton dashbordBUtton;
        @FXML
        private AnchorPane Pane;

        @FXML
        private Text txttime;

        @FXML
        private Label lbltitile;

        @FXML
        public Label lblDate;

        @FXML
        private AnchorPane pane;

        @FXML
        private AnchorPane pane1;



        @FXML
        void LogoutOnAction(ActionEvent event) throws IOException {
                Parent root = FXMLLoader.load(getClass().getResource("/hostelManagement/view/LoginForm.fxml"));
                Stage stage= (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene=new Scene(root);
                stage.setTitle("login");
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();

        }

        @FXML
        void deashBordOnAction(ActionEvent event) throws IOException {


        }

        @FXML
        void deatilsOnAction(ActionEvent event) throws IOException {
                Navigation.navigate(Routes.RESIVETIONVIEW, pane1);

        }

        @FXML
        void recevationOnAction(ActionEvent event) throws IOException {
                Navigation.navigate(Routes.RESIVETION, pane1);
        }

        @FXML
        void roomsOnAction(ActionEvent event) throws IOException {
                Navigation.navigate(Routes.ROOM, pane1);

        }

        @FXML
        void studentOnAction(ActionEvent event) throws IOException {
                Navigation.navigate(Routes.STUDDENT, pane1);

        }
        private void setTime() {
                Thread clock = new Thread() {
                        public void run() {
                                while (true) {
                                        DateFormat hour = new SimpleDateFormat("hh:mm:ss");
                                        txttime.setText("Time : "+hour.format(new Date()));

                                        try {
                                                sleep(1000);
                                        } catch (InterruptedException ex) {
                                        }
                                }
                        }
                };
                clock.start();
        }


        @Override
        public void initialize(URL location, ResourceBundle resources) {
                setTime();
                lblDate.setText("Date :"+ DateAndTime.dateNow());
                dashbordBUtton.setVisible(false);


        }
}
