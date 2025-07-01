package com.growit.app.retrospect.domain.service;

import com.growit.app.retrospect.domain.command.CreateRetrospectCommand;
import org.springframework.stereotype.Service;

@Service
public class RetrospectService implements RetrospectValidator {
  @Override
  public void checkRetrospect(CreateRetrospectCommand command) {
    if (command.userId() == null || command.userId().trim().isEmpty()) {
      throw new IllegalArgumentException("userId is required");
    }
    if (command.goalId() == null || command.goalId().trim().isEmpty()) {
      throw new IllegalArgumentException("goalId is required");
    }
    if (command.planId() == null || command.planId().trim().isEmpty()) {
      throw new IllegalArgumentException("planId is required");
    }
    if (command.content() == null || command.content().trim().isEmpty()) {
      throw new IllegalArgumentException("content is required");
    }
  }
}