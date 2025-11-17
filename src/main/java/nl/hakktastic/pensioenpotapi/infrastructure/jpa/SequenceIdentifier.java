package nl.hakktastic.pensioenpotapi.infrastructure.jpa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "pensioenpot_sequence_identifier")
class SequenceIdentifier {

    @Id
    @SequenceGenerator(name = "pensioenpot_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pensioenpot_sequence")
    private Long id;
}