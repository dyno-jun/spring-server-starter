package com.growit.app.sample.infrastructure.persistence.sample.source.entity;

import com.growit.app.common.entity.BaseEntity;
import com.growit.app.sample.domain.Sample;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.*;

@Entity
@Table(name = "samples")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SampleEntity extends BaseEntity {
  @Column(nullable = false, unique = true)
  private String uid;

  @Column(nullable = false, length = 128)
  private String userId;

  @Column(nullable = false, length = 128)
  private String name;

  @Column(nullable = false, length = 128)
  private String email;

  @Column(nullable = false)
  private LocalDate date;

  public void updateToByDomain(Sample sample) {
    this.name = sample.getName();
    this.date = sample.getDate();
    this.email = sample.getEmail().value();
  }
}
