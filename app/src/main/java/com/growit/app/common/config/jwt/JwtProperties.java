package com.growit.app.common.config.jwt;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
public class JwtProperties {
  private final int expiredSecond;
  private final int refreshExpiredSecond;
  private final String secretKey;

  public JwtProperties(int expiredSecond, int refreshExpiredSecond, String secretKey) {
    this.expiredSecond = expiredSecond;
    this.refreshExpiredSecond = refreshExpiredSecond;
    this.secretKey = secretKey;
  }

  public int getRefreshExpiredSecond() {
    return refreshExpiredSecond;
  }

  public int getExpiredSecond() {
    return expiredSecond;
  }

  public String getSecretKey() {
    return secretKey;
  }
}
