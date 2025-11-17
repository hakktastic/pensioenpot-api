package nl.hakktastic.pensioenpotapi.domain.aggregate.valueobject;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
@Getter
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class DienstverbandReference {

    private final UUID value;

    public static DienstverbandReference of(final UUID value) {
        log.debug("provided value='{}'", value);
        return new DienstverbandReference(value);
    }
}