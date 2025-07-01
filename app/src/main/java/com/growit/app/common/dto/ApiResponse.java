package com.growit.app.common.dto;

public record ApiResponse<T>(T data) {
  public static <T> ApiResponse<T> success(T data) {
    return new ApiResponse<>(data);
  }

  public static <T> ApiResponse<T> fail(T data) {
    return new ApiResponse<>(null);
  }
}
