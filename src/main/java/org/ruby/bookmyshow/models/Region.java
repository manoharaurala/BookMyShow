package org.ruby.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Region extends BaseModel {
    private String name;
    // private List<Theater> theaters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
