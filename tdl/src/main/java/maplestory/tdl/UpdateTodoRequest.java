package maplestory.tdl;

public class UpdateTodoRequest {
  private String newValue;
  private boolean newStatus;

  public String getNewValue() {
    return newValue;
  }

  public boolean getNewStatus() {
    return newStatus;
  }

  public void setNewValue(String newValue) {
    this.newValue = newValue;
  }

  public void setNewState(boolean newStatus) {
    this.newStatus = newStatus;
  }
}
