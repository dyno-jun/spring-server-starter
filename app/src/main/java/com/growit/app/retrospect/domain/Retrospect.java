package com.growit.app.retrospect.domain;

import com.growit.app.common.util.IDGenerator;
import com.growit.app.retrospect.domain.command.CreateRetrospectCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Retrospect {
  private String id;
  private String userId;
  private String goalId;
  private String planId;
  private String content;

  public static Retrospect from(CreateRetrospectCommand command) {
    return Retrospect.builder()
        .id(IDGenerator.generateId())
        .userId(command.userId())
        .goalId(command.goalId())
        .planId(command.planId())
        .content(command.content())
        .build();
  }

  public static Retrospect from(
      String id, String userId, String goalId, String planId, String content) {
    return Retrospect.builder()
        .id(id)
        .userId(userId)
        .goalId(goalId)
        .planId(planId)
        .content(content)
        .build();
  }
}