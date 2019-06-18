package com.example.madeinindiafurniture.furniture_list;

public class Furniture {

    private String pname;

    public Furniture() {
    }

    public Furniture(String pname, String p_price, String rating, int imgFurniture) {
        this.pname = pname;
        this.p_price = p_price;
        this.rating =  rating;
        this.imgFurniture = imgFurniture;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getP_price() {
        return p_price;
    }

    public void setP_price(String p_price) {
        this.p_price = p_price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getImgFurniture() {
        return imgFurniture;
    }

    public void setImgFurniture(int imgFurniture) {
        this.imgFurniture = imgFurniture;
    }

    private String p_price;
    private String rating;
    private int imgFurniture;

}
