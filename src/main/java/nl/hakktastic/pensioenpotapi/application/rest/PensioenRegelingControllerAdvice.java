package nl.hakktastic.pensioenpotapi.application.rest;

import jakarta.servlet.http.HttpServletRequest;
import nl.hakktastic.pensioenpotapi.infrastructure.PensioenRegelingNotFoundException;
import org.apache.logging.log4j.util.Strings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class PensioenRegelingControllerAdvice {

    @ExceptionHandler(PensioenRegelingNotFoundException.class)
    ResponseEntity<PensioenRegelingErrorResponse> handleException(PensioenRegelingNotFoundException exception, HttpServletRequest request) {

        final var httpStatusCode = HttpStatus.NOT_FOUND.value();
        final var httpMethod = request.getMethod();
        final var clientIp = request.getRemoteAddr();
        final var requestUri = request.getRequestURI();
        final var queryString = request.getQueryString();
        final var message = exception.getMessage();
        final var uri = requestUri + (queryString != null ? "?" + queryString : Strings.EMPTY);

        final var response = new PensioenRegelingErrorResponse(httpStatusCode, httpMethod, clientIp, uri, message);

        return ResponseEntity.status(httpStatusCode).body(response);
    }
}