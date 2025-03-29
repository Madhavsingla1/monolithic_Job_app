package com.madz.firstJobApp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {


    private JobService jobService;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }
    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return ResponseEntity.ok(jobService.findAll());
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job val){
        jobService.createJob(val);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> findById(@PathVariable int id){
        Job job = jobService.jobById(id);
        if(job == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable long id){
        boolean job =jobService.deleteById(id);
        if (!job){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
    }

//    @PutMapping("/jobs/{id}")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@RequestBody Job val, @PathVariable long id){
        boolean updated = jobService.updateJobById(id,val);
        if (!updated){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
    }
}
