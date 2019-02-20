package br.com.maisvida.jobapp.resources;

import br.com.maisvida.jobapp.domain.Job;
import br.com.maisvida.jobapp.dto.JobDTO;
import br.com.maisvida.jobapp.resources.swagger.JobResourceSwagger;
import br.com.maisvida.jobapp.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @GetMapping("/page")
    public ResponseEntity<Page<JobDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                                 @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
                                                 @RequestParam(value = "orderBy", defaultValue = "name") String orderBy,
                                                 @RequestParam(value = "direction", defaultValue = "ASC") String direction ) {
        Page<Job> list = jobService.findAllPageable(page, linesPerPage, orderBy, direction);
        return ResponseEntity.ok().body(list.map(obj -> new JobDTO(obj)));
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody JobDTO obj) {
        Job objx = jobService.fromDTO(obj);

        jobService.insert(objx);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objx.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<JobDTO> find(@PathVariable Long id) {
        Job job = jobService.find(id);
        return ResponseEntity.ok().body(new JobDTO(job));
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody JobDTO obj, @PathVariable Long id) {
        obj.setId(id);
        jobService.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        jobService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
