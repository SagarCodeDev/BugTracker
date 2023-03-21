package com.project.issuetracker;

import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Long> {
    
}
