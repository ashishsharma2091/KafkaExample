package com.ashish.kafka.springbootkafkaproducer.model;

public class Car {
private String name;
private String brand;
private int cost;

public Car(String name,String brand, int cost){
	this.brand=brand;
	this.cost=cost;
	this.name=name;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public int getCost() {
	return cost;
}
public void setCost(int cost) {
	this.cost = cost;
}

}
