--liquibase formatted sql

--changeset jhan:mysql.2024-01-13_1657_create_table

CREATE TABLE STUDENTS (
    id VARCHAR(36),
    username VARCHAR(255) UNIQUE,
    name VARCHAR(255),
    age INTEGER,
    gender VARCHAR(10),
    PRIMARY KEY(ID)
);
