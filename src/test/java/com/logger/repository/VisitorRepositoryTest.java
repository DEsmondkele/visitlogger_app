package com.logger.repository;

import com.logger.data.model.Visitor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
@Transactional
public class VisitorRepositoryTest {
    @Autowired
    VisitorRepo visitorRepo;
    Visitor visitor;

    @BeforeEach
    public void setUp(){
       visitor = new Visitor();
    }
    @Test
    public void  newVisitorCanBeCreatedTest(){
        assertThat(visitor).isNull();

        visitor.setId(1);
        visitor.setVisitorName("Jack Bill");
        visitor.setPhoneNumber("+14474774");
        visitor.setEmailAddress("jackbill@gmail.com");
        visitor.setAddress("plot 12, texas");
        assertNotNull(visitor);
        log.info("visitor info is not empty->{}",visitor);
    }
    @Test
    void visitorCanBeSaveToDataBaseTest(){
        visitor.setId(1);
        visitor.setVisitorName("Jack Bill");
        visitor.setPhoneNumber("+14474774");
        visitor.setEmailAddress("jackbill@gmail.com");
        visitor.setAddress("plot 12, texas");
        visitorRepo.save(visitor);

    }
    @Test
    void getOneVisitorFromDataBaseTest(){
        assertThat(visitor).isNotNull();
        visitor.setId(2);
        visitor.setVisitorName("Jill ray");
        visitor.setPhoneNumber("+14234342");
        visitor.setEmailAddress("jillray@gmail.com");
        visitor.setAddress("plot 121, Houston");
        visitorRepo.save(visitor);
        Visitor myVisitor = visitorRepo.getById(2);
        assertThat(myVisitor).isEqualTo(visitor);


    }
    @Test
    void getAllVisitorsFromDataBaseTest(){

        assertThat(visitorRepo.findAll()).isNotNull();

    }
}
/*Could not autowire. No beans of 'VisitorRepo' type found.
 Inspection info:
Reports autowiring problems on injection points of Spring beans:
More than one bean of 'concrete' type
No beans of 'concrete' type
No bean with qualifier
Autowired method or constructor without parameters
Example:
public interface FooInterface {...}
  @Component public class FooBean implements FooInterface {...}
  @Component public class OtherBean implements FooInterface {...}

@Component
public class MyComponent {
	@Autowired
	FooInterface foo;  // "Could not autowire. There is more than one bean of 'FooInterface' type.
                     // Beans: fooBean(FooBean.java), otherBean(OtherBean.java)"
}**/