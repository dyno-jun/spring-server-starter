package com.growit.app.sample.domain;

import java.util.List;
import java.util.Optional;

public interface SampleRepository {
  List<Sample> findAll();

  Optional<Sample> findById(String id);

  void saveSample(Sample sample);
}
