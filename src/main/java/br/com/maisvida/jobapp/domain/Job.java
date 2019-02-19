package br.com.maisvida.jobapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by loliveira on 18/02/19.
 */
@Entity
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToOne
    private Job parentJob;

    @OneToMany(mappedBy = "job")
    private List<Task> tasks;
    private Boolean active;
}
