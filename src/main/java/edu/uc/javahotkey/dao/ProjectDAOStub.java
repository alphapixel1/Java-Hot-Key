package edu.uc.javahotkey.dao;

import edu.uc.javahotkey.dto.Project;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProjectDAOStub implements IProjectDAO {

    Map<Integer, Project> allProjects = new HashMap<>();

    @Override
    public List<Project> fetchAllProjects() {
        return new ArrayList(allProjects.values());
    }

    @Override
    public Project save(Project project) {
        allProjects.put(project.getId(), project);
        return project;
    }

    @Override
    public void delete(int id) {
        allProjects.remove(id);
    }

    @Override
    public Project fetchById(int id) {
        return allProjects.get(id);
    }

   /* @Override
    public Project update(Project p) {
        throw new NotImplementedError();
        //allProjects.
    }*/


}
