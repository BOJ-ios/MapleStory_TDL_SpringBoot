package maplestory.tdl.DataBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users_characters") // 테이블 이름을 지정해야 합니다.
public class UsersCharacter {
  @Column(name = "UUID")
  private String UUID;
  @Id
  @Column(name = "Character_Name")
  private String Character_Name;

  // 생성자, getter 및 setter 등의 필요한 메서드를 추가할 수 있습니다.

  // 기본 생성자
  public UsersCharacter() {
  }

  public UsersCharacter(String UUID, String Character_Name) {
    this.UUID = UUID;
    this.Character_Name = Character_Name;
  }

  // getter 및 setter 메서드
  public String getUuid() {
    return UUID;
  }

  public void setUuid(String UUID) {
    this.UUID = UUID;
  }

  public String getCharacterName() {
    return Character_Name;
  }

  public void setCharacterName(String Character_Name) {
    this.Character_Name = Character_Name;
  }
}