package com.growit.app.sample.infrastructure.persistence.sample;

import com.growit.app.sample.domain.Sample;
import com.growit.app.sample.infrastructure.persistence.sample.source.entity.SampleEntity;
import com.growit.app.user.domain.user.vo.Email;
import org.springframework.stereotype.Component;

@Component
public class SampleDbMapper {
  public SampleEntity toEntity(Sample sample) {
    if (sample == null) return null;
    return SampleEntity.builder()
        .uid(sample.getId())
        .userId(sample.getUserId())
        .name(sample.getName())
        .date(sample.getDate())
        .build();
  }

  public Sample toDomain(SampleEntity entity) {
    return Sample.from(
        entity.getUid(),
        entity.getUserId(),
        entity.getName(),
        entity.getDate(),
        new Email(entity.getEmail()));
  }
}
