package com.growit.app.sample.domain.command;

import java.time.LocalDate;

public record CreateSampleCommand(String userId, String name, String email, LocalDate date) {}
