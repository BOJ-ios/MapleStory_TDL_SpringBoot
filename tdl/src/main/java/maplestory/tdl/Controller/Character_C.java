package maplestory.tdl.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.persistence.Id;
import jakarta.servlet.http.HttpSession;
import maplestory.tdl.DataBase.QuestAccountDailyRep;
import maplestory.tdl.DataBase.QuestSimball;
import maplestory.tdl.DataBase.QuestSimballRep;
import maplestory.tdl.DataBase.QuestWeekly;
import maplestory.tdl.DataBase.QuestWeeklyRep;
import maplestory.tdl.DataBase.UsersCharacter;
import maplestory.tdl.DataBase.UsersCharacterRep;

@Controller
public class Character_C {
  @Autowired
  private UsersCharacterRep characterRep;
  @Autowired
  private QuestSimballRep simballRep;
  @Autowired
  private QuestWeeklyRep weeklyRep;

  @Id
  @GetMapping("/selectCharacter")
  public String selectCharacter(HttpSession session, Model model) {
    String uuid = (String) session.getAttribute("UUID");
    List<UsersCharacter> characters = characterRep.findByUuid(uuid);
    List<String> characterNames = characters.stream()
        .map(UsersCharacter::getCharacterName)
        .collect(Collectors.toList());
    for (String string : characterNames) {
      System.out.println(string);
    }
    model.addAttribute("characterNames", characterNames);
    return "select_character";
  }

  // Todo 캐릭터 이름 중복 검사 필요
  @PostMapping("/save-character")
  public String saveCharacter(@RequestParam("characterName") String characterName, HttpSession session) {
    String UUID = (String) session.getAttribute("UUID");
    UsersCharacter userCharacter = new UsersCharacter(UUID, characterName);
    characterRep.save(userCharacter);
    QuestSimball newQuestSimball = new QuestSimball(UUID, characterName);
    simballRep.save(newQuestSimball);
    QuestWeekly newWeeklyQuest = new QuestWeekly(UUID, characterName);
    weeklyRep.save(newWeeklyQuest);
    return "redirect:/selectCharacter";
  }

  @PostMapping("/delete-character")
  public String deleteCharacter(@RequestParam("characterName") String characterName, HttpSession session) {
    UsersCharacter userCharacter = new UsersCharacter((String) session.getAttribute("UUID"), characterName);
    characterRep.delete(userCharacter);
    return "redirect:/selectCharacter";
  }
}
