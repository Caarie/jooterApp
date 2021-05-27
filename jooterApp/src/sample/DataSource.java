package sample;

import java.sql.*;

public final class DataSource {

    private static final String DB_NAME = "jooterExample";

    private static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/" + DB_NAME;

    private Connection c;

    private static final DataSource instance = new DataSource();


    private DataSource() {
    }

    public static DataSource getInstance() {

        return instance;
    }

    private static final String TABLE_USERS = "Users";
    private static final String COLUMN_USER_ID = "Id";
    private static final String COLUMN_USER_NAME = "Name";
    private static final String COLUMN_USER_SURNAME = "Surname";
    private static final String COLUMN_USER_LOGIN = "Login";
    private static final String COLUMN_USER_PASSWORD = "Password";
    private static final String COLUMN_USER_EMAIL = "Email";
    private static final String COLUMN_USER_CARD_NO = "CardNo";
    private static final String COLUMN_USER_ACC_BALANCE = "AccountBalance";
    private static final String COLUMN_USER_ACC_FUNDS = "AccountFunds";


    private static final String TABLE_ADMINS = "Admins";
    private static final String COLUMN_ADMIN_ID = "Id";
    private static final String COLUMN_ADMIN_NAME = "Name";
    private static final String COLUMN_ADMIN_SURNAME = "Surname";
    private static final String COLUMN_ADMIN_LOGIN = "Login";
    private static final String COLUMN_ADMIN_PASSWORD = "Password";
    private static final String COLUMN_ADMIN_EMAIL = "Email";


    private static final String TABLE_SCOOTERS = "Scooters";
    private static final String COLUMN_SCOOTER_ID = "Id";
    private static final String COLUMN_SCOOTER_MODEL = "Model";
    private static final String COLUMN_SCOOTER_MAX_VELOCITY = "MaxVelocity";
    private static final String COLUMN_SCOOTER_COLOR = "ScooterColor";
    private static final String COLUMN_SCOOTER_AVAILABILITY = "ScooterAvailability";
    private static final String COLUMN_SCOOTER_BASKET = "ScooterBasket";
    private static final String COLUMN_SCOOTER_RANGE = "ScooterRange";
    private static final String COLUMN_SCOOTER_PRICE = "ScooterPrice";
    private static final String COLUMN_SCOOTER_BATTERY = "ScooterBattery";


    private static final String TABLE_RENTS = "Rents";
    private static final String COLUMN_RENTS_ID = "Id";
    private static final String COLUMN_RENTS_TIMESTAMP = "RentalTime";
    private static final String COLUMN_RENTS_RETURN_DATE = "ReturnDate";
    private static final String COLUMN_RENTS_IDUSER = "IdUser";
    private static final String COLUMN_RENTS_IDSCOOTER = "IdScooter";
    private static final String COLUMN_RENTS_BALANCE = "Balance";

    private static final String TABLE_REPORTS = "Reports";
    private static final String COLUMN_REPORTS_ID = "ID";
    private static final String COLUMN_REPORTS_USER_ID = "UserID";
    private static final String COLUMN_REPORT_SUBMISSION_DATE = "SubmissionDate";
    private static final String COLUMN_REPORTS_TEXT = "ReportText";
    private static final String COLUMN_REPORTS_TITLE = "ReportTitle";


    private static final String COLUMN_REPORTS_DESTINATION = "ReportDestination";

    private final String CREATE_REPORTS_TABLE = "CREATE TABLE IF NOT EXISTS " + " " + TABLE_REPORTS +
            "(" +
            COLUMN_REPORTS_ID + " SERIAL PRIMARY KEY, " +
            COLUMN_REPORTS_USER_ID + " INT NOT NULL, " +
            COLUMN_REPORT_SUBMISSION_DATE + " TIMESTAMP NOT NULL, " +
            COLUMN_REPORTS_TITLE + " TEXT NOT NULL, " +
            COLUMN_REPORTS_TEXT + " TEXT NOT NULL, " +
            COLUMN_REPORTS_DESTINATION + " INT NOT NULL ) ";


