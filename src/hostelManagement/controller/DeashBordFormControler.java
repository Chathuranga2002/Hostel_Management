package hostelManagement.controller;
import hostelManagement.util.DateAndTime;
import hostelManagement.util.Navigation;
import hostelManagement.util.Routes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class DeashBordFormControler implements Initializable {


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
        void LogoutOnAction(ActionEvent event) {

        }

        @FXML
        void deashBordOnAction(ActionEvent event) throws IOException {
//                Navigation.navigate(Routes.DASHBORD, pane);

        }

        @FXML
        void deatilsOnAction(ActionEvent event) {
//                Navigation.navigate(Routes.FEEDBACK, pane);

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

        }
}
