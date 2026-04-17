# `:app`

## Purpose
The `:app` module is the entrypoint for the SASD Detection Tool API.
It bootstraps the Spring Boot application and wires together all dependencies via `@Configuration` classes.
It is the only module that produces an executable JAR.

## Dependency Rules

This module depends on all other modules &mdash; `:domain`, `:data`, `:api`.
It is the only module permitted to do so.

## Dependency Graph

_To be completed once all layers are implemented_

```mermaid
```