    private final String CREATE_RENTS_TABLE = " CREATE TABLE IF NOT EXISTS " + " " + TABLE_RENTS +
            "( " +
            COLUMN_RENTS_ID + " SERIAL PRIMARY KEY, " +
            COLUMN_RENTS_TIMESTAMP + " TIMESTAMP NOT NULL , " +
            COLUMN_RENTS_RETURN_DATE + " TIMESTAMP , " +
            COLUMN_RENTS_IDUSER + " INT, " +
            COLUMN_RENTS_IDSCOOTER + " INT, " +
            COLUMN_RENTS_BALANCE + " DOUBLE PRECISION, " +
            " FOREIGN KEY ( " + COLUMN_RENTS_IDUSER + " ) REFERENCES " + TABLE_USERS + " ( " + COLUMN_USER_ID + " ) " + " ON DELETE SET NULL, " +
            " FOREIGN KEY ( " + COLUMN_RENTS_IDSCOOTER + " ) REFERENCES " + TABLE_SCOOTERS + " ( " + COLUMN_SCOOTER_ID + " ) " + " ON DELETE SET NULL" + " ) ";


    private final String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS " + " " + TABLE_USERS +
            "(" +
            COLUMN_USER_ID + " SERIAL PRIMARY KEY,  " +
            COLUMN_USER_NAME + " varchar(20) NOT NULL, " +
            COLUMN_USER_SURNAME + " varchar(20) NOT NULL, " +
            COLUMN_USER_LOGIN + " varchar(20) NOT NULL, " +
            COLUMN_USER_PASSWORD + " varchar(20) NOT NULL, " +
            COLUMN_USER_EMAIL + " varchar(20) NOT NULL, " +
            COLUMN_USER_CARD_NO + " varchar(20) NOT NULL, " +
            COLUMN_USER_ACC_FUNDS + " DOUBLE PRECISION NOT NULL, " +
            COLUMN_USER_ACC_BALANCE + " DOUBLE PRECISION NOT NULL )";

    private final String CREATE_ADMINS_TABLE = "CREATE TABLE IF NOT EXISTS " + " " + TABLE_ADMINS +
            "(" +
            COLUMN_ADMIN_ID + " SERIAL PRIMARY KEY, " +
            COLUMN_ADMIN_NAME + " varchar(20) NOT NULL, " +
            COLUMN_ADMIN_SURNAME + " varchar(20) NOT NULL, " +
            COLUMN_ADMIN_LOGIN + " varchar(20) NOT NULL," +
            COLUMN_ADMIN_PASSWORD + " varchar(20) NOT NULL, " +
            COLUMN_ADMIN_EMAIL + " varchar(20) NOT NULL) ";

    private final String CREATE_SCOOTERS_TABLE = "CREATE TABLE IF NOT EXISTS " + " " + TABLE_SCOOTERS +
            "(" +
            COLUMN_SCOOTER_ID + " SERIAL PRIMARY KEY, " +
            COLUMN_SCOOTER_MODEL + " varchar(20) NOT NULL, " +
            COLUMN_SCOOTER_MAX_VELOCITY + " INT NOT NULL, " +
            COLUMN_SCOOTER_COLOR + " varchar(20) NOT NULL, " +
            COLUMN_SCOOTER_AVAILABILITY + " INT NOT NULL, " +
            COLUMN_SCOOTER_BASKET + " INT NOT NULL, " +
            COLUMN_SCOOTER_RANGE + " INT NOT NULL, " +
            COLUMN_SCOOTER_PRICE + " DOUBLE PRECISION NOT NULL, " +
            COLUMN_SCOOTER_BATTERY + " INT NOT NULL )";

    private static final String TABLE_RHISTORY = "Rhistory";

    private final String CREATE_RHISTORY_TABLE = " CREATE TABLE IF NOT EXISTS " + " " + TABLE_RHISTORY +
            "( " +
            COLUMN_SCOOTER_MODEL + " varchar(20) NOT NULL, " +
            COLUMN_SCOOTER_MAX_VELOCITY + " INT NOT NULL, " +
            COLUMN_SCOOTER_COLOR + " varchar(20) NOT NULL, " +
            COLUMN_SCOOTER_BASKET + " INT NOT NULL, " +
            COLUMN_SCOOTER_RANGE + " INT NOT NULL, " +
            COLUMN_SCOOTER_PRICE + " INT NOT NULL, " +
            COLUMN_SCOOTER_BATTERY + " INT NOT NULL , " +
            COLUMN_RENTS_TIMESTAMP + " TIMESTAMP NOT NULL , " +
            COLUMN_RENTS_RETURN_DATE + " TIMESTAMP , " +
            COLUMN_RENTS_IDUSER + " INT, " +
            COLUMN_SCOOTER_ID + " INT, " +
            COLUMN_USER_NAME + " varchar(20), " +
            COLUMN_USER_SURNAME + " varchar(20), " +
            COLUMN_RENTS_BALANCE + " DOUBLE PRECISION " + " ) ";

