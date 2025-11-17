package nl.hakktastic.pensioenpotapi.application.rest;

import lombok.RequiredArgsConstructor;
import nl.hakktastic.pensioenpotapi.domain.PensioenRegelingService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/v1/pensions/projections", produces = MediaType.APPLICATION_JSON_VALUE)
class PensioenRegelingController {
    
    private final PensioenRegelingService pensioenRegelingService;

    @GetMapping("/{pensioenregelingReference}")
    ResponseEntity<VerwachtePensioenWaardeResponse> getPensioenRegeling(@PathVariable UUID pensioenregelingReference, @RequestParam int gewenstePensioenLeeftijd) {

        final var verwachteWaarde = pensioenRegelingService.berekenVerwachteWaarde(pensioenregelingReference, gewenstePensioenLeeftijd);
        return ResponseEntity.ok(new VerwachtePensioenWaardeResponse(pensioenregelingReference, verwachteWaarde));
    }
}