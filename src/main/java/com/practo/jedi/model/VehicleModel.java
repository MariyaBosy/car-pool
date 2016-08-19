package com.practo.jedi.model;

import com.practo.jedi.data.entity.Vehicle;

public class VehicleModel implements java.io.Serializable {


  private static final long serialVersionUID = 2642296086463840850L;
  private Integer id;
  private int capacity;
  private String model;
  private String numberPlate;
  private UserModel user;

  public VehicleModel() {}


  public VehicleModel(int capacity, String model, String numberPlate) {
    this.capacity = capacity;
    this.model = model;
    this.numberPlate = numberPlate;
  }


  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public int getCapacity() {
    return this.capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }


  public String getModel() {
    return this.model;
  }

  public void setModel(String model) {
    this.model = model;
  }


  public String getNumberPlate() {
    return this.numberPlate;
  }

  public void setNumberPlate(String numberPlate) {
    this.numberPlate = numberPlate;
  }


  public UserModel getUser() {
    return this.user;
  }

  public void setUser(UserModel user) {
    this.user = user;
  }

  public Vehicle toEntity() {
    Vehicle vehicle = new Vehicle();
    if (this.getId() != null) {
      vehicle.setId(this.getId());
    }
    vehicle.setCapacity(this.getCapacity());
    vehicle.setModel(this.getModel());
    vehicle.setNumberPlate(this.getNumberPlate());
    if (this.getUser() != null) {
      vehicle.setUser(this.getUser().toEntity());
    }
    return vehicle;
  }

  public void fromEntity(Vehicle entity) {
    if (entity != null) {
      this.setId(entity.getId());
      this.setCapacity(entity.getCapacity());
      this.setModel(entity.getModel());
      this.setNumberPlate(entity.getNumberPlate());
      UserModel user = new UserModel();
      user.fromEntity(entity.getUser());
      this.setUser(user);
    }
  }

}


