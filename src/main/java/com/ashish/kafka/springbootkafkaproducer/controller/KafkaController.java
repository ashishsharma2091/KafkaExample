package com.ashish.kafka.springbootkafkaproducer.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.kafka.springbootkafkaproducer.model.Car;
import com.ashish.kafka.springbootkafkaproducer.model.CarOptions;

@RestController
@RequestMapping("kafka")
public class KafkaController {

	
	@Autowired
	//KafkaTemplate<String, String> kafkatemplate; //if publishing string message. That is by default supported.
	KafkaTemplate<String, CarOptions> kafkatemplate;//for this need kafka config.
	
	
	CarOptions carOptions=new CarOptions();
	
	
	public static final String Topic="sampleTopic";
	
	@GetMapping("/publish/{message}")
	public String postProducedMessage ( @PathVariable("message") final String message) {
		
		List<Car> tempList=new ArrayList<Car>();
		tempList.add(new Car("tiago","tata",2000));
		tempList.add(new Car("altroz","tata",3000));
		tempList.add(new Car("nexon","tata",7000));
		tempList.add(new Car("seltos","Kia",9000));
		tempList.add(new Car("xuv300","mahindra",8000));
		
		carOptions.setCaroptionList(tempList.stream().filter(car->car.getCost()>5000)
				.collect(Collectors.toList()));
		
		//kafkatemplate.send(Topic, message);// for string
		kafkatemplate.send(Topic, carOptions);
		return "published successfully";
		
	}
	
}
