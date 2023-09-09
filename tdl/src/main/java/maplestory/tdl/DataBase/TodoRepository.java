package maplestory.tdl.DataBase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoList, Long> {
  List<TodoList> findAllById(Long id);

  List<TodoList> findAllByUUID(String UUID);
}
