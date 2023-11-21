package com.diplomado.userservice.api.dto.user;

import com.diplomado.userservice.domain.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class UserDto {
  
  private Long id;
  private String userName;
  private String password;
  private String email;
  private UserDetailDto userDetail;
  private Date createdAt;
//  private List<Role> roles;
}
