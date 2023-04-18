package hostelManagement.controller;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import hostelManagement.bo.BOFactory;
import hostelManagement.bo.custom.AddStudentBO;
import hostelManagement.dto.StudentDTO;
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

public class AddStudentFormControler implements Initializable {


        AddStudentBO studentBO = (AddStudentBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.STUDENT);

        @FXML
        private AnchorPane pane1;

        @FXML
        private TableView<StudentTM> tblStudent;

        @FXML
        private TableColumn colCode;

        @FXML
        private TableColumn colname;

        @FXML
        private TableColumn colAddress;

        @FXML
        private TableColumn colContact;

        @FXML
        private TableColumn coldate;

        @FXML
        private TableColumn colgender;

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
                String student_id= txtId.getText();

                try {
                        studentBO.deleteStudent(student_id);
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
                String student_id= txtId.getText();
                String name=txtName.getText();
                String address=txtAddress.getText();
                String contact_no=txtContact.getText();
                LocalDate dob=dateofBirth.getValue();
                String gender= combGender.getValue();
                try {
                        studentBO.updateStudent(new StudentDTO(student_id, name, address, contact_no, dob, gender));
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
        private void Nextid() {

//                try {
//
//                        txtId.setText(studentBO.generateNewID());
//
//                } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                }
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
        private void setTable() {
                tblStudent.getItems().clear();
                try {
                        for (StudentDTO c : studentBO.getAll()) {
                                tblStudent.getItems().add(new StudentTM(c.getStudent_id(), c.getName(), c.getAddress(),
                                        c.getContact_no(),c.getDob(),c.getGender()));
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
                combGender.getItems().addAll(gender);
                colCode.setCellValueFactory(new PropertyValueFactory<>("student_id"));
                colname.setCellValueFactory(new PropertyValueFactory<>("name"));
                colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
                colContact.setCellValueFactory(new PropertyValueFactory<>("contact_no"));
                coldate.setCellValueFactory(new PropertyValueFactory<>("dob"));
                colgender.setCellValueFactory(new PropertyValueFactory<>("gender"));




        }

        public void SerchOnAction(ActionEvent actionEvent) {
//                String contactText = txtContact.getText();
//                try {
//                        StudentDTO dto = studentBO.serchStudent(contactText);
//                        txtAddress.setText(dto.getAddress());
//                        txtId.setText(dto.getStudent_id());
//                        txtName.setText(dto.getName());
//                        combGender.setValue(dto.getGender());
//                        dateofBirth.setValue(dto.getDob());
//
//                } catch (ClassNotFoundException e) {
//                        e.printStackTrace();
//                } catch (SQLException throwables) {
//                        throwables.printStackTrace();
//                }

        }


        public void SerchIdOnAction(ActionEvent actionEvent) {
                String contactText = txtId.getText();
                try {
                        StudentDTO dto = studentBO.serchStudent(contactText);
                        txtAddress.setText(dto.getAddress());
                        txtId.setText(dto.getStudent_id());
                        txtContact.setText(dto.getContact_no());
                        txtName.setText(dto.getName());
                        combGender.setValue(dto.getGender());
                        dateofBirth.setValue(dto.getDob());

                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                } catch (SQLException throwables) {
                        throwables.printStackTrace();
                }
        }
}
