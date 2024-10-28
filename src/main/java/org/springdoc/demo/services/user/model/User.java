package org.springdoc.demo.services.user.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "User", description = "用户实体")
public class User {
  @Schema(description = "用户ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
  private Long id;

  @Schema(description = "用户名", example = "john_doe", requiredMode = Schema.RequiredMode.REQUIRED)
  private String username;

  @Schema(description = "电子邮件", example = "john.doe@example.com", requiredMode = Schema.RequiredMode.REQUIRED)
  private String email;

  public User(Long id, String username, String email) {
    this.id = id;
    this.username = username;
    this.email = email;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}