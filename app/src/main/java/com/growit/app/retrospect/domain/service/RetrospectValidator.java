package com.growit.app.retrospect.domain.service;

import com.growit.app.retrospect.domain.command.CreateRetrospectCommand;

public interface RetrospectValidator {
  void checkRetrospect(CreateRetrospectCommand command);
}