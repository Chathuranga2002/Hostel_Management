package hostelManagement.controller;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class RoomManagementFormControler {


        @FXML
        private AnchorPane pane1;

        @FXML
        private TableView<?> tblRoom;

        @FXML
        private TableColumn<?, ?> colCode;

        @FXML
        private TableColumn<?, ?> coltype;

        @FXML
        private TableColumn<?, ?> colKeymony;

        @FXML
        private TableColumn<?, ?> colqty;

        @FXML
        private JFXTextField txtId;

        @FXML
        private JFXTextField txtroomtype;

        @FXML
        private JFXTextField txtkeymony;

        @FXML
        private JFXTextField txtQty;

        @FXML
        void AddRoomOnAction(ActionEvent event) {

        }

        @FXML
        void deleteOnAction(ActionEvent event) {

        }

        @FXML
        void updateOnAction(ActionEvent event) {

        }

    }
