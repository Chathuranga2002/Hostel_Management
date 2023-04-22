package hostelManagement.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import hostelManagement.bo.BOFactory;
import hostelManagement.bo.custom.ResivationBO;
import hostelManagement.dto.ReservationDTO;
import hostelManagement.dto.RoomDTO;
import hostelManagement.dto.StudentDTO;
import hostelManagement.entity.Room;
import hostelManagement.entity.Student;
import hostelManagement.util.DateAndTime;
import hostelManagement.util.Navigation;
import hostelManagement.util.Routes;
import hostelManagement.view.TM.RoomTM;
import hostelManagement.view.TM.StudentTM;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ResivationFormControler  implements Initializable {
    ResivationBO resivationBO = (ResivationBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.RESIVATION);


    @FXML
    private AnchorPane pane1;

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
    private JFXComboBox<String> Combstatus;

    @FXML
    private Label lblReId;

    @FXML
    private TableView<RoomTM> tblRoom;

    @FXML
    private TableColumn colroomId;

    @FXML
    private TableColumn colroomTyoe;

    @FXML
    private TableColumn colKeyMony;

    @FXML
    private TableColumn colqty;

    @FXML
    private TableView<StudentTM> tblStudent;

    @FXML
    private TableColumn colStId;

    @FXML
    private TableColumn ColstNAme;

    @FXML
    private TableColumn colAddress;

    @FXML
    private TableColumn ColContact;

    @FXML
    private TableColumn ColDob;

    @FXML
    private TableColumn colGender;

    @FXML
    private JFXTextField txtRoomID;

    @FXML
    private JFXTextField txtStId;

    @FXML
    void AddStudentOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.STUDDENT, pane1);

    }

    @FXML
    void OnActionMiuseClickedRoom(MouseEvent event) {
        int index = tblRoom.getSelectionModel ().getSelectedIndex ();
        txtRoomID.setText(colroomId.getCellData (index).toString ());
        txtroomtype.setText(colroomTyoe.getCellData (index).toString ());
        txtQty.setText(colqty.getCellData (index).toString ());
        txtkeymony.setText(colKeyMony.getCellData (index).toString ());


    }

    @FXML
    void OnActionMiuseClickedStudent(MouseEvent event) {
        int index = tblStudent.getSelectionModel ().getSelectedIndex ();
        txtStId.setText(colStId.getCellData (index).toString ());
        txtstudentname.setText(ColstNAme.getCellData (index).toString ());
        txtAddress.setText(colAddress.getCellData (index).toString ());
        txtContact.setText(ColContact.getCellData (index).toString ());
        txtDob.setText(ColDob.getCellData (index).toString ());
        txtGender.setText(colGender.getCellData (index).toString ());


    }

    @FXML
    void RecevedOnAction(ActionEvent event) {
        LocalDate date= LocalDate.parse(DateAndTime.dateNow());
        String res_id=lblReId.getText();
        String student_id=txtStId.getText();
        String room_id=txtRoomID.getText();
        String key_money=txtkeymony.getText();
        String status=Combstatus.getValue();

        try {
            resivationBO.saveReservation(new ReservationDTO(res_id, date, student_id, room_id, key_money, status));
            new Alert(Alert.AlertType.CONFIRMATION, "Receve Successful...!").show();
            setTable();
            nextId();
            cler();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.WARNING, "Something went Wrong...!").show();
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    String[] gender ={"Paid", "Pending"};
    private void setTable() {
        tblStudent.getItems().clear();
        try {
            for (StudentDTO c : resivationBO.getAllStudents()) {
                tblStudent.getItems().add(new StudentTM(c.getStudent_id(), c.getName(), c.getAddress(),
                        c.getContact_no(),c.getDob(),c.getGender()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        tblRoom.getItems().clear();
        try {
            for (RoomDTO c : resivationBO.getAllRooms()) {
                tblRoom.getItems().add(new RoomTM(c.getRoom_type_id(), c.getType(), c.getKey_money(),
                        c.getQty()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
        public void nextId(){
            try {
                lblReId.setText(resivationBO.generateNewId());
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
        public void txtDesible(){

            txtRoomID.setEditable(false);
            txtroomtype.setEditable(false);
            txtQty.setEditable(false);
            txtkeymony.setEditable(false);
            txtStId.setEditable(false);
            txtstudentname.setEditable(false);
            txtAddress.setEditable(false);
            txtContact.setEditable(false);
            txtDob.setEditable(false);
            txtGender.setEditable(false);


        }
        public void cler(){
            txtRoomID.clear();
            txtroomtype.clear();
            txtQty.clear();
            txtkeymony.clear();
            txtStId.clear();
            txtstudentname.clear();
            txtAddress.clear();
            txtContact.clear();
            txtDob.clear();
            txtGender.clear();
            Combstatus.getSelectionModel().clearSelection();

        }



        @Override
        public void initialize(URL location, ResourceBundle resources) {

            Combstatus.getItems().addAll(gender);
            txtDesible();
            setTable();
            nextId();
            colStId.setCellValueFactory(new PropertyValueFactory<>("student_id"));
            ColstNAme.setCellValueFactory(new PropertyValueFactory<>("name"));
            colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            ColContact.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
            ColDob.setCellValueFactory(new PropertyValueFactory<>("dob"));
            colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));

            colroomId.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
            colroomTyoe.setCellValueFactory(new PropertyValueFactory<>("type"));
            colKeyMony.setCellValueFactory(new PropertyValueFactory<>("key_money"));
            colqty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        }
}
