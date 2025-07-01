package com.growit.app.retrospect.domain.command;

public record CreateRetrospectCommand(
    String userId, String goalId, String planId, String content) {}