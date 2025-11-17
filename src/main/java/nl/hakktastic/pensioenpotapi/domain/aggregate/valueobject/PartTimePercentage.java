package nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

@Slf4j
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PartTimePercentage {

    private final BigDecimal value;

    public static PartTimePercentage of(BigDecimal value) {
        log.debug("provided value='{}'", value);
        return new PartTimePercentage(value);
    }
}