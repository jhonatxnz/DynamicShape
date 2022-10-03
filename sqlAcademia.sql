-------------------------------TABELAS------------------------------------
--1
create table Genero(
[idGenero] INT PRIMARY KEY NOT NULL identity,
[genero] VARCHAR (10) NULL
)

--5
create table Usuario (
[idConta] INT PRIMARY KEY NOT NULL IDENTITY(1,1),
[nome] VARCHAR (30) NULL,
[idade] INT NULL,
[telefone] VARCHAR (11) NULL,
[email] VARCHAR (40) NULL,
[peso] FLOAT (5) NULL,
[senha] VARCHAR (20),
imagem nvarchar(MAX) NULL,
idGenero int foreign key references Genero(idGenero),
idObjetivo int foreign key references Objetivo(idObjetivo)
)



--2
create table Ambiente(
[idAmbiente] INT PRIMARY KEY NOT NULL identity, 
[local] VARCHAR (9) NULL
)


--3
create table Objetivo(
[idObjetivo] INT PRIMARY KEY NOT NULL identity, 
[objetivo] VARCHAR (15) NULL,
[tempo] FLOAT(10) NULL --ATUALIZAAAAAAAAAAAAAAAAAAAAR
)

--4
create table Exercicios(
[idExercicio] INT PRIMARY KEY NOT NULL identity, 
[nome] VARCHAR (30) NULL,
[quantVezes] CHAR (2) NULL,
[sessoes] CHAR (2) NULL,
idAmbiente int foreign key references Ambiente(idAmbiente),
idObjetivo int foreign key references Objetivo(idObjetivo)
)

-------------------------------SELECT------------------------------------

select * from Exercicios
select * from Usuario
select * from Objetivo
select * from Ambiente
select * from Genero

-------------------------------INSERT------------------------------------
--1 GENERO
insert into Genero ([genero]) values('Masculino')
insert into Genero ([genero]) values('Feminino')

--3 OBJETIVO
insert into Objetivo([objetivo]) values ('Ganhar massa')
insert into Objetivo([objetivo]) values('Perder peso') 

--2 AMBIENTE
insert into Ambiente([local]) values('Academia')
insert into Ambiente([local]) values('Casa')

--4 EXERCICIO
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('Prancha', 4, 5, 2, 1)
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('Agachamento', 3, 2, 2, 1)
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('Leg 45º', 15, 3, 1, 1)
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('Corrida Estacionada', 7, 3, 1, 2)



--5 USUÁRIO
insert into Usuario([nome], [idade], [telefone], [email], [peso], [senha], [imagem], [idGenero], [idObjetivo]) values ('Valentina', 18, '19985874521','bestiuys@gmail.com', '65.6', 'senhablu', 'null', 1, 1 ) 
insert into Usuario([nome], [idade], [telefone], [email], [peso], [senha], [imagem], [idGenero], [idObjetivo]) values ('Jurema', 64, '19987456598','tiajuris@gmail.com', '77.9', 'jurisdj', 'null', 2, 2 ) 
insert into Usuario([nome], [idade], [telefone], [email], [peso], [senha], [imagem], [idGenero], [idObjetivo]) values ('Cleyton', 64, '19984758565','cleytitinhodabm.com', '50', 'cleytinho123', 'null', 1, 2 ) 


--------------
UPDATE Usuario SET [nome]= 'Cleyton',[idade]= 12 WHERE [idConta]=3;
UPDATE Usuario SET [nome] = 'sda',idade = 1,telefone ='1' ,email = 'dsa',peso = 1.2,senha = 'wdas',idGenero = 2,idObjetivo = 2 WHERE idConta = 3
select e.nome 
from 
Exercicios as e,
Usuario as u
where 
u.nome = 'Jurema' and
u.idObjetivo = e.idObjetivo

DELETE FROM Usuario WHERE idConta =1