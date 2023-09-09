package maplestory.tdl.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Reactive.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import maplestory.tdl.DataBase.UsersCharacter;
import maplestory.tdl.DataBase.UsersCharacterRep;

@Controller
public class Character_C {
  @Autowired
  private UsersCharacterRep characterRep;

  @PostMapping("/save-character")
  public String saveCharacter(@RequestParam("characterName") String characterName, HttpSession session) {
    UsersCharacter userCharacter = new UsersCharacter((String) session.getAttribute("UUID"), characterName);
    characterRep.save(userCharacter);
    return "redirect:/todo";
  }
}
