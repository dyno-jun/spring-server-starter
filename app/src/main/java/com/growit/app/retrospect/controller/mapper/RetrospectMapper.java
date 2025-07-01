package com.growit.app.retrospect.controller.mapper;

import com.growit.app.retrospect.controller.dto.request.CreateRetrospectRequest;
import com.growit.app.retrospect.domain.command.CreateRetrospectCommand;
import org.springframework.stereotype.Component;

@Component
public class RetrospectMapper {

  public CreateRetrospectCommand toCommand(String userId, CreateRetrospectRequest request) {
    return new CreateRetrospectCommand(
        userId, request.getGoalId(), request.getPlanId(), request.getContent());
  }
}