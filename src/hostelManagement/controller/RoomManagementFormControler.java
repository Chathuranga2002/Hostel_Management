package hostelManagement.controller;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import hostelManagement.bo.BOFactory;
import hostelManagement.bo.custom.AddStudentBO;
import hostelManagement.bo.custom.RoomManageBO;
import hostelManagement.dto.RoomDTO;
import hostelManagement.dto.StudentDTO;
import hostelManagement.view.TM.RoomTM;
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
import java.time.LocalDate;
import java.util.ResourceBundle;

public class RoomManagementFormControler implements Initializable {


        public JFXComboBox<String>cobtype;
        @FXML
        private AnchorPane pane1;

        @FXML
        private TableView<RoomTM> tblRoom;

        @FXML
        private TableColumn colCode;

        @FXML
        private TableColumn coltype;

        @FXML
        private TableColumn colKeymony;

        @FXML
        private TableColumn colqty;

        @FXML
        private JFXTextField txtId;

        @FXML
        private JFXTextField txtroomtype;

        @FXML
        private JFXTextField txtkeymony;

        @FXML
        private JFXTextField txtQty;
        RoomManageBO manageBO = (RoomManageBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.ROOM);

        @FXML
        void AddRoomOnAction(ActionEvent event) {
                String idText= txtId.getText();
                String type = cobtype.getValue();
                String mony  = txtkeymony.getText();
                int qty  = Integer.parseInt(txtQty.getText());


                try {
                        manageBO.save(new RoomDTO(idText,type,mony,qty));
                        setTable();
                        initUI();
                        new Alert(Alert.AlertType.CONFIRMATION, "Added Successful...!").show();

                } catch (SQLException e) {
                        new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
                        e.printStackTrace();

                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                }

        }

        @FXML
        void deleteOnAction(ActionEvent event) {

                try {
                        manageBO.delete(txtId.getText());
                        setTable();
                        initUI();
                        new Alert(Alert.AlertType.CONFIRMATION, "Delete Successful...!").show();

                } catch (SQLException e) {
                        new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
                        e.printStackTrace();

                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                }

        }

        @FXML
        void updateOnAction(ActionEvent event) {
                String idText= txtId.getText();
                String type = cobtype.getValue();
                String mony  = txtkeymony.getText();
                int qty  = Integer.parseInt(txtQty.getText());
                try {
                        manageBO.update(new RoomDTO(idText,type,mony,qty));
                        setTable();
                        initUI();
                        new Alert(Alert.AlertType.CONFIRMATION, "Update Successful...!").show();

                } catch (SQLException e) {
                        new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
                        e.printStackTrace();

                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                }

        }

        public void  SearchOnAction(ActionEvent actionEvent) {
                try {
                        RoomDTO dto = manageBO.serch(txtId.getText());
                        txtkeymony.setText(dto.getKey_money());
                        txtId.setText(dto.getRoom_type_id());
                        txtQty.setText(String.valueOf(dto.getQty()));
                        cobtype.setValue(dto.getType());


                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                } catch (SQLException throwables) {
                        throwables.printStackTrace();
                }
        }
        private void initUI() {
                txtId.clear();
                txtkeymony.clear();
                txtQty.clear();
                cobtype.getSelectionModel().clearSelection();


        }
        String[] type  ={"Non-AC", "Non-AC / Food","AC","AC / Food"};
        private void setTable() {
                tblRoom.getItems().clear();
                try {
                        for (RoomDTO c : manageBO.getAll()) {
                                tblRoom.getItems().add(new RoomTM(c.getRoom_type_id(), c.getType(), c.getKey_money(),
                                        c.getQty()));
                        }
                } catch (SQLException throwables) {
                        throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                }
        }

        @Override
        public void initialize(URL location, ResourceBundle resources) {
                initUI();
                setTable();
                cobtype.getItems().addAll(type);
                colCode.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
                coltype.setCellValueFactory(new PropertyValueFactory<>("type"));
                colKeymony.setCellValueFactory(new PropertyValueFactory<>("key_money"));
                colqty.setCellValueFactory(new PropertyValueFactory<>("qty"));


        }
}
