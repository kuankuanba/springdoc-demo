package org.springdoc.demo.services.user.controller;

import org.springdoc.demo.services.user.model.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

  private final Map<Long, User> userMap = new HashMap<>();

  public UserController() {
    // 初始化一些示例数据
    userMap.put(1L, new User(1L, "john_doe", "john.doe@example.com"));
    userMap.put(2L, new User(2L, "jane_doe", "jane.doe@example.com"));
  }

  @Operation(
      summary = "获取用户信息",
      description = "根据用户ID获取用户信息",
      responses = {
          @ApiResponse(
              responseCode = "200",
              description = "成功",
              content = @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = User.class)
              )
          ),
          @ApiResponse(
              responseCode = "404",
              description = "未找到用户"
          )
      }
  )
  @GetMapping("/{id}")
  public ResponseEntity<User> getUserById(@PathVariable @Parameter(description = "用户ID") Long id) {
    User user = userMap.get(id);
    if (user != null) {
      return ResponseEntity.ok(user);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/{id}/no-annotations")
  public ResponseEntity<User> getUserByIdNoAnnotations(@PathVariable Long id) {
    User user = userMap.get(id);
    if (user != null) {
      return ResponseEntity.ok(user);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
