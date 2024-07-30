package com.thebinh.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thebinh.customexeptions.FieldRequiredException;
import com.thebinh.model.BuildingDTO;
import com.thebinh.model.ErrorResponseDTO;
import com.thebinh.service.BuildingService;

@RestController
public class BuildingAPI {
	@Autowired
    private BuildingService buildingService;
	@GetMapping(value="/api/building/")
	public ArrayList<BuildingDTO> getBuilding(@RequestParam(value = "name") String name){
		ArrayList<BuildingDTO> result = buildingService.findAll(name);
		return result;
	}
}