package com.example.ffood;

public class foods {
    private int resourceId;
    private String name;
    private  String price;

    public foods(int resourceId, String name, String price) {
        this.resourceId = resourceId;
        this.name = name;
        this.price = price;
    }

    public int getResourceId() {
        return resourceId;
    }

    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    String ten,giatien,chitiet;

    public String getTen() {
        return ten;
    }

    public String getGiatien() {
        return giatien;
    }

    public String getChitiet() {
        return chitiet;
    }
}
