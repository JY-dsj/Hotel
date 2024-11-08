package bean;

import java.sql.Date;

public class Booking {
    private int jid;
    private int sid;
    private String name;
    private String phone;
    private Date enterTime;
    private Date leaveTime;
    private String roomType;

    public Booking(int jid, int sid, String name, String phone, Date enterTime, Date leaveTime,String roomType) {
        this.jid = jid;
        this.sid = sid;
        this.name = name;
        this.phone = phone;
        this.enterTime = enterTime;
        this.leaveTime = leaveTime;
        this.roomType = roomType;
    }

    public Booking() {

    }


    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    public Date getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(Date leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}

