package sample;

public class Admin {

    private int adminID;
    private String adminName;
    private String adminSurname;
    private String adminLogin;
    private String adminPassword;
    private String adminEmail;

    public Admin(int adminId, String adminName, String adminSurname, String adminLogin, String adminPassword, String adminEmail) {
        this.adminID = adminId;
        this.adminName = adminName;
        this.adminSurname = adminSurname;
        this.adminLogin = adminLogin;
        this.adminPassword = adminPassword;
        this.adminEmail = adminEmail;
    }

    public int getAdminID() {
        return adminID;
    }

    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminSurname() {
        return adminSurname;
    }

    public void setAdminSurname(String adminSurname) {
        this.adminSurname = adminSurname;
    }

    public String getAdminLogin() {
        return adminLogin;
    }

    public void setAdminLogin(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }
}