    //getters

    public static String getColumnScooterID() {
        return COLUMN_SCOOTER_ID;
    }

    public static String getColumnReportsDestination() {
        return COLUMN_REPORTS_DESTINATION;
    }

    public static String getColumnRentsReturnDate() {
        return COLUMN_RENTS_RETURN_DATE;
    }

    public static String getColumnAdminID() {
        return COLUMN_ADMIN_ID;
    }

    public static String getColumnAdminLogin() {
        return COLUMN_ADMIN_LOGIN;
    }

    public static String getColumnAdminPassword() {
        return COLUMN_ADMIN_PASSWORD;
    }

    public static String getColumnUserLogin() {
        return COLUMN_USER_LOGIN;
    }

    public static String getColumnUserID() {
        return COLUMN_USER_ID;
    }

    public static String getColumnUserPassword() {
        return COLUMN_USER_PASSWORD;
    }

    public static String getColumnUserEmail() {
        return COLUMN_USER_EMAIL;
    }

    public static String getColumnUserName() {
        return COLUMN_USER_NAME;
    }

    public static String getColumnUserSurname() {
        return COLUMN_USER_SURNAME;
    }

    public static String getColumnUserCardNo() {
        return COLUMN_USER_CARD_NO;
    }

    public static String getColumnUserAccBalance() {
        return COLUMN_USER_ACC_BALANCE;
    }

    public static String getColumnUserAccFunds() {
        return COLUMN_USER_ACC_FUNDS;
    }

    public static String getColumnScooterModel() {
        return COLUMN_SCOOTER_MODEL;
    }

    public static String getColumnScooterMaxVelocity() {
        return COLUMN_SCOOTER_MAX_VELOCITY;
    }

    public static String getColumnScooterColor() {
        return COLUMN_SCOOTER_COLOR;
    }

    public static String getColumnRentsBalance() {
        return COLUMN_RENTS_BALANCE;
    }

    public static String getColumnScooterAvailability() {
        return COLUMN_SCOOTER_AVAILABILITY;
    }

    public static String getColumnScooterBasket() {
        return COLUMN_SCOOTER_BASKET;
    }

    public static String getColumnScooterRange() {
        return COLUMN_SCOOTER_RANGE;
    }

    public static String getColumnScooterPrice() {
        return COLUMN_SCOOTER_PRICE;
    }

    public static String getColumnScooterBattery() {
        return COLUMN_SCOOTER_BATTERY;
    }

    public static String getColumnRentsId() {
        return COLUMN_RENTS_ID;
    }

    public static String getColumnRentsTimestamp() {
        return COLUMN_RENTS_TIMESTAMP;
    }

    public static String getColumnRentsIDUser() {
        return COLUMN_RENTS_IDUSER;
    }

    public static String getColumnRentsIDScooter() {
        return COLUMN_RENTS_IDSCOOTER;
    }

    public static String getColumnReportsId() {
        return COLUMN_REPORTS_ID;
    }

    public static String getColumnReportsUserId() {
        return COLUMN_REPORTS_USER_ID;
    }

    public static String getColumnReportSubmissionDate() {
        return COLUMN_REPORT_SUBMISSION_DATE;
    }

    public static String getColumnReportsText() {
        return COLUMN_REPORTS_TEXT;
    }

    public static String getColumnReportsTitle() {
        return COLUMN_REPORTS_TITLE;
    }

    // maybe just create one PreparedStatement and reinitialize the variable every time?

    public ResultSet queryUsers() throws SQLException {

        ResultSet rs;

        try (PreparedStatement ps = c.prepareStatement(QUERY_USERS)) {

            rs = ps.executeQuery();

        }

        return rs;
    }

    public ResultSet queryUser(int id) throws SQLException {

        ResultSet rs;

        try (PreparedStatement ps = c.prepareStatement(QUERY_USER)) {
            ps.setInt(1, id);
            rs = ps.executeQuery();
        }

        return rs;
    }

    // SQL expressions

    private static final String QUERY_USERS = "SELECT * FROM " + TABLE_USERS;

    private static final String QUERY_USER_BALANCE = " SELECT " + COLUMN_USER_ACC_BALANCE + " FROM " + TABLE_USERS + " WHERE " + COLUMN_USER_ID + " = ? ";

