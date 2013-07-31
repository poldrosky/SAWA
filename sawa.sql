--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: block(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION block(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'block';


ALTER FUNCTION public.block(text, text) OWNER TO postgres;

--
-- Name: block_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION block_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'block_op';


ALTER FUNCTION public.block_op(text, text) OWNER TO postgres;

--
-- Name: cosine(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION cosine(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'cosine';


ALTER FUNCTION public.cosine(text, text) OWNER TO postgres;

--
-- Name: cosine_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION cosine_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'cosine_op';


ALTER FUNCTION public.cosine_op(text, text) OWNER TO postgres;

--
-- Name: dice(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION dice(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'dice';


ALTER FUNCTION public.dice(text, text) OWNER TO postgres;

--
-- Name: dice_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION dice_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'dice_op';


ALTER FUNCTION public.dice_op(text, text) OWNER TO postgres;

--
-- Name: euclidean(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION euclidean(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'euclidean';


ALTER FUNCTION public.euclidean(text, text) OWNER TO postgres;

--
-- Name: euclidean_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION euclidean_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'euclidean_op';


ALTER FUNCTION public.euclidean_op(text, text) OWNER TO postgres;

--
-- Name: gin_extract_query_token(internal, internal, smallint, internal, internal, internal, internal); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION gin_extract_query_token(internal, internal, smallint, internal, internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'gin_extract_query_token';


ALTER FUNCTION public.gin_extract_query_token(internal, internal, smallint, internal, internal, internal, internal) OWNER TO postgres;

--
-- Name: gin_extract_value_token(internal, internal, internal); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION gin_extract_value_token(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'gin_extract_value_token';


ALTER FUNCTION public.gin_extract_value_token(internal, internal, internal) OWNER TO postgres;

--
-- Name: gin_token_consistent(internal, smallint, internal, integer, internal, internal, internal, internal); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION gin_token_consistent(internal, smallint, internal, integer, internal, internal, internal, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'gin_token_consistent';


ALTER FUNCTION public.gin_token_consistent(internal, smallint, internal, integer, internal, internal, internal, internal) OWNER TO postgres;

--
-- Name: hamming(bit varying, bit varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION hamming(bit varying, bit varying) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'hamming';


ALTER FUNCTION public.hamming(bit varying, bit varying) OWNER TO postgres;

--
-- Name: hamming_op(bit varying, bit varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION hamming_op(bit varying, bit varying) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'hamming_op';


ALTER FUNCTION public.hamming_op(bit varying, bit varying) OWNER TO postgres;

--
-- Name: hamming_text(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION hamming_text(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'hamming_text';


ALTER FUNCTION public.hamming_text(text, text) OWNER TO postgres;

--
-- Name: hamming_text_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION hamming_text_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'hamming_text_op';


ALTER FUNCTION public.hamming_text_op(text, text) OWNER TO postgres;

--
-- Name: jaccard(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION jaccard(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'jaccard';


ALTER FUNCTION public.jaccard(text, text) OWNER TO postgres;

--
-- Name: jaccard_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION jaccard_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'jaccard_op';


ALTER FUNCTION public.jaccard_op(text, text) OWNER TO postgres;

--
-- Name: jaro(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION jaro(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'jaro';


ALTER FUNCTION public.jaro(text, text) OWNER TO postgres;

--
-- Name: jaro_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION jaro_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'jaro_op';


ALTER FUNCTION public.jaro_op(text, text) OWNER TO postgres;

--
-- Name: jarowinkler(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION jarowinkler(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'jarowinkler';


ALTER FUNCTION public.jarowinkler(text, text) OWNER TO postgres;

--
-- Name: jarowinkler_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION jarowinkler_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'jarowinkler_op';


ALTER FUNCTION public.jarowinkler_op(text, text) OWNER TO postgres;

--
-- Name: lev(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION lev(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'lev';


ALTER FUNCTION public.lev(text, text) OWNER TO postgres;

--
-- Name: lev_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION lev_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'lev_op';


ALTER FUNCTION public.lev_op(text, text) OWNER TO postgres;

--
-- Name: levslow(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION levslow(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'levslow';


ALTER FUNCTION public.levslow(text, text) OWNER TO postgres;

--
-- Name: levslow_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION levslow_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'levslow_op';


ALTER FUNCTION public.levslow_op(text, text) OWNER TO postgres;

--
-- Name: matchingcoefficient(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION matchingcoefficient(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'matchingcoefficient';


ALTER FUNCTION public.matchingcoefficient(text, text) OWNER TO postgres;

--
-- Name: matchingcoefficient_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION matchingcoefficient_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'matchingcoefficient_op';


ALTER FUNCTION public.matchingcoefficient_op(text, text) OWNER TO postgres;

--
-- Name: mongeelkan(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION mongeelkan(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'mongeelkan';


ALTER FUNCTION public.mongeelkan(text, text) OWNER TO postgres;

--
-- Name: mongeelkan_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION mongeelkan_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'mongeelkan_op';


ALTER FUNCTION public.mongeelkan_op(text, text) OWNER TO postgres;

--
-- Name: needlemanwunsch(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION needlemanwunsch(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'needlemanwunsch';


ALTER FUNCTION public.needlemanwunsch(text, text) OWNER TO postgres;

--
-- Name: needlemanwunsch_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION needlemanwunsch_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'needlemanwunsch_op';


ALTER FUNCTION public.needlemanwunsch_op(text, text) OWNER TO postgres;

--
-- Name: overlapcoefficient(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION overlapcoefficient(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'overlapcoefficient';


ALTER FUNCTION public.overlapcoefficient(text, text) OWNER TO postgres;

--
-- Name: overlapcoefficient_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION overlapcoefficient_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'overlapcoefficient_op';


ALTER FUNCTION public.overlapcoefficient_op(text, text) OWNER TO postgres;

--
-- Name: qgram(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION qgram(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'qgram';


ALTER FUNCTION public.qgram(text, text) OWNER TO postgres;

--
-- Name: qgram_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION qgram_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'qgram_op';


ALTER FUNCTION public.qgram_op(text, text) OWNER TO postgres;

--
-- Name: smithwaterman(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION smithwaterman(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'smithwaterman';


ALTER FUNCTION public.smithwaterman(text, text) OWNER TO postgres;

--
-- Name: smithwaterman_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION smithwaterman_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'smithwaterman_op';


ALTER FUNCTION public.smithwaterman_op(text, text) OWNER TO postgres;

--
-- Name: smithwatermangotoh(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION smithwatermangotoh(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'smithwatermangotoh';


ALTER FUNCTION public.smithwatermangotoh(text, text) OWNER TO postgres;

--
-- Name: smithwatermangotoh_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION smithwatermangotoh_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'smithwatermangotoh_op';


ALTER FUNCTION public.smithwatermangotoh_op(text, text) OWNER TO postgres;

--
-- Name: soundex(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION soundex(text, text) RETURNS double precision
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/pg_similarity', 'soundex';


ALTER FUNCTION public.soundex(text, text) OWNER TO postgres;

--
-- Name: soundex_op(text, text); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION soundex_op(text, text) RETURNS boolean
    LANGUAGE c STABLE STRICT
    AS '$libdir/pg_similarity', 'soundex_op';


ALTER FUNCTION public.soundex_op(text, text) OWNER TO postgres;

--
-- Name: ~!!; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~!! (
    PROCEDURE = euclidean_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~!!,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~!! (text, text) OWNER TO postgres;

--
-- Name: ~!~; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~!~ (
    PROCEDURE = smithwatermangotoh_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~!~,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~!~ (text, text) OWNER TO postgres;

--
-- Name: ~##; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~## (
    PROCEDURE = cosine_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~##,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~## (text, text) OWNER TO postgres;

--
-- Name: ~#~; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~#~ (
    PROCEDURE = needlemanwunsch_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~#~,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~#~ (text, text) OWNER TO postgres;

--
-- Name: ~%%; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~%% (
    PROCEDURE = jaro_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~%%,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~%% (text, text) OWNER TO postgres;

--
-- Name: ~**; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~** (
    PROCEDURE = overlapcoefficient_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~**,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~** (text, text) OWNER TO postgres;

--
-- Name: ~*~; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~*~ (
    PROCEDURE = soundex_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~*~,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~*~ (text, text) OWNER TO postgres;

--
-- Name: ~++; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~++ (
    PROCEDURE = block_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~++,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~++ (text, text) OWNER TO postgres;

--
-- Name: ~-~; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~-~ (
    PROCEDURE = dice_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~-~,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~-~ (text, text) OWNER TO postgres;

--
-- Name: ~==; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~== (
    PROCEDURE = lev_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~==,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~== (text, text) OWNER TO postgres;

--
-- Name: ~=~; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~=~ (
    PROCEDURE = smithwaterman_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~=~,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~=~ (text, text) OWNER TO postgres;

--
-- Name: ~??; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~?? (
    PROCEDURE = jaccard_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~??,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~?? (text, text) OWNER TO postgres;

--
-- Name: ~@@; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~@@ (
    PROCEDURE = jarowinkler_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~@@,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~@@ (text, text) OWNER TO postgres;

--
-- Name: ~@~; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~@~ (
    PROCEDURE = hamming_text_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~@~,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~@~ (text, text) OWNER TO postgres;

--
-- Name: ~^^; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~^^ (
    PROCEDURE = matchingcoefficient_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~^^,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~^^ (text, text) OWNER TO postgres;

--
-- Name: ~||; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~|| (
    PROCEDURE = mongeelkan_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~||,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~|| (text, text) OWNER TO postgres;

--
-- Name: ~~~; Type: OPERATOR; Schema: public; Owner: postgres
--

CREATE OPERATOR ~~~ (
    PROCEDURE = qgram_op,
    LEFTARG = text,
    RIGHTARG = text,
    COMMUTATOR = ~~~,
    RESTRICT = contsel,
    JOIN = contjoinsel
);


ALTER OPERATOR public.~~~ (text, text) OWNER TO postgres;

--
-- Name: gin_similarity_ops; Type: OPERATOR CLASS; Schema: public; Owner: postgres
--

CREATE OPERATOR CLASS gin_similarity_ops
    FOR TYPE text USING gin AS
    OPERATOR 1 ~++(text,text) ,
    OPERATOR 2 ~##(text,text) ,
    OPERATOR 3 ~-~(text,text) ,
    OPERATOR 4 ~!!(text,text) ,
    OPERATOR 5 ~??(text,text) ,
    OPERATOR 9 ~^^(text,text) ,
    OPERATOR 12 ~**(text,text) ,
    OPERATOR 13 ~~~(text,text) ,
    FUNCTION 1 bttextcmp(text,text) ,
    FUNCTION 2 gin_extract_value_token(internal,internal,internal) ,
    FUNCTION 3 gin_extract_query_token(internal,internal,smallint,internal,internal,internal,internal) ,
    FUNCTION 4 gin_token_consistent(internal,smallint,internal,integer,internal,internal,internal,internal);


ALTER OPERATOR CLASS public.gin_similarity_ops USING gin OWNER TO postgres;

--
-- Name: simple_dict; Type: TEXT SEARCH DICTIONARY; Schema: public; Owner: postgres
--

CREATE TEXT SEARCH DICTIONARY simple_dict (
    TEMPLATE = pg_catalog.simple,
    stopwords = 'spanish', accept = 'false' );


ALTER TEXT SEARCH DICTIONARY public.simple_dict OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: departamento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE departamento (
    cod_dep character varying(5) NOT NULL,
    nombre character varying(50),
    cod_fac character varying(3)
);


ALTER TABLE public.departamento OWNER TO postgres;

--
-- Name: palabra; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE palabra (
    id_word integer NOT NULL,
    word character varying(1000)
);


ALTER TABLE public.palabra OWNER TO postgres;

--
-- Name: diccionario_id_word_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE diccionario_id_word_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.diccionario_id_word_seq OWNER TO postgres;

--
-- Name: diccionario_id_word_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE diccionario_id_word_seq OWNED BY palabra.id_word;


--
-- Name: docente; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE docente (
    codocente character varying(20) NOT NULL,
    nombres character varying(100),
    cedula character varying(20),
    nombre character varying(50),
    apellido character varying(50),
    tipo character(1)
);


ALTER TABLE public.docente OWNER TO postgres;

--
-- Name: estudiante; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE estudiante (
    codestudiante character varying(20) NOT NULL,
    apellidos character varying(50),
    programa character varying(10),
    identificacion character varying(20),
    fecha_grado date,
    nombres character varying(100)
);


ALTER TABLE public.estudiante OWNER TO postgres;

--
-- Name: facultad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE facultad (
    cod_fac character varying(3) NOT NULL,
    nombre character varying(50)
);


ALTER TABLE public.facultad OWNER TO postgres;

--
-- Name: keyword; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE keyword (
    id integer NOT NULL,
    palabra character varying(1000),
    id_tg integer
);


ALTER TABLE public.keyword OWNER TO postgres;

--
-- Name: id_keyword_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE id_keyword_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.id_keyword_id_seq OWNER TO postgres;

--
-- Name: id_keyword_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE id_keyword_id_seq OWNED BY keyword.id;


--
-- Name: lineainvestigacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE lineainvestigacion (
    codigo_linea character varying(2) NOT NULL,
    descripcion character varying(1000),
    cod_dep character varying(5),
    nombre character varying(100)
);


ALTER TABLE public.lineainvestigacion OWNER TO postgres;

--
-- Name: modalidad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE modalidad (
    modalidad character varying(100) NOT NULL,
    cod_modalidad character varying(2) NOT NULL,
    cod_dep character varying(5)
);


ALTER TABLE public.modalidad OWNER TO postgres;

--
-- Name: programa; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE programa (
    cod_prog character varying(10) NOT NULL,
    nombre character varying(100),
    cod_dep character varying(5)
);


ALTER TABLE public.programa OWNER TO postgres;

--
-- Name: significado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE significado (
    id_meaning integer NOT NULL,
    meaning character varying(1000)
);


ALTER TABLE public.significado OWNER TO postgres;

--
-- Name: significado_id_meaning_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE significado_id_meaning_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.significado_id_meaning_seq OWNER TO postgres;

--
-- Name: significado_id_meaning_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE significado_id_meaning_seq OWNED BY significado.id_meaning;


--
-- Name: sinonimo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sinonimo (
    id_word integer NOT NULL,
    id_meaning integer NOT NULL
);


ALTER TABLE public.sinonimo OWNER TO postgres;

--
-- Name: sinonimo_keyword; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE sinonimo_keyword (
    id integer NOT NULL,
    id_word integer NOT NULL
);


ALTER TABLE public.sinonimo_keyword OWNER TO postgres;

--
-- Name: tgasesor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tgasesor (
    id_tg integer NOT NULL,
    codocente character varying(20) NOT NULL
);


ALTER TABLE public.tgasesor OWNER TO postgres;

--
-- Name: tgasesores_id_tg_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tgasesores_id_tg_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tgasesores_id_tg_seq OWNER TO postgres;

--
-- Name: tgasesores_id_tg_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tgasesores_id_tg_seq OWNED BY tgasesor.id_tg;


--
-- Name: tgautor; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tgautor (
    id_tg integer NOT NULL,
    codestudiante character varying(20) NOT NULL,
    calificacion double precision
);


ALTER TABLE public.tgautor OWNER TO postgres;

--
-- Name: tgautores_id_tg_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tgautores_id_tg_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tgautores_id_tg_seq OWNER TO postgres;

--
-- Name: tgautores_id_tg_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tgautores_id_tg_seq OWNED BY tgautor.id_tg;


--
-- Name: tgjurado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tgjurado (
    id_tg integer NOT NULL,
    codocente character varying(20) NOT NULL
);


ALTER TABLE public.tgjurado OWNER TO postgres;

--
-- Name: tgjurados_id_tg_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE tgjurados_id_tg_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tgjurados_id_tg_seq OWNER TO postgres;

--
-- Name: tgjurados_id_tg_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE tgjurados_id_tg_seq OWNED BY tgjurado.id_tg;


--
-- Name: trabajosgrado; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE trabajosgrado (
    id_tg integer NOT NULL,
    sigtopografica character varying(20),
    titulo text,
    resumen text,
    abstract text,
    calificacion double precision,
    fechasustentacion date,
    codigo_linea character varying(2),
    cod_modalidad character varying(2)
);


ALTER TABLE public.trabajosgrado OWNER TO postgres;

--
-- Name: trabajosgrado_id_tg_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE trabajosgrado_id_tg_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.trabajosgrado_id_tg_seq OWNER TO postgres;

--
-- Name: trabajosgrado_id_tg_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE trabajosgrado_id_tg_seq OWNED BY trabajosgrado.id_tg;


--
-- Name: vocabulario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE vocabulario (
    id_palabra integer NOT NULL,
    palabra character varying(100)
);


ALTER TABLE public.vocabulario OWNER TO postgres;

--
-- Name: vocabulario_id_palabra_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE vocabulario_id_palabra_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.vocabulario_id_palabra_seq OWNER TO postgres;

--
-- Name: vocabulario_id_palabra_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE vocabulario_id_palabra_seq OWNED BY vocabulario.id_palabra;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY keyword ALTER COLUMN id SET DEFAULT nextval('id_keyword_id_seq'::regclass);


--
-- Name: id_word; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY palabra ALTER COLUMN id_word SET DEFAULT nextval('diccionario_id_word_seq'::regclass);


--
-- Name: id_meaning; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY significado ALTER COLUMN id_meaning SET DEFAULT nextval('significado_id_meaning_seq'::regclass);


--
-- Name: id_tg; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tgasesor ALTER COLUMN id_tg SET DEFAULT nextval('tgasesores_id_tg_seq'::regclass);


--
-- Name: id_tg; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tgautor ALTER COLUMN id_tg SET DEFAULT nextval('tgautores_id_tg_seq'::regclass);


--
-- Name: id_tg; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tgjurado ALTER COLUMN id_tg SET DEFAULT nextval('tgjurados_id_tg_seq'::regclass);


--
-- Name: id_tg; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY trabajosgrado ALTER COLUMN id_tg SET DEFAULT nextval('trabajosgrado_id_tg_seq'::regclass);


--
-- Name: id_palabra; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY vocabulario ALTER COLUMN id_palabra SET DEFAULT nextval('vocabulario_id_palabra_seq'::regclass);


--
-- Name: asesores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY docente
    ADD CONSTRAINT asesores_pkey PRIMARY KEY (codocente);


--
-- Name: departamento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (cod_dep);


--
-- Name: diccionario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY palabra
    ADD CONSTRAINT diccionario_pkey PRIMARY KEY (id_word);


--
-- Name: estudiantes_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY estudiante
    ADD CONSTRAINT estudiantes_pkey PRIMARY KEY (codestudiante);


--
-- Name: facultad_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY facultad
    ADD CONSTRAINT facultad_pkey PRIMARY KEY (cod_fac);


--
-- Name: id_keyword_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY keyword
    ADD CONSTRAINT id_keyword_pkey PRIMARY KEY (id);


--
-- Name: pk_linea; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY lineainvestigacion
    ADD CONSTRAINT pk_linea PRIMARY KEY (codigo_linea);


--
-- Name: pkmod; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY modalidad
    ADD CONSTRAINT pkmod PRIMARY KEY (cod_modalidad);


--
-- Name: programa_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY programa
    ADD CONSTRAINT programa_pkey PRIMARY KEY (cod_prog);


--
-- Name: significado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY significado
    ADD CONSTRAINT significado_pkey PRIMARY KEY (id_meaning);


--
-- Name: sinonimos_keywords_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sinonimo_keyword
    ADD CONSTRAINT sinonimos_keywords_pkey PRIMARY KEY (id, id_word);


--
-- Name: sinonimos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY sinonimo
    ADD CONSTRAINT sinonimos_pkey PRIMARY KEY (id_word, id_meaning);


--
-- Name: tgasesores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tgasesor
    ADD CONSTRAINT tgasesores_pkey PRIMARY KEY (id_tg, codocente);


--
-- Name: tgautores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tgautor
    ADD CONSTRAINT tgautores_pkey PRIMARY KEY (id_tg, codestudiante);


--
-- Name: tgjurados_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tgjurado
    ADD CONSTRAINT tgjurados_pkey PRIMARY KEY (id_tg, codocente);


--
-- Name: trabajosgrado_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY trabajosgrado
    ADD CONSTRAINT trabajosgrado_pkey PRIMARY KEY (id_tg);


--
-- Name: vocabulario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY vocabulario
    ADD CONSTRAINT vocabulario_pkey PRIMARY KEY (id_palabra);


--
-- Name: fki_dsl; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_dsl ON tgasesor USING btree (codocente);


--
-- Name: fki_ffkmod; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_ffkmod ON trabajosgrado USING btree (cod_modalidad);


--
-- Name: fki_fk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_fk ON tgjurado USING btree (codocente);


--
-- Name: fki_fkDepar; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX "fki_fkDepar" ON lineainvestigacion USING btree (cod_dep);


--
-- Name: fki_fkModa; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX "fki_fkModa" ON modalidad USING btree (cod_dep);


--
-- Name: fki_fke; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_fke ON tgautor USING btree (codestudiante);


--
-- Name: fki_fkmoddep; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_fkmoddep ON modalidad USING btree (cod_dep);


--
-- Name: fki_kk1; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_kk1 ON estudiante USING btree (programa);


--
-- Name: fki_linea; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_linea ON lineainvestigacion USING btree (cod_dep);


--
-- Name: i; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX i ON departamento USING btree (cod_fac);


--
-- Name: departamento_cod_fac_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY departamento
    ADD CONSTRAINT departamento_cod_fac_fkey FOREIGN KEY (cod_fac) REFERENCES facultad(cod_fac);


--
-- Name: estudiante_programa_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estudiante
    ADD CONSTRAINT estudiante_programa_fkey FOREIGN KEY (programa) REFERENCES programa(cod_prog);


--
-- Name: ffkmod; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY trabajosgrado
    ADD CONSTRAINT ffkmod FOREIGN KEY (cod_modalidad) REFERENCES modalidad(cod_modalidad);


--
-- Name: fke; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tgautor
    ADD CONSTRAINT fke FOREIGN KEY (codestudiante) REFERENCES estudiante(codestudiante);


--
-- Name: keyword_id_tg_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY keyword
    ADD CONSTRAINT keyword_id_tg_fkey FOREIGN KEY (id_tg) REFERENCES trabajosgrado(id_tg);


--
-- Name: lineainvestigacion_cod_dep_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY lineainvestigacion
    ADD CONSTRAINT lineainvestigacion_cod_dep_fkey FOREIGN KEY (cod_dep) REFERENCES departamento(cod_dep);


--
-- Name: modalidad_cod_dep_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY modalidad
    ADD CONSTRAINT modalidad_cod_dep_fkey FOREIGN KEY (cod_dep) REFERENCES departamento(cod_dep);


--
-- Name: modalidad_cod_dep_fkey1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY modalidad
    ADD CONSTRAINT modalidad_cod_dep_fkey1 FOREIGN KEY (cod_dep) REFERENCES departamento(cod_dep);


--
-- Name: programa_cod_dep_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY programa
    ADD CONSTRAINT programa_cod_dep_fkey FOREIGN KEY (cod_dep) REFERENCES departamento(cod_dep);


--
-- Name: sinonimo_keyword_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sinonimo_keyword
    ADD CONSTRAINT sinonimo_keyword_id_fkey FOREIGN KEY (id) REFERENCES keyword(id);


--
-- Name: sinonimo_keyword_id_word_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sinonimo_keyword
    ADD CONSTRAINT sinonimo_keyword_id_word_fkey FOREIGN KEY (id_word) REFERENCES palabra(id_word);


--
-- Name: sinonimos_id_meaning_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sinonimo
    ADD CONSTRAINT sinonimos_id_meaning_fkey FOREIGN KEY (id_meaning) REFERENCES significado(id_meaning);


--
-- Name: sinonimos_id_word_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY sinonimo
    ADD CONSTRAINT sinonimos_id_word_fkey FOREIGN KEY (id_word) REFERENCES palabra(id_word);


--
-- Name: tgasesor_codocente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tgasesor
    ADD CONSTRAINT tgasesor_codocente_fkey FOREIGN KEY (codocente) REFERENCES docente(codocente);


--
-- Name: tgasesor_id_tg_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tgasesor
    ADD CONSTRAINT tgasesor_id_tg_fkey FOREIGN KEY (id_tg) REFERENCES trabajosgrado(id_tg);


--
-- Name: tgautor_id_tg_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tgautor
    ADD CONSTRAINT tgautor_id_tg_fkey FOREIGN KEY (id_tg) REFERENCES trabajosgrado(id_tg);


--
-- Name: tgjurado_codocente_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tgjurado
    ADD CONSTRAINT tgjurado_codocente_fkey FOREIGN KEY (codocente) REFERENCES docente(codocente);


--
-- Name: tgjurado_id_tg_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY tgjurado
    ADD CONSTRAINT tgjurado_id_tg_fkey FOREIGN KEY (id_tg) REFERENCES trabajosgrado(id_tg);


--
-- Name: trabajosgrado_codigo_linea_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY trabajosgrado
    ADD CONSTRAINT trabajosgrado_codigo_linea_fkey FOREIGN KEY (codigo_linea) REFERENCES lineainvestigacion(codigo_linea);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

