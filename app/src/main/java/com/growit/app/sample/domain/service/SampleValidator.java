package com.growit.app.sample.domain.service;

import com.growit.app.sample.domain.command.CreateSampleCommand;

public interface SampleValidator {
  void checkSample(CreateSampleCommand command);
}
