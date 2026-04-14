# `:data:`

## Purpose
The `:data:` module provides concrete implementations of the repository and gateway interfaces defined in `:domain:`.
It handles all external communication — fetching VCS data from the GitHub API via Ktor and performing NLP analysis via the Google Gemini API.
DTOs are deserialized using kotlinx.serialization and mapped to domain entities through dedicated mapper functions.

## Package Structure
```text
com.sasd.data/
    client/
        analysis/
            dto/
                CweMappingDto.kt
                NlpAnalysisDto.kt
                SasdAnalysisDto.kt
            impl/
                google/
                    GeminiApiService.kt
            NlpApiService.kt
            NlpArtifactType.kt
            NlpSystemPrompt.kt
        vcs/
            dto/
                CommitDto.kt
                FileContentDto.kt
                IssueDto.kt
                IssueLabelDto.kt
                RepositoryItemDto.kt
            impl/
                github/
                    GitHubApiService.kt
            VcsApiService.kt
    gateway/
        NlpGatewayImpl.kt
    mapper/
        analysis/
            NlpAnalysisDtoMapper.kt
        vcs/
            CommitDtoMapper.kt
            FileContentDtoMapper.kt
            IssueDtoMapper.kt
            RepositoryItemDtoMapper.kt
    repository/
        VcsRepositoryImpl.kt
```

## Dependency Graph
_WIP_
