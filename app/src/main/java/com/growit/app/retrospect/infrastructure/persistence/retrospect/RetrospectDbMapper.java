package com.growit.app.retrospect.infrastructure.persistence.retrospect;

import com.growit.app.retrospect.domain.Retrospect;
import com.growit.app.retrospect.infrastructure.persistence.retrospect.source.entity.RetrospectEntity;
import org.springframework.stereotype.Component;

@Component
public class RetrospectDbMapper {
  public RetrospectEntity toEntity(Retrospect retrospect) {
    if (retrospect == null) return null;
    return RetrospectEntity.builder()
        .uid(retrospect.getId())
        .userId(retrospect.getUserId())
        .goalId(retrospect.getGoalId())
        .planId(retrospect.getPlanId())
        .content(retrospect.getContent())
        .build();
  }

  public Retrospect toDomain(RetrospectEntity entity) {
    return Retrospect.from(
        entity.getUid(),
        entity.getUserId(),
        entity.getGoalId(),
        entity.getPlanId(),
        entity.getContent());
  }
}