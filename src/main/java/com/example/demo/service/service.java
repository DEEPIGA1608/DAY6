package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.child;
import com.example.demo.repository.childRepo;

@Service
public class service {
		@Autowired
		childRepo r;
		
		public String add(child m) {
			r.save(m);
			return "Added";
		}
		
		public List<child> getDetails() {
			return r.findAll();
		}
		
		public List<child> getSorted(String field) {
			return r.findAll(Sort.by(Sort.Direction.ASC,field));
		}
		
		public List<child> getWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
			Page<child> page =r.findAll(PageRequest.of(offset, pageSize));
			return page.getContent();
		}

}