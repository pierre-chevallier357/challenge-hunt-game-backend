--CHAMIS
INSERT INTO chami (uid, email, pseudo, age, ville, nb_defis, description)
VALUES (421, 'swag@swag.swag', 'swagus', 69, 'Swagland', 2, 'Swaging Hard on randoms');
INSERT INTO chami (uid, email, pseudo, age, ville, nb_defis, description)
VALUES (900, 'wariorwars25@gmail.com', 'Barney', 23, 'Besançon', 0,
        '"J''ai cherché, j''ai cherché, j''ai cherché mais je ne pensais pas trouver le mouvement perpétuel pas du tout." -Léon Raoul Hatem, l''horloger de l''univers"');
INSERT INTO chami (uid, email, pseudo, age, ville, nb_defis, description)
VALUES (897, 'escribis@gmail.com', 'escribis', 43, 'Grenoble', 0, '  - Bravo à tous pour vos contributions. C''est cool !
  - Pour cette année pour ChaGra 2022 on pourrait voir avec la MDA.
  - Au passage vous devriez vous s''inscrire sur le site contribulle.org
  - Pour contribuer à quelque chose d''utile ca se passe là bas.');
INSERT INTO chami (uid, email, pseudo, age, ville, nb_defis, description)
VALUES (1, 'nautilusleswageur@swagmail.com', 'Yanis', 20, 'Valence', 1,
        '"Dans chaque enfant il y a un artiste. Le problème est de savoir comment rester un artiste en grandissant."');
INSERT INTO chami (uid, email, pseudo, age, ville, nb_defis, description)
VALUES (2, 'pierre@uga.fr', 'Pierrot', 20, 'Grenoble', 0, 'J''aime la MIAGE');
INSERT INTO chami (uid, email, pseudo, age, ville, nb_defis, description)
VALUES (3, 'requiem@uga.fr', 'Requiem', 21, 'Montpellier', 0, 'J''aime Requiem de Mozart');
INSERT INTO chami (uid, email, pseudo, age, ville, nb_defis, description)
VALUES (4, 'anais@uga.fr', 'Anais', 21, 'Nantes', 0, 'Je souhaite participer aux défis distanciels !');
INSERT INTO chami (uid, email, pseudo, age, ville, nb_defis, description)
VALUES (8, 'pierre.chevallier2000@gmail.com', 'PierreChevallier', 20, 'Grenoble', 0, 'Compte de test');
INSERT INTO chami (uid, email, pseudo, age, ville, nb_defis, description)
VALUES (9, 'snoop.dogg@music.com', 'SnoopDogg', 49, 'Los Angeles', 0, 'I''m an american rapper');
INSERT INTO chami (uid, email, pseudo, age, ville, nb_defis, description)
VALUES (10, 'omar.sy@acteur.fr', 'Omar', 43, 'Paris', 0, 'Je suis un acteur français');



--ARRETS
INSERT INTO arret (id_arret,  nom, code, lien_map)
VALUES (1,  'VICTOR HUGO', 'SEM_GENVICTHUGO', 'NULL');
INSERT INTO arret (id_arret,  nom, code, lien_map)
VALUES (2,  'HUBERT DUBEDOUT - MAISON DU TOURISME', 'SEM_GENDUBEDOUT', 'NULL');
INSERT INTO arret (id_arret,  nom, code, lien_map)
VALUES (3,  'HUBERT DUBEDOUT - MAISON DU TOURISME', 'SEM_GENDUBEDOUT', 'NULL');



--DEFIS
INSERT INTO defi (id_defi, uid, titre, defi_type, date_creation, date_modification, version_d, mots_clefs,
                  points, duree, prologue, description, epilogue, commentaire,id_arret)
VALUES ('D145', 421, 'Le vert, je le mange !', 'enigme', '2021-04-01 15:03:00.000000', '2021-04-03 10:03:00.000000', 1,
        'Swag, Fun', 5, 5, 'Bonne chance', ' - Rendez vous à l''arrêt de bus "Grenoble - hôtel de ville".
          - Passe par "l''orangerie".
          - Ca te donneras de l''énergie mais surtout ne dépasse pas les bornes !
          - Fatiguée ? T''as pas fait des bornes. Tu devrais avoir de l''énergie.
          - Reste sur le parking pour te recharger les piles.
          - Cherche plutôt celui qui pourrait te donner matière à te protéger pendant l''hiver.
          - Il est là. Il te regarde de haut. Il t''observe.
          - Il bêle. "Je suis ceux que je suis. Et le vert, je le mange !"', ' - La devise officielle des moutons est "Je suis ceux que je suis".
          - Il y a des centaines de moutons à grenoble.
          - Il y en a aussi dans de nombreuses villes autour du monde !
          - Sheepest dit :\
          - "A Paris ou à New-York, je recherche les coins reculés de la ville".
          - "Les endroits qui sont subtils, qui ont du sens et qui durent dans le temps".
          - Oublie le mouton. Retourne toi.
          - Derrière toi tu vois la première tour en béton du monde ! (1924)
          - Tour construite pour une exposition internationale [1].', 'GG WP',2);
INSERT INTO defi (id_defi, uid, titre, defi_type, date_creation, date_modification, version_d, mots_clefs,
                  points, duree, prologue, description, epilogue, commentaire,id_arret)
VALUES ('D189', 421, 'Et l''écureil alors ?', 'franchement_mec', '2021-03-17 12:03:00.000000',
        '2021-03-22 13:03:00.000000', 3, 'Animaux, Distanciel, Fun, Patrimoine', 5, 5, 'PROLOGUE', '
          - C''est l''été. Tu as besoin de grand air.
          - Demande à quelqu''un où est la maison de la montagne.
          - Longe le tram pour y aller. Tu demanderas où on peut voir des chamois.
          - Vas pas trop vite ! Les chamoix sont en plein centre ville !
          - Grenoble c''est la ville du béton, mais c''est aussi la capitale des Alpes.
          - Fait attention tu pourrais te faire écraser par des pachidermes !
        ', '
          - L''immeuble est appelé "immeuble des éléphants". Il date de 1903.
          - Il et a été construit pour le compte d''un important frabricant de ciment.
          - Le ciment a une histoire en béton à Grenoble.
          - En fait le béton est rééllement né à Grenoble, c''est pas une blague.
          - Le bicentenaire a d''ailleurs eu lieu en 2017.
          - Vas faire udes  un tour du coté de l''hotel de ville tu trouveras
        ', 'I''M A LOOSER, STILL A LOOSER IN LOVE' , 2);
INSERT INTO defi (id_defi, uid, titre, defi_type, date_creation, date_modification, version_d, mots_clefs,
                  points, duree, prologue, description, epilogue, commentaire,id_arret)
VALUES ('D151', 1, 'Ils tournent et rond.', 'challenge', '2022-01-04 12:03:00.000000', '2022-02-04 09:20:00.000000', 2,
        'Mouton, StreetArt, Fun, Distanciel', 8, 10, 'LOURD PROLOG', '  - Il tourne en rond pour le plaisir des petits. Cherche le.
  - Si il n''y est pas demande à quelqu''un où il est quand il y est :-)
  - Fait toi un selfie avec les 2 moutons en utilisant ton sens de la créativité.
  - Si tu n''y arrives pas demande à quelqu''un qu''il/elle te tire un portrait.', '  - Sheepest dit à propos de ses moutons :\
  - "C’est un mouton qui parle de la société. Il est observateur et dénonciateur".
  - "Il sert à faire lever les yeux au ciel".
  - "Je n’ai pas une volonté d’égayer la ville avec ce mouton ‘sympa’".
  - "Je cherche plutôt d’aiguiser des consciences".
  - "Les gens fonctionnent avec le premier plan et marchent la tête baissée."
  - "Si je mettais le mouton en bas, le ‘troupeau’ le verrait".
  - "Ce serait de la facilité".
  - "D’ailleurs j’aime qu’on me dise que l’on n’a pas vu mon mouton !"',
        '  -  Pourrait être aussi associé à l''arrêt "Maison du tourisme - Hubert Dubedout"',1);
INSERT INTO defi (id_defi, uid, titre, defi_type, date_creation, date_modification, version_d, mots_clefs,
                  points, duree, prologue, description, epilogue, commentaire,id_arret)
VALUES ('D128', 1, 'Escape Game - Street Art', 'enigme', '2021-03-04 22:42:00.000000', '2021-03-04 22:42:00.000000', 1,
        'Mouton, StreetArt, Fun, Distanciel, Graaly, EscapeGame, Presentiel', 43, 150, '  - Possible uniquement en présentiel. ~ 2h30
  - Télécharge l''application "Graaly" sur ton téléphone portable.
  - Cette application est indispensable pour jouer.
  - Le défi consiste à jouer à l''escape game "Street art".', '  - Vas du coté de l''oiseau tout plat.
  - Regarde le renard tout plat.
  - Prend la direction de la caserne.
  - Trouve un troupeau de moutons et tourne à droite.
  - Ouvre l''application Graly et choisi l''escape game "Street art" - bon jeu.
  ', 'NULL', '  - Compléter la question 2 avec la bonne énigme. Il s''agit de la presque dernière énigme avec les lettres.
  - Ajouter éventuellement une ou deux autres questions sur ce qui a été vu pendant l''escape game.
',1);
INSERT INTO defi (id_defi, uid, titre, defi_type, date_creation, date_modification, version_d, mots_clefs,
                  points, duree, prologue, description, epilogue, commentaire,id_arret)
VALUES ('D127', 1, 'Le Méchoui et l''animal', 'enigme', '2022-03-03 16:03:00.000000', '2021-01-04 16:03:00.000000',
        1000, 'Mouton, StreetArt, Fun, Distanciel', 14, 15,
        '  - Pour le présentiel regarder la vidéo avant d''aller sur place.', '  - Une amie t''as demandé de préparer un grand méchoui pour 100 personnes.
  - On t''as dit qu''il y avait 4 moutons qui se courraient après autour de la maison du tourisme.
  - 4 moutons dans un rayon de 100m.
  - Rendez vous à l''arrêt de bus "Maison du tourisme - Hubert Dubedout".
  - Cherche un premier mouton.', '  - Sheepest dit à propos de ses moutons :\
  - "Quand j’ai eu l’idée de faire des moutons je ne savais pas comment j’allais dessiner les dessiner."
  - "C’est en feuilletant un magazine que j’ai trouvé la tête du mouton propre à une marque de skate peu connue des années 90."
', '  - La première version était ennuyeuse : premier mouton trouvé immédiatement (1mn max)
  - La version 2 ajoute deux moutons dont un à découvrir avec une petite vidéo 3mn.
  -',1);



--QUESTIONS
INSERT INTO question (id_question, id_defi, numero, question, secret, points)
VALUES (1, 'D145', 1, 'Quelle est la couleur des moutons ?', 'Ça dépend', 10);



--INDICES
INSERT INTO indice (id_indice, id_defi, numero, description, points)
VALUES (1, 'D145', 1, 'Grenoble est une ville verte. Donc avec des voitures vertes.', 2);
INSERT INTO indice (id_indice, id_defi, numero, description, points)
VALUES (2, 'D145', 2, 'A l''angle de l''orangerie, regarde l''autre angle.', 2);
INSERT INTO indice (id_indice, id_defi, numero, description, points)
VALUES (3, 'D127', 1, '        - Détourne toi des bonbons.
        - Ce n''est pas bon pour les dents.', 1);
INSERT INTO indice (id_indice, id_defi, numero, description, points)
VALUES (4, 'D127', 2, '        - En fait il est environ à 25m du premier mouton à vol d''oiseaux.
        - Mais si tu veux le voir il faudra prendre du recul...', 3);
INSERT INTO indice (id_indice, id_defi, numero, description, points)
VALUES (5, 'D127', 3, ' - Place toi entre l''angle de monoprix et la maison du tourisme.', 0);



--VISITES
INSERT INTO visite (id_visite, id_defi, uid, date_visite, temps, version_d, mode_d, status, note, score,
                    commentaire)
VALUES ('V145-1', 'D145', 421, '2021-04-16 12:37:05.000000', 9, 1, 'présentiel', 'répondu', 4, 8, 'Franchement sympa');



--REPONSES
INSERT INTO reponse (question, visite, reponse)
VALUES (1, 'V145-1', 'Blanc');



--INDICES UTILISES
INSERT INTO indice_utilise (visite, indice)
VALUES ('V145-1', 1);
