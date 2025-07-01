package com.growit.app.sample.controller.fake;

import com.growit.app.sample.domain.command.CreateSampleCommand;
import com.growit.app.sample.domain.service.SampleValidator;

public class FakeSampleService implements SampleValidator {
  @Override
  public void checkSample(CreateSampleCommand command) {}
}
