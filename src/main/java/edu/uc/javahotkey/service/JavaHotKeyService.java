package edu.uc.javahotkey.service;

import edu.uc.javahotkey.JavaHotKeyController;
import edu.uc.javahotkey.dao.IProjectDAO;
import edu.uc.javahotkey.dto.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JavaHotKeyService implements IJavaHotKeyService {

    private static final Logger log = LoggerFactory.getLogger(JavaHotKeyService.class);
    @Autowired
    @Qualifier("jhk-sql")
    IProjectDAO projectDAO;

    @Override
    public List<Project> fetchAllProjects() {
        return projectDAO.fetchAllProjects();
    }

    @Override
    public Project save(Project project) {
        return projectDAO.save(project);
    }

    @Override
    public void delete(int id) {
        projectDAO.delete(id);
    }

    @Override
    public Project fetchById(int id) {
        return projectDAO.fetchById(id);
    }

}
