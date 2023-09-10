package maplestory.tdl.DataBase;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersCharacterRep extends JpaRepository<UsersCharacter, String> {
  @Query("SELECT u FROM UsersCharacter u WHERE u.UUID = :UUID")
  List<UsersCharacter> findByUuid(@Param("UUID") String UUID);
}
