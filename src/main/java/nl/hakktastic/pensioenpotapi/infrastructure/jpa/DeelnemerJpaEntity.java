package nl.hakktastic.pensioenpotapi.infrastructure.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "deelnemer")
class DeelnemerJpaEntity {

    @Id
    private Long id;

    @NaturalId
    private UUID deelnemerReference;

    private String naam;
    private String email;
    private LocalDate geboortedatum;

    @OneToOne(mappedBy = "deelnemer", cascade = CascadeType.ALL, orphanRemoval = true)
    private PensioenRegelingJpaEntity pensioenRegeling;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id") // PK of this table is also FK to dienstverband.id
    private DienstverbandJpaEntity dienstverband;
}