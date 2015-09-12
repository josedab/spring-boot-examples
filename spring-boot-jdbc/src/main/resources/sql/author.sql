-- Table: author

-- DROP TABLE author;

CREATE TABLE author
(
  id bigserial NOT NULL,
  name character varying(255),
  surname character varying(255),
  description character varying(255),
  birth_date date,
  CONSTRAINT pk_author PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE author
  OWNER TO "user";
