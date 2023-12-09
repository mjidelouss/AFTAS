package com.example.aftas.entities;

import com.example.aftas.enums.IdentityDocumentType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Name must not be Null")
    @Size(min = 3, max = 40, message = "Name must be between 3 and 40 Characters")
    private String name;
    @NotNull(message = "FamilyName must not be Null")
    @Size(min = 3, max = 40, message = "FamilyName must be between 3 and 40 Characters")
    private String familyName;
    @NotNull(message = "Access Date must not be Null")
    @PastOrPresent(message = "Access Date must be in the past or the present")
    @Temporal(TemporalType.DATE)
    private Date accessDate;
    @NotNull(message = "Nationality must not be Null")
    private String nationality;
    @Enumerated(EnumType.STRING)
    private IdentityDocumentType identityDocumentType;
    @NotNull(message = "Identity Number must not be Null")
    @Column(unique = true)
    @Size(min = 3, max =40, message = "Identity Number must be Between 3 and 4O Characters")
    private String identityNumber;
    @OneToMany(mappedBy = "member")
    private List<Ranking> rankings;
    @OneToMany(mappedBy = "member")
    private List<Hunting> huntings;

}
