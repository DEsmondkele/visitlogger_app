package com.logger.controller;

import com.logger.data.dto.request.AddNewVisitor;
import com.logger.data.dto.response.AddVisitorResponse;
import com.logger.data.dto.response.FindVisitorResponse;
import com.logger.data.model.Visitor;
import com.logger.services.VisitorServiceImpl;
import com.logger.services.VisitorServices;
import com.logger.utilities.exception.VisitorException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitorController {
    private  final VisitorServices visitorService = new VisitorServiceImpl();
    @PostMapping("visitor/post")
    public AddVisitorResponse createNewVisitor(@RequestBody AddNewVisitor addVisitor) {
      return visitorService.registerVisitor(addVisitor);
    }
    @GetMapping("visitor/get{id}")
    public FindVisitorResponse findVisitorById(@PathVariable("id") Integer id)throws VisitorException{
        return visitorService.findVisitor(id);
    }
    @GetMapping("visitor/get_all")
    public List<Visitor> findAllVisitors(){
        return visitorService.findAllVisitor();
    }
}
