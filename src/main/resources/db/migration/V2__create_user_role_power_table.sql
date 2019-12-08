
/*==============================================================*/
/* Table: power                                                 */
/*==============================================================*/
create table power
(
   power_id             varchar(40)                    not null,
   power_mark           varchar(20)                    null,
   constraint PK_POWER primary key clustered (power_id)
);

/*==============================================================*/
/* Table: role                                                  */
/*==============================================================*/
create table role
(
   role_id              varchar(40)                    not null,
   role_name            varchar(40)                    null,
   constraint PK_ROLE primary key clustered (role_id)
);

/*==============================================================*/
/* Table: role_power                                            */
/*==============================================================*/
create table role_power
(
   role_id              varchar(40)                    null,
   power_id             varchar(40)                    null
);

/*==============================================================*/
/* Table: user_role                                             */
/*==============================================================*/
create table user_role
(
   role_id              varchar(40)                    null,
   work_id              varchar(40)                    null
);

alter table role_power
   add constraint FK_ROLE_POW_REFERENCE_ROLE foreign key (role_id)
      references role (role_id)
      on update restrict
      on delete restrict;

alter table role_power
   add constraint FK_ROLE_POW_REFERENCE_POWER foreign key (power_id)
      references power (power_id)
      on update restrict
      on delete restrict;

alter table user_role
   add constraint FK_USER_ROL_REFERENCE_ROLE foreign key (role_id)
      references role (role_id)
      on update restrict
      on delete restrict;

alter table user_role
   add constraint FK_USER_ROL_REFERENCE_T_USER foreign key (work_id)
      references t_user (work_id)
      on update restrict
      on delete restrict;
