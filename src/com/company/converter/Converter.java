package com.company.converter;

import com.company.dto.FolderDto;
import com.company.entity.RepositoryEntity;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static FolderDto asDto(RepositoryEntity repositoryEntity){
        FolderDto folderDto = new FolderDto();
        folderDto.setRepositoryName(repositoryEntity.getName());
        folderDto.setChildren(convert(repositoryEntity.getSubRepositories()));
        return folderDto;
    }

    public static List<FolderDto> convert(List<RepositoryEntity> repositoryEntities){
        List<FolderDto> folderDtos = new ArrayList<>();
        if (repositoryEntities != null && !repositoryEntities.isEmpty()) {
            for (RepositoryEntity repositoryEntity : repositoryEntities) {
                List<FolderDto> subs = convert(repositoryEntity.getSubRepositories(), repositoryEntity.getName());
                folderDtos.add(new FolderDto(repositoryEntity.getName(), subs));
            }
        }
        return folderDtos;
    }

    private static List<FolderDto> convert(List<RepositoryEntity> repositoryEntities, String name){
        List<FolderDto> folderDtos = new ArrayList<>();
        if (repositoryEntities != null && !repositoryEntities.isEmpty()) {
            for (RepositoryEntity repositoryEntity : repositoryEntities) {
                folderDtos.add(new FolderDto(name, convert(repositoryEntity.getSubRepositories(), name)));
            }
        }
        return folderDtos;
    }
}
