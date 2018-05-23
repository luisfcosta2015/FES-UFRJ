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
 ELSE 'Pré Vestibular' END AS Ciclo_Importante_Fundamental_II

FROM turma t
INNER JOIN serie s ON s.id_serie = t.fk_serie
INNER JOIN aluno a ON a.fk_turma = t.id_turma
INNER JOIN escola e ON e.id_escola = t.fk_escola
WHERE e.id_escola = ${IdEscola} 
AND t.id_turma = ${IdTurma}
AND t.ano = ${Ano}
ORDER BY nome_aluno
