package sample;

import java.sql.*;

public class DatabaseHandler extends Configs{
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(User user) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USERS_FIRSTNAME + "," + Const.USERS_SURNAME + "," +
                Const.USERS_USERNAME + "," + Const.USERS_PASSWORD + "," +
                Const.USERS_LOCATION + "," + Const.USERS_GENDER + ")" +
                "VALUES(?,?,?,?,?,?)";

        try {

            PreparedStatement prSt = getDbConnection().prepareStatement(insert);

            prSt.setString(1,user.getFirstName());
            prSt.setString(2,user.getSurName());
            prSt.setString(3,user.getUserName());
            prSt.setString(4,user.getPassword());
            prSt.setString(5,user.getLocation());
            prSt.setString(6,user.getGender());

            prSt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getUser(User user) {
        ResultSet resSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_USERNAME + "=? AND " + Const.USERS_PASSWORD + "=?";

        try {

            PreparedStatement prSt = getDbConnection().prepareStatement(select);

            prSt.setString(1,user.getUserName());
            prSt.setString(2,user.getPassword());


            resSet = prSt.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
        e.printStackTrace();
        }

        return resSet;
    }
}
