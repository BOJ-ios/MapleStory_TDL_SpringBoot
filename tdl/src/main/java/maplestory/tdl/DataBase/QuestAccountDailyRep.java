package maplestory.tdl.DataBase;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestAccountDailyRep extends JpaRepository<QuestAccountDaily, String> {
  Optional<QuestAccountDaily> findByUUID(String UUID);
}
