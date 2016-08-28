package com.practo.jedi.carpool.model;

import com.practo.jedi.carpool.data.entity.User;
import com.practo.jedi.carpool.exceptions.EntityNotFoundException;

/**
 * Model for the user entity.
 * @author prashant
 *
 */
public class UserModel implements java.io.Serializable {

  private static final long serialVersionUID = 3483837657919043932L;
  private Integer id;
  private String name;
  private String email;
  private String phone;

  public UserModel() {}



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

  /**
   * Get entity from model.
   * @return Entity
   */
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

  /**
   * Get model from entity.
   * @param entity Entity to get model from.
   * @throws EntityNotFoundException If entity does not exist.
   */
  public void fromEntity(User entity) throws EntityNotFoundException {
    if (entity != null && entity.getIsDeleted() != true) {
      this.setId(entity.getId());
      this.setName(entity.getName());
      this.setEmail(entity.getEmail());
      this.setPhone(entity.getPhone());
    } else {
      throw new EntityNotFoundException("No user found with given Id");
    }
  }


}
