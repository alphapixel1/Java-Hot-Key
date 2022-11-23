package edu.uc.javahotkey.dao;

import edu.uc.javahotkey.dto.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier("jhk-sql")
public class ProjectSQLDAO implements IProjectDAO {

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public List<Project> fetchAllProjects() {
        return (List<Project>) projectRepository.findAll();
    }

    @Override
    public Project save(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public void delete(int id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Project fetchById(int id) {
        return projectRepository.findById(id);
    }
}
