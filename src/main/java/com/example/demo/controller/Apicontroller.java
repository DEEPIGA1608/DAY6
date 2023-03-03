package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.child;
import com.example.demo.service.service;

@RestController
public class Apicontroller {
		@Autowired
		service s;
		@GetMapping("/get")
		public List<child> showDetails() {
			return s.getDetails();

		}
		@PostMapping("/post")
		public String addDetails(@RequestBody child m) {
			s.add(m);
			return "Added product " + m.getBabyid();
		}
		//sorting
		@GetMapping("/product/{field}")
		public List<child> getWithSort(@PathVariable String field) {
			return s.getSorted(field);
		}
		// pagination
		@GetMapping("/product/{offset}/{pageSize}")
		public List<child> productsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
			return s.getWithPagination(offset, pageSize);
		}
}