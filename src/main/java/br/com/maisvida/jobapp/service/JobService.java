package br.com.maisvida.jobapp.service;

import br.com.maisvida.jobapp.domain.Job;
import br.com.maisvida.jobapp.domain.enuns.Role;
import br.com.maisvida.jobapp.dto.JobDTO;
import br.com.maisvida.jobapp.exception.AuthorizationException;
import br.com.maisvida.jobapp.exception.DataIntegrityException;
import br.com.maisvida.jobapp.exception.ObjectNotFoundException;
import br.com.maisvida.jobapp.repository.JobRepository;
import br.com.maisvida.jobapp.repository.TaskRepository;
import br.com.maisvida.jobapp.security.UserSS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by loliveira on 18/02/19.
 */
@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    @Autowired
    private TaskRepository taskRepository;

    public List<Job> findAll() {
        return repository.findAll();
    }

    public Job fromDTO(JobDTO obj) {
        Job job = new Job();
        job.setName(obj.getName());
        return job;
    }

    public Job insert(Job objx) {
        objx.setId(null);
        Job save = repository.save(objx);
        taskRepository.saveAll(save.getTasks());
        return save;
    }

    public Job update(JobDTO obj) {
        Job job = find(obj.getId());
        return repository.save(updateData(obj, job));
    }

    public void delete(Long id) {
        find(id);

        try{
            repository.deleteById(id);
        }catch (DataIntegrityViolationException ex){
            throw new DataIntegrityException("we cannot delete, there're relations.");
        }
    }

    public Job find(Long id) {
        UserSS user = UserService.authenticated();

        if(user == null || !user.hasRole(Role.ADMIN) && !user.getId().equals(id)) {
            throw new AuthorizationException("Access Denied");
        }

        return repository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found! Id:" + id + " " + Job.class.getName()));
    }

    private Job updateData(JobDTO obj, Job job) {
        job.setName(obj.getName());

        return job;
    }

    public Page<Job> findAllPageable(Integer page, Integer linesPerPage, String orderBy, String direction  ) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repository.findAll(pageRequest);
    }
}
