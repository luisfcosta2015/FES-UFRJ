SELECT DISTINCT
 a.id_aluno AS cod_ieducar,
 nome_escola,
 a.nome_aluno,
 nome_turma,
 ano,

 CASE nome_serie
 WHEN '1º ano' THEN 'Fundamental I'
 WHEN '2º ano' THEN 'Fundamental I'
 WHEN '3º ano' THEN 'Fundamental I'
 WHEN '4º ano' THEN 'Fundamental I'
 WHEN '5º ano' THEN 'Fundamental I'
 WHEN '6º ano' THEN 'Fundamental II (Anos Finais)'
 WHEN '7º ano' THEN 'Fundamental II (Anos Finais)'
 WHEN '8º ano' THEN 'Fundamental II (Anos Finais)' 
 WHEN '9º ano' THEN 'Fundamental II (Anos Finais)' 
 ELSE 'Pré Vestibular' END AS Ciclo_Importante_Fundamental_II,
 t.id_turma AS Numero_inep,

 a.id_aluno,
 CASE
 WHEN a.id_aluno > 1 AND a.id_aluno < 21 THEN 'PROMOVIDO'
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
WHERE e.id_escola = ${IdEscola} 
AND t.id_turma = ${IdTurma}
AND t.ano = ${Ano}
