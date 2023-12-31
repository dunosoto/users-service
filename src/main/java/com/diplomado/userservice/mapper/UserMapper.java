package com.diplomado.userservice.mapper;

import com.diplomado.userservice.api.dto.role.RoleDto;
import com.diplomado.userservice.api.dto.user.UserDetailDto;
import com.diplomado.userservice.api.dto.user.UserDto;
import com.diplomado.userservice.api.request.user.CreateUserRequest;
import com.diplomado.userservice.api.request.user.UpdateUserRequest;
import com.diplomado.userservice.domain.User;
import com.diplomado.userservice.domain.UserDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

  User createUserRequestToUser(CreateUserRequest request);
  
  @Mapping(target = "userDetail", expression = "java(detail)")
  User updateUserRequestToUser(UpdateUserRequest request, UserDetail detail);

  @Mapping(target = "id", source = "user.id")
  @Mapping(target = "userDetail", expression = "java(userDetailDto)")
  @Mapping(target = "roles", expression = "java(roleDtoList)")
  UserDto fromUserToUserDto(User user, UserDetailDto userDetailDto, List<RoleDto> roleDtoList);

  @Mapping(target = "userDetail", ignore = true)
  UserDto fromUserToUserDtoWithOutDetails(User user);
  
  @Mapping(target = "id", source = "user.id")
  UserDto userToUserDto(User user);
  
  
  
}
