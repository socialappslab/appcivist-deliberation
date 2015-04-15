# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table comment (
  comment_id                bigint not null,
  comment                   varchar(255) not null,
  comment_date              timestamp not null,
  constraint pk_comment primary key (comment_id))
;

create table external_resource (
  ext_res_id                varchar(255) not null,
  ext_res_link              varchar(255) not null,
  ext_res_alias             varchar(255),
  ext_res_type              integer not null,
  constraint ck_external_resource_ext_res_type check (ext_res_type in (0,1,2,3,4)),
  constraint pk_external_resource primary key (ext_res_id))
;

create table tag (
  tag_name                  varchar(255) not null,
  tag_type                  integer not null,
  constraint ck_tag_tag_type check (tag_type in (0,1,2,3)),
  constraint pk_tag primary key (tag_name))
;

create table appCivistUser (
  user_id                   bigint not null,
  user_name                 varchar(255),
  user_picture              varchar(255),
  constraint pk_appCivistUser primary key (user_id))
;


create table comment_tag (
  comment_comment_id             bigint not null,
  tag_tag_name                   varchar(255) not null,
  constraint pk_comment_tag primary key (comment_comment_id, tag_tag_name))
;

create table comment_external_resource (
  comment_comment_id             bigint not null,
  external_resource_ext_res_id   varchar(255) not null,
  constraint pk_comment_external_resource primary key (comment_comment_id, external_resource_ext_res_id))
;

create table appCivistUser_comment (
  appCivistUser_user_id          bigint not null,
  comment_comment_id             bigint not null,
  constraint pk_appCivistUser_comment primary key (appCivistUser_user_id, comment_comment_id))
;
create sequence comment_seq;

create sequence external_resource_seq;

create sequence tag_seq;

create sequence appCivistUser_seq;




alter table comment_tag add constraint fk_comment_tag_comment_01 foreign key (comment_comment_id) references comment (comment_id);

alter table comment_tag add constraint fk_comment_tag_tag_02 foreign key (tag_tag_name) references tag (tag_name);

alter table comment_external_resource add constraint fk_comment_external_resource__01 foreign key (comment_comment_id) references comment (comment_id);

alter table comment_external_resource add constraint fk_comment_external_resource__02 foreign key (external_resource_ext_res_id) references external_resource (ext_res_id);

alter table appCivistUser_comment add constraint fk_appCivistUser_comment_appC_01 foreign key (appCivistUser_user_id) references appCivistUser (user_id);

alter table appCivistUser_comment add constraint fk_appCivistUser_comment_comm_02 foreign key (comment_comment_id) references comment (comment_id);

# --- !Downs

drop table if exists comment cascade;

drop table if exists comment_tag cascade;

drop table if exists comment_external_resource cascade;

drop table if exists external_resource cascade;

drop table if exists tag cascade;

drop table if exists appCivistUser cascade;

drop table if exists appCivistUser_comment cascade;

drop sequence if exists comment_seq;

drop sequence if exists external_resource_seq;

drop sequence if exists tag_seq;

drop sequence if exists appCivistUser_seq;

