package maplestory.tdl.DataBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quest_account_daily") // 테이블 이름을 지정해야 합니다.
public class QuestAccountDaily {
  @Id
  @Column(name = "UUID")
  private String UUID;
  @Column(name = "Urus")
  private boolean Urus;
  @Column(name = "Extreme_Monster")
  private boolean Extreme_Monster;
  @Column(name = "Daily_Monster")
  private boolean Daily_Monster;
  @Column(name = "Maple_M")
  private boolean Maple_M;
  @Column(name = "Union_Coin")
  private boolean Union_Coin;
  @Column(name = "Daily_Gift")
  private boolean Daily_Gift;
  @Column(name = "Expertise")
  private boolean Expertise;
  @Column(name = "Golden_Wagen")
  private boolean Golden_Wagen;

  // 생성자, getter 및 setter 등의 필요한 메서드를 추가할 수 있습니다.

  // 기본 생성자
  public QuestAccountDaily() {
  }

  public QuestAccountDaily(String UUID) {
    this.UUID = UUID;
  }

  public QuestAccountDaily(String UUID, boolean Urus, boolean Extreme_Monster,
      boolean Daily_Monster, boolean Maple_M, boolean Union_Coin, boolean Daily_Gift,
      boolean Expertise, boolean Golden_Wagen) {
    this.UUID = UUID;
    this.Urus = Urus;
    this.Extreme_Monster = Extreme_Monster;
    this.Daily_Monster = Daily_Monster;
    this.Maple_M = Maple_M;
    this.Union_Coin = Union_Coin;
    this.Daily_Gift = Daily_Gift;
    this.Expertise = Expertise;
    this.Golden_Wagen = Golden_Wagen;
  }

  // getter 및 setter 메서드
  public String getUUID() {
    return UUID;
  }

  public void setUUID(String UUID) {
    this.UUID = UUID;
  }

  public boolean getUrus() {
    return Urus;
  }

  public void setUrus(boolean Urus) {
    this.Urus = Urus;
  }

  public boolean getExtremeMonster() {
    return Extreme_Monster;
  }

  public void setExtremeMonster(boolean Extreme_Monster) {
    this.Extreme_Monster = Extreme_Monster;
  }

  public boolean getDailyMonster() {
    return Daily_Monster;
  }

  public void setDailyMonster(boolean Daily_Monster) {
    this.Daily_Monster = Daily_Monster;
  }

  public boolean getMapleM() {
    return Maple_M;
  }

  public void setMapleM(boolean Maple_M) {
    this.Maple_M = Maple_M;
  }

  public boolean getUnionCoin() {
    return Union_Coin;
  }

  public void setUnionCoin(boolean Union_Coin) {
    this.Union_Coin = Union_Coin;
  }

  public boolean getDailyGift() {
    return Daily_Gift;
  }

  public void setDailyGift(boolean Daily_Gift) {
    this.Daily_Gift = Daily_Gift;
  }

  public boolean getExpertise() {
    return Expertise;
  }

  public void setExpertise(boolean Expertise) {
    this.Expertise = Expertise;
  }

  public boolean getGoldenWagen() {
    return Golden_Wagen;
  }

  public void setGoldenWagen(boolean Golden_Wagen) {
    this.Golden_Wagen = Golden_Wagen;
  }
}