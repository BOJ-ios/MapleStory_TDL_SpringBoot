package maplestory.tdl;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
  @Column(length = 36)
  private String uuid;
  @Id
  @Column(length = 255)
  private String id;

  @Column(length = 255)
  private String pw;

  // 생성자, 게터, 세터 등 필요한 다른 메서드들을 추가할 수 있습니다.

  public Users() {
    // 기본 생성자
  }

  public Users(String id, String pw, String uuid) {
    this.uuid = uuid;
    this.id = id;
    this.pw = pw;
  }

  // 게터와 세터 메서드
  public String getUUID() {
    return uuid;
  }

  public void setUUID(String uuid) {
    this.uuid = uuid;
  }

  public String getID() {
    return id;
  }

  public void setID(String id) {
    this.id = id;
  }

  public String getPW() {
    return pw;
  }

  public void setPW(String pw) {
    this.pw = pw;
  }
}