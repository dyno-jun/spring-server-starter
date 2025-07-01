package com.growit.app.retrospect.infrastructure.persistence.retrospect.source.entity;

import com.growit.app.common.entity.BaseEntity;
import com.growit.app.retrospect.domain.Retrospect;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "retrospects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RetrospectEntity extends BaseEntity {
  @Column(nullable = false, unique = true)
  private String uid;

  @Column(nullable = false, length = 128)
  private String userId;

  @Column(nullable = false, length = 128)
  private String goalId;

  @Column(nullable = false, length = 128)
  private String planId;

  @Column(nullable = false, length = 1000)
  private String content;

  public void updateToByDomain(Retrospect retrospect) {
    this.goalId = retrospect.getGoalId();
    this.planId = retrospect.getPlanId();
    this.content = retrospect.getContent();
  }
}