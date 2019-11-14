package com.ec.lidl.beans;

public class LineBean {
    String name;
    String qty;
    String price;

    public LineBean(String name, String qty, String price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }

    public LineBean() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
