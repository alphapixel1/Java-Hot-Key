package edu.uc.javahotkey.dao;

import edu.uc.javahotkey.dto.Project;

import java.util.List;

public interface IProjectDAO {

    List<Project> fetchAllLaborActions();
    Project save(Project laborAction);
    void delete(int id);
    Project fetchById(int id);

}
