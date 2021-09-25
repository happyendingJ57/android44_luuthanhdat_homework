package function_home;

import java.io.Serializable;

public class Food implements Serializable {
    private int imgID;
    private String tenFood;
    private double giaFood;

    public Food(int imgID, String tenFood, double giaFood) {
        this.imgID = imgID;
        this.tenFood = tenFood;
        this.giaFood = giaFood;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getTenFood() {
        return tenFood;
    }

    public void setTenFood(String tenFood) {
        this.tenFood = tenFood;
    }

    public double getGiaFood() {
        return giaFood;
    }

    public void setGiaFood(double giaFood) {
        this.giaFood = giaFood;
    }
}
