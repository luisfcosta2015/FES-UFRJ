# Exemplos de Consultas

<p>
Definimos como realizar algumas buscas no nosso BD teste. Elas servirão de teste para as próximas etapas do nosso projeto.
</p>

**OBS**: Mais consultas serão ser adicionadas no futuro.



## Script
```SQL
// Seleciona os dados de todos os alunos

SELECT * FROM Aluno;

// Seleciona o Nome de todos os professores que ministram Matematica III

SELECT Nome FROM Professor WHERE Disciplina='Matemática III';

// Seleciona as datas das provas de Matematica II

SELECT Data_Prova FROM Prova WHERE Disciplina='Matemática II';

// Seleciona o nome de todos os alunos da turma 3A

SELECT a.Nome FROM Aluno as a natural join AlunoTurma as alt WHERE a.Matricula=alt.Matricula_aluno AND alt.Cod_Turma='3A' AND alt.Ano='2018';

// Seleciona o bismestre e a disciplina da prova que foi aplicada à turma 2B no dia '15/06/2018'

SELECT p.Disciplina,p.Bimestre FROM Prova as p natural join ProvaTurma as pt  WHERE p.Disciplina=pt.Disciplina_Prova AND p.Data_Prova='2018/06/15' AND pt.Cod_Turma='2B';
```
