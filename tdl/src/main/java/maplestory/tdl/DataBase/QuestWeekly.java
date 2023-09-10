package maplestory.tdl.DataBase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quest_weekly") // 테이블 이름을 지정해야 합니다.
public class QuestWeekly {
  @Column(name = "UUID")
  private String UUID;
  @Id
  @Column(name = "Charactor_Name")
  private String Charactor_Name;
  @Column(name = "Scrapyard")
  private boolean Scrapyard;
  @Column(name = "Dark_World_Tree")
  private boolean Dark_World_Tree;
  @Column(name = "Kritias")
  private boolean Kritias;
  @Column(name = "Mu_Lung_Dojo")
  private boolean Mu_Lung_Dojo;
  @Column(name = "Sharenian_Culvert")
  private boolean Sharenian_Culvert;
  // 생성자, getter 및 setter 등의 필요한 메서드를 추가할 수 있습니다.

  // 기본 생성자
  public QuestWeekly() {
  }

  public QuestWeekly(String UUID, String Charactor_Name) {
    this.UUID = UUID;
    this.Charactor_Name = Charactor_Name;
  }

  public QuestWeekly(String UUID, String Charactor_Name, boolean Scrapyard,
      boolean Dark_World_Tree, boolean Kritias, boolean Mu_Lung_Dojo, boolean Sharenian_Culvert) {
    this.UUID = UUID;
    this.Charactor_Name = Charactor_Name;
    this.Scrapyard = Scrapyard;
    this.Dark_World_Tree = Dark_World_Tree;
    this.Kritias = Kritias;
    this.Mu_Lung_Dojo = Mu_Lung_Dojo;
    this.Sharenian_Culvert = Sharenian_Culvert;
  }

  // getter 및 setter 메서드
  public String getUUID() {
    return UUID;
  }

  public void setUUID(String UUID) {
    this.UUID = UUID;
  }

  public String getCharactor_Name() {
    return Charactor_Name;
  }

  public void setCharactor_Name(String Charactor_Name) {
    this.Charactor_Name = Charactor_Name;
  }

  public boolean getScrapyard() {
    return Scrapyard;
  }

  public void setScrapyard(boolean Scrapyard) {
    this.Scrapyard = Scrapyard;
  }

  public boolean getDarkWorldTree() {
    return Dark_World_Tree;
  }

  public void setDarkWorldTree(boolean Dark_World_Tree) {
    this.Dark_World_Tree = Dark_World_Tree;
  }

  public boolean getKritias() {
    return Kritias;
  }

  public void setKritias(boolean Kritias) {
    this.Kritias = Kritias;
  }

  public boolean getMuLungDojo() {
    return Mu_Lung_Dojo;
  }

  public void setMuLungDojo(boolean Mu_Lung_Dojo) {
    this.Mu_Lung_Dojo = Mu_Lung_Dojo;
  }

  public boolean getSharenian_Culvert() {
    return Sharenian_Culvert;
  }

  public void setSharenian_Culvert(boolean Sharenian_Culvert) {
    this.Sharenian_Culvert = Sharenian_Culvert;
  }
}