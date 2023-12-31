package com.diplomado.userservice.service;

import com.diplomado.userservice.domain.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
  
  User save(User user);
  List<User> getAll();
  Optional<User> findById(Long id);
  User update(User user);
  void delete(User user);
  User updateUserNameByUserId(String newUserName, Long userId);
}
