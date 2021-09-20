/*
Créer une table 'item' avec :
- un id autogénéré
- une colonne 'name' de type chaîne de caractères non nulle et unique
- une colonne 'item_date' de type date, vec pour valeur par défaut la date courante
*/
DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  name VARCHAR (255) UNIQUE NOT NULL,
  item_date DATETIME DEFAULT CURRENT_TIMESTAMP
);

/*
Créer une table 'item_dependency' avec :
- un id autogénéré
- une colonne 'item_id' faisant référence à l'ID de la table 'item'
- une colonne 'value' de type chaîne de caractère
*/
DROP TABLE IF EXISTS `item_dependency`;

CREATE TABLE `item_dependency` (
  id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  value VARCHAR (255),
  item_id int(11) DEFAULT NULL,
  FOREIGN KEY (item_id) REFERENCES item(id)
);

/*
Insérer dans la table 'item' une ligne avec la valeur 'item_1' dans la colonne 'name'
Insérer dans la table 'item_dependency' une ligne associée à l'entité 1 créé précédemment et avec la valeur 'value_1'
dans la colonne 'value'
*/
INSERT INTO item (name) VALUES ('item_1');

INSERT INTO item_dependency (value, item_id) VALUES ('value_1', (SELECT id FROM item WHERE name = 'item_1'));

/*
Insérer dans la table 'item' une ligne avec la valeur 'item_2' dans la colonne 'name'
Insérer dans la table 'item_dependency' une ligne associée à l'entité créé précédemment et avec la valeur 'value_2' dans
la colonne 'value'
*/
INSERT INTO item (name) VALUES ('item_2');

INSERT INTO item_dependency (value, item_id) VALUES ('value_2', (SELECT id FROM item WHERE name = 'item_2'));

/*
Insérer dans la table 'item' une ligne avec la valeur 'item_3' dans la colonne 'name'
*/
INSERT INTO item (name) VALUES ('item_3');

/*
Sélectionner les champs item.name et item_dependency.value pour les enregistrements qui remplissent les conditions
suivantes :
- élément avec pour valeur dans la colonne 'name' table 'item' = 'item_1', quelle que soit la casse (majuscule/minuscule)
OU
- élément présent dans la table 'item' mais sans correspondance dans la table 'item_dependency'
*/
SELECT i.name, i_d.value 
FROM item AS i
LEFT OUTER JOIN item_dependency AS i_d ON i.id = i_d.item_id
WHERE LOWER(i.name) = 'item_1' OR i_d.item_id is null;