package maplestory.tdl.Scheduled;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class QuestClear {
  // 매일 월요일 00시에 실행
  @Scheduled(cron = "0 0 * * MON")
  public void runOnMondayMidnight() {
    // 여기에 월요일에 실행하고자 하는 작업을 추가합니다.
    System.out.println("월요일 00시에 실행되는 작업");
  }

  // 매일 목요일 00시에 실행
  @Scheduled(cron = "0 0 * * THU")
  public void runOnThursdayMidnight() {
    // 여기에 목요일에 실행하고자 하는 작업을 추가합니다.
    System.out.println("목요일 00시에 실행되는 작업");
  }
}
