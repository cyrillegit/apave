package com.company.entity;

import java.util.List;

public class RepositoryEntity {
    private String name;
    private String path;
    private List<RepositoryEntity> subRepositories;

    public RepositoryEntity(String name, String path, List<RepositoryEntity> subRepositories) {
        this.name = name;
        this.path = path;
        this.subRepositories = subRepositories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<RepositoryEntity> getSubRepositories() {
        return subRepositories;
    }

    public void setSubRepositories(List<RepositoryEntity> subRepositories) {
        this.subRepositories = subRepositories;
    }

    @Override
    public String toString() {
        return "RepositoryEntity{" +
                "name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", subRepositories=" + subRepositories +
                '}';
    }
}
