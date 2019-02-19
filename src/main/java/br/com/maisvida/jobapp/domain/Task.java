package br.com.maisvida.jobapp.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by loliveira on 18/02/19.
 */
@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
}
