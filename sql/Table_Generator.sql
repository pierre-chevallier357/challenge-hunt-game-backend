DROP TABLE IF EXISTS indice_utilise;
DROP TABLE IF EXISTS reponse;
DROP TABLE IF EXISTS visite;
DROP TABLE IF EXISTS indice;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS defi;
DROP TABLE IF EXISTS arret;
DROP TABLE IF EXISTS chami;
DROP TYPE IF EXISTS defi_type;


CREATE TYPE defi_type AS enum ('fun', 'enigme', 'challenge', 'hardcore', 'franchement_mec');

CREATE TABLE chami
(
    uid         integer PRIMARY KEY,
    email       varchar(50) UNIQUE,
    pseudo      varchar(30) UNIQUE,
    age         integer,
    ville       varchar(30),
    nb_defis    integer,
    description text
);

CREATE TABLE arret
(
    id_arret integer PRIMARY KEY,
    nom      varchar(100),
    code     varchar(300),
    lien_map varchar(500)
);

CREATE TABLE defi
(
    id_defi           varchar(10) PRIMARY KEY,
    uid               integer REFERENCES chami,
    id_arret          integer REFERENCES arret,
    titre             varchar(40),
    defi_type         defi_type,
    date_creation     timestamp,
    date_modification timestamp,
    version_d         integer,
    mots_clefs        varchar(120),
    points            integer,
    duree             integer,
    prologue          text,
    description       text,
    epilogue          text,
    commentaire       text
);



CREATE TABLE question
(
    id_question integer PRIMARY KEY,
    id_defi     varchar(10) REFERENCES defi,
    numero      integer,
    question    varchar(500),
    secret      varchar(500),
    points      integer
);

CREATE TABLE indice
(
    id_indice   integer PRIMARY KEY,
    id_defi     varchar(10) REFERENCES defi,
    numero      integer,
    description text,
    points      integer
);

CREATE TABLE visite
(
    id_visite   varchar(10) PRIMARY KEY,
    id_defi     varchar(10) REFERENCES defi,
    uid         integer REFERENCES chami,
    date_visite timestamp,
    temps       integer,
    version_d   integer,
    mode_d      varchar(50),
    status      varchar(20),
    note        integer CHECK (note BETWEEN 0 AND 5),
    score       integer,
    commentaire text
);

CREATE TABLE reponse
(
    question integer REFERENCES question,
    visite   varchar(10) REFERENCES visite,
    reponse  varchar(500),
    PRIMARY KEY (question, visite)
);

CREATE TABLE indice_utilise
(
    visite varchar(10) REFERENCES visite,
    indice integer REFERENCES indice,
    PRIMARY KEY (visite, indice)
);
