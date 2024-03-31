package com.dinesh.Spring.DataRest.DAO;

import com.dinesh.Spring.DataRest.Model.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepo extends JpaRepository<JobPost, Integer>{

//List<JobPost> findByJobNameContainingOrJobDescContaining(String name, String Desc);

}