DROP TABLE IF EXISTS reponse;
DROP TABLE IF EXISTS visite;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS defi;
DROP TABLE IF EXISTS arret;
DROP TABLE IF EXISTS chami;


CREATE TABLE chami
(
    uid         varchar(100) PRIMARY KEY,
    email       varchar(50) UNIQUE,
    pseudo      varchar(30) UNIQUE,
    age         integer,
    ville       varchar(30),
    nb_defis    integer,
    description text
);

CREATE TABLE arret
(
    id_arret  serial PRIMARY KEY,
    nom       varchar(100),
    code      varchar(300) UNIQUE,
    latitude  real,
    longitude real,
    lien_map  varchar(500)
);

CREATE TABLE defi
(
    id_defi           serial PRIMARY KEY,
    uid               varchar(100) REFERENCES chami,
    id_arret          integer REFERENCES arret,
    titre             varchar(40),
    defi_type         varchar(50) CHECK (defi_type IN ('fun', 'enigme', 'challenge', 'hardcore', 'franchement_mec')),
    date_creation     timestamp,
    date_modification timestamp,
    version_d         integer,
    mots_clefs        varchar(120),
    points            integer,
    duree             integer,
    note_moyenne      integer,
    prologue          text,
    description       text,
    epilogue          text,
    commentaire       text
);

CREATE TABLE question
(
    id_question     serial PRIMARY KEY,
    id_defi         integer REFERENCES defi,
    numero          integer,
    question        varchar(500),
    secret          varchar(500),
    points_question integer,
    indice          varchar(500),
    points_indice   integer
);

CREATE TABLE visite
(
    id_visite   serial PRIMARY KEY,
    id_defi     integer REFERENCES defi,
    uid         varchar(100) REFERENCES chami,
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
    question       integer REFERENCES question,
    visite         integer REFERENCES visite,
    reponse        varchar(500),
    indice_utilise boolean,
    PRIMARY KEY (question, visite)
);


--TRIGGERS/FUNCTIONS

--MISE À JOUR DE LA NOTE MOYENNE
CREATE OR REPLACE FUNCTION meanupdater()
    RETURNS trigger
    LANGUAGE plpgsql
AS
$function$
BEGIN
    UPDATE defi SET note_moyenne = (SELECT AVG(note) FROM visite) WHERE defi.id_defi = new.id_defi;
    RETURN new;
END;
$function$
;

CREATE TRIGGER meanprocessing
    AFTER
        INSERT OR UPDATE OR DELETE
    ON
        visite
    FOR EACH ROW
EXECUTE FUNCTION meanupdater();

CREATE OR REPLACE FUNCTION meanupdaterold()
    RETURNS trigger
    LANGUAGE plpgsql
AS
$function$
BEGIN
    UPDATE defi SET note_moyenne = (SELECT AVG(note) FROM visite) WHERE defi.id_defi = old.id_defi;
    RETURN old;
END;
$function$
;

CREATE TRIGGER meanprocessingold
    AFTER
        DELETE
    ON
        visite
    FOR EACH ROW
EXECUTE FUNCTION meanupdaterold();


--IN/DÉCRÉMENTER NBDEFIS
CREATE OR REPLACE FUNCTION decnbdefis()
    RETURNS trigger
    LANGUAGE plpgsql
AS
$function$
BEGIN
    UPDATE chami SET nb_defis = nb_defis - 1 WHERE uid = old.uid;
    RETURN old;
END;
$function$
;

CREATE TRIGGER decrementthis
    AFTER
        DELETE
    ON
        defi
    FOR EACH ROW
EXECUTE FUNCTION decnbdefis();

CREATE OR REPLACE FUNCTION public.incnbdefis()
    RETURNS trigger
    LANGUAGE plpgsql
AS
$function$
BEGIN
    UPDATE chami SET nb_defis = nb_defis + 1 WHERE uid = new.uid;
    RETURN new;
END;
$function$
;

CREATE TRIGGER incrementthis
    AFTER
        INSERT
    ON
        defi
    FOR EACH ROW
EXECUTE FUNCTION incnbdefis();
