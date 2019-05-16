package com.galvanize.employeedb.Controllers;

import com.galvanize.employeedb.Entities.Job;
import com.galvanize.employeedb.Services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "/job")
@CrossOrigin(origins = "http://localhost:8080")
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


    @PostMapping("/add")
    public Job save(@RequestBody Job job) { return this.jobService.save(job); }

    @GetMapping(value = "/get/{id}")
    public Optional<Job> findJobById(@PathVariable("id") Long jobId){ return this.jobService.findJobById(jobId); }


    @PutMapping("/put/{id}")
    public Job updateJob(@PathVariable("id") Long id, @RequestBody ModelMap mm) {

        Job updatedJob = jobService.findJobById(id).get();
        updatedJob.setCustomer((mm.get("customer").toString()));
        return this.jobService.save(updatedJob);
    }


}
