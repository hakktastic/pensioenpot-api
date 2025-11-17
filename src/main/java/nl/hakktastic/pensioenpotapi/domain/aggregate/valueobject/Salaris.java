package nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Salaris {

    private final BigDecimal value;

    public static Salaris of(BigDecimal value) {
        log.debug("provided value='{}'", value);
        return new Salaris(value);
    }
}