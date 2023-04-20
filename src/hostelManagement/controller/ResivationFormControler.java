package hostelManagement.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import hostelManagement.bo.BOFactory;
import hostelManagement.bo.custom.ResivationBO;
import hostelManagement.dto.RoomDTO;
import hostelManagement.dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ResivationFormControler  implements Initializable {


        public Label lblReId;
    public JFXComboBox cobStudentId;
    @FXML
        private AnchorPane pane1;

        @FXML
        private JFXTextField txtStudentId;

        @FXML
        private JFXTextField txtroomtype;

        @FXML
        private JFXTextField txtkeymony;

        @FXML
        private JFXTextField txtQty;

        @FXML
        private JFXTextField txtstudentname;

        @FXML
        private JFXTextField txtContact;

        @FXML
        private JFXTextField txtAddress;

        @FXML
        private JFXTextField txtDob;

        @FXML
        private JFXTextField txtGender;

        @FXML
        private JFXComboBox cobRomId;
        ResivationBO resivationBO = (ResivationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESIVATION);

        @FXML
        void AddStudentOnAction(ActionEvent event) {

        }

        @FXML
        void RecevedOnAction(ActionEvent event) {

        }

    public void StudentSerchOnAction(ActionEvent actionEvent) {
    }

        public void RoomSerchOnAction(ActionEvent actionEvent) {
        }
    private void loadAllRoomIds() {
        try {
            ArrayList<RoomDTO> all = resivationBO.getAllRooms();
            for (RoomDTO roomDTO : all) {
                cobRomId.getItems().add(roomDTO.getRoom_type_id());
            }
        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadAllStudentIds() {
        try {
            ArrayList<StudentDTO> all = resivationBO.getAllStudents();
            for (StudentDTO studentDTO : all) {
                cobStudentId.getItems().add(studentDTO.getStudent_id());
            }

        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    private void loadAllRoomIds() {
//        try {
//            ArrayList<RoomDTO> all = purchaseRoomBO.getAllRooms();
//            for (RoomDTO roomDTO : all) {
//                cmbRoomId.getItems().add(roomDTO.getRoom_type_id());
//            }
//        } catch (SQLException e) {
//            NotificationController.Warring("Rooms Load", "Failed to load customer ids.");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
        @Override
        public void initialize(URL location, ResourceBundle resources) {
            loadAllRoomIds();
        }
}
