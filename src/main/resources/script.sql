
-- 示例sql

-- auto-generated definition
create table user
(
  id         int(11) unsigned auto_increment
    primary key,
  username   varchar(30) default ''              not null
  comment '用户名',
  email      varchar(50) default ''              not null
  comment '邮箱',
  phone      char(11)                            null
  comment '用户手机号',
  avatar     varchar(128) default ''             not null
  comment '头像',
  status     tinyint default '1'                 not null
  comment '状态',
  role       varchar(30) default ''              not null
  comment '角色',
  gmt_create timestamp default CURRENT_TIMESTAMP not null,
  gmt_update timestamp default CURRENT_TIMESTAMP not null
  on update CURRENT_TIMESTAMP
);



-- auto-generated definition
create table user_auth
(
  id                int auto_increment
    primary key,
  uid               int                                 not null
  comment '用户id',
  identity_type     tinyint default '1'                 not null
  comment '授权类型',
  identifier        varchar(30) default ''              not null
  comment '授权标识id',
  credential        varchar(128)                        null
  comment '授权秘钥或token',
  credential_expire datetime default CURRENT_TIMESTAMP  not null
  on update CURRENT_TIMESTAMP
  comment 'token过期时间',
  status            tinyint default '1'                 not null
  comment '状态字段',
  gmt_create        timestamp default CURRENT_TIMESTAMP not null
  comment '创建时间',
  gmt_update        timestamp default CURRENT_TIMESTAMP not null
  comment '更新时间',
  constraint unx_uid
  unique (uid, identity_type)
)
  comment '用户授权表';

create index idx_identifier
  on user_auth (identifier);

