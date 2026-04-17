# `:api:`

## Purpose

The `:api` module is the Spring Boot web layer for the SASD Detection Tool API.
It exposes RESTful endpoints, handles request validation, maps domain results to HTTP responses, and manages exception handling.
Spring Boot is strictly contained within this module and does not leak into any other layer.

## Dependency Rules

The module depends on `:domain` only.
It has no knowledge of `:data` or `:app`.

## Dependency Graph

_To be completed once all layers are implemented_

```mermaid
```