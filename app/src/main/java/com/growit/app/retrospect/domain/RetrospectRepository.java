package com.growit.app.retrospect.domain;

import java.util.List;
import java.util.Optional;

public interface RetrospectRepository {
  List<Retrospect> findAll();

  Optional<Retrospect> findById(String id);

  void saveRetrospect(Retrospect retrospect);
}