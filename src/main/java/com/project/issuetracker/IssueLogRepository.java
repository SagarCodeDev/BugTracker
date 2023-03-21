package com.project.issuetracker;

import org.springframework.data.repository.CrudRepository;

public interface IssueLogRepository extends CrudRepository<IssueLog,Long>{
    
}
