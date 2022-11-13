package edu.uc.javahotkey;

import edu.uc.javahotkey.dto.Project;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest
class JavaHotKeyApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void verifyProjectName(){
        String name = "random unit test";

        var project = new Project();
        project.setName(name);
        assertEquals(name,Project.getName());
    }

}
