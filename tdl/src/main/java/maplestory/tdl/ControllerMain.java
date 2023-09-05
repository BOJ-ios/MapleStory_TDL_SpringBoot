package maplestory.tdl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControllerMain {
  // !처음 접속 페이지
  @GetMapping("/")
  public String main_Page(Model model) {
    return "main";
  }

  // !로그인
  @Autowired
  private UsersRepository userRep;

  @PostMapping("/login")
  public String login_validation(HttpSession session, Model model, String id, String pw) {
    Users user = userRep.findById(id).orElse(null);
    // *유저 존재 */
    if (user != null) {
      // *비밀번호 정답 */
      if (user.getPW().equals(pw)) {
        session.setAttribute("UUID", user.getUUID());
        System.out.println("-------로그인정보-------");
        System.out.println("id : " + user.getID());
        System.out.println("pw : " + user.getPW());
        System.out.println("uuid : " + user.getUUID());
        System.out.println("---------------------\n");
        return "redirect:/todo";
      }
      // *비밀번호 오류 */
      System.out.println("-------비밀번호 오류-------");
      System.out.println("id : " + user.getID());
      System.out.println("입력한 pw : " + pw);
      System.out.println("정확한 pw : " + user.getPW());
      System.out.println("---------------------\n");
      model.addAttribute("id", id);
      model.addAttribute("loginFailReason", "비밀번호가 틀렸습니다.");
      return "main";
    }
    // *유저 없음 */
    System.out.println("-------존재하지 않는 유저-------");
    System.out.println("id : " + id);
    System.out.println("---------------------\n");
    model.addAttribute("id", id);
    model.addAttribute("loginFailReason", "존재하지않는 아이디입니다.");
    return "main";
  }

  // !회원가입
  @PostMapping("/register")
  public String register_validation(HttpSession session, Model model, String id, String pw) {
    Users user = userRep.findById(id).orElse(null);
    // *유저 존재 */
    System.out.println("-------회원가입 시도-------");
    if (user != null) {
      System.out.println("-------이미 존재하는 유저-------");
      System.out.println("id : " + id);
      System.out.println("---------------------\n");
      model.addAttribute("loginFailReason", "이미 존재하는 아이디입니다");
      return "main";
    }
    // *유저 없음 */
    model.addAttribute("loginFailReason", "회원가입 완료.");
    Users new_user = new Users(id, pw, UUID.randomUUID().toString());
    System.out.println("-------회원가입 완료-------");
    System.out.println("id : " + new_user.getID());
    System.out.println("pw : " + new_user.getPW());
    System.out.println("uuid : " + new_user.getUUID());
    System.out.println("---------------------\n");
    userRep.save(new_user);
    return "main";
  }
}
