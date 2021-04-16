INSERT INTO chami (uid, email, pseudo, age, ville, nb_defis, description)
VALUES (421, 'swag@swag.swag', 'swagus', 69, 'Swagland', 2, 'Swaging Hard on randoms');

INSERT INTO defi(id_defi, uid, titre, defi_type, date_creation, date_modification, version_d, mots_clefs, points, duree,
                 prologue, description, epilogue, commentaire)
VALUES ('D145', 421, 'Le vert, je le mange !', 'enigme', '2021-04-01 15:03', '2021-04-03 10:03', 1,
        'Swag, Fun, Tes Morts', 5, 5, 'TA MERE',
        ' - Rendez vous à l''arrêt de bus "Grenoble - hôtel de ville".
          - Passe par "l''orangerie".
          - Ca te donneras de l''énergie mais surtout ne dépasse pas les bornes !
          - Fatiguée ? T''as pas fait des bornes. Tu devrais avoir de l''énergie.
          - Reste sur le parking pour te recharger les piles.
          - Cherche plutôt celui qui pourrait te donner matière à te protéger pendant l''hiver.
          - Il est là. Il te regarde de haut. Il t''observe.
          - Il bêle. "Je suis ceux que je suis. Et le vert, je le mange !"',
        ' - La devise officielle des moutons est "Je suis ceux que je suis".
          - Il y a des centaines de moutons à grenoble.
          - Il y en a aussi dans de nombreuses villes autour du monde !
          - Sheepest dit :\
          - "A Paris ou à New-York, je recherche les coins reculés de la ville".
          - "Les endroits qui sont subtils, qui ont du sens et qui durent dans le temps".
          - Oublie le mouton. Retourne toi.
          - Derrière toi tu vois la première tour en béton du monde ! (1924)
          - Tour construite pour une exposition internationale [1].',
        'GG WP');

INSERT INTO defi(id_defi, uid, titre, defi_type, date_creation, date_modification, version_d, mots_clefs, points,
                 duree, prologue, description, epilogue, commentaire)
VALUES ('D189', 421, 'Et l''écureil alors ?', 'franchement_mec', '2021-03-17 12:03', '2021-03-22 13:03', 3,
        'Animaux, Distanciel, Fun, Patrimoine', 5, 5, 'PROLOGUE',
        '
          - C''est l''été. Tu as besoin de grand air.
          - Demande à quelqu''un où est la maison de la montagne.
          - Longe le tram pour y aller. Tu demanderas où on peut voir des chamois.
          - Vas pas trop vite ! Les chamoix sont en plein centre ville !
          - Grenoble c''est la ville du béton, mais c''est aussi la capitale des Alpes.
          - Fait attention tu pourrais te faire écraser par des pachidermes !
        ',
        '
          - L''immeuble est appelé "immeuble des éléphants". Il date de 1903.
          - Il et a été construit pour le compte d''un important frabricant de ciment.
          - Le ciment a une histoire en béton à Grenoble.
          - En fait le béton est rééllement né à Grenoble, c''est pas une blague.
          - Le bicentenaire a d''ailleurs eu lieu en 2017.
          - Vas faire udes  un tour du coté de l''hotel de ville tu trouveras
        ', 'I''M A LOOSER, STILL A LOOSER IN LOVE');

INSERT INTO visite (id_visite, id_defi, uid, date_visite, temps, version_d, mode_d, status, note, score, commentaire)
VALUES ('V145-1', 'D145', 421, '2021-04-16 12:37:05.000000', 9, 1, 'présentiel', 'répondu', 4, 8, 'nul');

INSERT INTO indice (id_indice, id_defi, numero, descritpion, points)
VALUES (1, 'D145', 1, 'non', 1);

INSERT INTO indice_utilise (visite, indice)
VALUES ('V145-1', 1);

INSERT INTO question (id_question, id_defi, numero, question, secret, points)
VALUES (1, 'D145', 1, 'Oui ?', 'Non.', 1000);

INSERT INTO reponse (question, visite, reponse)
VALUES (1, 'V145-1', 'Yes');
