package br.com.maisvida.jobapp.dto;

import br.com.maisvida.jobapp.domain.Job;
import lombok.Data;

import java.util.List;

/**
 * Created by loliveira on 18/02/19.
 */
@Data
public class JobDTO {
    private Long id;
    private String name;
    private JobDTO parentJob;
    private List<TaskDTO> tasks;
    private Boolean active;

    public JobDTO(Job job) {
        this.id = job.getId();
        this.name = job.getName();
        this.active = job.getActive();
    }
}
