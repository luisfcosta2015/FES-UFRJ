CREATE SCHEMA escola;

CREATE TABLE escola.professor (
login INT(6) NOT NULL AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(100) NOT NULL,
turma VARCHAR(3),
materia VARCHAR(30)
);

CREATE TABLE escola.aluno (
matricula INT(6) NOT NULL AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(100) NOT NULL,
dataNascimento date,
local_nascimento VARCHAR (50),
identidade VARCHAR(8),
nomePai VARCHAR(100),
nomeMae VARCHAR(100),
escola VARCHAR(100),
escolaridade VARCHAR(15) default 'Fundamental',
serie VARCHAR(100),
turma VARCHAR(100)
);

CREATE TABLE escola.notas (
alunoMatricula INT(6),
portugues FLOAT(4),
matematica FLOAT(4),
fisica FLOAT(4),
quimica FLOAT(4),
filosofia FLOAT(4),
historia FLOAT(4),
geografia FLOAT(4),
ingles FLOAT(4),
educacao_fisica FLOAT(4),
FOREIGN KEY (alunoMatricula) REFERENCES escola.aluno(matricula)
);

	-- professor (login, nome , turma, materia)
INSERT INTO escola.professor values (login, 'Ricardo'	,'701','portugues');
INSERT INTO escola.professor values (login, 'Trump'	,'701','matematica');
INSERT INTO escola.professor values (login, 'Neymar'	,'701','fisica'	);
INSERT INTO escola.professor values (login, 'Harry'	,'701','quimica');
INSERT INTO escola.professor values (login, 'Hudson'	,'701','filosofia');
INSERT INTO escola.professor values (login, 'Tereza'	,'701','historia');
INSERT INTO escola.professor values (login, 'Potter'	,'701','geografia');
INSERT INTO escola.professor values (login, 'Guito'	,'701','ingles');
INSERT INTO escola.professor values (login, 'Bino'	,'701','educacao_fisica');

INSERT INTO escola.professor values (login, 'Ricardo'	,'801','portugues');
INSERT INTO escola.professor values (login, 'Trump'	,'801','matematica');
INSERT INTO escola.professor values (login, 'Neymar'	,'801','fisica'	);
INSERT INTO escola.professor values (login, 'Harry'	,'801','quimica');
INSERT INTO escola.professor values (login, 'Hudson'	,'801','filosofia');
INSERT INTO escola.professor values (login, 'Tereza'	,'801','historia');
INSERT INTO escola.professor values (login, 'Harry'	,'801','geografia');
INSERT INTO escola.professor values (login, 'Hudson'	,'801','ingles');
INSERT INTO escola.professor values (login, 'Tereza'	,'801','educacao_fisica');

INSERT INTO escola.professor values (login, 'Ricardo'	,'901','portugues');
INSERT INTO escola.professor values (login, 'Trump'	,'901','matematica');
INSERT INTO escola.professor values (login, 'Neymar'	,'901','fisica'	);
INSERT INTO escola.professor values (login, 'Harry'	,'901','quimica');
INSERT INTO escola.professor values (login, 'Hudson'	,'901','filosofia');
INSERT INTO escola.professor values (login, 'Tereza'	,'901','historia');
INSERT INTO escola.professor values (login, 'Harry'	,'901','geografia');
INSERT INTO escola.professor values (login, 'Hudson'	,'901','ingles');
INSERT INTO escola.professor values (login, 'Tereza'	,'901','educacao_fisica');

