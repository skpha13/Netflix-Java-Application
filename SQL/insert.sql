insert all
    into SUBSCRIPTIE(subscriptie_id, tip, cost) values (55245,'basic',5)
    into SUBSCRIPTIE(subscriptie_id, tip, cost) values (39959,'standard',10)
    into SUBSCRIPTIE(subscriptie_id, tip, cost) values (94030,'normal',15)
    into SUBSCRIPTIE(subscriptie_id, tip, cost) values (67933,'premium',20)
    into SUBSCRIPTIE(subscriptie_id, tip, cost) values (78477,'ultimate',25)
select 'worked' from dual;

insert all
    into UTILIZATOR(utilizator_id, subscriptie_id, porecla, mail, parola) values (101,55245,'NovaFire','handsomeDaniel@gmail.com','RD_2003')
    into UTILIZATOR(utilizator_id, subscriptie_id, porecla, mail, parola) values (102,55245,'Dingo','din.go@yahoo.com','39hsrda9')
    into UTILIZATOR(utilizator_id, subscriptie_id, porecla, mail, parola) values (103,55245,'Zed999','duncan_thomas@yahoo.com','Zed_MY_life')
    into UTILIZATOR(utilizator_id, subscriptie_id, porecla, mail, parola) values (104,39959,'Lulu','mun.benj@yahoo.com','Aida_2022')
    into UTILIZATOR(utilizator_id, subscriptie_id, porecla, mail, parola) values (105,39959,'Kirby','stepehnson14@gmail.com','kirby1306')
    into UTILIZATOR(utilizator_id, subscriptie_id, porecla, mail, parola) values (106,39959,'Joshuuuuua','josh.h@gmail.com','netflixPassword')
    into UTILIZATOR(utilizator_id, subscriptie_id, porecla, mail, parola) values (107,39959,'happydog1234','happy.dog123@yahoo.com','dogggsAREsweet')
    into UTILIZATOR(utilizator_id, subscriptie_id, porecla, mail, parola) values (108,67933,'RoninHack','martin_net@yahoo.com','genshin001')
    into UTILIZATOR(utilizator_id, subscriptie_id, porecla, mail, parola) values (109,67933,'Matoka26','avaiscool@gmail.com','Mihai1234568')
    into UTILIZATOR(utilizator_id, subscriptie_id, porecla, mail, parola) values (110,78477,'skpha','ray.ana@gmail.com','VulturViteaz')
select 'worked' from dual;

insert all
    into FILM(film_id, denumire, nota, data_aparitie) VALUES (1, 'The Shawshank Redemption', 9.3, '14/09/1994')
    into FILM(film_id, denumire, nota, data_aparitie) VALUES (2, 'The Godfather', 9.2, '24/03/1972')
    into FILM(film_id, denumire, nota, data_aparitie) VALUES (3, 'The Dark Knight', 9.0, '14/07/2008')
    into FILM(film_id, denumire, nota, data_aparitie) VALUES (4, 'Schindler''s List', 8.9, '30/11/1993') -- 2 '' pentru a avea doar unul
    into FILM(film_id, denumire, nota, data_aparitie) VALUES (5, 'The Lord of the Rings: The Return of the King', 8.9, '17/12/2003')
    into FILM(film_id, denumire, nota, data_aparitie) VALUES (6, 'Pulp Fiction', 8.9, '21/05/1994')
    into FILM(film_id, denumire, nota, data_aparitie) VALUES (7, 'The Good, the Bad and the Ugly', 8.8, '23/12/1966')
    into FILM(film_id, denumire, nota, data_aparitie) VALUES (8, 'Fight Club', 8.8, '15/10/1999')
    into FILM(film_id, denumire, nota, data_aparitie) VALUES (9, 'Forrest Gump', 8.8, '06/07/1994')
    into FILM(film_id, denumire, nota, data_aparitie) VALUES (10, 'Inception', 8.7, '13/07/2010')
select 'worked' from dual;

insert all
    into SERIAL(serial_id, denumire, nota, data_aparitie) VALUES (1, 'Breaking Bad', 9.5, '20/01/2008')
    into SERIAL(serial_id, denumire, nota, data_aparitie) VALUES (2, 'Game of Thrones', 9.3, '17/04/2011')
    into SERIAL(serial_id, denumire, nota, data_aparitie) VALUES (3, 'The Office', 8.9, '24/03/2005')
    into SERIAL(serial_id, denumire, nota, data_aparitie) VALUES (4, 'Stranger Things', 8.8, '15/07/2016')
    into SERIAL(serial_id, denumire, nota, data_aparitie) VALUES (5, 'Narcos', 8.6, '28/08/2015')
