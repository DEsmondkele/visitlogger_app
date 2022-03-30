package com.logger.services;

import com.logger.data.dto.ModelMapperConfig;
import com.logger.data.dto.request.AddNewStaff;
import com.logger.data.dto.response.AddStaffResponse;
import com.logger.data.dto.response.StaffResponse;
import com.logger.data.model.Staff;
import com.logger.repository.StaffRepo;
import com.logger.utilities.exception.StaffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Component
@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    StaffRepo staffRepo;
    @Override
    public AddStaffResponse createNewStaff(AddNewStaff addNewStaff) {
        Staff staff = ModelMapperConfig.mapStaff(addNewStaff);
         staff =staffRepo.save(staff);
         return ModelMapperConfig.mapNewStaffResponse(staffRepo.save(staff));
    }

    @Override
    public StaffResponse findStaff(Integer id) throws StaffException {
        Optional<Staff>staff = staffRepo.findById(id);
        if(staff.isEmpty())throw new StaffException("Staff does not exist");
        return ModelMapperConfig.mapStaffResponse(staff.get());
    }

    @Override
    public List<Staff> findAllStaff() {
        return staffRepo.findAll();
    }

}
