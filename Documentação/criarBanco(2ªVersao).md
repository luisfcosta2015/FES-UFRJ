# Script de criacao e populacao de um banco ficticio

## Script
```SQL
DROP DATABASE IF EXISTS Escola_Teste;
CREATE DATABASE Escola_Teste CHARACTER SET utf8 COLLATE utf8_general_ci;

DROP TABLE IF EXISTS Aluno;
DROP TABLE IF EXISTS Avaliacao;
DROP TABLE IF EXISTS Turma;
DROP TABLE IF EXISTS Aluno_Turma;

CREATE TABLE Aluno(
Matricula int(5) PRIMARY KEY,
Nome varchar(50)
);

CREATE TABLE  Turma(
ID_Turma int(5) PRIMARY KEY,
N_Turma varchar(5),
Serie varchar(5)
);

CREATE TABLE Aluno_Turma(
Matricula int(5),
ID_Turma int(5),
Ano varchar(4),
PRIMARY KEY(Matricula, ID_Turma,Ano),
FOREIGN KEY(ID_Turma) REFERENCES Turma (ID_Turma) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY(Matricula) REFERENCES Aluno (Matricula) ON UPDATE CASCADE ON DELETE CASCADE
);



CREATE TABLE Avaliacao(
ID_Ava int(5) PRIMARY KEY,
Matricula int(5),
Nota1 double ,
Nota2 double ,
Nota3 double ,
Disciplina varchar(50),
FOREIGN KEY(Matricula) REFERENCES Aluno (Matricula) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Aluno VALUES(1,'Ducca Martins');

INSERT INTO Aluno VALUES(2,'Lucas Pampazzo');

INSERT INTO Avaliacao VALUES(1,1,4.5,7.5,7.4,'Matemática');

INSERT INTO Avaliacao VALUES(2,1,4.5,7.5,7.4,'Biologia');

INSERT INTO Avaliacao VALUES(3,1,4.5,7.5,7.4,'Português');

INSERT INTO Avaliacao VALUES(4,1,5.5,8.3,9.2,'Quimica');

INSERT INTO Avaliacao VALUES(5,1,5.1,9.5,3.4,'Fisica');

INSERT INTO Avaliacao VALUES(6,1,3.5,6.3,4.1,'Geometria');

INSERT INTO Avaliacao VALUES(7,2,10,9,8.9,'Matemática');

INSERT INTO Avaliacao VALUES(8,2,4,1,7.3,'Biologia');

INSERT INTO Avaliacao VALUES(9,2,7.5,3,10,'Português');

INSERT INTO Avaliacao VALUES(10,2,5.9,8.2,9.5,'Quimica');

INSERT INTO Avaliacao VALUES(11,2,0,1.5,2.4,'Fisica');

INSERT INTO Avaliacao VALUES(12,2,7.5,4.3,9.1,'Geometria');

INSERT INTO Turma VALUES(1,'801','8ª');

INSERT INTO Aluno_Turma VALUES(1,1,'2018');

INSERT INTO Aluno_Turma VALUES (2,1,'2018');