select 'worked' from dual;

insert all
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (1,1,'Pilot',1,58)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (2,1,'Cat''s in the bag...',2,48)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (3,1,'...And the Bag''s in the river',3,47)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (4,2,'Winter Is Coming',1,60)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (5,2,'The Kingsroad',2,56)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (6,2,'Lord Snow',3,58)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (7,2,'Cripples, Bastards, and Broken Things',4,54)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (8,2,'The Wolf and the Lion',5,55)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (9,3,'Pilot',1,22)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (10,3,'Diversity Day',2,23)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (11,4,'Chapter One: The Vanishing of Will Byers',1,48)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (12,4,'Chapter Two: The Weirdo on Maple Street',2,55)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (13,4,'Chapter Three: Holly, Jolly',3,51)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (14,4,'Chapter Four: The Body',4,58)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (15,5,'Descenso',1,57)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (16,5,'The Sword of Simón Bolivar',2,50)
    into EPISOD(episod_id, serial_id, denumire, numar, durata) VALUES (17,5,'The Men of Always',3,46)
select 'worked' from dual;

    -- SUBSCRIPTIE_SERIAL --
insert into SUBSCRIPTIE_SERIAL(subscriptie_serial_id, serial_id, subscriptie_id) VALUES (INCREMENTARE_SERIAL.nextval,5,39959);
insert into SUBSCRIPTIE_SERIAL(subscriptie_serial_id, serial_id, subscriptie_id) VALUES (INCREMENTARE_SERIAL.nextval,4,39959);

insert into SUBSCRIPTIE_SERIAL(subscriptie_serial_id, serial_id, subscriptie_id) VALUES (INCREMENTARE_SERIAL.nextval,5,94030);
insert into SUBSCRIPTIE_SERIAL(subscriptie_serial_id, serial_id, subscriptie_id) VALUES (INCREMENTARE_SERIAL.nextval,4,94030);
insert into SUBSCRIPTIE_SERIAL(subscriptie_serial_id, serial_id, subscriptie_id) VALUES (INCREMENTARE_SERIAL.nextval,3,94030);

insert into SUBSCRIPTIE_SERIAL(subscriptie_serial_id, serial_id, subscriptie_id) VALUES (INCREMENTARE_SERIAL.nextval,5,67933);
insert into SUBSCRIPTIE_SERIAL(subscriptie_serial_id, serial_id, subscriptie_id) VALUES (INCREMENTARE_SERIAL.nextval,4,67933);
insert into SUBSCRIPTIE_SERIAL(subscriptie_serial_id, serial_id, subscriptie_id) VALUES (INCREMENTARE_SERIAL.nextval,3,67933);
insert into SUBSCRIPTIE_SERIAL(subscriptie_serial_id, serial_id, subscriptie_id) VALUES (INCREMENTARE_SERIAL.nextval,2,67933);

insert into SUBSCRIPTIE_SERIAL(subscriptie_serial_id, serial_id, subscriptie_id) VALUES (INCREMENTARE_SERIAL.nextval,5,78477);
insert into SUBSCRIPTIE_SERIAL(subscriptie_serial_id, serial_id, subscriptie_id) VALUES (INCREMENTARE_SERIAL.nextval,4,78477);
insert into SUBSCRIPTIE_SERIAL(subscriptie_serial_id, serial_id, subscriptie_id) VALUES (INCREMENTARE_SERIAL.nextval,3,78477);
insert into SUBSCRIPTIE_SERIAL(subscriptie_serial_id, serial_id, subscriptie_id) VALUES (INCREMENTARE_SERIAL.nextval,2,78477);
insert into SUBSCRIPTIE_SERIAL(subscriptie_serial_id, serial_id, subscriptie_id) VALUES (INCREMENTARE_SERIAL.nextval,1,78477);
-- ==========================================================================================================================

    -- SUBSCRIPTIE_FILM --
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,10,55245);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,9,55245);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,8,55245);

insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,10,39959);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,9,39959);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,8,39959);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,7,39959);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,6,39959);

insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,10,94030);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,9,94030);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,8,94030);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,7,94030);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,6,94030);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,5,94030);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,4,94030);

insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,10,67933);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,9,67933);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,8,67933);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,7,67933);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,6,67933);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,5,67933);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,4,67933);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,3,67933);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,2,67933);

insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,10,78477);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,9,78477);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,8,78477);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,7,78477);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,6,78477);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,5,78477);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,4,78477);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,3,78477);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,2,78477);
insert into SUBSCRIPTIE_film(subscriptie_film_id, film_id, subscriptie_id) VALUES (INCREMENTARE_film.nextval,1,78477);
-- =====================================================================================================================