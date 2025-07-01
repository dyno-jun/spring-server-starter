package com.growit.app.sample.usecase;

import com.growit.app.sample.domain.Sample;
import com.growit.app.sample.domain.SampleRepository;
import com.growit.app.sample.domain.command.CreateSampleCommand;
import com.growit.app.sample.domain.service.SampleValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSampleUseCase {
  private final SampleValidator validator;
  private final SampleRepository sampleRepository;

  public String execute(CreateSampleCommand command) {
    validator.checkSample(command);
    Sample sample = Sample.from(command);
    sampleRepository.saveSample(sample);

    return sample.getId();
  }
}
