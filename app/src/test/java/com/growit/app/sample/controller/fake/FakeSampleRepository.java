package com.growit.app.sample.controller.fake;

import com.growit.app.sample.domain.Sample;
import com.growit.app.sample.domain.SampleRepository;
import java.util.List;
import java.util.Optional;

public class FakeSampleRepository implements SampleRepository {
  @Override
  public List<Sample> findAll() {
    return List.of();
  }

  @Override
  public Optional<Sample> findById(String id) {
    return Optional.empty();
  }

  @Override
  public void saveSample(Sample sample) {}
}
