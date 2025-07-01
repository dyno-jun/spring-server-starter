package com.growit.app.sample.controller;

import com.growit.app.common.dto.ApiResponse;
import com.growit.app.common.dto.IdDto;
import com.growit.app.sample.controller.dto.request.CreateSampleRequest;
import com.growit.app.sample.controller.mapper.SampleMapper;
import com.growit.app.sample.domain.command.CreateSampleCommand;
import com.growit.app.sample.usecase.CreateSampleUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/samples")
@RequiredArgsConstructor
public class SampleController {
  private final CreateSampleUseCase createSampleUseCase;
  private final SampleMapper mapper;

  @PostMapping
  public ResponseEntity<ApiResponse<IdDto>> createSample(
      @Valid @RequestBody CreateSampleRequest request) {
    CreateSampleCommand command = mapper.toCommand("userId", request);
    String id = createSampleUseCase.execute(command);

    return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success(new IdDto(id)));
  }
}
