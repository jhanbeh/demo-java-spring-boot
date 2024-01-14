--liquibase formatted sql

--changeset jhan:mssql.2024-01-13_1657_create_table

CREATE TABLE STUDENT (
    ID VARCHAR(36),
    USERNAME VARCHAR(255) UNIQUE,
    NAME VARCHAR(255),
    AGE INTEGER,
    GENDER VARCHAR(10),
    PRIMARY KEY(ID)
);
