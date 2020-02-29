package Controllers;

import Apllications.Main;
import Cipher.Cipher;
import Cipher.Imp.CezarCipher;
import file.utils.FileTool;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private Stage mainStage;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainStage = Main.getMainStage();
    }

    @FXML
    TextArea textArea;


    @FXML
    public void triggerEncoding() {
        String userText = textArea.getText();
        if ( !userText.isEmpty() ) {
            Cipher cezarCipher = new CezarCipher();
            String encode = cezarCipher.encode(userText);
            textArea.setText(encode);

        }


    }

    @FXML
    public void triggerDecoding() {
        String userText = textArea.getText();
        if ( !userText.isEmpty() ) {
            Cipher cezarCipher = new CezarCipher();
            String decode = cezarCipher.decode(userText);
            textArea.setText(decode);
        }
    }
    @FXML
    public void saveToFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save to file");
        fileChooser.setInitialFileName("message.crpt");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("crypt file", "*.crpt"),
                new FileChooser.ExtensionFilter("text file", "*.txt")
        );
        File fileToSave = fileChooser.showSaveDialog(null);
        if(fileToSave != null) {
            String absoltePath = fileToSave.getAbsolutePath();
            try {
                FileTool.writeFileContent(absoltePath, textArea.getText());
            }catch (IOException e) {
                System.out.println(" Could not save text in file: " + absoltePath + "expection : " + e);
            }
        }
    }

    public void LoadFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load file");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("crypt file", "*.crpt"),
                new FileChooser.ExtensionFilter("text file", "*.txt")
        );
  File fileToOpen = fileChooser.showOpenDialog(mainStage);
            if(null != fileToOpen) {
                String fileContent = FileTool.getFileContent(fileToOpen.getAbsolutePath());
                textArea.setText(fileContent);


            }
    }
    }



