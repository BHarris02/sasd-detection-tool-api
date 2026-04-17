# `:data:`

## Purpose
The `:data:` module provides concrete implementations of the repository and gateway interfaces defined in `:domain:`.
It handles all external communication — fetching VCS data from the GitHub API via Ktor and performing NLP analysis via an LLM provider API.
DTOs are deserialized using kotlinx.serialization and mapped to domain entities through dedicated mapper functions.

## Dependency Rules

This module depends only on `:data`. No other modules are accessible.

## Dependency Graph

```mermaid
graph TD
    subgraph com.sasd.data
        client_analysis[client.analysis]
        client_analysis_dto[client.analysis.dto]
        client_vcs[client.vcs]
        client_vcs_dto[client.vcs.dto]
        client_vcs_impl_github[client.vcs.impl.github]
        gateway[gateway]
        mapper_analysis[mapper.analysis]
        mapper_vcs[mapper.vcs]
        repository[repository]
    end

    subgraph com.sasd.domain
        domain_common[common]
        domain_entity_analysis[entity.analysis]
        domain_entity_vcs[entity.vcs]
        domain_gateway[gateway]
        domain_repository[repository]
    end

    gateway --> client_analysis
    gateway --> mapper_analysis
    gateway --> domain_common
    gateway --> domain_entity_analysis
    gateway --> domain_entity_vcs
    gateway --> domain_gateway

    repository --> client_vcs
    repository --> mapper_vcs
    repository --> domain_common
    repository --> domain_entity_vcs
    repository --> domain_repository

    client_vcs --> client_vcs_dto
    client_vcs_impl_github --> client_vcs
    client_vcs_impl_github --> client_vcs_dto

    client_analysis --> client_analysis_dto

    mapper_vcs --> client_vcs_dto
    mapper_vcs --> domain_common
    mapper_vcs --> domain_entity_vcs

    mapper_analysis --> client_analysis_dto
    mapper_analysis --> domain_common
    mapper_analysis --> domain_entity_analysis
```
