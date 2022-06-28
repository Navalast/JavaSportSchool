package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class appController extends Configs2 {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        try (Connection connection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        Statement statement = connection.createStatement()) {
            System.out.println("Связь есть");
            System.out.println();
            ResultSet resultSet = statement.executeQuery("select * from sections.sections");
            while (resultSet.next()) {
                comboBoxPane.getItems().addAll(resultSet.getString(1));
            }
        }
        return dbConnection;
    }


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea textPane;

    @FXML
    private ComboBox<String> comboBoxPane;

    @FXML
    void initialize() {
        try {
            getDbConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        comboBoxPane.setOnAction(actionEvent -> {
            setComboBoxPane();
        });
    }

    public void setComboBoxPane() {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        if (comboBoxPane.getValue().equals("Бокс")){
            try (Connection connection = DriverManager.getConnection(connectionString,
                    dbUser, dbPass);
                 Statement statement = connection.createStatement()) {
                System.out.println("Первый if");
                ResultSet resultSet = statement.executeQuery("select * from sections.info");
                while (resultSet.next()) {
                    textPane.setText(resultSet.getString(1));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (comboBoxPane.getValue().equals("Бег")) {
            try (Connection connection = DriverManager.getConnection(connectionString,
                    dbUser, dbPass);
                 Statement statement = connection.createStatement()) {
                System.out.println("Второй if");
                ResultSet resultSet = statement.executeQuery("select * from sections.info");
                while (resultSet.next()) {
                    textPane.setText(resultSet.getString(2));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (comboBoxPane.getValue().equals("Акробатика")) {
            try (Connection connection = DriverManager.getConnection(connectionString,
                    dbUser, dbPass);
                 Statement statement = connection.createStatement()) {
                System.out.println("Третий if");
                ResultSet resultSet = statement.executeQuery("select * from sections.info");
                while (resultSet.next()) {
                    textPane.setText(resultSet.getString(3));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (comboBoxPane.getValue().equals("Плавание")) {
            try (Connection connection = DriverManager.getConnection(connectionString,
                    dbUser, dbPass);
                 Statement statement = connection.createStatement()) {
                System.out.println("Четвертый if");
                ResultSet resultSet = statement.executeQuery("select * from sections.info");
                while (resultSet.next()) {
                    textPane.setText(resultSet.getString(4));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
