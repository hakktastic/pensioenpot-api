package nl.hakktastic.pensioenpotapi.application.rest;

import java.math.BigDecimal;
import java.util.UUID;

record VerwachtePensioenWaardeResponse(UUID pensioenRegelingReference, BigDecimal verwachtePensioenWaarde) {
}