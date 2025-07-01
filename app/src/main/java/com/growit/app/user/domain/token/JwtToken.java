package com.growit.app.user.domain.token;

public class JwtToken implements Token {
  private final String access;
  private final String refresh;

  public JwtToken(String access, String refresh) {
    this.access = access;
    this.refresh = refresh;
  }

  public String getAccess() {
    return access;
  }

  public String getRefresh() {
    return refresh;
  }

  @Override
  public String getToken() {
    return refresh;
  }
}
