SELECT DISTINCT
 a.id_aluno AS cod_ieducar,
 a.nome_aluno,
 
 a.id_aluno,
 CASE WHEN a.id_aluno > 1 AND a.id_aluno < 21 THEN 'PROMOVIDO'
	  WHEN a.id_aluno > 20 AND a.id_aluno < 31 THEN 'RETIDO'
	  WHEN a.id_aluno > 30 AND a.id_aluno < 41  THEN 'EM ANDAMENTO'
	  WHEN a.id_aluno > 40 AND a.id_aluno < 51 THEN 'TRANSFERIDO'
	  WHEN a.id_aluno > 50 AND a.id_aluno < 61 THEN 'RECLASSIFICADO'
	  WHEN a.id_aluno > 60 AND a.id_aluno < 71 THEN 'ABANDONO'
	  WHEN a.id_aluno > 70 AND a.id_aluno < 81 THEN 'RECUPERACAO'
	  WHEN a.id_aluno > 80 AND a.id_aluno < 91 THEN 'Ap com Prog Parc'
	  ELSE 'EM EXAME' END AS situacao
 
FROM turma t
INNER JOIN serie s ON s.id_serie = t.fk_serie
INNER JOIN aluno a ON a.fk_turma = t.id_turma
INNER JOIN escola e ON e.id_escola = t.fk_escola
WHERE t.fk_serie = s.id_serie 
AND UPPER(e.nome_escola) like UPPER('${escolaNome}')
AND UPPER(t.nome_turma) like UPPER('${escolaTurma}')
AND t.ano = ${year}
