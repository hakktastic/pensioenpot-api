package nl.hakktastic.pensioenpotapi.infrastructure.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import nl.hakktastic.pensioenpotapi.domain.aggregate.Deelnemer;
import nl.hakktastic.pensioenpotapi.domain.aggregate.Dienstverband;
import nl.hakktastic.pensioenpotapi.domain.aggregate.PensioenRegeling;
import nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject.*;
import org.hibernate.annotations.NaturalId;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "pensioen_regeling")
public class PensioenRegelingJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pensioenpot_sequence")
    private Long id;

    @NaturalId
    private UUID pensioenRegelingReference;

    private BigDecimal franchise;
    private BigDecimal beschikbarePremiePercentage;
    private String beleggingsrekeningReferences;

    @MapsId
    @OneToOne
    @JoinColumn(name = "id") // PK of this table is also FK to deelnemer.id
    private DeelnemerJpaEntity deelnemer;

    private static Deelnemer getDeelnemer(DeelnemerJpaEntity deelnemerJpaEntity, DienstverbandJpaEntity dienstverbandJpaEntity) {
        return Deelnemer.of(
                DeelnemerReference.of(deelnemerJpaEntity.getDeelnemerReference()),
                Naam.of(deelnemerJpaEntity.getNaam()),
                Email.of(deelnemerJpaEntity.getEmail()),
                Geboortedatum.of(deelnemerJpaEntity.getGeboortedatum()),
                getDienstverband(dienstverbandJpaEntity)
        );
    }

    private static Dienstverband getDienstverband(DienstverbandJpaEntity dienstverbandJpaEntity) {
        return Dienstverband.of(
                DienstverbandReference.of(dienstverbandJpaEntity.getDienstverbandReference()),
                Salaris.of(dienstverbandJpaEntity.getSalaris()),
                PartTimePercentage.of(dienstverbandJpaEntity.getPartTimePercentage())
        );
    }

    public PensioenRegeling toPensioenRegeling() {

        final var deelnemerJpaEntity = getDeelnemer();
        final var dienstverbandJpaEntity = deelnemerJpaEntity.getDienstverband();

        return PensioenRegeling.of(
                PensioenRegelingReference.of(pensioenRegelingReference),
                getDeelnemer(deelnemerJpaEntity, dienstverbandJpaEntity),
                Franchise.of(franchise),
                BeschikbarePremiePercentage.of(beschikbarePremiePercentage),
                BeleggingsrekeningReference.of(beleggingsrekeningReferences)
        );
    }
}