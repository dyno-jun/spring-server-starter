package com.growit.app.sample.domain;

import com.growit.app.common.util.IDGenerator;
import com.growit.app.sample.domain.command.CreateSampleCommand;
import com.growit.app.user.domain.user.vo.Email;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sample {
  private String id;
  private String userId;
  private String name;
  private LocalDate date;
  private Email email;

  public static Sample from(CreateSampleCommand command) {
    return Sample.builder()
        .id(IDGenerator.generateId())
        .userId(command.userId())
        .name(command.name())
        .date(command.date())
        .email(new Email(command.email()))
        .build();
  }

  public static Sample from(String id, String userId, String name, LocalDate date, Email email) {
    return Sample.builder().id(id).userId(userId).name(name).date(date).email(email).build();
  }
}
