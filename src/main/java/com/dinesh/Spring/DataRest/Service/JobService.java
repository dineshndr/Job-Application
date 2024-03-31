package com.dinesh.Spring.DataRest.Service;
import com.dinesh.Spring.DataRest.DAO.JobRepo;
import com.dinesh.Spring.DataRest.Model.JobPost;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    @Autowired
    JobRepo jobrepo;


    public List<JobPost> getAllJobs()
    {
        return jobrepo.findAll();
    }

    public JobPost getJob(int id) throws NullPointerException{

        return  jobrepo.findById(id).orElse(new JobPost());
    }

    public JobPost addJob(JobPost jobpost) {
        return jobrepo.save(jobpost);
    }

    public JobPost updateJob(JobPost jobpost) {
        return jobrepo.save(jobpost);

    }

    public void deleteJob(int id)
    {
        jobrepo.deleteById(id);
    }
    public void load()
    {
        List<JobPost> jobs= new ArrayList<>(List.of(
                new JobPost("Software Engineer", 1,"Engineer"),
                new JobPost("Devops Engineer", 2, "Engineer")
        ));
        jobrepo.saveAll(jobs);
    }


//    public List<JobPost> findByJobNameContainingOrJobDescContaining(String name) {
//        return jobrepo.findByJobNameContainingOrJobDescContaining(name,name);
//    }
}
