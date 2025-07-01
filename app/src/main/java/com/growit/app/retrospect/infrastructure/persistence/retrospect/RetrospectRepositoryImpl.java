package com.growit.app.retrospect.infrastructure.persistence.retrospect;

import com.growit.app.retrospect.domain.Retrospect;
import com.growit.app.retrospect.domain.RetrospectRepository;
import com.growit.app.retrospect.infrastructure.persistence.retrospect.source.DBRetrospectRepository;
import com.growit.app.retrospect.infrastructure.persistence.retrospect.source.entity.RetrospectEntity;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RetrospectRepositoryImpl implements RetrospectRepository {
  private final RetrospectDbMapper mapper;
  private final DBRetrospectRepository repository;

  @Override
  public List<Retrospect> findAll() {
    return repository.findAll().stream().map(mapper::toDomain).toList();
  }

  @Override
  public Optional<Retrospect> findById(String id) {
    return repository.findByUid(id).map(mapper::toDomain);
  }

  @Override
  public void saveRetrospect(Retrospect retrospect) {
    Optional<RetrospectEntity> existing = repository.findByUid(retrospect.getId());
    if (existing.isPresent()) {
      RetrospectEntity exist = existing.get();
      exist.updateToByDomain(retrospect);
      repository.save(exist);
    } else {
      RetrospectEntity entity = mapper.toEntity(retrospect);
      repository.save(entity);
    }
  }
}