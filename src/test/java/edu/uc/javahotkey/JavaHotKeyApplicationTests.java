package edu.uc.javahotkey;

import edu.uc.javahotkey.dto.KeyMap;
import edu.uc.javahotkey.dto.Project;
import edu.uc.javahotkey.lua.CompilerMessage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

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
        Project project = new Project(0,"random2");
        project.setName(name);
        assertEquals(name,project.getName());
    }
    @Test
    void verifyCompilerMessage(){
        String message ="test";
        CompilerMessage cm=new CompilerMessage(message,true);
        assertEquals(cm.Message, "test");
    }

    @Test
    void verifyCompilerMessageIsError(){
        String message ="test";
        CompilerMessage cm=new CompilerMessage(message,true);
        assertTrue(cm.isError);
    }

    @Test
    void verifyKeyMap(){
            var keyMap=new KeyMap();
            keyMap.functionName="hi";
            keyMap.keymap=new ArrayList<>();
            assertEquals(keyMap.toString(),"{ function=hi, keymap=[]}");
    }

}
