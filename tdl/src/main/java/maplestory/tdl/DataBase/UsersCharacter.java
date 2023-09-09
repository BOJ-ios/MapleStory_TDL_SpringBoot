package maplestory.tdl.DataBase;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_characters") // 테이블 이름을 지정해야 합니다.
public class UsersCharacter {
  @Id
  private String uuid;

  private String charactor_name;

  // 생성자, getter 및 setter 등의 필요한 메서드를 추가할 수 있습니다.

  // 기본 생성자
  public UsersCharacter() {
  }

  public UsersCharacter(String uuid, String charactor_name) {
    this.uuid = uuid;
    this.charactor_name = charactor_name;
  }

  // getter 및 setter 메서드
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getCharacterName() {
    return charactor_name;
  }

  public void setCharacterName(String charactor_name) {
    this.charactor_name = charactor_name;
  }
}