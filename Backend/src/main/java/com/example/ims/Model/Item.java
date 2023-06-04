package com.example.ims.Model;

public class Item {
    private String id;
    private String name;
    private double price;
    private String type;
    private int quantity;
    private int dispatchQuantity;
    private String OrderNumber;
    private double saleGenerated;

    public Item() {
    }

    public Item(String id, String name, double price, String type, int quantity, int dispatchQuantity, double saleGenerated, String OrderNumber) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
        this.dispatchQuantity = dispatchQuantity;
        this.saleGenerated = saleGenerated;
        this.OrderNumber = OrderNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getDispatchQuantity() {
        return dispatchQuantity;
    }

    public void setDispatchQuantity(int dispatchQuantity) {
        this.dispatchQuantity = dispatchQuantity;
    }

    public String getOrderNumber() {
        return OrderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        OrderNumber = orderNumber;
    }

    public double getSaleGenerated() {
        return saleGenerated;
    }

    public void setSaleGenerated(double saleGenerated) {
        this.saleGenerated = saleGenerated;
    }
}
