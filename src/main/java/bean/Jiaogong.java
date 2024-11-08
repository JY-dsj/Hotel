package bean;

/**
 * @author 2022
 */
public class Jiaogong {
    private int jid;
    private String name;
    private String sex;
    private int sid;
    private String phone;
    private String account;
    private String password;

    public Jiaogong(int jid, String name, String sex, int sid, String phone, String account, String password) {
        this.jid = jid;
        this.name = name;
        this.sex = sex;
        this.sid = sid;
        this.phone = phone;
        this.account = account;
        this.password = password;
    }

    public Jiaogong() {}

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
