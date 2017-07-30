package ua.itea.entity;

import lombok.Data;
import ua.itea.entity.enumeratiom.Gender;
import ua.itea.entity.enumeratiom.Role;

import javax.persistence.*;
import java.sql.Date;

@Data

@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "UserEntity.getAll",
                query = "select users from UserEntity users"),
        @NamedQuery(name = "UserEntity.getUserByEmail",
                query = "select user from UserEntity user where user.email = :email")
})
public class UserEntity implements FloraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "additional_information")
    private String additionalInformation;

    @Column(name = "role", nullable = false, columnDefinition = "varchar(10) default 'USER'")
    @Enumerated(EnumType.STRING)
    private Role role;

}
