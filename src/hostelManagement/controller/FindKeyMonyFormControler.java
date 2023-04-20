package hostelManagement.controller;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class FindKeyMonyFormControler {


        @FXML
        private AnchorPane pane1;

        @FXML
        private TableView<?> tblKeyMony;

        @FXML
        private TableColumn<?, ?> colReceveId;

        @FXML
        private TableColumn<?, ?> colRoomId;

        @FXML
        private TableColumn<?, ?> colStudentID;

        @FXML
        private TableColumn<?, ?> coDate;

        @FXML
        private TableColumn<?, ?> colKeymony;

        @FXML
        private TableColumn<?, ?> colstatus;

        @FXML
        private JFXTextField serchId;

        @FXML
        void SearchOnAction(ActionEvent event) {

        }
}
