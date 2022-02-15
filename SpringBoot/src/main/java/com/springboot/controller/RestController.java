package com.springboot.controller;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springboot.data.entity.User;
import com.springboot.data.repo.UserRepository;
import com.springboot.dto.ResultDto;
import com.springboot.dto.UserDto;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
	
	@Autowired
	UserRepository repo;

	@GetMapping("/info")
	public ResultDto getInfo() {
		return new ResultDto();
	}
	
	@PostMapping("/user/add")
	public ResultDto addUser(@RequestBody UserDto user) {
		User entity = new User();
		BeanUtils.copyProperties(user, entity);
		String message = "Created successfully";
		try {
		repo.save(entity);
		} catch (Exception e) {
			message = e.getMessage();
		}
		return new ResultDto(message);
	}
	
	@GetMapping("/user/{id}")
	public ResultDto getUser(@PathVariable("id") int id) {
		User entity = repo.getById(id);
		if (entity!= null) {
			ResultDto<UserDto> result = new ResultDto("User Info in map");
			UserDto dto = new UserDto();
			BeanUtils.copyProperties(entity, dto);
			result.setData(Arrays.asList(dto));
			return result;
		} else {
			return new ResultDto<>("User not found");
		}
	}
}
