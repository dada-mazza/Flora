package ua.itea.entity;

import lombok.Data;
import org.joda.time.DateTime;
import ua.itea.entity.enumeratiom.Gender;
import ua.itea.entity.enumeratiom.Role;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "UserEntity.getAll",
                query = "select users from UserEntity users"),
        @NamedQuery(name = "UserEntity.getUserByEmail",
                query = "select user from UserEntity user where user.email = :email")
})

public class UserEntity {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "user_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
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
    private DateTime dateOfBirth;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "additional_information", nullable = false)
    private String additionalInformation;

    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

}
