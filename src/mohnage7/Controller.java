package mohnage7;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class Controller {
    @FXML
    TextField directoryTxtField;
    @FXML
    TextField extensionTxtField;
    @FXML
    TextArea fileNamesTxtArea;
    @FXML
    TextArea JQLQueryTxtArea;

    @FXML
    public void showAllFileNames() {
        FileManager fileManager = new FileManager();
        // set fileExtension as empty string if the user doesn't enter it.
        String fileExtension = extensionTxtField.getText().isEmpty() ? "" : extensionTxtField.getText();
        // directory validation
        String directory = directoryTxtField.getText();
        if (directory.isEmpty()) {
            showAlert("Failure", "Directory Can't be empty");
        }
        // fetch all files names
        List<String> fileNamesList = fileManager.getFilesNamesFromDirectory(directory, fileExtension);
        // print results into the text area
        if (fileNamesList.isEmpty()) {
            fileNamesTxtArea.setText("No files have been found");
            JQLQueryTxtArea.setText("Cannot generate Query");
        } else {
            fileNamesTxtArea.setText(String.join("\n", fileNamesList));
            // generate and show query
            JQLQuery jqlQuery = new JQLQuery();
            String containsQuery = jqlQuery.generateContainsQueryFrom(fileNamesList);
            JQLQueryTxtArea.setText(containsQuery);
        }
    }


    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }
}
