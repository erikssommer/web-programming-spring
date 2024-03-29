CREATE TABLE Motorvogn
(
    personnr   INTEGER      NOT NULL,
    navn       VARCHAR(255) NOT NULL,
    adresse    VARCHAR(255) NOT NULL,
    kjennetegn VARCHAR(255) NOT NULL,
    merke      VARCHAR(255) NOT NULL,
    type       VARCHAR(255) NOT NULL,
    PRIMARY KEY (personnr)
);

CREATE TABLE Bil
(
    id    INTEGER AUTO_INCREMENT NOT NULL,
    merke VARCHAR(255) NOT NULL,
    type  VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Motorvogn6 tabeller (her har Motorvogn-tabellen en egen id som autogenereres)

CREATE TABLE Motorvogn6
(
    id         INTEGER AUTO_INCREMENT NOT NULL,
    personnr   INTEGER      NOT NULL,
    navn       VARCHAR(255) NOT NULL,
    adresse    VARCHAR(255) NOT NULL,
    kjennetegn VARCHAR(255) NOT NULL,
    merke      VARCHAR(255) NOT NULL,
    type       VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Bil6
(
    id    INTEGER AUTO_INCREMENT NOT NULL,
    merke VARCHAR(255) NOT NULL,
    type  VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Motorvogn7 tabeller (her har Motorvogn-tabellen en egen id som autogenereres)

CREATE TABLE Motorvogn7
(
    id         INTEGER AUTO_INCREMENT NOT NULL,
    personnr   VARCHAR(255) NOT NULL,
    navn       VARCHAR(255) NOT NULL,
    adresse    VARCHAR(255) NOT NULL,
    kjennetegn VARCHAR(255) NOT NULL,
    merke      VARCHAR(255) NOT NULL,
    type       VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Bil7
(
    id    INTEGER AUTO_INCREMENT NOT NULL,
    merke VARCHAR(255) NOT NULL,
    type  VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Motorvogn8 tabeller (Sesjoner: bruker er ny)

CREATE TABLE Motorvogn8
(
    id         INTEGER AUTO_INCREMENT NOT NULL,
    personnr   VARCHAR(255) NOT NULL,
    navn       VARCHAR(255) NOT NULL,
    adresse    VARCHAR(255) NOT NULL,
    kjennetegn VARCHAR(255) NOT NULL,
    merke      VARCHAR(255) NOT NULL,
    type       VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Bil8
(
    id    INTEGER AUTO_INCREMENT NOT NULL,
    merke VARCHAR(255) NOT NULL,
    type  VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Bruker8
(
    id         INTEGER AUTO_INCREMENT NOT NULL,
    brukernavn VARCHAR(255) NOT NULL,
    passord    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

-- Motorvogn9 tabeller

CREATE TABLE Motorvogn9
(
    id         INTEGER AUTO_INCREMENT NOT NULL,
    personnr   VARCHAR(255) NOT NULL,
    navn       VARCHAR(255) NOT NULL,
    adresse    VARCHAR(255) NOT NULL,
    kjennetegn VARCHAR(255) NOT NULL,
    merke      VARCHAR(255) NOT NULL,
    type       VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Bil9
(
    id    INTEGER AUTO_INCREMENT NOT NULL,
    merke VARCHAR(255) NOT NULL,
    type  VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Bruker9
(
    id         INTEGER AUTO_INCREMENT NOT NULL,
    brukernavn VARCHAR(255) NOT NULL,
    passord    VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);