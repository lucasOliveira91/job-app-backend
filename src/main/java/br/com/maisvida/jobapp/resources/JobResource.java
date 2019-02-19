package br.com.maisvida.jobapp.resources;

import br.com.maisvida.jobapp.domain.Job;
import br.com.maisvida.jobapp.dto.JobDTO;
import br.com.maisvida.jobapp.resources.swagger.JobResourceSwagger;
import br.com.maisvida.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by loliveira on 18/02/19.
 */
@RestController
@RequestMapping("/jobs")
public class JobResource implements JobResourceSwagger {

    @Autowired
    private JobService jobService;

    @GetMapping
    public ResponseEntity<?> getJobs() {
        List<Job> all = jobService.findAll();
        return ResponseEntity.ok().body(all.stream().map(obj -> new JobDTO(obj)).collect(Collectors.toList()));
    }
}
