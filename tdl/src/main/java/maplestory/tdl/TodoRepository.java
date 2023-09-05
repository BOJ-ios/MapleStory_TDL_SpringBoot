package maplestory.tdl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoCommon, Long> {
  List<TodoCommon> findAllById(Long id);

  List<TodoCommon> findAllByUUID(String UUID);
}
