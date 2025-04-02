create table dev_cluster_meta
(
    cluster_name             varchar(256)  not null
        primary key,
    cluster_status           varchar(64)   not null,
    cluster_type             varchar(64)   not null,
    cluster_desc             varchar(1024) null,
    cluster_internal_address varchar(1024) not null,
    cluster_address          varchar(1024) not null,
    gmt_create               datetime      not null,
    gmt_modified             datetime      not null
);

create table dev_index_meta
(
    full_name     varchar(256) not null
        primary key,
    index_name    varchar(256) not null,
    project_name  varchar(256) not null,
    template_name varchar(256) not null,
    legacy        tinyint(1)   not null,
    tags          varchar(256) not null,
    gmt_create    datetime     not null,
    gmt_modified  datetime     not null
);

create table dev_index_template_meta
(
    index_template_name       varchar(256) not null
        primary key,
    project_name              varchar(256) not null,
    alias                     varchar(256) not null,
    auto_index_name_prefix    varchar(256) not null,
    auto_index_rolling_policy varchar(64)  not null,
    auto_index_rolling_window int          not null,
    mappings                  mediumtext   null,
    settings                  mediumtext   null,
    gmt_create                datetime     not null,
    gmt_modified              datetime     not null
);

create table dev_project_meta
(
    project_name    varchar(256)  not null
        primary key,
    cluster_name    varchar(256)  not null,
    project_desc    varchar(1024) null,
    project_setting text          null,
    gmt_create      datetime      not null,
    gmt_modified    datetime      not null
);