package maplestory.tdl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todo_common")
public class TodoCommon {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "UUID", length = 36, nullable = false)
  private String UUID;

  @Column(name = "value", length = 200)
  private String value;

  @Column(name = "status", nullable = false)
  private boolean status;

  @Column(name = "daily_weekly", nullable = false)
  private boolean dailyWeekly;

  // *Constructors
  public TodoCommon() {
    // Default constructor
  }

  public TodoCommon(Long id, String UUID, String value, boolean status, boolean dailyWeekly) {
    this.id = id;
    this.UUID = UUID;
    this.value = value;
    this.status = status;
    this.dailyWeekly = dailyWeekly;
  }

  // *Getter
  public long getId() {
    return id;
  }

  public String getUUID() {
    return UUID;
  }

  public String getValue() {
    return value;
  }

  public boolean getStatus() {
    return status;
  }

  public boolean getDailyWeekly() {
    return dailyWeekly;
  }

  // *Setter
  public void setUUID(String UUID) {
    this.UUID = UUID;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public void setStatus(boolean status) {
    this.status = status;
  }

  public void setDailyWeekly(boolean dailyWeekly) {
    this.dailyWeekly = dailyWeekly;
  }
}
