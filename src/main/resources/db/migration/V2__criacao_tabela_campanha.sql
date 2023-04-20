create table "opus"."campanha"
(
  id integer constraint campanha_pk primary key not null
, inclusao timestamp not null
, alteracao timestamp
, status integer not null
, nome varchar not null
, nome_empresa varchar not null
, descricao varchar not null
, quantidade_vagas integer default 0
, inicio timestamp not null
, fechamento timestamp not null
, area_interesse varchar
, palavra_chave varchar
, exclusivo_pcd boolean not null default false
, observacao varchar
, bairro_id integer
);

create sequence "opus"."seq_campanha"  minvalue 1 maxvalue 999999999999999 increment by 1 start with 1000;

create table "opus"."vaga"
(
  id integer constraint vaga_pk primary key not null
, inclusao timestamp not null
, alteracao timestamp
, status integer not null
, funcao varchar not null
, salario_min numeric
, salario_max numeric
, campanha_id integer not null
);

alter table "opus"."vaga" add foreign key (campanha_id) references "opus".campanha(id);

create sequence "opus"."seq_vaga"  minvalue 1 maxvalue 999999999999999 increment by 1 start with 1000;

create table "opus"."candidato_contato"
(
  id integer constraint contato_candidato_pk primary key not null
, inclusao timestamp not null
, alteracao timestamp
, status integer not null
, email boolean not null default false
, whatsapp boolean not null default false
, sms boolean not null default false
, mensagem varchar not null
, vaga_id integer not null
);

create sequence "opus"."seq_candidato_contato"  minvalue 1 maxvalue 999999999999999 increment by 1 start with 1000;

alter table "opus"."candidato_contato" add foreign key (vaga_id) references "opus".vaga(id);


create table "opus"."campanha_responsavel"
(
  id integer constraint campanha_responsavel_pk primary key not null
, inclusao timestamp not null
, alteracao timestamp
, status integer not null
, nome varchar
, email varchar
, telefone varchar
, vaga_id integer not null
);

alter table "opus"."campanha_responsavel" add foreign key (vaga_id) references "opus".vaga(id);

create sequence "opus"."seq_campanha_responsavel"  minvalue 1 maxvalue 999999999999999 increment by 1 start with 1000;


create table "opus"."beneficio"
(
  id integer constraint beneficio_pk primary key not null
, inclusao timestamp not null
, alteracao timestamp
, status integer not null
, descricao varchar not null
);

create sequence "opus"."seq_beneficio"  minvalue 1 maxvalue 999999999999999 increment by 1 start with 1000;

create table "opus"."tipo_contracao"
(
  id integer constraint tipo_contracao_pk primary key not null
, inclusao timestamp not null
, alteracao timestamp
, status integer not null
, descricao varchar not null
);

create sequence "opus"."seq_tipo_contracao"  minvalue 1 maxvalue 999999999999999 increment by 1 start with 1000;

create table "opus"."questao"
(
  id integer constraint questao_pk primary key not null
, inclusao timestamp not null
, alteracao timestamp
, status integer not null
, tipo_questao varchar not null
, pergunta varchar not null
, questao varchar not null
, ordem integer not null
);

create sequence "opus"."seq_questao"  minvalue 1 maxvalue 999999999999999 increment by 1 start with 1000;


create table "opus"."idiomas"
(
  id integer constraint idiomas_pk primary key not null
, inclusao timestamp not null
, alteracao timestamp
, status integer not null
, indiferente boolean not null default false
, portugues boolean not null default false
, ingles boolean not null default false
, espanhol boolean not null default false
, frances boolean not null default false
, alemao boolean not null default false
, italiano boolean not null default false
, outros varchar not null
, vaga_id integer not null
);

alter table "opus"."idiomas" add foreign key (vaga_id) references "opus".vaga(id);

create sequence "opus"."seq_idiomas"  minvalue 1 maxvalue 999999999999999 increment by 1 start with 1000;

create table "opus"."nivel_ensino"
(
  id integer constraint nivel_ensino_pk primary key not null
, inclusao timestamp not null
, alteracao timestamp
, status integer not null
, indiferente boolean not null default false
, fundamental boolean not null default false
, tecnico boolean not null default false
, superior boolean not null default false
, vaga_id integer not null
);

