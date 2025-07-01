package com.growit.app.sample.infrastructure.persistence.sample;

import com.growit.app.sample.domain.Sample;
import com.growit.app.sample.domain.SampleRepository;
import com.growit.app.sample.infrastructure.persistence.sample.source.DBSampleRepository;
import com.growit.app.sample.infrastructure.persistence.sample.source.entity.SampleEntity;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class SampleRepositoryImpl implements SampleRepository {
  private final SampleDbMapper mapper;
  private final DBSampleRepository repository;

  @Override
  public List<Sample> findAll() {
    return repository.findAll().stream().map(mapper::toDomain).toList();
  }

  @Override
  public Optional<Sample> findById(String id) {
    return repository.findByUid(id).map(mapper::toDomain);
  }

  @Override
  public void saveSample(Sample sample) {
    Optional<SampleEntity> existing = repository.findByUid(sample.getId());
    if (existing.isPresent()) {
      SampleEntity exist = existing.get();
      exist.updateToByDomain(sample);
      repository.save(exist);
    } else {
      SampleEntity entity = mapper.toEntity(sample);
      repository.save(entity);
    }
  }
}
