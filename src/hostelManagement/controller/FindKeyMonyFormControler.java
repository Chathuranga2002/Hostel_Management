package hostelManagement.controller;
import com.jfoenix.controls.JFXTextField;
import hostelManagement.bo.BOFactory;
import hostelManagement.bo.custom.ResivationBO;
import hostelManagement.bo.custom.RoomManageBO;
import hostelManagement.dto.ReservationDTO;
import hostelManagement.dto.StudentDTO;
import hostelManagement.entity.Reservation;
import hostelManagement.view.TM.ReservationTM;
import hostelManagement.view.TM.StudentTM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class FindKeyMonyFormControler implements Initializable {


        @FXML
        private AnchorPane pane1;

        @FXML
        private TableView<ReservationTM> tblKeyMony;

        @FXML
        private TableColumn colReceveId;

        @FXML
        private TableColumn colRoomId;

        @FXML
        private TableColumn colStudentID;

        @FXML
        private TableColumn coDate;

        @FXML
        private TableColumn colKeymony;

        @FXML
        private TableColumn colstatus;

        @FXML
        private JFXTextField serchId;

        ResivationBO resivationBO = (ResivationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESIVATION);

        @FXML
        void SearchOnAction(ActionEvent event) {

        }
        private void loadAllReserve() {
                tblKeyMony.getItems().clear();
                try {
                        for (ReservationDTO c : resivationBO.getAllResivation()) {
                                tblKeyMony.getItems().add(new ReservationTM(c.getRes_id(), c.getDate(),
                                        c.getStudent_id(), c.getRoom_type_id(),
                                        c.getKey_money(), c.getStatus()));
                        }
                } catch (SQLException throwables) {
                        throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                }
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
                colReceveId.setCellValueFactory(new PropertyValueFactory<>("res_id"));
                colStudentID.setCellValueFactory(new PropertyValueFactory<>("student_id"));
                colRoomId.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
                coDate.setCellValueFactory(new PropertyValueFactory<>("date"));
                colKeymony.setCellValueFactory(new PropertyValueFactory<>("key_money"));
                colstatus.setCellValueFactory(new PropertyValueFactory<>("status"));


                loadAllReserve();
                serchId.setVisible(false);

        }
}
