package com.benalibenabdesselam.eticketbackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String email;
    private String num_telephone;
    private String Nom_societe;
    private String ImageUrl;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Ticket> tickets;
    @OneToOne
    private User user;

}