    private static final String QUERY_USER_FUNDS = " SELECT " + COLUMN_USER_ACC_FUNDS + " FROM " + TABLE_USERS + " WHERE " + COLUMN_USER_ID + " = ? ";

    private static final String UPDATE_RENTS_BALANCE = " UPDATE " + TABLE_RENTS + " SET " + COLUMN_RENTS_BALANCE + " = " + " ? " + " WHERE " + COLUMN_RENTS_ID + " = ? ";

    private static final String UPDATE_USER_ACC_BALANCE = " UPDATE " + TABLE_USERS + " SET " + COLUMN_USER_ACC_BALANCE + " = " + " ( ? ) " + " WHERE " + COLUMN_USER_ID + " = ? ";

    private static final String UPDATE_USER_ACC_FUNDS = " UPDATE " + TABLE_USERS + " SET " + COLUMN_USER_ACC_FUNDS + " = " + " ( ? ) " + " WHERE " + COLUMN_USER_ID + " = ? ";

    private static final String QUERY_USER = " SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USER_ID + " = ? ";

    private static final String QUERY_SCOOTER = " SELECT * FROM " + TABLE_SCOOTERS + " WHERE " + COLUMN_SCOOTER_ID + " = ? ";

    private static final String UPDATE_USER = " UPDATE " + TABLE_USERS + " SET " + " ( " + COLUMN_USER_NAME + ", " + COLUMN_USER_SURNAME + ", " + COLUMN_USER_LOGIN + ", " + COLUMN_USER_PASSWORD + ", " + COLUMN_USER_EMAIL + ", " + COLUMN_USER_CARD_NO + " ) " + " = " + " ( ? , ? , ? , ? , ? , ? ) " + " WHERE " + COLUMN_SCOOTER_ID + " = ? ";

    private static final String UPDATE_SCOOTERSS = " UPDATE " + TABLE_SCOOTERS + " SET " + " ( " + COLUMN_SCOOTER_MAX_VELOCITY + ", " + COLUMN_SCOOTER_COLOR + ", " + COLUMN_SCOOTER_BASKET + ", " + COLUMN_SCOOTER_AVAILABILITY + ", " + COLUMN_SCOOTER_RANGE + ", " + COLUMN_SCOOTER_PRICE + " ) " + " = " + " ( ? , ? , ? , ? , ? , ? ) " + " WHERE " + COLUMN_SCOOTER_ID + " = ? ";

    private static final String QUERY_ADMINS = " SELECT * FROM " + TABLE_ADMINS;

    private static final String UPDATE_SCOOTER_AVAILABILITY = " UPDATE " + TABLE_SCOOTERS + " SET " + COLUMN_SCOOTER_AVAILABILITY + " = " + "  ?  " + " WHERE " + COLUMN_SCOOTER_ID + " = ? ";

    private static final String UPDATE_SCOOTER_BATTERY = " UPDATE " + TABLE_SCOOTERS + " SET " + COLUMN_SCOOTER_BATTERY + " = " + "  ?  " + " WHERE " + COLUMN_SCOOTER_ID + " = ? ";

    private static final String INSERT_INTO_RENTALS = " INSERT INTO " + TABLE_RENTS + " ( " + COLUMN_RENTS_TIMESTAMP + ", " + COLUMN_RENTS_IDUSER + ", " + COLUMN_RENTS_IDSCOOTER + " ) " +
            "VALUES ( ? , ? , ? )";
    private static final String INSERT_INTO_REPORTS = " INSERT INTO " + TABLE_REPORTS + " ( " + COLUMN_REPORTS_USER_ID + ", " + COLUMN_REPORT_SUBMISSION_DATE + ", " + COLUMN_REPORTS_TITLE + ", " + COLUMN_REPORTS_TEXT + ", " + COLUMN_REPORTS_DESTINATION + " ) " +
            "VALUES ( ? , ? , ? , ?, ?)";

    private static final String UPDATE_RETURN_DATE = " UPDATE " + TABLE_RENTS + " SET " + COLUMN_RENTS_RETURN_DATE + " = " + " ( ? ) " + " WHERE " + COLUMN_RENTS_ID + " = ? ";

