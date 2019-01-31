package com.journaldev.spring;

import java.io.FileReader;
import java.io.FileWriter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
public class PersonController {
	
	@RequestMapping("/")
	public String healthCheck() {
		javaToJson();
		javaToJsonPrettyPrint();
		javaToJsonFile();
		jsonToJava();
		jsonFileToJava();
		return "Converted Successfully...";
	}
	
	public void javaToJson() {
		try {
			Person person = new Person();		
			person.setName("Peter");
			person.setSal("20000");
			person.setAge("25");
			person.setAddress("Hyderabad");
			person.setPhoneNumber("9000080000");
			
			Gson gson = new Gson();
	        String json = gson.toJson(person);
			System.out.println("JSON String : " + json);
			
		}catch (Exception e) {
	        e.printStackTrace();
	    }	
	}
	
	public void javaToJsonPrettyPrint() {
		try {
			Person person = new Person();		
			person.setName("Peter");
			person.setSal("20000");
			person.setAge("25");
			person.setAddress("Hyderabad");
			person.setPhoneNumber("9000080000");
			
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String json = gson.toJson(person);
			System.out.println("JSON String Pretty Print : " + json);
			
		}catch (Exception e) {
	        e.printStackTrace();
	    }	
	}
	
	public void javaToJsonFile() {
		try {
			Person person = new Person();		
			person.setName("Peter");
			person.setSal("20000");
			person.setAge("25");
			person.setAddress("Hyderabad");
			person.setPhoneNumber("9000080000");
			
			Gson gson = new Gson();
			
			try (FileWriter writer = new FileWriter("C:\\Output\\Person.json")) {
	             gson.toJson(person, writer);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			
		}catch (Exception e) {
	        e.printStackTrace();
	    }	
	}
	
	public void jsonToJava() {
		try {
            String jsonStr = "{\"name\":\"Peter\",\"sal\":\"20000\",\"age\":\"25\",\"address\":\"Hyderabad\",\"phoneNumber\":\"9000080000\"}";	
            Gson gson = new Gson();
            Person person = gson.fromJson(jsonStr, Person.class);
            System.out.println("Person POJO 1 : " + person);
 		}catch (Exception e) {
	        e.printStackTrace();
	    }	
	}
	
	public void jsonFileToJava() {
		try (FileReader reader = new FileReader("C:\\Input\\Person.json")) {
            Gson gson = new Gson();
            Person person = gson.fromJson(reader, Person.class);
            System.out.println("Person POJO 2 : " + person);
 		}catch (Exception e) {
	        e.printStackTrace();
	    }	
	}
		
}
