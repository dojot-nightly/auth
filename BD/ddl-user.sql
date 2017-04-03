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