package br.com.maisvida.jobapp.resources;

import br.com.maisvida.jobapp.dto.JobDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * Created by loliveira on 20/02/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= RANDOM_PORT)
public class JobResourceTest {

    private JacksonTester<List<JobDTO>> jsonListJob;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        JacksonTester.initFields(this,objectMapper);
    }

    @Test
    public void ShouldReturnAll() throws IOException {
        final ResponseEntity<String> result = this.restTemplate.getForEntity("/jobs/1", String.class);

        assertThat(result.getBody()).isNotNull();
    }
}
