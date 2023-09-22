package br.ce.wcaquino.taskbackend.controller;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class TaskControllerTest {
    private AutoCloseable closeable;
    @Mock
    private TaskRepo taskRepo;
    @InjectMocks
    TaskController taskController = new TaskController(taskRepo);

    @BeforeEach
    public void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    public void naoDeveSalvarTarefaSemDescricao() {
        Task task = new Task();
        task.setDueDate(LocalDate.now());

        try {
            taskController.save(task);
        } catch (ValidationException e) {
            assertEquals("Fill the task description", e.getMessage());
        }
    }

    @Test
    public void naoDeveSalvarTarefaSemData() {
        Task task = new Task();
        task.setTask("Tasks");

        try {
            taskController.save(task);
        } catch (ValidationException e) {
            assertEquals("Fill the due date", e.getMessage());
        }
    }

    @Test
    public void naoDeveSalvarTarefacomDataPassada() {
        Task task = new Task();
        task.setTask("Tasks");
        task.setDueDate(LocalDate.of(2020, 01, 01));
        try {
            taskController.save(task);
        } catch (ValidationException e) {
            assertEquals("Due date must not be in past", e.getMessage());
        }
    }


}
