package maplestory.tdl;

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

@Controller
public class ControllerTodo {
  // !할일
  @Autowired
  private TodoRepository todoRep;

  @GetMapping("/todo")
  public String todo(HttpSession session, Model model) {
    // *세션 확인 */
    if (session.getAttribute("UUID") == null) {
      return "invalid_access_pop";
    }
    String UUID = (String) session.getAttribute("UUID");
    List<TodoCommon> todoList = todoRep.findAllByUUID(UUID);
    System.out.println("TODO 로드 완료\n");
    System.out.println("todoList: " + todoList.size());
    model.addAttribute("todoList", todoList);
    return "todo";
  }

  // ! Todo 내용 업데이트
  @PutMapping("/todo/updateTodoName")
  @ResponseBody
  public ResponseEntity<String> updateTodoName(@RequestBody TodoCommon newState) {
    try {
      System.out.println("----TODO 내용 업데이트 진행----");
      System.out.println("변경내용 -> " + newState.getValue());
      TodoCommon todo = todoRep.findById(newState.getId()).orElse(null);
      System.out.println("id: " + newState.getId());
      if (todo != null) {
        todo.setValue(newState.getValue());
        todoRep.save(todo);
        System.out.println("----TODO 내용 업데이트 완료----\n");
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
  public ResponseEntity<String> dailyWeeklyChange(@RequestBody TodoCommon newDailyWeekly) {
    try {
      System.out.println("----TODO 초기화일 업데이트 진행----");
      TodoCommon todo = todoRep.findById(newDailyWeekly.getId()).orElse(null);
      if (todo != null) {
        todo.setDailyWeekly(newDailyWeekly.getDailyWeekly());
        todoRep.save(todo);
        System.out.println("변경내용 -> " + newDailyWeekly.getStatus());
        System.out.println("----TODO 초기화일 업데이트 완료----\n");
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
  public ResponseEntity<String> updateTodoStatus(@RequestBody TodoCommon newState) {
    try {
      System.out.println("----TODO 체크박스 업데이트 진행----");
      TodoCommon todo = todoRep.findById(newState.getId()).orElse(null);
      if (todo != null) {
        todo.setStatus(newState.getStatus());
        todoRep.save(todo);
        System.out.println("변경내용 -> " + newState.getStatus());
        System.out.println("----TODO 체크박스 업데이트 완료----\n");
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
  public ResponseEntity<String> deleteTodo(@RequestBody TodoCommon onlyId, HttpServletRequest request) {
    try {
      System.out.println("----TODO 삭제 진행----");
      HttpSession session = request.getSession();
      // Retrieve the UUID from the session
      String uuid = (String) session.getAttribute("UUID");
      System.out.println("uuid: " + uuid);
      TodoCommon todo = todoRep.findById(onlyId.getId()).orElse(null);
      if (todo != null && uuid != null && uuid.equals(todo.getUUID())) {
        todoRep.deleteById(onlyId.getId());
        System.out.println("id: " + onlyId.getId());
        System.out.println("----TODO 삭제 완료----\n");
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
      System.out.println("----TODO 생성 진행----\n");
      TodoCommon newTodo = new TodoCommon();
      HttpSession session = request.getSession();
      // Retrieve the UUID from the session
      String uuid = (String) session.getAttribute("UUID");
      // Set the UUID in the newTodo object
      newTodo.setUUID(uuid);
      newTodo.setValue("");
      // Perform the database insertion
      todoRep.save(newTodo);
      System.out.println("----TODO 생성 완료----\n");
      return ResponseEntity.ok("Todo 생성 성공");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("오류 : Todo 생성 실패 - " + e.getMessage());
    }
  }
}
