package dev.amit.userservicetestfinal.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonDeserialize(as = Role.class)
public class Role extends BaseModel {

    private String role;
}
