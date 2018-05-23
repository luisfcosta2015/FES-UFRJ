SELECT DISTINCT
nome_escola,
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
 ELSE 'Pré Vestibular' END AS escolaCiclo

FROM turma t
INNER JOIN serie s ON s.id_serie = t.fk_serie
INNER JOIN aluno a ON a.fk_turma = t.id_turma
INNER JOIN escola e ON e.id_escola = t.fk_escola
WHERE t.fk_serie = s.id_serie 
AND UPPER(e.nome_escola) like UPPER('${escolaNome}')
AND UPPER(t.nome_turma) like UPPER('${escolaTurma}')
AND t.ano = ${year}
