package com.logger.services;

import com.logger.data.dto.ModelMapperConfig;
import com.logger.data.dto.request.CreateNewVisit;
import com.logger.data.dto.response.VisitResponse;
import com.logger.data.model.Visit;
import com.logger.repository.VisitRepo;
import com.logger.services.mail.EmailServices;
import com.logger.services.mail.EmailServicesImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@Service
@AllArgsConstructor
@NoArgsConstructor
public class VisitServiceImpl implements VisitService {
    @Autowired
    VisitRepo visitRepo ;

    private final EmailServices mailService = new EmailServicesImpl();

    @Override
    public VisitResponse createVisit(CreateNewVisit newVisit) {
        Visit visit = ModelMapperConfig.mapVisit(newVisit);
        visit=visitRepo.save(visit);
        return ModelMapperConfig.mapVisitResponse(visitRepo.save(visit));
    }

    @Override
    public void sendVisitLogg() {
mailService.sendPreConfigMail("you have a new visitor: ");
    }
}
