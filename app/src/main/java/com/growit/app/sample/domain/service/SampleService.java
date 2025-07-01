package com.growit.app.sample.domain.service;

import com.growit.app.sample.domain.command.CreateSampleCommand;
import org.springframework.stereotype.Service;

@Service
public class SampleService implements SampleValidator {
  @Override
  public void checkSample(CreateSampleCommand command) {
    if (command.name() == null) {
      throw new IllegalArgumentException("name is required");
    }
  }
}
