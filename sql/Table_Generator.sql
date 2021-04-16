DROP TABLE IF EXISTS indice_utilise;
DROP TABLE IF EXISTS reponse;
DROP TABLE IF EXISTS visite;
DROP TABLE IF EXISTS indice;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS arret;
DROP TABLE IF EXISTS defi;
DROP TABLE IF EXISTS chami;
DROP TYPE IF EXISTS defi_type;


CREATE TYPE defi_type AS enum ('fun',' enigme', 'challenge',  'hardcore', 'franchement_mec');

CREATE TABLE chami
(
    uid         integer PRIMARY KEY,
    email       varchar(50) UNIQUE,
    pseudo      varchar(30) UNIQUE,
    age         integer,
    ville       varchar(30),
    nb_defis    integer,
    description varchar(500)
);

CREATE TABLE defi
(
    id_defi           varchar(10) PRIMARY KEY,
    uid               integer REFERENCES chami,
    titre             varchar(40),
    defi_type         defi_type,
    date_creation     timestamp,
    date_modification timestamp,
    version_d         integer,
    mots_clefs        varchar(120),
    points            integer,
    duree             integer,
    prologue          varchar(200),
    description       varchar(1000),
    epilogue          varchar(200),
    commentaire       varchar(150)
);

CREATE TABLE arret
(
    id_arret integer PRIMARY KEY,
    id_defi  varchar(10) REFERENCES defi,
    nom      varchar(30),
    code     varchar(300),
    lien_map varchar(500)
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
    descritpion varchar(1000),
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
    score       integer
);

CREATE TABLE reponse
(
    id_question integer REFERENCES question,
    id_visite   varchar(10) REFERENCES visite,
    reponse     varchar(500),
    PRIMARY KEY (id_question, id_visite)
);

CREATE TABLE indice_utilise
(
    id_visite varchar(10) REFERENCES visite,
    id_indice integer REFERENCES indice,
    PRIMARY KEY (id_visite, id_indice)
);
