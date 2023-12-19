CREATE ROLE gr_app WITH
    NOLOGIN
    NOSUPERUSER
    NOCREATEDB
    NOCREATEROLE
    INHERIT
    NOREPLICATION
    CONNECTION LIMIT -1;
COMMENT ON ROLE gr_app IS 'Group for our CA application';


CREATE ROLE app_user WITH
    LOGIN
    NOSUPERUSER
    INHERIT
    NOCREATEDB
    NOCREATEROLE
    NOREPLICATION
    ENCRYPTED PASSWORD 'SCRAM-SHA-256$4096:TL5Ug9oXuFUg7JMUHoc1hw==$SqfoJPXa7CgQhUGFiXvKf+cI7kUGunIJu8oEMc+3ZFc=:rOU7kOnut7vCLs4+PEGApccnkBhIuBZK5curKQBrRY4=';

GRANT gr_app TO app_user;

COMMENT ON ROLE app_user IS 'User for our small application';


CREATE DATABASE ca_app_db
    WITH
    OWNER = gr_app
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

-- !!! below scripts should be run when we connected to ca_app_db !!!

GRANT ALL ON DATABASE ca_app_db TO gr_app;

CREATE SCHEMA IF NOT EXISTS public
    AUTHORIZATION gr_app;

COMMENT ON SCHEMA public
    IS 'standard public schema';

GRANT USAGE ON SCHEMA public TO PUBLIC;

GRANT ALL ON SCHEMA public TO gr_app;

ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA public
    GRANT INSERT, DELETE, SELECT, UPDATE ON TABLES TO gr_app;

ALTER DEFAULT PRIVILEGES FOR ROLE postgres IN SCHEMA public
    GRANT ALL ON SEQUENCES TO gr_app;

CREATE TABLE person (
    id SERIAL PRIMARY KEY NOT NULL,
    name varchar(50) NOT NULL,
    surname varchar(100) NOT NULL,
    age smallint
);

ALTER TABLE IF EXISTS public.person
    OWNER to gr_app;

insert into person (name, surname, age)
values ('Petras', 'Petraitis', null),
       ('Antanas', 'Antanaitis', 33);

CREATE TABLE IF NOT EXISTS auto
(
    id serial NOT NULL,
    number varchar(10) NOT NULL,
    CONSTRAINT auto_id_pk PRIMARY KEY (id)
);

alter table auto
    add person_id integer;

ALTER TABLE IF EXISTS auto
    ADD CONSTRAINT auto_person_id_person_id_fkey FOREIGN KEY (person_id)
        REFERENCES person (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE RESTRICT;
