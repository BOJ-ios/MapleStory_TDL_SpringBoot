package maplestory.tdl.DataBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo_list")
public class TodoList {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long ID;

  @Column(name = "UUID", length = 36, nullable = false)
  private String UUID;

  @Column(name = "Value", length = 200)
  private String Value;

  @Column(name = "Status", nullable = false)
  private boolean Status;

  @Column(name = "Daily_Weekly", nullable = false)
  private boolean Daily_Weekly;

  // *Constructors
  public TodoList() {
    // Default constructor
  }

  public TodoList(Long ID, String UUID, String Value, boolean Status, boolean Daily_Weekly) {
    this.ID = ID;
    this.UUID = UUID;
    this.Value = Value;
    this.Status = Status;
    this.Daily_Weekly = Daily_Weekly;
  }

  // *Getter
  public long getId() {
    return ID;
  }

  public String getUUID() {
    return UUID;
  }

  public String getValue() {
    return Value;
  }

  public boolean getStatus() {
    return Status;
  }

  public boolean getDailyWeekly() {
    return Daily_Weekly;
  }

  // *Setter
  public void setUUID(String UUID) {
    this.UUID = UUID;
  }

  public void setValue(String Value) {
    this.Value = Value;
  }

  public void setStatus(boolean Status) {
    this.Status = Status;
  }

  public void setDailyWeekly(boolean Daily_Weekly) {
    this.Daily_Weekly = Daily_Weekly;
  }
}
