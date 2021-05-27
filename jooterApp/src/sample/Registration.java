package sample;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Registration {


    public static void registerUser(User user) {

        DataSource.getInstance().insertUsers(user);

    }

    public static boolean checkIfUserExists(String login, String email) {

        try (ResultSet userRs = DataSource.getInstance().queryUsers();
             ResultSet adminRs = DataSource.getInstance().queryAdmins()) {

            while (userRs.next()) {
                if (userRs.getString(DataSource.getColumnUserLogin()).equals(login) || userRs.getString(DataSource.getColumnUserEmail()).equals(email)) {
                    return true;
                }
            }
            while (adminRs.next()) {
                if (adminRs.getString(DataSource.getColumnAdminLogin()).equals(login) || adminRs.getString(DataSource.getColumnUserEmail()).equals(email)) {
                    return true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
