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