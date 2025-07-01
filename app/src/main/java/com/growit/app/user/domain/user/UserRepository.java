package com.growit.app.user.domain.user;

public interface UserRepository {
  User findUserById(String id);
}
