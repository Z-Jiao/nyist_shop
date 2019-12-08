create table t_college
(
   college_id           varchar(40) not null,
   college_name         varchar(40),
   primary key (college_id)
);

/*==============================================================*/
/* Table: t_major                                               */
/*==============================================================*/
create table t_major
(
   college_id           varchar(40),
   major_id             varchar(40) not null,
   major_name           varchar(40),
   primary key (major_id)
);

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   varchar(40),
   name                 varchar(50),
   work_id              varchar(20) not null,
   password             varchar(255),
   sex                  varchar(4),
   age                  int(4),
   number               varchar(20),
   major_id             varchar(40),
   email                varchar(40),
   avatar               varchar(255),
   out_time             varchar(40),
   create_time          varchar(40),
   state                int(2),
   primary key (work_id)
);


alter table t_major add constraint FK_Reference_2 foreign key (college_id)
      references t_college (college_id) on delete restrict on update restrict;

alter table t_user add constraint FK_Reference_3 foreign key (major_id)
      references t_major (major_id) on delete restrict on update restrict;