    private static final String JOIN_SCOOTERS_ON_RENTALS = " SELECT " + TABLE_SCOOTERS + "." + COLUMN_SCOOTER_MODEL + ", " + TABLE_SCOOTERS + "." + COLUMN_SCOOTER_MAX_VELOCITY + ", " + TABLE_SCOOTERS + "." + COLUMN_SCOOTER_COLOR + ", " + TABLE_SCOOTERS + "." + COLUMN_SCOOTER_AVAILABILITY + ", " + TABLE_SCOOTERS + "." + COLUMN_SCOOTER_BASKET + ", " + TABLE_SCOOTERS + "." + COLUMN_SCOOTER_RANGE + ", " + TABLE_SCOOTERS + "." + COLUMN_SCOOTER_PRICE + ", " + TABLE_SCOOTERS + "." + COLUMN_SCOOTER_BATTERY + ", " + TABLE_RENTS + "." + COLUMN_RENTS_TIMESTAMP + ", " + TABLE_RENTS + "." + COLUMN_RENTS_IDUSER + ", " + TABLE_RENTS + "." + COLUMN_RENTS_IDSCOOTER + ", " + TABLE_RENTS + "." + COLUMN_RENTS_RETURN_DATE + ", " + TABLE_RENTS + "." + COLUMN_RENTS_ID + ", " + TABLE_RENTS + "." + COLUMN_RENTS_BALANCE + " FROM " + TABLE_SCOOTERS + " INNER JOIN " + TABLE_RENTS + " ON " + TABLE_SCOOTERS + "." + COLUMN_SCOOTER_ID + " = " + TABLE_RENTS + "." + COLUMN_RENTS_IDSCOOTER + " WHERE " + TABLE_RENTS + "." + COLUMN_RENTS_RETURN_DATE + " IS NULL " + " AND " + TABLE_RENTS + "." + COLUMN_RENTS_IDUSER + " = ? ";

    private static final String QUERY_RHISTORY = " SELECT * FROM " + TABLE_RHISTORY + " WHERE " + COLUMN_RENTS_IDUSER + " = " + " ? ";

    private static final String DELETE_FROM_USERS = " DELETE FROM " + TABLE_USERS + " WHERE " + COLUMN_USER_ID + " = " + " ? ";

    private static final String SELECT_COLOR = " SELECT * FROM " + TABLE_SCOOTERS + " WHERE " + COLUMN_SCOOTER_COLOR + " = ?";

    private static final String SELECT_PRICE = " SELECT * FROM " + TABLE_SCOOTERS + " WHERE " + COLUMN_SCOOTER_PRICE + " = ?";

    private static final String SELECT_AVA = " SELECT * FROM " + TABLE_SCOOTERS + " WHERE " + COLUMN_SCOOTER_AVAILABILITY + " = ? ";

    private static final String SELECT_RANGE = " SELECT * FROM " + TABLE_SCOOTERS + " WHERE " + COLUMN_SCOOTER_RANGE + " BETWEEN " + " ? " + " AND " + " ? ";

    private static final String QUERY_REPORTS = " SELECT * FROM " + TABLE_REPORTS;

    private static final String DELETE_FROM_REPORTS = " DELETE FROM " + TABLE_REPORTS + " WHERE " + COLUMN_REPORTS_ID + " = ? ";

    private static final String QUERY_REPORTS_BY_ID = " SELECT * FROM " + TABLE_REPORTS + " WHERE " + COLUMN_REPORTS_ID + " = ? ";

    private static final String QUERY_ALL_FROM_RHISTORY = " SELECT * FROM " + TABLE_RHISTORY;

    private final String INSERT_INTO_USERS = " INSERT INTO " + TABLE_USERS + " ( " + COLUMN_USER_NAME + ", " + COLUMN_USER_SURNAME + ", " + COLUMN_USER_LOGIN + ", " + COLUMN_USER_PASSWORD + ", " + COLUMN_USER_EMAIL + ", " + COLUMN_USER_CARD_NO + ", " + COLUMN_USER_ACC_BALANCE + ", " + COLUMN_USER_ACC_FUNDS + " ) " +
            "VALUES ( ? , ? , ? , ?, ?, ?, ?, ?)";

    private final String INSERT_INTO_SCOOTERS = " INSERT INTO " + TABLE_SCOOTERS + " ( " + COLUMN_SCOOTER_MODEL + ", " + COLUMN_SCOOTER_MAX_VELOCITY + ", " + COLUMN_SCOOTER_COLOR + ", " + COLUMN_SCOOTER_AVAILABILITY + ", " + COLUMN_SCOOTER_BASKET + ", " + COLUMN_SCOOTER_RANGE + ", " + COLUMN_SCOOTER_PRICE + ", " + COLUMN_SCOOTER_BATTERY + " ) " +
            "VALUES ( ? , ? , ? , ?, ?, ?, ?, ? )";