-- Data de Nascimento = YYYY-MM-DD
-- Inserir valores na tabela aluno(matrícula, nome , data de nascimento,local nasc , identidade, nome pai, nome mae, escola, escolaridade, serie, turma)
INSERT INTO escola.aluno values (matricula, 'Xiao'	,'1995-07-06'	,'Hong Kong'		,'833102-6','Ip Yuang'			,'Fei Man'			,'CIEP II'	,'Fundamental','7 ano','701');
INSERT INTO escola.aluno values (matricula, 'Andre'	,'2006-01-15'	,'Santos'			,'663201-3','Felipe da Silva'		,'Amanda Soares'		,'CIEP II'	,'Fundamental','7 ano','701');
INSERT INTO escola.aluno values (matricula, 'Debora'	,'2006-01-15'	,'Rio de Janeiro'		,'322108-8','Joaquim Queiroz'		,'Fernanda Buarque'	,'CIEP II'	,'Fundamental','7 ano','701');
INSERT INTO escola.aluno values (matricula, 'Gabriel'	,'2006-01-15'	,'Rio de Janeiro'		,'564601-7','Cesar de Oliveira'	,'Aline Vasquez'		,'CIEP II'	,'Fundamental','7 ano','701');
INSERT INTO escola.aluno values (matricula, 'Gustavo'	,'2006-01-15'	,'Duque de Caxias'	,'914562-6','Seleno Borges'		,'Andrea Silva'		,'CIEP II'	,'Fundamental','7 ano','701');
INSERT INTO escola.aluno values (matricula, 'Muniz'	,'2006-01-15'	,'Itaperuna'		,'516234-2','Carlos Cipriano'		,'Adriana May'		,'CIEP II'	,'Fundamental','7 ano','701');
INSERT INTO escola.aluno values (matricula, 'Vinicius','2006-01-15'	,'Angra dos Reis'		,'416285-6','Felipe Jose'		,'Leandra Vasconcelos'	,'CIEP II'	,'Fundamental','7 ano','701');
INSERT INTO escola.aluno values (matricula, 'Michel'	,'2006-01-15'	,'Rio de Janeiro'		,'322542-7','Marcos Telo'		,'Rebeca Soares'		,'CIEP II'	,'Fundamental','7 ano','701');
INSERT INTO escola.aluno values (matricula, 'Irene'	,'2006-01-15'	,'Nova Iguacu'		,'414896-1','Vicente de Carvalho'	,'Larissa Alves'		,'CIEP II'	,'Fundamental','7 ano','701');
INSERT INTO escola.aluno values (matricula, 'Ricardo'	,'2006-01-15'	,'Nova Iguacu'		,'616498-3','Galvao Bueno'		,'Rosa Weber'		,'CIEP II'	,'Fundamental','7 ano','701');
INSERT INTO escola.aluno values (matricula, 'Felipe'	,'2006-01-15'	,'Rio de Janeiro'		,'833352-6','Andre Andreoli'		,'Andressa Filipino'	,'CIEP II'	,'Fundamental','7 ano','701');
INSERT INTO escola.aluno values (matricula, 'Valquiria','2006-02-01'	,'Salvador'			,'147896-4','Anderson Daeneris'	,'Joana Sa'			,'CIEP II'	,'Fundamental','7 ano','701');
INSERT INTO escola.aluno values (matricula, 'Anne'	, '2006-02-01'	,'Frankfurt'		,'753916-3','George Vilbert'		,'Joice Reis'		,'CIEP II'	,'Fundamental','7 ano','701');

INSERT INTO escola.aluno values (matricula, 'Andre'	,'2005-02-20'	,'Duque de Caxias'	,'224462-5','Carlos Pimenta'		,'Felicia Rosa'		,'CIEP II'	,'Fundamental','8 ano','801');
INSERT INTO escola.aluno values (matricula, 'Andre'	,'2005-02-20'	,'Sao Joao de Meriti'	,'284352-9','Cesar Figueiredo'	,'Ana Fonseca'		,'CIEP II'	,'Fundamental','8 ano','801');
INSERT INTO escola.aluno values (matricula, 'Goku'	,'2005-02-20'	,'Vegeta'			,'264451-9','Son Bardock'		,'Gean Kakarot'		,'CIEP II'	,'Fundamental','8 ano','801');
INSERT INTO escola.aluno values (matricula, 'Gohan'	,'2005-02-20'	,'Duque de Caxias'	,'264424-8','Son Goku'			,'Chichi'			,'CIEP II'	,'Fundamental','8 ano','801');
INSERT INTO escola.aluno values (matricula, 'Vegeta'	,'2005-02-20'	,'Rio de Janeiro'		,'231152-6','Vegeta King'		,'Vegeta Queen'		,'CIEP II'	,'Fundamental','8 ano','801');
INSERT INTO escola.aluno values (matricula, 'Trunks'	,'2005-02-20'	,'Rio de Janeiro'		,'268901-3','Vegeta'			,'Bulma'			,'CIEP II'	,'Fundamental','8 ano','801');
INSERT INTO escola.aluno values (matricula, 'Satan'	,'2005-02-20'	,'Duque de Caxias'	,'214601-3','Devil'			,'Shaitan'			,'CIEP II'	,'Fundamental','8 ano','801');
INSERT INTO escola.aluno values (matricula, 'Videl'	,'2005-02-20'	,'Sao Joao de Meriti'	,'264791-2','Satan'			,'Santana'			,'CIEP II'	,'Fundamental','8 ano','801');
INSERT INTO escola.aluno values (matricula, 'Kuririn'	,'2005-02-20'	,'Nova Iguacu'		,'264571-0','Dan Hibiki'		,'Felisha'			,'CIEP II'	,'Fundamental','8 ano','801');
INSERT INTO escola.aluno values (matricula, 'Bulma'	,'2005-02-20'	,'Sao Joao de Meriti'	,'144601-0','Andre Feijo'		,'Fein Hao'			,'CIEP II'	,'Fundamental','8 ano','801');

