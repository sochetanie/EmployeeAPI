package com.galvanize.employeedb.Services;

import com.galvanize.employeedb.Entities.Job;
import com.galvanize.employeedb.Repositories.JobRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;


@Service
public class JobService {
    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository){
        this.jobRepository = jobRepository;
    }

    public Job save(Job job){
        return this.jobRepository.save(job);
    }

    public Optional<Job> findJobById(long id) { return this.jobRepository.findById(id); }


}