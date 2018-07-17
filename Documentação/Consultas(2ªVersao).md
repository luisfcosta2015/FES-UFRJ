# Query Exemplo

<p>
Retorna dados para a geracao de um boletim do aluno com matricula=1
<p>

```SQL
Select a.nome AS 'Nome', 
ava.Nota1,ava.Nota2,ava.Nota3, 
ava.Disciplina, 
t.Serie, 
alut.Ano, 
t.N_Turma 
from 
Avaliacao ava INNER JOIN Aluno a ON a.Matricula=ava.Matricula 
INNER JOIN Aluno_Turma alut ON alut.Matricula=a.Matricula
INNER JOIN Turma t ON t.ID_Turma=alut.ID_Turma
WHERE a.Matricula=1;
