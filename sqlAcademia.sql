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
[tempo] INT NULL,
[email] VARCHAR (40) NULL,
[peso] FLOAT (5) NULL,
[altura] FLOAT (5) NULL,
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
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('PranchaFacil', 4, 5, 2, 1)
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('AgachamentoFacil', 3, 2, 2, 1)
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('Leg 45ºFacil', 15, 3, 1, 1)
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('Corrida EstacionadaFacil', 7, 3, 1, 2)

insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('PranchaMedio', 9, 6, 2, 1)
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('AgachamentoMedio', 8, 3, 2, 1)
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('Leg 45ºMedio', 20, 3, 2, 1)
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('Corrida EstacionadaMedio', 13, 4, 1, 2)

insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('PranchaDificil', 14, 7, 2, 1)
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('AgachamentoDificil', 13, 4, 2, 1)
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('Leg 45ºDificil', 25, 5, 1, 1)
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('Corrida EstacionadaDificil', 18, 5, 1, 2)

insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('AgachamentoPadrao', 1, 1, 2, 1)
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('Leg 45ºPadrao',1, 1, 1, 1)
insert into Exercicios([nome], [quantVezes], [sessoes], [idAmbiente], [idObjetivo]) values ('Corrida EstacionadaPadrao', 1, 1, 1, 2)





--5 USUÁRIO
insert into Usuario([nome], [idade], [tempo], [email], [peso],[altura], [senha], [imagem], [idGenero], [idObjetivo]) values ('Valentina', 18, 1,'bestiuys@gmail.com', '65.6','1.6', 'senhablu', 'null', 1, 1 ) 


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

Select * from Usuario where email = 'dsada@gmail.com'
DELETE FROM Usuario WHERE idConta =1

drop table Exercicios

SELECT DISTINCT nome FROM Exercicios where nome like '%Padrao%'
