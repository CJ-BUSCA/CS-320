import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskTest {

  private String id, name, description;
  private String tooLongId, tooLongName, tooLongDescription;

  @BeforeEach
  void setUp() {
    id = "0000000000";
    name = "ABCDEFGHIJKLMNOPQRST";
    description = "Description of the task object.";
    tooLongId = "0000000000000000000000000000000000";
    tooLongName = "The task object shall have a required name String field that cannot be longer than 20 characters.";
    tooLongDescription = "The task object shall have a required description String field that cannot be longer than 50 characters. The description field shall not be null.";
  }

  @Test
  void getTaskIdTest() {
    Task task = new Task(id);
    Assertions.assertEquals(id, task.getTaskId());
  }

  @Test
  void getNameTest() {
    Task task = new Task(id, name);
    Assertions.assertEquals(name, task.getName());
  }

  @Test
  void getDescriptionTest() {
    Task task = new Task(id, name, description);
    Assertions.assertEquals(description, task.getDescription());
  }

  @Test
  void setNameTest() {
    Task task = new Task();
    task.setName(name);
    Assertions.assertEquals(name, task.getName());
  }

  @Test
  void setDescriptionTest() {
    Task task = new Task();
    task.setDescription(description);
    Assertions.assertEquals(description, task.getDescription());
  }

  @Test
  void TaskIdTooLongTest() {
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> new Task(tooLongId));
  }

  @Test
  void setTooLongNameTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setName(tooLongName));
  }

  @Test
  void setTooLongDescriptionTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setDescription(tooLongDescription));
  }

  @Test
  void TaskIdNullTest() {
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> new Task(null));
  }

  @Test
  void TaskNameNullTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setName(null));
  }

  @Test
  void TaskDescriptionNullTest() {
    Task task = new Task();
    Assertions.assertThrows(IllegalArgumentException.class,
                            () -> task.setDescription(null));
  }
}