INSERT INTO escola.aluno values (matricula, 'Tenshihan','2004-03-21'	,'Parati'			,'150601-7','Juse Felicio'		,'Ana Pires'		,'CIEP II'	,'Fundamental','9 ano','901');
INSERT INTO escola.aluno values (matricula, 'Picolo'	,'2004-03-21'	,'Rio de Janeiro'		,'130601-6','Mestre das Galaxias'	,'Ana Jose'			,'CIEP II'	,'Fundamental','9 ano','901');
INSERT INTO escola.aluno values (matricula, 'Piologo'	,'2004-03-21'	,'Rio de Janeiro'		,'350601-8','Piologo Senior'		,'Fernanda Almeida'	,'CIEP II'	,'Fundamental','9 ano','901');
INSERT INTO escola.aluno values (matricula, 'Piologo'	,'2004-03-21'	,'Englebart'		,'754601-6','Wolfgang von Stronhein','Beatriz Souza'		,'CIEP II'	,'Fundamental','9 ano','901');
INSERT INTO escola.aluno values (matricula, 'Pedro'	,'2004-03-21'	,'Queimados'		,'146608-2','Washington Pereira'	,'Adriana Cachoeiros'	,'CIEP II'	,'Fundamental','9 ano','901');
INSERT INTO escola.aluno values (matricula, 'Tony'	, '2004-03-21'	,'Japeri'			,'654289-6','Joseph Stark'		,'Alma May'			,'CIEP II'	,'Fundamental','9 ano','901');
INSERT INTO escola.aluno values (matricula, 'Thor'	, '2004-03-21'	,'Sao Paulo'		,'154782-3','Odin de Odin'		,'Valhala Van Hallen'	,'CIEP II'	,'Fundamental','9 ano','901');
INSERT INTO escola.aluno values (matricula, 'Buzz'	,'2006-02-01'	, 'Boston'			,'124963-6','Mach Lightyear'		,'Dandara Sousa'		,'CIEP II'	,'Fundamental','9 ano','901');
INSERT INTO escola.aluno values (matricula, 'Andy'	,'2006-02-01'	,'Cleaveland'		,'132584-4','Jeff Bogard'		,'May Lee'			,'CIEP II'	,'Fundamental','9 ano','901');
INSERT INTO escola.aluno values (matricula, 'Benjamin','2006-02-01'	,'Paracambi'		,'164285-7','Jarbas Silverio'		,'Fernanda Jua'		,'CIEP II'	,'Fundamental','9 ano','901');






-- Inserir valores na tabela aluno(aluno_matricula, portugues, matematica, fisica, quimica, filosofia, historia, geografia, ingles, educacao_fisica)
INSERT INTO escola.notas values (1, 9.9,8,7,5,4,8,7,9,8);
INSERT INTO escola.notas values (2, 8,9.8,7,5,4,8,7,9,8);
INSERT INTO escola.notas values (3, 6.7,8,9.7,5,4,8,7,9,8);
INSERT INTO escola.notas values (4, 9,6.8,7,9.5,4,8,7,9,8);
INSERT INTO escola.notas values (5, 8,8,6.7,5,9.4,8,7,9,8);
INSERT INTO escola.notas values (6, 9,8,7,6.5,4,9.8,7,9,8);
INSERT INTO escola.notas values (7, 9.5,8,7,6.5,4,9.8,7,9,8);
INSERT INTO escola.notas values (8, 9,8.5,7,5,6.4,8,9.7,9,8);
INSERT INTO escola.notas values (9, 9,8,7.5,5,4,6.8,7,9.9,8);
INSERT INTO escola.notas values (10, 9,8,7,5.5,4,8.6,7,9.9,8);
INSERT INTO escola.notas values (11, 9,8,7,5,5.4,8,7.6,9,8.9);
INSERT INTO escola.notas values (12, 9,8,7,5,4,5.8,7.6,9,8);
INSERT INTO escola.notas values (13, 9,8,7,5,4,8,5.7,9.6,8);
INSERT INTO escola.notas values (14, 9,8,7,5,4,8,7,5.9,8.6);
INSERT INTO escola.notas values (15, 9,8,7,5,4,8,7,9,5.8);
INSERT INTO escola.notas values (16, 7.9,8,7,5,4,8,7,9,8);
INSERT INTO escola.notas values (17, 9,7.8,7,5,4,8,7,9,8);
INSERT INTO escola.notas values (18, 9,8,7.7,5,4,8,7,9,8);
INSERT INTO escola.notas values (19, 9,8,7,7.5,4,8,7,9,8);
INSERT INTO escola.notas values (20, 9,8,7,5,7.4,8,7,9,8);
INSERT INTO escola.notas values (21, 9,8,7,5,4,7.8,7,9,8);
INSERT INTO escola.notas values (22, 9,8,7,5,4,8,7.7,9,8);
INSERT INTO escola.notas values (23, 9,8,7,5,4,8,7,7.9,8);
INSERT INTO escola.notas values (24, 9,8,7,5,4,8,7,9,7.8);
INSERT INTO escola.notas values (25, 8.9,8,7,5,4,8,7,9,8);
INSERT INTO escola.notas values (26, 9,8.8,7,5,4,8,7,9,8);
INSERT INTO escola.notas values (27, 9,8,8.7,5,4,8,7,9,8);
INSERT INTO escola.notas values (28, 9,8,7,8.5,4,8,7,9,8);
INSERT INTO escola.notas values (29, 9,8,7,5,8.4,8,7,9,8);
INSERT INTO escola.notas values (30, 9,8,7,5,4,8.8,7,9,8);
INSERT INTO escola.notas values (31, 9,8,7,5,4,8,8.7,9,8);
INSERT INTO escola.notas values (32, 9,8,7,5,4,8,7,8.9,8);
INSERT INTO escola.notas values (33, 9,8,7,5,4,8,7,9,8.8);