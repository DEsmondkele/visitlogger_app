package com.logger.controller;

import com.logger.data.dto.request.CreateNewVisit;
import com.logger.data.dto.response.VisitResponse;
import com.logger.services.VisitService;
import com.logger.services.VisitServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitController {
    public  final VisitService visitService= new VisitServiceImpl();
    @PostMapping("visit/create")
    public VisitResponse createNewVisit(CreateNewVisit newVisit){

        return  visitService.createVisit(newVisit);
    }
    @PostMapping("visit/email")
    public void  sendVisitLog(){
        visitService.sendVisitLogg();
    }
}
