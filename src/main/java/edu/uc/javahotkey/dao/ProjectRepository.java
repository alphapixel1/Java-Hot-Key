package edu.uc.javahotkey.dao;

import edu.uc.javahotkey.dto.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
    public void deleteById(int id);
    public Project findById(int id);
}
