package com.hei.project2p1.model;

import com.hei.project2p1.model.utils.SocialCategory;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "\"employee\"")
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity implements Serializable  {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String ref;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    @Lob
    private String profileImage;
    private String sex;

    @OneToMany
    @Column(name = "phone_numbers")
    private List<PhoneEntity> phoneNumbers;

    private String address;
    @Column(name = "work_email")
    private String workMail;

    @Column(name = "personal_email")
    private String personalMail;


    @OneToOne
    private IdentityCardEntity identityCard;

    private String jobFunction;
    private int numberOfChildren;

    private LocalDate hireDate;
    private LocalDate departureDate;

    private SocialCategory socioProfessionalCategory;
    private String cnapsNumber;

}
