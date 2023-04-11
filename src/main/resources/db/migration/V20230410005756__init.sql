CREATE TABLE item
(
    id         UUID         NOT NULL,
    name       VARCHAR(40)  NOT NULL,
    price      INTEGER      NOT NULL,
    stock      INTEGER      NOT NULL,
    detail     VARCHAR(400) NOT NULL,
    status     VARCHAR(20)  NOT NULL,
    created_at TIMESTAMP    NOT NULL,
    updated_at TIMESTAMP    NOT NULL,
    PRIMARY KEY (id)
)