package edu.uc.javahotkey.dao;

import edu.uc.javahotkey.dto.Project;

import java.util.List;

public interface IProjectDAO {

    List<Project> fetchAllProjects();
    Project save(Project project);
    void delete(int id);
    Project fetchById(int id);

    //Project update(Project p);

}
