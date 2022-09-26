package com.benalibenabdesselam.eticketbackend.model;


import com.benalibenabdesselam.eticketbackend.enums.TicketGravite;
import com.benalibenabdesselam.eticketbackend.enums.TicketRaison;
import com.benalibenabdesselam.eticketbackend.enums.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(updatable = false, nullable = false)
    private String reference;
    private String demande;

    private Date createdAt;
    private Date updatedAt;

    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @Enumerated(EnumType.STRING)
    private TicketGravite gravite;
    @Enumerated(EnumType.STRING)
    private TicketRaison raison;
    // private String email;
    private String email_second;
    private String pays;
    @ManyToOne
    private Client client;
    //support
    private String SRN;
    // private String num_telephone;

}
