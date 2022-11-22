package edu.uc.javahotkey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// disabling data source until we are ready for persistence unit
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class JavaHotKeyApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaHotKeyApplication.class, args);
    }

}
