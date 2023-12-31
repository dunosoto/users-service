package com.diplomado.userservice.usecase.userrole;


import com.diplomado.userservice.api.request.userrole.UpdateActiveRequest;
import com.diplomado.userservice.api.response.userrole.UserRoleResponse;
import com.diplomado.userservice.common.Message;
import com.diplomado.userservice.domain.UserRole;
import com.diplomado.userservice.exception.NotFoundUserRoleException;
import com.diplomado.userservice.service.IUserRoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateUserRoleActiveUseCase {

  @Autowired
  private IUserRoleService userRoleService;
  
  private Message message;
  
  public UserRoleResponse execute(UpdateActiveRequest request, Long userRoleId) {
    UserRole userRole = validateUserRole(userRoleId);

    userRole.setActive(request.isActive());
    
    userRoleService.save(userRole);
    
    
    return new UserRoleResponse();
    
  }
  
  private UserRole validateUserRole(Long userRoleId) {
    Optional<UserRole> optionalUserRole = userRoleService.findById(userRoleId);
  
    if (optionalUserRole.isEmpty()) {
      throw new NotFoundUserRoleException(message.getMessage("User.role.not.found"));
    }
  
    return optionalUserRole.get();
  }

}
