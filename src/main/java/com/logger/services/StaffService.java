package com.logger.services;

import com.logger.data.dto.request.AddNewStaff;
import com.logger.data.dto.response.AddStaffResponse;
import com.logger.data.dto.response.StaffResponse;
import com.logger.data.model.Staff;
import com.logger.utilities.exception.StaffException;

import java.util.List;

public interface StaffService {
    AddStaffResponse createNewStaff(AddNewStaff addNewStaff);
    StaffResponse findStaff(Integer id)throws StaffException;
    List<Staff> findAllStaff();
}
