package nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@Getter
@ToString
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PensioenRegelingReference {

    private final UUID value;

    public static PensioenRegelingReference of(final UUID value) {
        log.debug("provided value='{}'", value);
        return new PensioenRegelingReference(value);
    }
}