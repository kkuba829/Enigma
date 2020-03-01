package Controllers;

import Apllications.Main;
import Cipher.Cipher;
import Cipher.Imp.VigenereCipher;
import factories.CipherFactory;
import factories.impl.CipherFactoryImpl;
import file.utils.FileTool;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.ResourceBundle;

import static factories.impl.CipherFactoryImpl.*;


public class MainController implements Initializable {

    @FXML
    public ChoiceBox<String> cipherChoose;
    @FXML
    public TextArea textArea;

    private Stage mainStage;
    private ObservableList<String> possibleCipherMethods =
            FXCollections.observableArrayList(Arrays.asList(CESAR, ROOT13, VigenereCipher));
    private CipherFactory cipherFactory = new CipherFactoryImpl();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cipherChoose.setItems(possibleCipherMethods);
        cipherChoose.setValue(CESAR);
        mainStage = Main.getMainStage();
    }

    @FXML
    public void triggerEncoding() {
        String userText = textArea.getText();
        if ( !userText.isEmpty() ) {
            String cipherType = cipherChoose.getValue();
            Cipher cipher = cipherFactory.create(cipherType);
            if ( cipher instanceof VigenereCipher ) {
                TextInputDialog inputDialog = new TextInputDialog("Key");
                inputDialog.setContentText("Key: ");
                inputDialog.setHeaderText("If you know the key, write it here.");
                Optional<String> userInputOptional = inputDialog.showAndWait();
                if ( userInputOptional.isPresent() && !userInputOptional.get().equals("") ) {
                    ((VigenereCipher) (cipher)).setKey(userInputOptional.get());

                } else {
                    return;
                }

            }
            String encode = cipher.encode(userText);
            textArea.setText(encode);
        }
    }


    @FXML
    public void triggerDecoding() {
        String userText = textArea.getText();
        if ( !userText.isEmpty() ) {
            String cipherType = cipherChoose.getValue();
            Cipher cipher = cipherFactory.create(cipherType);
            if ( cipher instanceof VigenereCipher ) {
                TextInputDialog inputDialog = new TextInputDialog("Key");
                inputDialog.setContentText("Key: ");
                inputDialog.setHeaderText("If you know the key, write it here.");
                Optional<String> userInputOptional = inputDialog.showAndWait();
                if ( userInputOptional.isPresent() && !userInputOptional.get().equals("") ) {
                    ((VigenereCipher) (cipher)).setKey(userInputOptional.get());

                } else {
                    return;
                }
            }
            String decode = cipher.decode(userText);
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
        if ( fileToSave != null ) {
            String absoltePath = fileToSave.getAbsolutePath();
            try {
                FileTool.writeFileContent(absoltePath, textArea.getText());
            } catch (IOException e) {
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
        if ( null != fileToOpen ) {
            String fileContent = FileTool.getFileContent(fileToOpen.getAbsolutePath());
            textArea.setText(fileContent);


        }
    }
}



