package maplestory.tdl.DataBase;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quest_daily") // 테이블 이름을 지정해야 합니다.
public class QuestDaily {
  @Id
  private String uuid;

  private String characterName;
  private boolean urus;
  private boolean extremeMonster;
  private boolean dailyMonster;
  private boolean mapleM;
  private boolean unionCoin;
  private boolean dailyGift;
  private boolean expertise;

  // 생성자, getter 및 setter 등의 필요한 메서드를 추가할 수 있습니다.

  // 기본 생성자
  public QuestDaily() {
  }

  public QuestDaily(String uuid, String characterName, boolean urus, boolean extremeMonster,
      boolean dailyMonster, boolean mapleM, boolean unionCoin, boolean dailyGift,
      boolean expertise) {
    this.uuid = uuid;
    this.characterName = characterName;
    this.urus = urus;
    this.extremeMonster = extremeMonster;
    this.dailyMonster = dailyMonster;
    this.mapleM = mapleM;
    this.unionCoin = unionCoin;
    this.dailyGift = dailyGift;
    this.expertise = expertise;
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

  public boolean isUrus() {
    return urus;
  }

  public void setUrus(boolean urus) {
    this.urus = urus;
  }

  public boolean isExtremeMonster() {
    return extremeMonster;
  }

  public void setExtremeMonster(boolean extremeMonster) {
    this.extremeMonster = extremeMonster;
  }

  public boolean isDailyMonster() {
    return dailyMonster;
  }

  public void setDailyMonster(boolean dailyMonster) {
    this.dailyMonster = dailyMonster;
  }

  public boolean isMapleM() {
    return mapleM;
  }

  public void setMapleM(boolean mapleM) {
    this.mapleM = mapleM;
  }

  public boolean isUnionCoin() {
    return unionCoin;
  }

  public void setUnionCoin(boolean unionCoin) {
    this.unionCoin = unionCoin;
  }

  public boolean isDailyGift() {
    return dailyGift;
  }

  public void setDailyGift(boolean dailyGift) {
    this.dailyGift = dailyGift;
  }

  public boolean isExpertise() {
    return expertise;
  }

  public void setExpertise(boolean expertise) {
    this.expertise = expertise;
  }
}