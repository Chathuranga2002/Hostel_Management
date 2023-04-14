package hostelManagement.controller;
import hostelManagement.util.Navigation;
import hostelManagement.util.Routes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class DeashBordFormControler {


        @FXML
        private AnchorPane Pane;

        @FXML
        private Text txttime;

        @FXML
        private Label lbltitile;

        @FXML
        private Label lblDate;

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



}
