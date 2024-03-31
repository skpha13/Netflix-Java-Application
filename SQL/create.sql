create table SUBSCRIPTIE (
    subscriptie_id number(6) constraint pk_subscritpie primary key ,
    tip varchar2(20) default 'basic' check ( lower(tip) in ('basic','standard', 'normal', 'premium','ultimate') ) ,
    cost number(2)
);

create table UTILIZATOR (
    utilizator_id number(6) constraint pk_utilizator primary key ,
    subscriptie_id number(6) not null ,
    porecla varchar2(50) constraint porecla_null not null ,
    mail varchar2(255) constraint mail_null not null ,
    parola varchar2(255) constraint parola_null not null,
    constraint fk_subscriptie foreign key (subscriptie_id) references SUBSCRIPTIE(subscriptie_id)
);

create table SERIAL (
    serial_id number(6) constraint pk_serial primary key ,
    denumire varchar2(50) constraint denumire_null not null ,
    nota number(4,2) constraint nota_check check ( nota >= 1 and nota <= 10 ),
    data_aparitie date
);

create table EPISOD (
    episod_id number(6) constraint pk_episod primary key ,
    serial_id number(6) not null ,
    denumire varchar2(50)constraint denumire_episod_null not null ,
    numar number(2),
    durata number(3) constraint durata_null not null ,
    constraint fk_serial foreign key (serial_id) references SERIAL(serial_id)
        on delete cascade
);

create table  SUBSCRIPTIE_SERIAL (
    subscriptie_serial_id number(6) constraint pk_sub_ser primary key ,
    serial_id number(6) not null ,
    subscriptie_id number(6) not null ,
    constraint fk_subscriptie_asoc foreign key (subscriptie_id) references SUBSCRIPTIE(subscriptie_id) ,
    constraint fk_serial_asoc foreign key (serial_id) references SERIAL(serial_id) ,
    CONSTRAINT uk_serial_subscriptie UNIQUE (serial_id, subscriptie_id)
);

create table FILM (
    film_id number(6) constraint pk_film primary key ,
    denumire varchar2(50) constraint denumire_film_null not null ,
    nota number(4,2) constraint nota_film_check check ( nota >= 1 and nota <= 10 ) ,
    data_aparitie date
);

create table SUBSCRIPTIE_FILM (
    subscriptie_film_id number(6) constraint pk_sub_film primary key ,
    film_id number(6) not null ,
    subscriptie_id number(6) not null ,
    constraint fk_subscriptie_asocf foreign key (subscriptie_id) references SUBSCRIPTIE(subscriptie_id) ,
    constraint fk_serial_asocf foreign key (film_id) references FILM(film_id) ,
    CONSTRAINT uk_film_subscriptie UNIQUE (film_id, subscriptie_id)
);

create sequence incrementare_serial
start with 1
increment by 1
minvalue 0
maxvalue 10000
nocycle;

create sequence incrementare_film
start with 1
increment by 1
minvalue 0
maxvalue 10000
nocycle;

drop table SUBSCRIPTIE_FILM;
drop table SUBSCRIPTIE_SERIAL;
drop table FILM;
drop table EPISOD;
drop table SERIAL;
drop table UTILIZATOR;
drop table SUBSCRIPTIE;