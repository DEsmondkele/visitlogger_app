package com.logger.services;

import com.logger.data.dto.request.AddNewVisitor;
import com.logger.data.dto.response.AddVisitorResponse;
import com.logger.data.dto.response.FindVisitorResponse;
import com.logger.data.model.Visitor;
import com.logger.utilities.exception.VisitorException;

import java.util.List;

public interface VisitorServices {
    AddVisitorResponse registerVisitor(AddNewVisitor addNewVisitor);

    FindVisitorResponse findVisitor(Integer id)throws VisitorException;

    List<Visitor> findAllVisitor();
}
