package com.logger.services;

import com.logger.data.dto.ModelMapperConfig;
import com.logger.data.dto.request.AddNewVisitor;
import com.logger.data.dto.response.AddVisitorResponse;
import com.logger.data.dto.response.FindVisitorResponse;
import com.logger.data.model.Visitor;
import com.logger.repository.VisitorRepo;
import com.logger.utilities.exception.VisitorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class VisitorServiceImpl implements VisitorServices {
    @Autowired
    VisitorRepo visitorRepo;
    @Override
    public AddVisitorResponse registerVisitor(AddNewVisitor addNewVisitor) {
        Visitor visitor = ModelMapperConfig.map(addNewVisitor);
        visitor = visitorRepo.save(visitor);
        return ModelMapperConfig.mapCreateVisitorResponse(visitorRepo.save(visitor));
    }
    @Override
   public FindVisitorResponse findVisitor(Integer id) {
        Optional<Visitor> visitor = visitorRepo.findById(id);
        if (visitor.isEmpty())throw new VisitorException("No such visitor in our data base");
        return ModelMapperConfig.mapVisitorResponse(visitor.get());
    }
    @Override
    public List<Visitor> findAllVisitor() {
        return visitorRepo.findAll();
    }
}
