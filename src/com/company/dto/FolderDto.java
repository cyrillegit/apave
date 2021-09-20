package com.company.dto;

import java.util.List;

public class FolderDto {
    private String repositoryName;
    private List<FolderDto> children;

    public FolderDto() {
    }

    public FolderDto(String repositoryName, List<FolderDto> children) {
        this.repositoryName = repositoryName;
        this.children = children;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName;
    }

    public List<FolderDto> getChildren() {
        return children;
    }

    public void setChildren(List<FolderDto> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "FolderDto{" +
                "repositoryName='" + repositoryName + '\'' +
                ", children=" + children +
                '}';
    }
}
