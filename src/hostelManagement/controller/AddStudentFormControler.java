package hostelManagement.controller;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import hostelManagement.bo.BOFactory;
import hostelManagement.bo.custom.AddStudentBO;
import hostelManagement.dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddStudentFormControler implements Initializable {


        AddStudentBO studentBO = (AddStudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

        @FXML
        private AnchorPane pane1;

        @FXML
        private TableView<?> tblStudent;

        @FXML
        private TableColumn<?, ?> colCode;

        @FXML
        private TableColumn<?, ?> colname;

        @FXML
        private TableColumn<?, ?> colAddress;

        @FXML
        private TableColumn<?, ?> colContact;

        @FXML
        private TableColumn<?, ?> coldate;

        @FXML
        private TableColumn<?, ?> colgender;

        @FXML
        private JFXTextField txtId;

        @FXML
        private JFXTextField txtName;

        @FXML
        private JFXTextField txtAddress;

        @FXML
        private JFXTextField txtContact;

        @FXML
        private JFXDatePicker dateofBirth;

        @FXML
        private JFXComboBox<String> combGender;

        @FXML
        void AddStudentOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
                 String student_id= txtId.getText();
                 String name=txtName.getText();
                 String address=txtAddress.getText();
                 String contact_no=txtContact.getText();
                 LocalDate dob=dateofBirth.getValue();
                String gender= combGender.getValue();
                try {
                        studentBO.saveStudent(new StudentDTO(student_id, name, address, contact_no, dob, gender));
//                        tblStudent.getItems().add(new StudentTM(id, name, address, cNO, dob, gender));
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

        }

        @FXML
        void updateOnAction(ActionEvent event) {

        }
        private void Nextid() {

                try {

                        txtId.setText(studentBO.generateNewID());

                } catch (SQLException throwables) {
                        throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                }
        }

        private void initUI() {
                txtId.clear();
                txtName.clear();
                txtContact.clear();
                txtAddress.clear();
                dateofBirth.getEditor().clear();
                combGender.getSelectionModel().clearSelection();


        }
        String[] gender ={"male", "female","Other"};

        @Override
        public void initialize(URL location, ResourceBundle resources) {
                initUI();
                combGender.getItems().addAll(gender);


        }

        public void SerchOnAction(ActionEvent actionEvent) {
        }


}
