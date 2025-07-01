package com.growit.app.retrospect.controller;

import com.growit.app.common.dto.ApiResponse;
import com.growit.app.common.dto.IdDto;
import com.growit.app.retrospect.controller.dto.request.CreateRetrospectRequest;
import com.growit.app.retrospect.controller.mapper.RetrospectMapper;
import com.growit.app.retrospect.domain.command.CreateRetrospectCommand;
import com.growit.app.retrospect.usecase.CreateRetrospectUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/retrospects")
@RequiredArgsConstructor
public class RetrospectController {
  private final CreateRetrospectUseCase createRetrospectUseCase;
  private final RetrospectMapper mapper;

  @PostMapping
  public ResponseEntity<ApiResponse<IdDto>> createRetrospect(
      @Valid @RequestBody CreateRetrospectRequest request) {
    CreateRetrospectCommand command = mapper.toCommand("userId", request);
    String id = createRetrospectUseCase.execute(command);

    return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(new IdDto(id)));
  }
}