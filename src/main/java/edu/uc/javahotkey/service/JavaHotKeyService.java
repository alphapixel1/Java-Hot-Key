package edu.uc.javahotkey.service;

import edu.uc.javahotkey.dao.ProjectDAOStub;
import edu.uc.javahotkey.dto.Project;
import org.springframework.beans.factory.annotation.Autowired;

public class JavaHotKeyService implements IJavaHotKeyService {

    @Autowired
    ProjectDAOStub projectDAOStub;

    @Override
    public Project findProject(int id) {
        return projectDAOStub.fetchById(id);
    }
}