alter table "opus"."nivel_ensino" add foreign key (vaga_id) references "opus".vaga(id);

create sequence "opus"."seq_nivel_ensino"  minvalue 1 maxvalue 999999999999999 increment by 1 start with 1000;

create table "opus"."tempo_experiencia"
(
  id integer constraint tempo_experiencia_pk primary key not null
, inclusao timestamp not null
, alteracao timestamp
, status integer not null
, indiferente boolean not null default false
, ate_6meses boolean not null default false
, um_dois_anos boolean not null default false
, tres_quatro_anos boolean not null default false
, cinco_anos boolean not null default false
, vaga_id integer not null
);

alter table "opus"."tempo_experiencia" add foreign key (vaga_id) references "opus".vaga(id);

create sequence "opus"."seq_tempo_experiencia"  minvalue 1 maxvalue 999999999999999 increment by 1 start with 1000;

CREATE TABLE "opus"."estado"( id integer constraint estado_pk primary key not null , inclusao timestamp not null , alteracao timestamp ,
nome varchar not null , codigo varchar not null, id_pais integer );

CREATE TABLE "opus"."cidade"( id integer constraint cidade_pk primary key not null , inclusao timestamp not null , alteracao timestamp ,
nome varchar not null , codigo varchar not null, id_estado integer );

ALTER TABLE "opus"."cidade" ADD FOREIGN KEY (id_estado) REFERENCES "opus".estado(id);

CREATE TABLE "opus"."bairro"( id integer constraint bairro_pk primary key not null , inclusao timestamp not null , alteracao timestamp ,
nome varchar not null , codigo varchar not null, id_estado integer );

ALTER TABLE "opus"."bairro" ADD FOREIGN KEY (id_estado) REFERENCES "opus".estado(id);


create table "opus"."jornada_trabalho"
(
  id integer constraint jornada_trabalho_pk primary key not null
, inclusao timestamp not null
, alteracao timestamp
, status integer not null
, dia_semana varchar not null
, inicio timestamp
, final timestamp
);

create sequence "opus"."seq_jornada_trabalho"  minvalue 1 maxvalue 999999999999999 increment by 1 start with 1000;

create table "opus"."vaga_questao"
(
vaga_id integer not null
, questao_id integer not null
);

create sequence "opus"."seq_vaga_questao"  minvalue 1 maxvalue 999999999999999 increment by 1 start with 1000;

alter table "opus"."vaga_questao" add foreign key (vaga_id) references "opus".vaga(id);
alter table "opus"."vaga_questao" add foreign key (questao_id) references "opus".questao(id);

create table "opus"."vaga_tipo_contracao"
(
vaga_id integer not null
, tipo_contracao_id integer not null
);

create sequence "opus"."seq_vaga_tipo_contracao"  minvalue 1 maxvalue 999999999999999 increment by 1 start with 1000;

alter table "opus"."vaga_tipo_contracao" add foreign key (vaga_id) references "opus".vaga(id);
alter table "opus"."vaga_tipo_contracao" add foreign key (tipo_contracao_id) references "opus".tipo_contracao(id);

create table "opus"."vaga_beneficio"
(
vaga_id integer not null
, beneficio_id integer not null
);

create sequence "opus"."seq_vaga_beneficio"  minvalue 1 maxvalue 999999999999999 increment by 1 start with 1000;

alter table "opus"."vaga_beneficio" add foreign key (vaga_id) references "opus".vaga(id);
alter table "opus"."vaga_beneficio" add foreign key (beneficio_id) references "opus".beneficio(id);

create table "opus"."vaga_jornada_trabalho"
(
vaga_id integer not null
, jornada_trabalho_id integer not null
);

create sequence "opus"."seq_vaga_jornada_trabalho"  minvalue 1 maxvalue 999999999999999 increment by 1 start with 1000;

alter table "opus"."vaga_jornada_trabalho" add foreign key (vaga_id) references "opus".vaga(id);
alter table "opus"."vaga_jornada_trabalho" add foreign key (jornada_trabalho_id) references "opus".jornada_trabalho(id);


