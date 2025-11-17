package nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DeelnemerReference {

    private final UUID value;

    public static DeelnemerReference of(UUID value) {
        log.debug("provided value='{}'", value);
        return new DeelnemerReference(value);
    }
}