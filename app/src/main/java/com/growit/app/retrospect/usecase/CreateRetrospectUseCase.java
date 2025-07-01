package com.growit.app.retrospect.usecase;

import com.growit.app.retrospect.domain.Retrospect;
import com.growit.app.retrospect.domain.RetrospectRepository;
import com.growit.app.retrospect.domain.command.CreateRetrospectCommand;
import com.growit.app.retrospect.domain.service.RetrospectValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateRetrospectUseCase {
  private final RetrospectValidator validator;
  private final RetrospectRepository retrospectRepository;

  public String execute(CreateRetrospectCommand command) {
    validator.checkRetrospect(command);
    Retrospect retrospect = Retrospect.from(command);
    retrospectRepository.saveRetrospect(retrospect);

    return retrospect.getId();
  }
}