--
-- PostgreSQL database dump
--

-- Dumped from database version 14.0 (Debian 14.0-1.pgdg110+1)
-- Dumped by pg_dump version 14.6 (Homebrew)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: smartwater; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA smartwater;


ALTER SCHEMA smartwater OWNER TO postgres;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: mediciones; Type: TABLE; Schema: smartwater; Owner: postgres
--

CREATE TABLE smartwater.mediciones (
    id bigint NOT NULL,
    instante timestamp without time zone NOT NULL,
    device_id character varying(50) NOT NULL,
    nombre character varying(100) NOT NULL,
    valor double precision NOT NULL
);


ALTER TABLE smartwater.mediciones OWNER TO postgres;

--
-- Name: mediciones_id_seq; Type: SEQUENCE; Schema: smartwater; Owner: postgres
--

CREATE SEQUENCE smartwater.mediciones_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE smartwater.mediciones_id_seq OWNER TO postgres;

--
-- Name: mediciones_id_seq; Type: SEQUENCE OWNED BY; Schema: smartwater; Owner: postgres
--

ALTER SEQUENCE smartwater.mediciones_id_seq OWNED BY smartwater.mediciones.id;


--
-- Name: mediciones id; Type: DEFAULT; Schema: smartwater; Owner: postgres
--

ALTER TABLE ONLY smartwater.mediciones ALTER COLUMN id SET DEFAULT nextval('smartwater.mediciones_id_seq'::regclass);


--
-- Data for Name: mediciones; Type: TABLE DATA; Schema: smartwater; Owner: postgres
--

COPY smartwater.mediciones (id, instante, device_id, nombre, valor) FROM stdin;
\.


--
-- Name: mediciones_id_seq; Type: SEQUENCE SET; Schema: smartwater; Owner: postgres
--

SELECT pg_catalog.setval('smartwater.mediciones_id_seq', 1, false);


--
-- Name: mediciones mediciones_pk; Type: CONSTRAINT; Schema: smartwater; Owner: postgres
--

ALTER TABLE ONLY smartwater.mediciones
    ADD CONSTRAINT mediciones_pk PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

