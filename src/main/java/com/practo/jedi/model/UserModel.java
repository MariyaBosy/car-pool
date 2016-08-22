package com.practo.jedi.model;

import com.practo.jedi.data.entity.User;
import com.practo.jedi.exceptions.EntityNotFoundException;

public class UserModel implements java.io.Serializable {

  private static final long serialVersionUID = 3483837657919043932L;
  private Integer id;
  private String name;
  private String email;
  private String phone;

  public UserModel() {}


  public UserModel(String name, String email, String phone) {
    this.name = name;
    this.email = email;
    this.phone = phone;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getPhone() {
    return this.phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public User toEntity() {
    User user = new User();
    if (this.getId() != null) {
      user.setId(this.getId());
    }
    user.setName(this.getName());
    user.setEmail(this.getEmail());
    user.setPhone(this.getPhone());
    return user;
  }

  public void fromEntity(User entity) throws EntityNotFoundException {
    if (entity != null && entity.getIsDeleted() != true) {
      this.setId(entity.getId());
      this.setName(entity.getName());
      this.setEmail(entity.getEmail());
      this.setPhone(entity.getPhone());
    } else {throw new EntityNotFoundException("No user found with given Id");}
  }


  @Override
  public String toString() {
    return "UserModel [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
  }

}
