package com.dungken.PropertiesConfiguration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PropertiesConfigurationApplication {
	@Value("${course.name}")
	private String name;
	@Value("${course.price}")
	private double price;
	@Value("${course.mentor}")
	private String mentor;
	@Value("${course.website}")
	private String website;
	public static void main(String[] args) {
		SpringApplication.run(PropertiesConfigurationApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "Hello World !";
	}

	@GetMapping("/infoCourse")
	public String inforCourse() {
		return
				"Tên khóa học: " + name + "<br/>" +
				"Giá tiền: " + price + "<br/>" +
				"Người hướng dẫn: " + mentor + "<br/>"+
				"Website: " + website + "<br/>";
	}

}
