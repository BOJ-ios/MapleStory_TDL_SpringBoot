package maplestory.tdl.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import maplestory.tdl.DataBase.TodoList;
import maplestory.tdl.DataBase.TodoRepository;

@Controller
public class Todo_C {
  // !할일
  @Autowired
  private TodoRepository todoRep;

  @GetMapping("/todo")
  public String todo(HttpSession session, Model model) {
    // *세션 UUID 확인 */
    if (session.getAttribute("UUID") == null) {
      return "invalid_access_pop";
    }
    String UUID = (String) session.getAttribute("UUID");
    List<TodoList> todoList = todoRep.findAllByUUID(UUID);
    model.addAttribute("todoList", todoList);
    return "todo";
  }

  // ! Todo 내용 업데이트
  @PutMapping("/todo/updateTodoName")
  @ResponseBody
  public ResponseEntity<String> updateTodoName(@RequestBody TodoList newState, HttpServletRequest request) {
    try {
      HttpSession session = request.getSession();
      String uuid = (String) session.getAttribute("UUID");

      TodoList selectedTodo = todoRep.findById(newState.getId()).orElse(null);
      if (selectedTodo != null && uuid != null && uuid.equals(selectedTodo.getUUID())) {
        selectedTodo.setValue(newState.getValue());
        todoRep.save(selectedTodo);
        return ResponseEntity.ok("Todo 내용 업데이트 성공.");
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo not found.");
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("오류 : Todo 내용 업데이트 실패 " + e.getMessage());
    }
  }

  // ! Todo 완료 박스 업데이트
  @PutMapping("/todo/dailyWeeklyChange")
  @ResponseBody
  public ResponseEntity<String> dailyWeeklyChange(@RequestBody TodoList newDailyWeekly, HttpServletRequest request) {
    try {
      HttpSession session = request.getSession();
      String uuid = (String) session.getAttribute("UUID");

      TodoList selectedTodo = todoRep.findById(newDailyWeekly.getId()).orElse(null);
      if (selectedTodo != null && uuid != null && uuid.equals(selectedTodo.getUUID())) {
        selectedTodo.setDailyWeekly(newDailyWeekly.getDailyWeekly());
        todoRep.save(selectedTodo);
        return ResponseEntity.ok("Todo 초기화일 업데이트 성공.");
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo not found.");
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("오류 : 초기화일 체크(해제) 실패: " + e.getMessage());
    }
  }

  // ! Todo 완료 박스 업데이트
  @PutMapping("/todo/updateTodoStatus")
  @ResponseBody
  public ResponseEntity<String> updateTodoStatus(@RequestBody TodoList newState, HttpServletRequest request) {
    try {
      HttpSession session = request.getSession();
      String uuid = (String) session.getAttribute("UUID");

      TodoList selectedTodo = todoRep.findById(newState.getId()).orElse(null);
      if (selectedTodo != null && uuid != null && uuid.equals(selectedTodo.getUUID())) {
        selectedTodo.setStatus(newState.getStatus());
        todoRep.save(selectedTodo);
        return ResponseEntity.ok("Todo 체크박스 업데이트 성공.");
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo not found.");
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("오류 : 완료버튼 체크(해제) 실패: " + e.getMessage());
    }
  }

  // ! Todo 삭제
  @DeleteMapping("/todo/deleteTodo")
  public ResponseEntity<String> deleteTodo(@RequestBody TodoList onlyId, HttpServletRequest request) {
    try {
      HttpSession session = request.getSession();
      String uuid = (String) session.getAttribute("UUID");

      TodoList selectedTodo = todoRep.findById(onlyId.getId()).orElse(null);
      if (selectedTodo != null && uuid != null && uuid.equals(selectedTodo.getUUID())) {
        todoRep.deleteById(onlyId.getId());
        return ResponseEntity.ok("Todo 삭제 성공");
      } else {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid UUID or Todo not found.");
      }
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("오류 : Todo 삭제 실패 - " + e.getMessage());
    }
  }

  // ! Todo 생성
  @PostMapping("/todo/addNewTodo")
  public ResponseEntity<String> addNewTodo(HttpServletRequest request) {
    try {
      HttpSession session = request.getSession();
      String uuid = (String) session.getAttribute("UUID");

      TodoList newTodo = new TodoList();
      newTodo.setUUID(uuid);
      newTodo.setValue("");
      todoRep.save(newTodo);
      return ResponseEntity.ok("Todo 생성 성공");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("오류 : Todo 생성 실패 - " + e.getMessage());
    }
  }
}
