Para que alteremos o arquivo de consulta fornecido pelo usuário, é preciso definir uma sintaxe própria, na qual o usuário deixará a sua marcação e nós a substituiremos pelo valor a ser utilizado na consulta.

Para isso, usaremos o caracter especial **§**, que não é encontrado na sintaxe do SQL.

## Exemplo Prático

```SQL
SELECT Nome FROM Professor WHERE Disciplina=§materia;
```

Dessa forma, pegaremos essa string, identificaremos o §materia, e iremos substituí-lo de acordo com o valor fornecido pelo usuário. Imagine que a consulta seria feita com o valor "Matematica III", logo, a string seria alterada para:

```SQL
SELECT Nome FROM Professor WHERE Disciplina='Matematica III';
```