    private final String INSERT_INTO_RHISTORY = " INSERT INTO " + TABLE_RHISTORY + " ( " + COLUMN_SCOOTER_MODEL + ", " + COLUMN_SCOOTER_MAX_VELOCITY + ", " + COLUMN_SCOOTER_COLOR + ", " + COLUMN_SCOOTER_BASKET + ", " + COLUMN_SCOOTER_RANGE + ", " + COLUMN_SCOOTER_PRICE + ", " + COLUMN_SCOOTER_BATTERY + ", " + COLUMN_RENTS_IDUSER + ", " + COLUMN_RENTS_TIMESTAMP + ", " + COLUMN_RENTS_RETURN_DATE + "," + COLUMN_RENTS_BALANCE + ", " + COLUMN_SCOOTER_ID + ", " + COLUMN_USER_NAME + ", " + COLUMN_USER_SURNAME + " ) " +
            "VALUES ( ? , ? , ? , ?, ?, ?, ?, ? , ? , ? , ?, ?, ?, ? )";


    private final String DELETE_SCOOTER = " DELETE FROM " + TABLE_SCOOTERS + " WHERE " + COLUMN_SCOOTER_ID + " = " + " ? ";

    private final String DELETE_FROM_RHISTORY = " DELETE FROM " + TABLE_RHISTORY + " WHERE " + COLUMN_RENTS_IDUSER + " = " + " ? ";

    private static final String QUERY_SCOOTERS = " SELECT * FROM " + TABLE_SCOOTERS;

