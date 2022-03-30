package com.logger.controller;


import com.logger.data.dto.request.AddNewStaff;
import com.logger.data.dto.response.AddStaffResponse;
import com.logger.data.dto.response.StaffResponse;
import com.logger.data.model.Staff;
import com.logger.services.StaffService;
import com.logger.services.StaffServiceImpl;
import com.logger.utilities.exception.StaffException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StaffController {
    private final StaffService staffService = new StaffServiceImpl();
    @PostMapping("staff/post")
    public AddStaffResponse createStaff(AddNewStaff newStaff){
        return staffService.createNewStaff(newStaff);
    }
    @GetMapping("staff/get{id}")
    public StaffResponse getStaff(@PathVariable("id") Integer id) throws StaffException {
        return staffService.findStaff(id);
    }
    @GetMapping("staff/get_all")
    public List<Staff> getAllStaff(){
        return staffService.findAllStaff();
    }
}
