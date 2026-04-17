# `:domain:`

## Purpose
The `:domain:` module contains the core business logic for the SASD detection tool. 
It defines entities, use cases, and gateway/repository interfaces that are independent of any framework or external dependency. 
Implementations are provided by the `:data:` layer.

## Dependency Rules

This module has zero external dependencies &mdash; it depends only on the Kotlin standard library.
No frameworks, no third-party libraries.
This is enforced at compile time by Gradle.

## Dependency Graph

```mermaid
graph TD
    subgraph com.sasd.domain
        common[common]
        entity_analysis[entity.analysis]
        entity_vcs[entity.vcs]
        gateway[gateway]
        repository[repository]
        usecase_analysis[usecase.analysis]
        usecase_vcs[usecase.vcs]
    end

    usecase_analysis --> common
    usecase_analysis --> entity_analysis
    usecase_analysis --> entity_vcs
    usecase_analysis --> gateway
    usecase_analysis --> repository

    usecase_vcs --> common
    usecase_vcs --> entity_vcs
    usecase_vcs --> repository

    gateway --> entity_analysis
    gateway --> entity_vcs

    repository --> entity_vcs
```
