package com.logger.services;

import com.logger.data.dto.request.CreateNewVisit;
import com.logger.data.dto.response.VisitResponse;

public interface VisitService {

    VisitResponse createVisit(CreateNewVisit newVisit);
    void sendVisitLogg();
}
