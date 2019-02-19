package br.com.maisvida.jobapp.repository;

import br.com.maisvida.jobapp.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by loliveira on 18/02/19.
 */
public interface JobRepository extends JpaRepository<Job, Long> {
}
