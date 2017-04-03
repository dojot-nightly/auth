CREATE TABLE cpqdplatiot.usuario (
    id integer NOT NULL,
    nome character varying(50) NOT NULL,
    login character varying(50) NOT NULL
);

ALTER TABLE cpqdplatiot.usuario OWNER TO postgres;

CREATE SEQUENCE cpqdplatiot.usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE cpqdplatiot.usuario_id_seq OWNER TO postgres;

ALTER SEQUENCE cpqdplatiot.usuario_id_seq OWNED BY cpqdplatiot.usuario.id;

ALTER TABLE ONLY cpqdplatiot.usuario ALTER COLUMN id SET DEFAULT nextval('cpqdplatiot.usuario_id_seq'::regclass);

ALTER TABLE ONLY cpqdplatiot.usuario ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);

CREATE TABLE cpqdplatiot.senhaativa (
    id integer NOT NULL,
    data timestamp without time zone NOT NULL,
    hash character(255) NOT NULL,
    salt bytea NOT NULL,
    usuario integer NOT NULL
);

ALTER TABLE cpqdplatiot.senhaativa OWNER TO postgres;

CREATE SEQUENCE cpqdplatiot.senhaativa_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE cpqdplatiot.senhaativa_id_seq OWNER TO postgres;

ALTER SEQUENCE cpqdplatiot.senhaativa_id_seq OWNED BY cpqdplatiot.senhaativa.id;

ALTER TABLE ONLY cpqdplatiot.senhaativa ALTER COLUMN id SET DEFAULT nextval('cpqdplatiot.senhaativa_id_seq'::regclass);

ALTER TABLE ONLY cpqdplatiot.senhaativa
    ADD CONSTRAINT senhaativa_pkey PRIMARY KEY (id);

CREATE INDEX fki_senhaativa_usuario ON cpqdplatiot.senhaativa USING btree (usuario);

ALTER TABLE ONLY cpqdplatiot.senhaativa
    ADD CONSTRAINT fk_senhaativa_usuario FOREIGN KEY (usuario) REFERENCES cpqdplatiot.usuario(id);