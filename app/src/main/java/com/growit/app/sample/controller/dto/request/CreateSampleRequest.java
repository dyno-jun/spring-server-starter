package com.growit.app.sample.controller.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateSampleRequest {
  @NotBlank(message = "이름은 필수입니다.")
  @Size(min = 1, max = 30, message = "이름은 30자 이하여야 합니다.")
  private String name;

  @NotNull(message = "이메일은 필수 입니다.")
  @Valid
  private String emial;

  @NotNull(message = "날짜는 필수 입니다.")
  @Valid
  private LocalDate date;
}
