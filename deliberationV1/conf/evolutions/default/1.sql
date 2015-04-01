# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table comment (
  _id                       bigint not null,
  comment                   varchar(255) not null,
  date                      timestamp not null,
  constraint pk_comment primary key (_id))
;

create table external_resource (
  _id                       varchar(255) not null,
  comment__id               bigint not null,
  link                      varchar(255) not null,
  alias                     varchar(255),
  type                      integer not null,
  constraint ck_external_resource_type check (type in (0,1,2,3,4)),
  constraint pk_external_resource primary key (_id))
;

create table tag (
  name                      varchar(255) not null,
  comment__id               bigint not null,
  type                      integer not null,
  constraint ck_tag_type check (type in (0,1,2)),
  constraint pk_tag primary key (name))
;

create table appCivistUser (
  _id                       bigint not null,
  name                      varchar(255),
  picture                   varchar(255),
  constraint pk_appCivistUser primary key (_id))
;

create sequence comment_seq;

create sequence external_resource_seq;

create sequence tag_seq;

create sequence appCivistUser_seq;

alter table external_resource add constraint fk_external_resource_comment_1 foreign key (comment__id) references comment (_id);
create index ix_external_resource_comment_1 on external_resource (comment__id);
alter table tag add constraint fk_tag_comment_2 foreign key (comment__id) references comment (_id);
create index ix_tag_comment_2 on tag (comment__id);



# --- !Downs

drop table if exists comment cascade;

drop table if exists external_resource cascade;

drop table if exists tag cascade;

drop table if exists appCivistUser cascade;

drop sequence if exists comment_seq;

drop sequence if exists external_resource_seq;

drop sequence if exists tag_seq;

drop sequence if exists appCivistUser_seq;

