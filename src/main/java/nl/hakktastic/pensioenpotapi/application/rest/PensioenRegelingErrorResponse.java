package nl.hakktastic.pensioenpotapi.application.rest;

record PensioenRegelingErrorResponse(int httpStatus, String httpMethod, String clientIp, String uri, String message) {
}