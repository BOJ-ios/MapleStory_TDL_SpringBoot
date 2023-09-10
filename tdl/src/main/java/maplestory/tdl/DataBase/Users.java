package maplestory.tdl.DataBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
  @Column(length = 36)
  private String UUID;
  @Id
  @Column(length = 20)
  private String ID;

  @Column(length = 64)
  private String PW;

  // 생성자, 게터, 세터 등 필요한 다른 메서드들을 추가할 수 있습니다.

  public Users() {
    // 기본 생성자
  }

  public Users(String ID, String PW, String UUID) {
    this.UUID = UUID;
    this.ID = ID;
    this.PW = PW;
  }

  // 게터와 세터 메서드
  public String getUUID() {
    return UUID;
  }

  public void setUUID(String UUID) {
    this.UUID = UUID;
  }

  public String getID() {
    return ID;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public String getPW() {
    return PW;
  }

  public void setPW(String PW) {
    this.PW = PW;
  }
}