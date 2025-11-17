package nl.hakktastic.pensioenpotapi.infrastructure.jpa;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "dienstverband")
class DienstverbandJpaEntity {

    @Id
    private Long id;

    @NaturalId
    private UUID dienstverbandReference;

    private BigDecimal salaris;
    private BigDecimal partTimePercentage;

    @OneToOne(mappedBy = "dienstverband", cascade = CascadeType.ALL, orphanRemoval = true)
    private DeelnemerJpaEntity deelnemer;
}