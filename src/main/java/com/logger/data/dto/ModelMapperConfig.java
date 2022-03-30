package com.logger.data.dto;

import com.logger.data.dto.request.AddNewStaff;
import com.logger.data.dto.request.AddNewVisitor;
import com.logger.data.dto.request.CreateNewVisit;
import com.logger.data.dto.request.LoginRequest;
import com.logger.data.dto.response.*;
import com.logger.data.model.Staff;
import com.logger.data.model.Visit;
import com.logger.data.model.Visitor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        return modelMapper;
    }
    public  static Visitor map(AddNewVisitor addNewVisitor){
        Visitor visitor = new Visitor();
        visitor.setId(addNewVisitor.getId());
        visitor.setVisitorName(addNewVisitor.getVisitorName());
        visitor.setPhoneNumber(addNewVisitor.getPhoneNumber());
        visitor.setEmailAddress(addNewVisitor.getEmailAddress());
        visitor.setAddress(addNewVisitor.getAddress());
        visitor.setPassword(addNewVisitor.getPassword());
        return visitor;
    }
    public static Staff mapStaff(AddNewStaff addNewStaff){
        Staff staff = new Staff();
        staff.setId(addNewStaff.getId());
        staff.setStaffName(addNewStaff.getStaffName());
        staff.setPhoneNumber(addNewStaff.getPhoneNumber());
        staff.setEmailAddress(addNewStaff.getEmailAddress());
        staff.setAddress(addNewStaff.getAddress());
        staff.setPassword(addNewStaff.getPassword());
        return  staff;
    }
    public  static Visit mapVisit(CreateNewVisit newVisit){
        Visit visit = new Visit();
        visit.setVisitorId(newVisit.getVisitorId());
        visit.setPurposeOfVisit(newVisit.getPurposeOfVisit());
        visit.setDateOfVisit(LocalDateTime.now());
        visit.setName(newVisit.getName());
        return visit;
    }
    public  static StaffResponse mapStaffResponse(Staff staff){
        StaffResponse response = new StaffResponse();
        response.setId(staff.getId());
        response.setName(staff.getStaffName());
        response.setEmailAddress(staff.getEmailAddress());
        return response;
    }
    public  static FindVisitorResponse mapVisitorResponse(Visitor visitor){
        FindVisitorResponse findVisitorResponse = new FindVisitorResponse();
        findVisitorResponse.setVisitorId(visitor.getId());
        findVisitorResponse.setVisitorName(visitor.getVisitorName());
        findVisitorResponse.setPhoneNumber(visitor.getPhoneNumber());
        findVisitorResponse.setAddress(visitor.getAddress());
        return findVisitorResponse;
    }
    public  static VisitResponse mapVisitResponse(Visit visit){
        VisitResponse response = new VisitResponse();
        response.setVisitorName(visit.getName());
        response.setVisitorId(visit.getVisitorId());
        response.setPurposeOfVisit(visit.getPurposeOfVisit());
        response.setDateOfVisit(LocalDateTime.now());
        return response;
    }
    public static AddVisitorResponse mapCreateVisitorResponse(Visitor visitor){
        AddVisitorResponse addVisitorResponse = new AddVisitorResponse();
        addVisitorResponse.setId(visitor.getId());
        addVisitorResponse.setName(visitor.getVisitorName());
        return addVisitorResponse;
    }
    public static AddStaffResponse mapNewStaffResponse(Staff staff){
        AddStaffResponse addStaffResponse = new AddStaffResponse();
        addStaffResponse.setId(staff.getId());
        addStaffResponse.setName(staff.getStaffName());
        return addStaffResponse;
    }
    public static AddNewStaff mapStaffLogin(LoginRequest request){
        AddNewStaff staffLogin = new AddNewStaff();
        staffLogin.setEmailAddress(request.getEmail());
        staffLogin.setPassword(request.getPassWord());
        return staffLogin;
    }
    public  static AddNewVisitor mapVisitorLogin(LoginRequest request){
        AddNewVisitor visitorLogin = new AddNewVisitor();
        visitorLogin.setEmailAddress(request.getEmail());
        visitorLogin.setPassword(request.getPassWord());
        return visitorLogin;
    }

}
