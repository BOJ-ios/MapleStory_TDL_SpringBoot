package maplestory.tdl.DataBase;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quest_weekly") // 테이블 이름을 지정해야 합니다.
public class QuestWeekly {
  @Id
  private String uuid;

  private String characterName;
  private boolean scrapyard;
  private boolean darkWorldTree;
  private boolean kritias;
  private boolean muLungDojo;

  // 생성자, getter 및 setter 등의 필요한 메서드를 추가할 수 있습니다.

  // 기본 생성자
  public QuestWeekly() {
  }

  public QuestWeekly(String uuid, String characterName, boolean scrapyard,
      boolean darkWorldTree, boolean kritias, boolean muLungDojo) {
    this.uuid = uuid;
    this.characterName = characterName;
    this.scrapyard = scrapyard;
    this.darkWorldTree = darkWorldTree;
    this.kritias = kritias;
    this.muLungDojo = muLungDojo;
  }

  // getter 및 setter 메서드
  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getCharacterName() {
    return characterName;
  }

  public void setCharacterName(String characterName) {
    this.characterName = characterName;
  }

  public boolean isScrapyard() {
    return scrapyard;
  }

  public void setScrapyard(boolean scrapyard) {
    this.scrapyard = scrapyard;
  }

  public boolean isDarkWorldTree() {
    return darkWorldTree;
  }

  public void setDarkWorldTree(boolean darkWorldTree) {
    this.darkWorldTree = darkWorldTree;
  }

  public boolean isKritias() {
    return kritias;
  }

  public void setKritias(boolean kritias) {
    this.kritias = kritias;
  }

  public boolean isMuLungDojo() {
    return muLungDojo;
  }

  public void setMuLungDojo(boolean muLungDojo) {
    this.muLungDojo = muLungDojo;
  }
}