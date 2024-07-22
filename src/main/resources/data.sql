alter table public.BATTLE alter Column id INT auto_increment;

insert into public.BATTLE (id,startTime,endTime) values
    (001,'2024-08-13 12:00:05','2024-08-13 13:00:00'),
    (002, '2024-09-01 08:15:00','2024-09-01 10:00:00'),
    (003,'2024-10-01 11:40:00', '2024-10-01 13:30:00');

insert into public.ITEMS (id,name,description,category) values
    (1,'Potion','Heals 20 HP','Potion'),
    (2,'Super Potion','Heals 50 HP','Potion'),
    (3,'Calcium','Adds up to Special Attack','Vitamin'),
    (4,'Flame Orb', 'Induce Burn Status', 'Orb');


insert into public.PLACE (id,region,gym,city) values
    (1,'Kan','Stone','Azalea'),
    (2,'Joh','Water','Celadon'),
    (3,'Hoe','Eletric','Pallet');

INSERT INTO public.POKEMON (id,name,type,hp,attack,defense,speed) VALUES
    (004,'Charmander','Fir',39,52,43,65),
    (024,'Pikachu','Ele',35,55,40,90),
    (007,'Squirtle','Wat',44,48,65,43);

INSERT INTO public.TRAINER (id,firstName,secondName,email,password,gender) VALUES
    (1,'John','Smith','JohnSmith@edu.com','johsmi','M'),
    (2,'Steve','Man','Stevee@uol.eu','creeper','P');