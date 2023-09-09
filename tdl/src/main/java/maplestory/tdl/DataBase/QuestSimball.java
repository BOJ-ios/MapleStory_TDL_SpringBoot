package maplestory.tdl.DataBase;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quest_simball") // 테이블 이름을 지정해야 합니다.
public class QuestSimball {
  @Id
  private String uuid;

  private String characterName;
  private boolean vanishingJourney;
  private boolean chuChu;
  private boolean lachelein;
  private boolean arcana;
  private boolean morass;
  private boolean esfera;
  private boolean cernium;
  private boolean arcus;
  private boolean odium;
  private boolean shangriLa;
  private boolean arteria;
  private boolean carcion;

  // 생성자, getter 및 setter 등의 필요한 메서드를 추가할 수 있습니다.

  // 기본 생성자
  public QuestSimball() {
  }

  public QuestSimball(String uuid, String characterName, boolean vanishingJourney,
      boolean chuChu, boolean lachelein, boolean arcana, boolean morass,
      boolean esfera, boolean cernium, boolean arcus, boolean odium,
      boolean shangriLa, boolean arteria, boolean carcion) {
    this.uuid = uuid;
    this.characterName = characterName;
    this.vanishingJourney = vanishingJourney;
    this.chuChu = chuChu;
    this.lachelein = lachelein;
    this.arcana = arcana;
    this.morass = morass;
    this.esfera = esfera;
    this.cernium = cernium;
    this.arcus = arcus;
    this.odium = odium;
    this.shangriLa = shangriLa;
    this.arteria = arteria;
    this.carcion = carcion;
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

  public boolean isVanishingJourney() {
    return vanishingJourney;
  }

  public void setVanishingJourney(boolean vanishingJourney) {
    this.vanishingJourney = vanishingJourney;
  }

  public boolean isChuChu() {
    return chuChu;
  }

  public void setChuChu(boolean chuChu) {
    this.chuChu = chuChu;
  }

  public boolean isLachelein() {
    return lachelein;
  }

  public void setLachelein(boolean lachelein) {
    this.lachelein = lachelein;
  }

  public boolean isArcana() {
    return arcana;
  }

  public void setArcana(boolean arcana) {
    this.arcana = arcana;
  }

  public boolean isMorass() {
    return morass;
  }

  public void setMorass(boolean morass) {
    this.morass = morass;
  }

  public boolean isEsfera() {
    return esfera;
  }

  public void setEsfera(boolean esfera) {
    this.esfera = esfera;
  }

  public boolean isCernium() {
    return cernium;
  }

  public void setCernium(boolean cernium) {
    this.cernium = cernium;
  }

  public boolean isArcus() {
    return arcus;
  }

  public void setArcus(boolean arcus) {
    this.arcus = arcus;
  }

  public boolean isOdium() {
    return odium;
  }

  public void setOdium(boolean odium) {
    this.odium = odium;
  }

  public boolean isShangriLa() {
    return shangriLa;
  }

  public void setShangriLa(boolean shangriLa) {
    this.shangriLa = shangriLa;
  }

  public boolean isArteria() {
    return arteria;
  }

  public void setArteria(boolean arteria) {
    this.arteria = arteria;
  }

  public boolean isCarcion() {
    return carcion;
  }

  public void setCarcion(boolean carcion) {
    this.carcion = carcion;
  }
}