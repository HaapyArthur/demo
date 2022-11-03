package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("/hello")
	public void hello(@RequestParam(value = "name", defaultValue = "World") String name) {

		List<OOMObject> list = new ArrayList<OOMObject>();
		while (true) {
			list.add(new 	OOMObject());
		}
	}
	@GetMapping("/hi")
	public String hi(@RequestParam(value = "name", defaultValue = "World") String name) {

		return "hi";
	}

	static class OOMObject {
	}
}