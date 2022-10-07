package edu.uc.javahotkey.service;

import edu.uc.javahotkey.dto.Project;

import java.util.List;

public interface IJavaHotKeyService {

    List<Project> fetchAllProjects();
    Project save(Project project);
    void delete(int id);
    Project fetchById(int id);


}
