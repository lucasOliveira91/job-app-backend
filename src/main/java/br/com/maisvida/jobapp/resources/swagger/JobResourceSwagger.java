package br.com.maisvida.jobapp.resources.swagger;

import br.com.maisvida.jobapp.domain.Job;
import br.com.maisvida.jobapp.dto.JobDTO;
import io.swagger.annotations.*;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

/**
 * Created by loliveira on 18/02/19.
 */
@Api(value = "1.0", description = "Manager the Jobs.")
public interface JobResourceSwagger {

    @ApiOperation("Return all jobs")
    ResponseEntity<?> getJobs();

    @ApiOperation("Return all jobs using page limit.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "This is the currently page.", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "linesPerPage", value = "The lines should be returned.", required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "orderBy", value = "Order",required = false, dataType = "String", paramType = "query"),
            @ApiImplicitParam(name = "direction", value = "Type order.",required = false, dataType = "String", paramType = "query"),
    })
    ResponseEntity<Page<JobDTO>> findPage(Integer page, Integer linesPerPage, String orderBy, String direction );

    @ApiOperation("Register a Job")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succefull Registed.", response = Job.class),
            @ApiResponse(code = 400, message = "It wasn't possible to register the job, wrong parameters."),
            @ApiResponse(code = 500, message = "It wasn't possible to register the job.") })
    ResponseEntity<Void> insert(JobDTO obj);

    @ApiOperation("Update data from Job")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "It wasn't possible to update the job, wrong parameters."),
            @ApiResponse(code = 500, message = "It wasn't possible to update the job.") })
    ResponseEntity<Void> update(JobDTO obj, Long id);

    @ApiOperation("Delete a Job")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "It wasn't possible to delete the job, wrong parameters."),
            @ApiResponse(code = 500, message = "It wasn't possible delete the job.") })
    ResponseEntity<Void> delete(Long id);
}
