package com.tokioschool.basedatos.dao.domain;

public class Car {

    private String model;
    private String color;
    private int maxSpeed;
    private float weigth;
    private boolean repaired;
    private String damage;

    public Car(String model, String color, int maxSpeed, float weigth, boolean repaired, String damage) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.weigth = weigth;
        this.repaired = repaired;
        this.damage = damage;
    }

    public Car(String model, String color, int maxSpeed, float weigth, String damage) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.weigth = weigth;
        this.damage = damage;
    }
    public boolean isRepaired() {
        return repaired;
    }

    public void setRepaired(boolean repaired) {
        this.repaired = repaired;
    }

    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public Car(){

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getWeigth() {
        return weigth;
    }

    public void setWeigth(float weigth) {
        this.weigth = weigth;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", weigth=" + weigth +
                ", repaired=" + repaired +
                ", damage='" + damage + '\'' +
                '}';
    }
}
