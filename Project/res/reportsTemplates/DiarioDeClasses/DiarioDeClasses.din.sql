SELECT DISTINCT
 a.id_aluno AS codIeducar,
 a.nome_aluno,
 
FROM turma t
INNER JOIN serie s ON s.id_serie = t.fk_serie
INNER JOIN aluno a ON a.fk_turma = t.id_turma
INNER JOIN escola e ON e.id_escola = t.fk_escola
WHERE t.fk_serie = s.id_serie 
AND UPPER(e.nome_escola) like UPPER('${escolaNome}')
AND UPPER(t.nome_turma) like UPPER('${escolaTurma}')
AND t.ano = ${year}
ORDER BY nome_aluno