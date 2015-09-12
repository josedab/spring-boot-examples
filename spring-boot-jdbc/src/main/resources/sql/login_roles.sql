-- DROP ROLE "user";

-- Password is password. This is just an example, never put the md5 of a password on git
-- Just a convenient script for the test

CREATE ROLE "user" LOGIN
  ENCRYPTED PASSWORD 'md54d45974e13472b5a0be3533de4666414'
  NOSUPERUSER INHERIT NOCREATEDB NOCREATEROLE NOREPLICATION;
