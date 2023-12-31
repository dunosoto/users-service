package com.diplomado.userservice.service;

import com.diplomado.userservice.domain.Role;
import java.util.List;
import java.util.Optional;

public interface IRoleService {
  
  Role save(Role role);
  List<Role> getAll();
  Optional<Role> findById(Long id);
  Role update(Role role);
  void deleteById(Long id);
}
