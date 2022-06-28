package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class signUpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private PasswordField password_field;

    @FXML
    private Button create;

    @FXML
    private TextField login;

    @FXML
    private TextField surname;

    @FXML
    private TextField country;

    @FXML
    private CheckBox man;

    @FXML
    private CheckBox woman;

    @FXML
    void initialize() {

        create.setOnAction(actionEvent -> {

                signUpNewUser();
                System.out.println("Вася");
                openNewSceneSignUp("/sample/app.fxml");

        });
        }

    private void signUpNewUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();

        String firstName = name.getText();
        String surName = surname.getText();
        String userName = login.getText();
        String password = password_field.getText();
        String location = country.getText();
        String gender = "";

        if (man.isSelected()){
            gender = "Мужской";
        } else {
            gender = "Женский";
        }

        User user = new User(firstName, surName, userName, password, location, gender);

        dbHandler.signUpUser(user);

    }

    public void openNewSceneSignUp(String window) {
        create.getScene().getWindow().hide();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent par = loader.getRoot();
        Stage stage = new Stage();
        stage.setTitle("");
        stage.setResizable(false);
        stage.setScene(new Scene(par));
        stage.show();
    }

}


