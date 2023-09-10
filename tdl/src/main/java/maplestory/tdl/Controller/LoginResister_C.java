package maplestory.tdl.Controller;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;
import maplestory.tdl.DataBase.QuestAccountDaily;
import maplestory.tdl.DataBase.QuestAccountDailyRep;
import maplestory.tdl.DataBase.Users;
import maplestory.tdl.DataBase.UsersRepository;
import maplestory.tdl.Service.SHA256;

@Controller
public class LoginResister_C {
  public static final String dpNone = "display: none";
  public static final String dpBlock = "display: block";

  // !처음 접속 페이지
  @GetMapping("/")
  public String main_Page(Model model) {
    model.addAttribute("errorMsg_Style", dpNone);
    model.addAttribute("idMsg_Style", dpNone);
    model.addAttribute("pwMsg_Style", dpNone);
    return "main";
  }

  // !로그인
  @Autowired
  private UsersRepository userRep;

  @Autowired
  private QuestAccountDailyRep qadRep;

  @PostMapping("/login")
  public String login_validation(HttpSession session, Model model, String ID, String PW) {
    model.addAttribute("idMsg_Style", dpNone);
    model.addAttribute("pwMsg_Style", dpNone);
    int validation = checkEmpty(ID, PW);
    if (validation == 0) { // !아이디 안적음
      model.addAttribute("errorMsg_Style", dpBlock);
      model.addAttribute("errorMsg", "아이디를 입력해주세요.");
      return "main";
    } else if (validation == 1) { // !비밀번호 안적음
      model.addAttribute("ID", ID);
      model.addAttribute("errorMsg_Style", dpBlock);
      model.addAttribute("errorMsg", "비밀번호를 입력해주세요.");
      return "main";
    } else { // ! 둘다 적음
      // !암호화
      SHA256 hash = new SHA256();
      try {
        PW = hash.encrypt(PW + ID.substring(0, 3));
      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      }
      Users user = userRep.findById(ID).orElse(null);
      // *유저 존재 */
      if (user != null) {
        // *비밀번호 정답 */
        if (user.getPW().equals(PW)) {
          session.setAttribute("UUID", user.getUUID());
          return "redirect:/selectCharacter";
        }
      }
      // *비번 틀림 */
      model.addAttribute("ID", ID);
      model.addAttribute("errorMsg_Style", dpBlock);
      model.addAttribute("errorMsg", "아이디 또는 비밀번호를 잘못 입력했습니다.");
    }
    return "main";
  }

  // !회원가입
  @PostMapping("/register")
  public String register_validation(HttpSession session, Model model, String ID, String PW) {
    int validation = checkEmpty(ID, PW);
    model.addAttribute("errorMsg_Style", dpBlock);
    if (validation == 0) {
      model.addAttribute("errorMsg", "아이디를 입력해주세요.");
      return "main";
    } else if (validation == 1) {
      model.addAttribute("errorMsg", "비밀번호를 입력해주세요.");
      return "main";
    } else {
      model.addAttribute("errorMsg_Style", dpNone);
      // 아이디 유효성 검사
      if (!isValidId(ID)) {
        model.addAttribute("idMsg_Style", dpBlock);
        return "main";
      }
      // 비밀번호 유효성 검사
      if (!isValidPassword(PW)) {
        model.addAttribute("pwMsg_Style", dpBlock);
        return "main";
      }
      model.addAttribute("idMsg_Style", dpNone);
      model.addAttribute("pwMsg_Style", dpNone);
      Users user = userRep.findById(ID).orElse(null);
      if (user != null) {
        model.addAttribute("errorMsg_Style", dpBlock);
        model.addAttribute("errorMsg", "이미 존재하는 아이디입니다.");
        return "main";
      }
      // 암호화
      SHA256 hash = new SHA256();
      try {
        PW = hash.encrypt(PW + ID.substring(0, 3));
      } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
      }
      Users new_user = new Users(ID, PW, UUID.randomUUID().toString());
      userRep.save(new_user);
      QuestAccountDaily newQuest = new QuestAccountDaily(new_user.getUUID());
      qadRep.save(newQuest);
      model.addAttribute("errorMsg_Style", dpBlock);
      model.addAttribute("errorMsg", "회원가입 완료.");
      return "main";
    }
  }

  // !아이디 유효성 검사
  private boolean isValidId(String ID) {
    // 아이디: 5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.
    return ID.matches("[a-zA-Z0-9_-]{5,20}");
  }

  // !비밀번호 유효성 검사
  private boolean isValidPassword(String PW) {
    // 비밀번호: 8~16자의 영문 대/소문자, 숫자, 특수문자를 사용해 주세요.
    return PW.matches("[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\",.<>?]{8,16}");
  }

  // !빈칸 확인
  public static int checkEmpty(String ID, String PW) {
    if (ID == null || ID.equals("")) {
      return 0;
    } else if (PW == null || PW.equals("")) {
      return 1;
    }
    return 2;
  }
}