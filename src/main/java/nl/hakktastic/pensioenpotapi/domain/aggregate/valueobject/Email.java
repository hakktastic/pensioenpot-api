package nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Email {

    private final String value;

    public static Email of(String value) {
        log.debug("provided value='{}'", value);
        return new Email(value);
    }
}