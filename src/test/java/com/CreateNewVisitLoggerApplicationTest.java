package com;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;
@Slf4j
@SpringBootTest
@Data
public class CreateNewVisitLoggerApplicationTest {
    DataSource dataSource;

        @Test
        public void dataBaseConnectionTest() {
            assertThat(dataSource).isNotNull();
            log.info("Datasource properties ->{}", dataSource);
            try {
                Connection connection = dataSource.getConnection();
                assertThat(connection).isNotNull();
                log.info("Connected to Database -> {}", connection.getCatalog());

            } catch (SQLException exception) {
                log.info("Exception occurred -> {}", exception.getMessage());
            }
        }
    }
