# Como lidar com um ResultSet

## Iterando uma tabela retornada por uma consulta
Tendo um ResultSet rs, o método rs.next() andará para a próxima linha da tabela em rs. Você começa antes da primeira linha e ele retorna false quando chega no final, então dá pra iterar fazendo:
```java
while(rs.next()) {
// comandos
}
```

## Exemplos de uso
```java
// SELECT Nome FROM Professor WHERE Disciplina='Matemática III'
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("SELECT Nome FROM Professor WHERE Disciplina='Matemática III'");    
while(rs.next()) {
	String nome = rs.getString("Nome");
	System.out.println("Nome do Professor: " + nome);
}

// SELECT p.Disciplina,p.Bimestre FROM Prova as p natural join ProvaTurma as pt  WHERE p.Disciplina=pt.Disciplina_Prova AND p.Data_Prova='2018/06/15' AND pt.Cod_Turma='2B'
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("SELECT p.Disciplina,p.Bimestre FROM Prova as p natural join ProvaTurma as pt  WHERE p.Disciplina=pt.Disciplina_Prova AND p.Data_Prova='2018/06/15' AND pt.Cod_Turma='2B'");    
while(rs.next()) {
	String disciplina = rs.getString("Disciplina");
	int bimestre = rs.getInt("Bimestre");
	System.out.println("Disciplina: " + disciplina + ". Bimestre: " + bimestre + ".");
}
```

## E se não conhecermos a tabela do BD?
  Nesse caso, usaremos a classe ResultSetMetaData, que contém os metadados (estruturas) referentes a alguma tabela.
```java
// SELECT * FROM Aluno
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("SELECT * FROM Aluno");
ResultSetMetaData rsmd = rs.getMetaData();
while(rs.next()) {
	for(int i = 1; i <= rsmd.getColumnCount(); i++) {//itera sob a qntd de colunas da tabela
		String atrib = rsmd.getColumnName(i);//nome da i-ésima coluna da tabela
		Object val = rs.getObject(i);//getObject() é utilizado pois não sabemos o domínio do atributo da coluna i
		System.out.print(atrib + ": " + val + ". ");
	}
	System.out.println("");
}
```
