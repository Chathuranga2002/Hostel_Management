package hostelManagement.controller;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class AddStudentFormControler {



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
        private JFXComboBox<?> combGender;

        @FXML
        void AddStudentOnAction(ActionEvent event) {

        }

        @FXML
        void deleteOnAction(ActionEvent event) {

        }

        @FXML
        void updateOnAction(ActionEvent event) {

        }



}
