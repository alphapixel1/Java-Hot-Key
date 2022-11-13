package edu.uc.javahotkey;

import edu.uc.javahotkey.dto.Project;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class JavaHotKeyApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void verifyProjectID(){
        int id = 2;
        Project project = new Project(2,"");
        project.setId(id);
       assertEquals(id,project.getId());
    }


    @Test
    void verifyProjectName(){
        String name = "random";
        Project project = new Project(0,"random");
        project.setName(name);
        assertEquals(name,project.getName());
    }

}
