package com.growit.app.sample.infrastructure.persistence.sample.source;

import com.growit.app.sample.infrastructure.persistence.sample.source.entity.SampleEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DBSampleRepository extends JpaRepository<SampleEntity, Long> {
  Optional<SampleEntity> findByUid(String uid);
}
