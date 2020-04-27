package com.spring.simplenote.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {
    @Id
    private String id;
    private String name;
    private String userpic;
    private String email;
    private String gender;
    private String locale;

}
