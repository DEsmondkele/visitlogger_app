package com.logger.services;

import com.logger.data.dto.request.LoginRequest;
import com.logger.data.dto.response.LoginResponse;
import com.logger.data.dto.response.LoginStatus;
import com.logger.data.model.Staff;
import com.logger.data.model.Visitor;
import com.logger.repository.StaffRepo;
import com.logger.repository.VisitorRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.security.auth.login.CredentialException;
import javax.security.auth.login.LoginException;
import java.util.Optional;

@Slf4j
@Component
@Service
public class LoginServicesImpl implements LoginServices {
    private  LoginResponse response;
    @Autowired
    VisitorRepo visitorRepo;
    @Autowired
    StaffRepo staffRepo;
    private EmailValidator emailValidator;

    @Override
    public LoginResponse visitorLogin(LoginRequest request) throws LoginException {
        boolean isValidEmail=emailValidator.test(request.getEmail());
        if(!isValidEmail){throw new IllegalArgumentException("email not valid");}
        Optional<Visitor> visitorEmail= visitorRepo.findByEmail(request.getEmail());
        Optional<Visitor>visitorPassword =visitorRepo.findByPassword(request.getPassWord());
        if(visitorEmail.isEmpty())throw  new LoginException("please register or enter a valid email!");
        if(visitorPassword.isEmpty()){
            throw new CredentialException("incorrect email or password");
        }
        return response= new LoginResponse(LoginStatus.SUCCESSFUL);
    }

    @Override
    public LoginResponse staffLogin(LoginRequest loginRequest) throws LoginException {
        boolean isValidEmail=emailValidator.test(loginRequest.getEmail());
        if(!isValidEmail){throw new IllegalArgumentException("email not valid");}
        Optional<Staff> staffEmail = staffRepo.finByEmail(loginRequest.getEmail());
        if(staffEmail.isEmpty())throw  new LoginException("please register or enter a valid email");
        Optional<Staff> staffPassword = staffRepo.findByPassword(loginRequest.getPassWord());
        if (staffPassword.isEmpty()){throw new CredentialException("incorrect email or password");}
        return response=new LoginResponse(LoginStatus.SUCCESSFUL) ;
    }
}
