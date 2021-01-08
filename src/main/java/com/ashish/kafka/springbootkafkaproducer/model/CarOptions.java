package com.ashish.kafka.springbootkafkaproducer.model;

import java.util.ArrayList;
import java.util.List;

public class CarOptions {
List<Car> caroptionList=new ArrayList<Car>();

public List<Car> getCaroptionList() {
	return caroptionList;
}

public void setCaroptionList(List<Car> caroptionList) {
	this.caroptionList = caroptionList;
}
}
