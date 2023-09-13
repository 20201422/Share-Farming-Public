package Model;

public class User {

    private String Uno;
    private String Una;
    private String Upwd;
    private String Uemil;
    // 0是普通用户 1是代种人员
    private Integer Ust = 0;

    public User() {
    }

    public User(String uno, String una, String upwd, String uemil, Integer ust) {
        Uno = uno;
        Una = una;
        Upwd = upwd;
        Uemil = uemil;
        Ust = ust;
    }

    public String getUno() {
        return Uno;
    }

    public void setUno(String uno) {
        Uno = uno;
    }

    public String getUna() {
        return Una;
    }

    public void setUna(String una) {
        Una = una;
    }

    public String getUpwd() {
        return Upwd;
    }

    public void setUpwd(String upwd) {
        Upwd = upwd;
    }

    public String getUemil() {
        return Uemil;
    }

    public void setUemil(String uemil) {
        Uemil = uemil;
    }

    public Integer getUst() {
        return Ust;
    }

    public void setUst(Integer ust) {
        Ust = ust;
    }

    @Override
    public String toString() {
        return "User{" +
                "Uno='" + Uno + '\'' +
                ", Una='" + Una + '\'' +
                ", Upwd='" + Upwd + '\'' +
                ", Uemil='" + Uemil + '\'' +
                ", Ust=" + Ust +
                '}';
    }
}
