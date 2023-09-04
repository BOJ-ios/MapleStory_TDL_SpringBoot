package maplestory.tdl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
  List<Todo> findAllById(Long id);

  List<Todo> findAllByUUID(String UUID);
}