    public ResultSet queryReportsByID(int reportID) {

        try (PreparedStatement ps = c.prepareStatement(QUERY_REPORTS_BY_ID)) {
            ps.setInt(1, reportID);
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void deleteFromReports(int reportID) {

        try (PreparedStatement ps = c.prepareStatement(DELETE_FROM_REPORTS)) {
            ps.setInt(1, reportID);
            ps.executeUpdate();
            c.commit();


        } catch (SQLException e) {
            e.printStackTrace();


        }

    }

    public ResultSet queryAllFromRhistory() {

        ResultSet rs;

        try (PreparedStatement ps = c.prepareStatement(QUERY_ALL_FROM_RHISTORY)) {
            return rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }


    public ResultSet joinScooterOnRentals(int userID) throws SQLException {

        ResultSet rs;

        try (PreparedStatement ps = c.prepareStatement(JOIN_SCOOTERS_ON_RENTALS)) {
            ps.setInt(1, userID);
            rs = ps.executeQuery();
        }

        return rs;
    }

    public ResultSet queryReports() throws SQLException {

        try (PreparedStatement ps = c.prepareStatement(QUERY_REPORTS)) {

            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet queryAdmins() throws SQLException {

        ResultSet rs;

        try (PreparedStatement ps = c.prepareStatement(QUERY_ADMINS)) {

            rs = ps.executeQuery();
        }

        return rs;
    }


    public ResultSet queryScooters() throws SQLException {

        ResultSet rs;

        try (PreparedStatement ps = c.prepareStatement(QUERY_SCOOTERS)) {

            rs = ps.executeQuery();
        }
        return rs;
    }

    public ResultSet queryScooter(int scooterID) throws SQLException {

        ResultSet rs;

        try (PreparedStatement ps = c.prepareStatement(QUERY_SCOOTER)) {
            ps.setInt(1, scooterID);
            rs = ps.executeQuery();
        }

        return rs;
    }


    public ResultSet queryUserBalance(int userID) throws SQLException {

        ResultSet rs;

        try (PreparedStatement ps = c.prepareStatement(QUERY_USER_BALANCE)) {
            ps.setInt(1, userID);
            rs = ps.executeQuery();
        }
        return rs;
    }

    public ResultSet queryUserFunds(int userID) throws SQLException {

        ResultSet rs;

        try (PreparedStatement ps = c.prepareStatement(QUERY_USER_FUNDS)) {
            ps.setInt(1, userID);
            rs = ps.executeQuery();
        }
        return rs;
    }

    public void updateUserAccBalance(double amount, int userID) {

        try (PreparedStatement ps = c.prepareStatement(UPDATE_USER_ACC_BALANCE)) {
            ps.setDouble(1, amount);
            ps.setInt(2, userID);
            ps.executeUpdate();
            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserAccFunds(double amount, int userID) {

        try (PreparedStatement ps = c.prepareStatement(UPDATE_USER_ACC_FUNDS)) {
            ps.setDouble(1, amount);
            ps.setInt(2, userID);
            ps.executeUpdate();
            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet queryRHistory(int userID) throws SQLException {

        ResultSet rs;

        try (PreparedStatement ps = c.prepareStatement(QUERY_RHISTORY)) {
            ps.setInt(1, userID);
            rs = ps.executeQuery();
        }

        return rs;
    }


    public ResultSet selectAva(int number) throws SQLException {

        ResultSet rs;

        try (PreparedStatement ps = c.prepareStatement(SELECT_AVA)) {
            ps.setInt(1, number);
            rs = ps.executeQuery();
        }
        return rs;
    }


    public ResultSet selectColor(String color) throws SQLException {

        ResultSet rs;

        try (PreparedStatement ps = c.prepareStatement(SELECT_COLOR)) {
            ps.setString(1, color);
            rs = ps.executeQuery();
        }

        return rs;
    }

    public ResultSet selectPrice(double price) throws SQLException {

        ResultSet rs;

        try (PreparedStatement ps = c.prepareStatement(SELECT_PRICE)) {
            rs = ps.executeQuery();
        }

        return rs;

    }

    public ResultSet selectRange(int range1, int range2) throws SQLException {

        ResultSet rs;

        try (PreparedStatement ps = c.prepareStatement(SELECT_RANGE)) {
            ps.setInt(1, range1);
            ps.setInt(2, range2);
            rs = ps.executeQuery();
        }

        return rs;
    }

    public void deleteFromUsers(int userID) {

        try (PreparedStatement ps = c.prepareStatement(DELETE_FROM_USERS)) {
            ps.setInt(1, userID);
            ps.executeUpdate();
            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertIntoRhistory(ScooterJoin sj, User user) {

        try (PreparedStatement ps = c.prepareStatement(INSERT_INTO_RHISTORY)) {
            ps.setString(1, sj.getScooterModel());
            ps.setInt(2, sj.getScooterMaxVelocity());
            ps.setString(3, sj.getScooterColor());
            ps.setInt(4, sj.getScooterBasket());
            ps.setInt(5, sj.getScooterRange());
            ps.setDouble(6, sj.getScooterPrice());
            ps.setInt(7, sj.getScooterBattery());
            ps.setInt(8, sj.getUserID());
            ps.setTimestamp(9, sj.getRentalTime());
            ps.setTimestamp(10, sj.getReturnDate());
            ps.setDouble(11, sj.getBalance());
            ps.setInt(12, sj.getRentsScooterID());
            ps.setString(13, user.getUserName());
            ps.setString(14, user.getUserSurname());
            ps.executeUpdate();
            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertIntoRentals(Rent rent) {

        try (PreparedStatement ps = c.prepareStatement(INSERT_INTO_RENTALS)) {

            ps.setTimestamp(1, rent.getRentalTime());
            ps.setInt(2, rent.getUserID());
            ps.setInt(3, rent.getRentScooterID());
            ps.executeUpdate();
            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void insertIntoReports(Report report) {

        try (PreparedStatement ps = c.prepareStatement(INSERT_INTO_REPORTS)) {

            ps.setInt(1, report.getUserID());
            ps.setTimestamp(2, report.getSubmissionDate());
            ps.setString(3, report.getReportTitle());
            ps.setString(4, report.getReportText());
            ps.setInt(5, report.getDestination());
            ps.executeUpdate();
            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateUser(User user) {

        try (PreparedStatement ps = c.prepareStatement(UPDATE_USER)) {

            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserSurname());
            ps.setString(3, user.getUserLogin());
            ps.setString(4, user.getUserPassword());
            ps.setString(5, user.getUserEmail());
            ps.setString(6, user.getUserCardNo());
            ps.setInt(7, user.getUserID());
            ps.executeUpdate();
            c.commit();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public void updateRentsBalance(double balance, int rentsID) {

        try (PreparedStatement ps = c.prepareStatement(UPDATE_RENTS_BALANCE)) {

            ps.setDouble(1, balance);
            ps.setInt(2, rentsID);
            ps.executeUpdate();
            c.commit();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void updateScooter(Scooter scooter) {

        try (PreparedStatement ps = c.prepareStatement(UPDATE_SCOOTERSS)) {

            ps.setInt(1, scooter.getScooterMaxVelocity());
            ps.setString(2, scooter.getScooterColor());
            ps.setInt(3, scooter.getScooterBasket());
            ps.setInt(4, scooter.getScooterAvailability());
            ps.setInt(5, scooter.getScooterRange());
            ps.setDouble(6, scooter.getScooterPrice());
            ps.setInt(7, scooter.getScooterID());
            ps.executeUpdate();
            c.commit();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

    public void updateReturnDate(Timestamp tsp, int rentsID) {

        try (PreparedStatement ps = c.prepareStatement(UPDATE_RETURN_DATE)) {
            ps.setTimestamp(1, tsp);
            ps.setInt(2, rentsID);
            ps.executeUpdate();
            c.commit();

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void updateScooterAvailability(Scooter scooter) {

        try (PreparedStatement ps = c.prepareStatement(UPDATE_SCOOTER_AVAILABILITY)) {

            ps.setInt(1, scooter.getScooterAvailability());
            ps.setInt(2, scooter.getScooterID());
            ps.executeUpdate();
            c.commit();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void updateScooterBattery(Scooter scooter) {

        try (PreparedStatement ps = c.prepareStatement(UPDATE_SCOOTER_BATTERY)) {

            ps.setInt(1, scooter.getScooterBattery());
            ps.setInt(2, scooter.getScooterID());
            ps.executeUpdate();
            c.commit();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void insertUsers(User user) {

        try (PreparedStatement ps = c.prepareStatement(INSERT_INTO_USERS)) {
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getUserSurname());
            ps.setString(3, user.getUserLogin());
            ps.setString(4, user.getUserPassword());
            ps.setString(5, user.getUserEmail());
            ps.setString(6, user.getUserCardNo());
            ps.setDouble(7, user.getUserAccountBalance());
            ps.setDouble(8, user.getUserAccountFunds());
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 1) {
                c.commit();
            } else {
                throw new SQLException("The user insertion failed");
            }
        } catch (SQLException e1) {
            try {
                System.out.println("Rollback");
                c.rollback();
            } catch (SQLException e2) {
                System.out.println("Rollback failed");
                e2.printStackTrace();
            }
        }
    }

    public boolean insertScooters(Scooter scooter) {


        try (PreparedStatement ps = c.prepareStatement(INSERT_INTO_SCOOTERS)) {
            ps.setString(1, scooter.getScooterModel());
            ps.setInt(2, scooter.getScooterMaxVelocity());
            ps.setString(3, scooter.getScooterColor());
            ps.setInt(4, scooter.getScooterAvailability());
            ps.setInt(5, scooter.getScooterBasket());
            ps.setInt(6, scooter.getScooterRange());
            ps.setDouble(7, scooter.getScooterPrice());
            ps.setInt(8, scooter.getScooterBattery());
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 1) {

                c.commit();
                return true;

            } else {

                throw new SQLException("The scooter insertion failed");

            }
        } catch (SQLException e1) {

            try {

                System.out.println("Rollback");
                c.rollback();

            } catch (SQLException e2) {

                System.out.println("Rollback failed");
                e2.printStackTrace();

            }

        }
        return false;
    }


    public void deleteFromRhistory(int userID) {

        try (PreparedStatement ps = c.prepareStatement(DELETE_FROM_RHISTORY)) {

            ps.setInt(1, userID);
            ps.executeUpdate();
            c.commit();


        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void deleteScooter(int scooterId) {

        try (PreparedStatement ps = c.prepareStatement(DELETE_SCOOTER)) {
            ps.setInt(1, scooterId);
            ps.executeUpdate();
            c.commit();

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void open() {

        try {
            c = DriverManager.getConnection(CONNECTION_STRING, "postgres", "password");
            Statement stm = c.createStatement();
            c.setAutoCommit(false);
            stm.executeUpdate(CREATE_USERS_TABLE);
            stm.executeUpdate(CREATE_ADMINS_TABLE);
            stm.executeUpdate(CREATE_SCOOTERS_TABLE);
            stm.executeUpdate(CREATE_RENTS_TABLE);
            stm.executeUpdate(CREATE_RHISTORY_TABLE);
            stm.executeUpdate(CREATE_REPORTS_TABLE);
            c.commit();
            stm.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    public void close() {

        try {

            c.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

