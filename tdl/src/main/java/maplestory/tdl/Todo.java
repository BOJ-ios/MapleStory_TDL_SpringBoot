package maplestory.tdl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "character_todo")
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "UUID", length = 36, nullable = false)
  private String UUID;

  @Column(name = "todo_name", length = 200)
  private String todoName;

  @Column(name = "donecheck", nullable = false)
  private boolean doneCheck;
  // Constructors, getters, and setters

  public Todo() {
    // Default constructor
  }

  public Todo(Long id, String UUID, String todoName, boolean doneCheck) {
    this.id = id;
    this.UUID = UUID;
    this.todoName = todoName;
    this.doneCheck = doneCheck;
  }

  // Getter and setter methods for UUID, todoName, doneCheck, and characterName
  public long getId() {
    return id;
  }

  public String getUUID() {
    return UUID;
  }

  public void setUUID(String UUID) {
    this.UUID = UUID;
  }

  public String getTodoName() {
    return todoName;
  }

  public void setTodoName(String todoName) {
    this.todoName = todoName;
  }

  public boolean isDoneCheck() {
    return doneCheck;
  }

  public void setDoneCheck(boolean doneCheck) {
    this.doneCheck = doneCheck;
  }

  public void reverseCheck() {
    this.doneCheck = this.doneCheck ? false : true;
  }
}
