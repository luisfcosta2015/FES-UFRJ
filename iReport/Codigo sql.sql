- Criando a base de dados, no mysql é schema

CREATE SCHEMA fes;

-- Criando tabela

CREATE TABLE fes.alunos (
matricula INT(6) NOT NULL AUTO_INCREMENT PRIMARY KEY,
Nome VARCHAR(30) NOT NULL,
Sobrenome VARCHAR(30) NOT NULL,
dataNascimento date,
localNascimento VARCHAR(30),
identidade VARCHAR(8),
nomePai VARCHAR(30),
nomeMae VARCHAR(30),
escola VARCHAR(100),
escolaridade VARCHAR(100),
serie VARCHAR(100),
turma VARCHAR(100)
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

-- Inserir valores na tabela alunos(matrícula, Nome, Sobrenome, data de nascimento, local nasc, identidade, nome pai, nome mae, escola, escolaridade, serie, turma)
-- Data de Nascimento = YYYY-MM-DD

INSERT INTO fes.alunos values (matricula, 'Xiao', 'Yuang', '1995-07-06','Hong Kong','833102-6','Ip Yuang','Fei Man', 'UFRJ','Superior', '4 Periodo','2015-2');
INSERT INTO fes.alunos values (matricula, 'Andre', 'da Silva','2006-01-15','Santos','663201-3','Felipe da Silva','Amanda Soares', 'CIEP II','Fudamental 2', '7 ano','F2-701');
INSERT INTO fes.alunos values (matricula, 'Debora', 'Queiroz', '2006-01-15','Rio de Janeiro','322108-8','Joaquim Queiroz','Fernanda Buarque', 'CIEP II','Fudamental 2', '7 ano','F2-701');
INSERT INTO fes.alunos values (matricula, 'Gabriel', 'de Oliveira', '2006-01-15','Rio de Janeiro','564601-7','Cesar de Oliveira','Aline Vasquez', 'CIEP II','Fudamental 2', '7 ano','F2-701');
INSERT INTO fes.alunos values (matricula, 'Gustavo', 'Borges', '2006-01-15','Duque de Caxias','914562-6','Seleno Borges','Andrea Silva', 'CIEP II','Fudamental 2', '7 ano','F2-702');
INSERT INTO fes.alunos values (matricula, 'Muniz', 'Cipriano', '2006-01-15','Itaperuna','516234-2','Carlos Cipriano','Adriana May', 'CIEP II','Fudamental 2', '7 ano','F2-702');
INSERT INTO fes.alunos values (matricula, 'Vinicius', 'Jose', '2006-01-15','Angra dos Reis','416285-6','Felipe Jose','Leandra Vasconcelos', 'CIEP II','Fudamental 2', '7 ano','F2-711');
INSERT INTO fes.alunos values (matricula, 'Michel', 'Telo', '2006-01-15','Rio de Janeiro','322542-7','Marcos Telo','Rebeca Soares', 'CIEP II','Fudamental 2', '7 ano','F2-711');
INSERT INTO fes.alunos values (matricula, 'Irene', 'de Carvalho', '2006-01-15','Nova Iguacu','414896-1','Vicente de Carvalho','Larissa Alves', 'CIEP II','Fudamental 2', '7 ano','F2-711');
INSERT INTO fes.alunos values (matricula, 'Ricardo', 'Bueno', '2006-01-15','Nova Iguacu','616498-3','Galvao Bueno','Rosa Weber', 'CIEP II','Fudamental 2', '7 ano','F2-712');
INSERT INTO fes.alunos values (matricula, 'Felipe', 'Andreoli', '2006-01-15','Rio de Janeiro','833352-6','Andre Andreoli','Andressa Filipino', 'CIEP II','Fudamental 2', '7 ano','F2-712');
INSERT INTO fes.alunos values (matricula, 'Andre', 'Pimenta', '2005-02-20','Duque de Caxias','22442-5','Carlos Pimenta','Felicia Rosa', 'CIEP II','Fudamental 2', '8 ano','F2-801');
INSERT INTO fes.alunos values (matricula, 'Andre', 'Figueiredo', '2005-02-20','Sao Joao de Meriti','284352-9','Cesar Figueiredo','Ana Fonseca', 'CIEP II','Fudamental 2', '8 ano','F2-801');
INSERT INTO fes.alunos values (matricula, 'Goku', 'Son', '2005-02-20','Vegeta','264451-9','Son Bardock','Gean Kakarot', 'CIEP II','Fudamental 2', '8 ano','F2-801');
INSERT INTO fes.alunos values (matricula, 'Gohan', 'Son', '2005-02-20','Duque de Caxias','264424-8','Son Goku','Chichi', 'CIEP II','Fudamental 2', '8 ano','F2-802');
INSERT INTO fes.alunos values (matricula, 'Vegeta', 'Sayan', '2005-02-20','Rio de Janeiro','231152-6','Vegeta King','Vegeta Queen', 'CIEP II','Fudamental 2', '8 ano','F2-802');
INSERT INTO fes.alunos values (matricula, 'Trunks', 'Match', '2005-02-20','Rio de Janeiro','268901-3','Vegeta','Bulma', 'CIEP II','Fudamental 2', '8 ano','F2-802');
INSERT INTO fes.alunos values (matricula, 'Satan', 'do Diabo', '2005-02-20','Duque de Caxias','214601-3','Devil','Shaitan', 'CIEP II','Fudamental 2', '8 ano','F2-811');
INSERT INTO fes.alunos values (matricula, 'Videl', 'de Souza', '2005-02-20','Sao Joao de Meriti','264791-2','Satan','Santana', 'CIEP II','Fudamental 2', '8 ano','F2-811');
INSERT INTO fes.alunos values (matricula, 'Kuririn', 'dos Santos', '2005-02-20','Nova Iguacu','264571-0','Dan Hibiki','Felisha', 'CIEP II','Fudamental 2', '8 ano','F2-812');
INSERT INTO fes.alunos values (matricula, 'Bulma', 'Feijo', '2005-02-20','Sao Joao de Meriti','144601-0','Andre Feijo','Fein Hao', 'CIEP II','Fudamental 2', '8 ano','F2-812');
INSERT INTO fes.alunos values (matricula, 'Tenshihan', 'Felicio', '2004-03-21','Parati','150601-7','Juse Felicio','Ana Pires', 'CIEP II','Fudamental 2', '9 ano','F2-901');
INSERT INTO fes.alunos values (matricula, 'Picolo', 'das Galaxias', '2004-03-21','Rio de Janeiro','130601-6','Mestre das Galaxias','Ana Jose', 'CIEP II','Fudamental 2', '9 ano','F2-901');
INSERT INTO fes.alunos values (matricula, 'Piologo', 'Junior','2004-03-21','Rio de Janeiro','350601-8','Piologo Senior','Fernanda Almeida', 'CIEP II','Fudamental 2', '9 ano','F2-901');
INSERT INTO fes.alunos values (matricula, 'Piologo', 'von Stronhein', '2004-03-21','Englebart','754601-6','Wolfgang von Stronhein','Beatriz Souza', 'CIEP II', 'Fudamental 2','9 ano','F2-902');
INSERT INTO fes.alunos values (matricula, 'Pedro', 'Pereira', '2004-03-21','Queimados','146608-2','Washington Pereira','Adriana Cachoeiros', 'CIEP II', 'Fudamental 2','9 ano','F2-902');
INSERT INTO fes.alunos values (matricula, 'Tony', 'Stark', '2004-03-21','Japeri','654289-6','Joseph Stark','Alma May', 'CIEP II','Fudamental 2', '9 ano','F2-902');
INSERT INTO fes.alunos values (matricula, 'Thor', 'de Odin', '2004-03-21','Sao Paulo','154782-3','Odin de Odin','Valhala Van Hallen', 'CIEP II', 'Fudamental 2','9 ano','F2-902');
INSERT INTO fes.alunos values (matricula, 'Valquiria', 'Daeneris', '2006-02-01','Salvador','147896-4','Anderson Daeneris','Joana Sa', 'Brizolaum','Fudamental 2', '7 ano','7010');
INSERT INTO fes.alunos values (matricula, 'Anne', 'Vilbert', '2006-02-01','Frankfurt','753916-3','George Vilbert','Joice Reis', 'Brizolaum','Fudamental 2', '7 ano','7010');
INSERT INTO fes.alunos values (matricula, 'Buzz', 'Lightyear', '2006-02-01', 'Boston','124963-6','Mach Lightyear','Dandara Sousa','Brizolaum','Fudamental 2', '7 ano','7011');
INSERT INTO fes.alunos values (matricula, 'Andy', 'Bogard', '2006-02-01','Cleaveland','132584-4','Jeff Bogard','May Lee', 'Brizolaum','Fudamental 2', '7 ano','7011');
INSERT INTO fes.alunos values (matricula, 'Benjamin', 'Silverio', '2006-02-01','Paracambi','164285-7','Jarbas Silverio','Fernanda Jua', 'Brizolaum','Fudamental 2', '7 ano','7012');

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
