package com.growit.app.sample.controller.mapper;

import com.growit.app.sample.controller.dto.request.CreateSampleRequest;
import com.growit.app.sample.domain.command.CreateSampleCommand;
import org.springframework.stereotype.Component;

@Component
public class SampleMapper {

  public CreateSampleCommand toCommand(String userId, CreateSampleRequest request) {
    return new CreateSampleCommand(
        userId, request.getName(), request.getEmial(), request.getDate());
  }
}
