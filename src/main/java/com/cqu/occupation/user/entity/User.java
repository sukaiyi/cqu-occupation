package com.cqu.occupation.user.entity;

import com.cqu.occupation.common.entity.SuperEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author sukaiyi
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User extends SuperEntity {
    @Id
    Integer id;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    @Column(name = "type")
    int type;
}
