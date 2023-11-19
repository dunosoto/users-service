package com.diplomado.userservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "user_details")
public class UserDetail {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(length = 100, nullable = false)
  private String firstName;
  
  @Column(length = 100, nullable = false)
  private String lastName;
  
  private Integer age;
  
  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date birthDay;
  
  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;
  
  
  
  
  
}
