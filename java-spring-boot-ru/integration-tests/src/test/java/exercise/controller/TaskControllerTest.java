package exercise.controller;

import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    // BEGIN
    @Test
    public void testShow() throws Exception {
        var title = faker.lorem().word();
        var description = faker.lorem().sentence(11);
        var task = Instancio.of(Task.class)
                .supply(Select.field(Task::getTitle), () -> title)
                .supply(Select.field(Task::getDescription), () -> description)
                .create();
        taskRepository.save(task);

        var request = get("/tasks/{0}", task.getId());

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andReturn();

        task = taskRepository.findById(task.getId()).get();
        assertThat(task.getTitle()).isEqualTo(title);
        assertThat(task.getDescription()).isEqualTo(description);
    }

    @Test
    public void testCreate() throws Exception {
        var title = faker.lorem().word();
        var description = faker.lorem().sentence(11);

        var task = new HashMap<>();
        task.put("title", title);
        task.put("description", description);


        var request = post("/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(task));

        mockMvc.perform(request)
                .andExpect(status().isCreated());

        var response  = taskRepository.findByTitle(title).get();
        assertThat(response.getTitle()).isEqualTo(title);
        assertThat(response.getDescription()).isEqualTo(description);
    }

    @Test
    public void testUpdate() throws Exception {
        var task = Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .ignore(Select.field(Task::getCreatedAt))
                .ignore(Select.field(Task::getUpdatedAt))
                .create();
        taskRepository.save(task);

        var title = faker.lorem().word();
        var description = faker.lorem().sentence(11);

        var data = new HashMap<>();
        data.put("title", title);
        data.put("description", description);


        var request = put("/tasks/{0}", task.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));

        mockMvc.perform(request)
                .andExpect(status().isOk());

        task = taskRepository.findById(task.getId()).get();
        assertThat(task.getTitle()).isEqualTo(title);
        assertThat(task.getDescription()).isEqualTo(description);
    }

    @Test
    public void testDelete() throws Exception {

        var title = faker.lorem().word();
        var description = faker.lorem().sentence(11);
        var task = Instancio.of(Task.class)
                    .supply(Select.field(Task::getTitle), () -> title)
                    .supply(Select.field(Task::getDescription), () -> description)
                    .create();
        taskRepository.save(task);


        var request = delete("/tasks/{0}", task.getId());

        mockMvc.perform(request)
                .andExpect(status().isOk());

        var deletTask = taskRepository.findById(task.getId());
        assertThat(deletTask).isEmpty();
    }
    // END
}
