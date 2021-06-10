create table book
(
    number     char(50) charset utf8 not null
        primary key,
    bname      char(50) charset utf8 null,
    bauthor    char(50) charset utf8 null,
    bpublisher char(50) charset utf8 null,
    bprice     float default 0       null
);

create table user
(
    username char(20) charset utf8 default '' not null
        primary key,
    password char(20) charset utf8            null
);


