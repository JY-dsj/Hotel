package bean;

/**
 * @author 2022
 */
public class SState {
    private int floor;
    private int sid;
    private String features1;
    private String features2;
    private String state;


    // 构造函数、Getter 和 Setter 方法
    public SState(int floor, int sid, String features1, String features2, String state) {
        this.floor = floor;
        this.sid = sid;
        this.features1 = features1;
        this.features2 = features2;
        this.state = state;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getFeatures1() {
        return features1;
    }

    public void setFeatures1(String features1) {
        this.features1 = features1;
    }

    public String getFeatures2() {
        return features2;
    }

    public void setFeatures2(String features2) {
        this.features2 = features2;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
