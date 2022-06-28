package sample;

import animation.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button signUp;

    @FXML
    private TextField login;

    @FXML
    private PasswordField password;

    @FXML
    private Button signIn;

    @FXML
    void initialize() {

        signIn.setOnAction(actionEvent -> {
            String loginText = login.getText().trim();
            String loginPassword = password.getText().trim();

            if (!loginText.equals("") && !loginPassword.equals("")){
                loginUser(loginText, loginPassword);
            }
            else {
                System.out.println("Ошибка");
                Shake userLoginAnim = new Shake(login);
                Shake userPasswordAnim = new Shake(password);
                userLoginAnim.playAnim();
                userPasswordAnim.playAnim();
            }
        });

        signUp.setOnAction(actionEvent -> {
            openNewScene("/sample/signUp.fxml");
        });


    }

    private void loginUser(String loginText, String loginPassword) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUserName(loginText);
        user.setPassword(loginPassword);
        ResultSet result = dbHandler.getUser(user);

        int counter = 0;

        while (true) {
            try {
                if (!result.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            counter++;
        }

        if (counter >= 1) {
            openNewScene("/sample/app.fxml");
        } else {
            Shake userLoginAnim = new Shake(login);
            Shake userPasswordAnim = new Shake(password);
            userLoginAnim.playAnim();
            userPasswordAnim.playAnim();
        }
    }

    public void openNewScene(String window) {
        signUp.getScene().getWindow().hide();

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
        stage.showAndWait();
    }
}