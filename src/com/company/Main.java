package com.company;

import com.company.converter.Converter;
import com.company.dto.FolderDto;
import com.company.entity.RepositoryEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    private static final List<RepositoryEntity> entities = Arrays.asList(
            new RepositoryEntity(
                    "name_1"
                    , "path_1",
                    Arrays.asList(
                            new RepositoryEntity(
                                    "child_1",
                                    "child_path_1",
                                    Collections.singletonList(new RepositoryEntity("small_child_1", "small_child_path_1", null))),
                            new RepositoryEntity("child_2", "child_path_2", Collections.emptyList())
                    )
            ),
            new RepositoryEntity(
                    "name_2"
                    , "path_2",
                    null
            )
    );

    private static final FolderDto newDto = new FolderDto("newDto", null);

    public static void main(String[] args) {
        List<FolderDto> dtos = new ArrayList<>();
	    process(dtos);
    }

    /**
     * @param dtos liste d'éléments en entrée
     */
    static void process(List<FolderDto> dtos) {
        // S'assurer que la liste en paramètre d'entrée de la méthode est vide, sinon la vider
        dtos = new ArrayList<>();
        // Remplir la liste 'dtos' en convertissant chaque entité présente dans la liste ‘entities’ en DTO (implémentation
        //d’un converter entité -> DTO avec les correspondances des propriétés name/repositoryName et
        //subRepositories/children)
        for (RepositoryEntity entity: entities){
            FolderDto dto = Converter.asDto(entity);
            dtos.add(dto);
        }
        // Ajouter l'objet "newDto' dans la liste "dtos' si elle ne contient pas déjà un objet avec le même nom
        addNewDto(dtos);
        // Vérifier que la liste 'dtos' contient bien un item avec le nom 'newDto’
        if (containsNewDto(dtos)){
            System.out.println("newDto exists");
        }
        // Ajouter l'objet "newDto' dans la liste "dtos' si elle ne contient pas déjà un objet avec le même nom
        addNewDto(dtos);
        // Afficher la taille de la liste 'dtos' dans la console
        System.out.println(dtos.size());
        // Afficher le contenu de la liste 'dtos' dans la console en une seule ligne
        System.out.println(dtos);
    }

    /**
     * verifie si newDto est contenu dans la liste dtos
     * @param dtos liste de dtos
     * @return true si est contenu, false sinon
     */
    static boolean containsNewDto(List<FolderDto> dtos){
        return dtos.toString().contains(newDto.getRepositoryName());
    }

    /**
     * ajoute newDto dans la liste si pas encore contenu
     * @param dtos liste de dtos
     * @return dtos modifiée
     */
    static List<FolderDto> addNewDto(List<FolderDto> dtos){
        if (!containsNewDto(dtos)){
            dtos.add(newDto);
        }
        return dtos;
    }
}
