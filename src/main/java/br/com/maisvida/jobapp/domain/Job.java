package br.com.maisvida.jobapp.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
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

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL)
    private List<Task> tasks = new ArrayList<>();
    private Boolean active;
}
