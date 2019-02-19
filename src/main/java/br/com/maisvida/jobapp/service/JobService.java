package br.com.maisvida.jobapp.service;

import br.com.maisvida.jobapp.domain.Job;
import br.com.maisvida.jobapp.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by loliveira on 18/02/19.
 */
@Service
public class JobService {

    @Autowired
    private JobRepository repository;

    public List<Job> findAll() {
        return repository.findAll();
    }
}
