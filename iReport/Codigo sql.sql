-- Criando a base de dados, no mysql é schema

CREATE SCHEMA fes;

-- Criando tabela

CREATE TABLE fes.alunos (
matricula INT(6) NOT NULL AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(30) NOT NULL,
dataNascimento date,
escola VARCHAR(100),
serie VARCHAR(100)
);

CREATE TABLE fes.notas (
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
FOREIGN KEY (alunoMatricula) REFERENCES fes.alunos(matricula)
);

-- Inserir valores na tabela alunos(matrícula, Nome, data de nascimento, escola, serie,
-- Data de Nascimento = YYYY-MM-DD

INSERT INTO fes.alunos values (matricula, 'Xiao', '1995-07-06', 'UFRJ', '4 Periodo');
INSERT INTO fes.alunos values (matricula, 'Andre', '2006-01-15', 'CIEP II', '7 ano');
INSERT INTO fes.alunos values (matricula, 'Debora', '2006-01-15', 'CIEP II', '7 ano');
INSERT INTO fes.alunos values (matricula, 'Gabriel', '2006-01-15', 'CIEP II', '7 ano');
INSERT INTO fes.alunos values (matricula, 'Gustavo', '2006-01-15', 'CIEP II', '7 ano');
INSERT INTO fes.alunos values (matricula, 'Muniz', '2006-01-15', 'CIEP II', '7 ano');
INSERT INTO fes.alunos values (matricula, 'Vinicius', '2006-01-15', 'CIEP II', '7 ano');
INSERT INTO fes.alunos values (matricula, 'Michel', '2006-01-15', 'CIEP II', '7 ano');
INSERT INTO fes.alunos values (matricula, 'Irene', '2006-01-15', 'CIEP II', '7 ano');
INSERT INTO fes.alunos values (matricula, 'Ricardo', '2006-01-15', 'CIEP II', '7 ano');
INSERT INTO fes.alunos values (matricula, 'Felipe', '2006-01-15', 'CIEP II', '7 ano');
INSERT INTO fes.alunos values (matricula, 'Andre', '2005-02-20', 'CIEP II', '8 ano');
INSERT INTO fes.alunos values (matricula, 'Andre', '2005-02-20', 'CIEP II', '8 ano');
INSERT INTO fes.alunos values (matricula, 'Goku', '2005-02-20', 'CIEP II', '8 ano');
INSERT INTO fes.alunos values (matricula, 'Gohan', '2005-02-20', 'CIEP II', '8 ano');
INSERT INTO fes.alunos values (matricula, 'Vegita', '2005-02-20', 'CIEP II', '8 ano');
INSERT INTO fes.alunos values (matricula, 'Trunks', '2005-02-20', 'CIEP II', '8 ano');
INSERT INTO fes.alunos values (matricula, 'Satan', '2005-02-20', 'CIEP II', '8 ano');
INSERT INTO fes.alunos values (matricula, 'Videl', '2005-02-20', 'CIEP II', '8 ano');
INSERT INTO fes.alunos values (matricula, 'Kuririn', '2005-02-20', 'CIEP II', '8 ano');
INSERT INTO fes.alunos values (matricula, 'Bulma', '2005-02-20', 'CIEP II', '8 ano');
INSERT INTO fes.alunos values (matricula, 'Tenshihan', '2004-03-21', 'CIEP II', '9 ano');
INSERT INTO fes.alunos values (matricula, 'Picolo', '2004-03-21', 'CIEP II', '9 ano');
INSERT INTO fes.alunos values (matricula, 'Piologo','2004-03-21', 'CIEP II', '9 ano');
INSERT INTO fes.alunos values (matricula, 'Piologo', '2004-03-21', 'CIEP II', '9 ano');
INSERT INTO fes.alunos values (matricula, 'Pedro', '2004-03-21', 'CIEP II', '9 ano');
INSERT INTO fes.alunos values (matricula, 'Tony', '2004-03-21', 'CIEP II', '9 ano');
INSERT INTO fes.alunos values (matricula, 'Thor', '2004-03-21', 'CIEP II', '9 ano');
INSERT INTO fes.alunos values (matricula, 'Valquiria', '2006-02-01', 'Brizolaum', '7 ano');
INSERT INTO fes.alunos values (matricula, 'Anne', '2006-02-01', 'Brizolaum', '7 ano');
INSERT INTO fes.alunos values (matricula, 'Buzz', '2006-02-01', 'Brizolaum', '7 ano');
INSERT INTO fes.alunos values (matricula, 'Andy', '2006-02-01', 'Brizolaum', '7 ano');
INSERT INTO fes.alunos values (matricula, 'Benjamin', '2006-02-01', 'Brizolaum', '7 ano');

-- Inserir valores na tabela alunos(aluno_matricula, portugues, matematica, fisica, quimica, filosofia, historia, geografia, ingles, educacao_fisica)

INSERT INTO fes.notas values (1, 9.9,8,7,5,4,8,7,9,8);
INSERT INTO fes.notas values (2, 8,9.8,7,5,4,8,7,9,8);
INSERT INTO fes.notas values (3, 6.7,8,9.7,5,4,8,7,9,8);
INSERT INTO fes.notas values (4, 9,6.8,7,9.5,4,8,7,9,8);
INSERT INTO fes.notas values (5, 8,8,6.7,5,9.4,8,7,9,8);
INSERT INTO fes.notas values (6, 9,8,7,6.5,4,9.8,7,9,8);
INSERT INTO fes.notas values (7, 9.5,8,7,6.5,4,9.8,7,9,8);
INSERT INTO fes.notas values (8, 9,8.5,7,5,6.4,8,9.7,9,8);
INSERT INTO fes.notas values (9, 9,8,7.5,5,4,6.8,7,9.9,8);
INSERT INTO fes.notas values (10, 9,8,7,5.5,4,8.6,7,9.9,8);
INSERT INTO fes.notas values (11, 9,8,7,5,5.4,8,7.6,9,8.9);
INSERT INTO fes.notas values (12, 9,8,7,5,4,5.8,7.6,9,8);
INSERT INTO fes.notas values (13, 9,8,7,5,4,8,5.7,9.6,8);
INSERT INTO fes.notas values (14, 9,8,7,5,4,8,7,5.9,8.6);
INSERT INTO fes.notas values (15, 9,8,7,5,4,8,7,9,5.8);
INSERT INTO fes.notas values (16, 7.9,8,7,5,4,8,7,9,8);
INSERT INTO fes.notas values (17, 9,7.8,7,5,4,8,7,9,8);
INSERT INTO fes.notas values (18, 9,8,7.7,5,4,8,7,9,8);
INSERT INTO fes.notas values (19, 9,8,7,7.5,4,8,7,9,8);
INSERT INTO fes.notas values (20, 9,8,7,5,7.4,8,7,9,8);
INSERT INTO fes.notas values (21, 9,8,7,5,4,7.8,7,9,8);
INSERT INTO fes.notas values (22, 9,8,7,5,4,8,7.7,9,8);
INSERT INTO fes.notas values (23, 9,8,7,5,4,8,7,7.9,8);
INSERT INTO fes.notas values (24, 9,8,7,5,4,8,7,9,7.8);
INSERT INTO fes.notas values (25, 8.9,8,7,5,4,8,7,9,8);
INSERT INTO fes.notas values (26, 9,8.8,7,5,4,8,7,9,8);
INSERT INTO fes.notas values (27, 9,8,8.7,5,4,8,7,9,8);
INSERT INTO fes.notas values (28, 9,8,7,8.5,4,8,7,9,8);
INSERT INTO fes.notas values (29, 9,8,7,5,8.4,8,7,9,8);
INSERT INTO fes.notas values (30, 9,8,7,5,4,8.8,7,9,8);
INSERT INTO fes.notas values (31, 9,8,7,5,4,8,8.7,9,8);
INSERT INTO fes.notas values (32, 9,8,7,5,4,8,7,8.9,8);
INSERT INTO fes.notas values (33, 9,8,7,5,4,8,7,9,8.8);
