package nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;

@Slf4j
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Geboortedatum {

    private final LocalDate value;

    public static Geboortedatum of(LocalDate value) {
        log.debug("provided value='{}'", value);
        return new Geboortedatum(value);
    }
}