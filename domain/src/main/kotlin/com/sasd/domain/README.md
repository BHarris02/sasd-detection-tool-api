# `:domain:`

## Purpose
The `:domain:` module contains the core business logic for the SASD detection tool. 
It defines entities, use cases, and gateway/repository interfaces that are independent of any framework or external dependency. 
Implementations are provided by the `:data:` layer.

## Package Structure
```text
com.sasd.domain/
    common/
        DomainError.kt
        DomainResult.kt
    entity/
        analysis/
            CweMapping.kt
            NlpAnalysis.kt
            SasdAnalysis.kt
            SasdAnalysisSeverity.kt
        vcs/
            CodeSnippet.kt
            Commit.kt
            FileContent.kt
            Issue.kt
            IssueLabel.kt
            RepositoryItem.kt
            RepositoryItemType.kt
    gateway/
        NlpGateway.kt
    repository/
        VcsRepository.kt
    usecase/
        analysis/
            AnalyzeCodeCommentsUseCase.kt
            AnalyzeCommitsUseCase.kt
            AnalyzeFileCommentsUseCase.kt
            AnalyzeIssuesUseCase.kt
            AnalyzeRepositoryUseCase.kt
        vcs/
            GetFileContentUseCase.kt
            GetRepositoryStructureUseCase.kt
```

## Dependency Graph
_To be completed once all layers are implemented_
