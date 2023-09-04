package maplestory.tdl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class LinkController {
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
        System.out.println("id " + user.getID());
        System.out.println("pw " + user.getPW());
        System.out.println("uuid " + user.getUUID());
        return "redirect:/todo";
      }
      // *비밀번호 오류 */
      model.addAttribute("id", id);
      model.addAttribute("loginFailReason", "비밀번호가 틀렸습니다.");
      return "main";
    }
    // *유저 없음 */
    model.addAttribute("id", id);
    model.addAttribute("loginFailReason", "존재하지않는 아이디입니다.");
    return "main";
  }

  // !회원가입
  @PostMapping("/register")
  public String register_validation(Model model) {

    return "register";
  }

  // !할일

  @Autowired
  private TodoRepository todoRep;

  @GetMapping("/todo")
  public String todo(HttpSession session, Model model) {
    if (session.getAttribute("UUID") == null) {
      return "invalid_access_pop";
    }
    String UUID = (String) session.getAttribute("UUID");
    List<Todo> todoList = todoRep.findAllByUUID(UUID);
    System.out.println("todoList: " + todoList.size());
    model.addAttribute("todoList", todoList);
    return "todo";
  }

  @PutMapping("/updateTodoName/{id}")
  @ResponseBody
  public ResponseEntity<String> updateTodoName(@PathVariable Long id, @RequestBody UpdateTodoRequest request) {
    try {
      // 데이터베이스에서 해당 Todo를 찾아서 이름을 업데이트
      Todo todo = todoRep.findById(id).orElse(null);
      if (todo != null) {
        todo.setTodoName(request.getNewValue());
        todoRep.save(todo);
        return ResponseEntity.ok("Todo name updated successfully.");
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo not found.");
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error updating todo name: " + e.getMessage());
    }
  }

  // Todo 상태 업데이트 엔드포인트
  @PutMapping("/updateTodoStatus/{id}")
  @ResponseBody
  public ResponseEntity<String> updateTodoStatus(@PathVariable Long id, @RequestBody UpdateTodoRequest request) {
    try {
      // 데이터베이스에서 해당 Todo를 찾아서 상태를 업데이트
      Todo todo = todoRep.findById(id).orElse(null);
      if (todo != null) {
        todo.setDoneCheck(request.getNewStatus());
        todoRep.save(todo);
        return ResponseEntity.ok("Todo status updated successfully.");
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo not found.");
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error updating todo status: " + e.getMessage());
    }
  }

  @DeleteMapping("/deleteTodo/{id}")
  public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
    try {
      todoRep.deleteById(id);
      return ResponseEntity.ok("Todo deleted successfully.");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error deleting todo: " + e.getMessage());
    }
  }

  @PostMapping("/insertTodo")
  public ResponseEntity<String> insertTodo(HttpServletRequest request) {
    try {
      Todo newTodo = new Todo();
      HttpSession session = request.getSession();
      // Retrieve the UUID from the session
      String uuid = (String) session.getAttribute("UUID");
      // Set the UUID in the newTodo object
      System.out.println("uuid " + uuid);
      newTodo.setUUID(uuid);
      newTodo.setTodoName("");
      // Perform the database insertion
      todoRep.save(newTodo);
      return ResponseEntity.ok("Todo inserted successfully.");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error inserting todo: " + e.getMessage());
    }
  }

}
