package com.growit.app.retrospect.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateRetrospectRequest {
  @NotBlank(message = "goalId는 필수입니다.")
  @Size(min = 1, max = 100, message = "goalId는 100자 이하여야 합니다.")
  private String goalId;

  @NotBlank(message = "planId는 필수입니다.")
  @Size(min = 1, max = 100, message = "planId는 100자 이하여야 합니다.")
  private String planId;

  @NotBlank(message = "내용은 필수입니다.")
  @Size(min = 1, max = 1000, message = "내용은 1000자 이하여야 합니다.")
  private String content;
}