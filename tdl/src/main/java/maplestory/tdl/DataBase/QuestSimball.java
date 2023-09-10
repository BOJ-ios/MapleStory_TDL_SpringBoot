package maplestory.tdl.DataBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quest_simball") // 테이블 이름을 지정해야 합니다.
public class QuestSimball {
  @Column(name = "UUID")
  private String UUID;
  @Id
  @Column(name = "Character_Name")
  private String Character_Name;
  @Column(name = "Vanishing_Journey")
  private boolean Vanishing_Journey;
  @Column(name = "ChuChu")
  private boolean ChuChu;
  @Column(name = "Lachelein")
  private boolean Lachelein;
  @Column(name = "Arcana")
  private boolean Arcana;
  @Column(name = "Morass")
  private boolean Morass;
  @Column(name = "Esfera")
  private boolean Esfera;
  @Column(name = "Cernium")
  private boolean Cernium;
  @Column(name = "Arcus")
  private boolean Arcus;
  @Column(name = "Odium")
  private boolean Odium;
  @Column(name = "Shangri_La")
  private boolean Shangri_La;
  @Column(name = "Arteria")
  private boolean Arteria;
  @Column(name = "Carcion")
  private boolean Carcion;

  // 생성자, getter 및 setter 등의 필요한 메서드를 추가할 수 있습니다.

  // 기본 생성자
  public QuestSimball() {
  }

  public QuestSimball(String UUID, String Character_Name) {
    this.UUID = UUID;
    this.Character_Name = Character_Name;
  }

  public QuestSimball(String UUID, String Character_Name, boolean Vanishing_Journey,
      boolean ChuChu, boolean Lachelein, boolean Arcana, boolean Morass,
      boolean Esfera, boolean Cernium, boolean Arcus, boolean Odium,
      boolean Shangri_La, boolean Arteria, boolean Carcion) {
    this.UUID = UUID;
    this.Character_Name = Character_Name;
    this.Vanishing_Journey = Vanishing_Journey;
    this.ChuChu = ChuChu;
    this.Lachelein = Lachelein;
    this.Arcana = Arcana;
    this.Morass = Morass;
    this.Esfera = Esfera;
    this.Cernium = Cernium;
    this.Arcus = Arcus;
    this.Odium = Odium;
    this.Shangri_La = Shangri_La;
    this.Arteria = Arteria;
    this.Carcion = Carcion;
  }

  // getter 및 setter 메서드
  public String getUUID() {
    return UUID;
  }

  public void setUUID(String UUID) {
    this.UUID = UUID;
  }

  public String getCharacterName() {
    return Character_Name;
  }

  public void setCharacterName(String Character_Name) {
    this.Character_Name = Character_Name;
  }

  public boolean getVanishingJourney() {
    return Vanishing_Journey;
  }

  public void setVanishingJourney(boolean Vanishing_Journey) {
    this.Vanishing_Journey = Vanishing_Journey;
  }

  public boolean getChuChu() {
    return ChuChu;
  }

  public void setChuChu(boolean ChuChu) {
    this.ChuChu = ChuChu;
  }

  public boolean getLachelein() {
    return Lachelein;
  }

  public void setLachelein(boolean Lachelein) {
    this.Lachelein = Lachelein;
  }

  public boolean getArcana() {
    return Arcana;
  }

  public void setArcana(boolean Arcana) {
    this.Arcana = Arcana;
  }

  public boolean getMorass() {
    return Morass;
  }

  public void setMorass(boolean Morass) {
    this.Morass = Morass;
  }

  public boolean getEsfera() {
    return Esfera;
  }

  public void setEsfera(boolean Esfera) {
    this.Esfera = Esfera;
  }

  public boolean getCernium() {
    return Cernium;
  }

  public void setCernium(boolean Cernium) {
    this.Cernium = Cernium;
  }

  public boolean getArcus() {
    return Arcus;
  }

  public void setArcus(boolean Arcus) {
    this.Arcus = Arcus;
  }

  public boolean getOdium() {
    return Odium;
  }

  public void setOdium(boolean Odium) {
    this.Odium = Odium;
  }

  public boolean getShangriLa() {
    return Shangri_La;
  }

  public void setShangriLa(boolean Shangri_La) {
    this.Shangri_La = Shangri_La;
  }

  public boolean getArteria() {
    return Arteria;
  }

  public void setArteria(boolean Arteria) {
    this.Arteria = Arteria;
  }

  public boolean getCarcion() {
    return Carcion;
  }

  public void setCarcion(boolean Carcion) {
    this.Carcion = Carcion;
  }
}