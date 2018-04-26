# Como conectar o JAVA ao MySQL?
Basicamente, o código para estabelecer a comunicação pode
ser resumido em:  
```java
import java.sql.*;  
  class MysqlCon{  
    public static void main(String args[]){  
      try{  
        Class.forName("com.mysql.jdbc.Driver"); //importa o driver necessário para realizar a conexao
        Connection con=DriverManager.getConnection(  
        "jdbc:mysql://localhost:3306/sonoo","root","root"); //3 parametros: url, user, senha

        //exemplo de requisição
        Statement stmt=con.createStatement();  
        ResultSet rs=stmt.executeQuery("select * from emp");  

        //desconectar do banco
        con.close();  
    }catch(Exception e){
      System.out.println(e);
    }  
  }  
}  
```

Uma observação importante é que na linha Class.forName... ,ele importa o driver responsável por estabelecer a conexão entre o JAVA e o banco de dados. O que acontece é que nem sempre esse arquivo fará parte da sua biblioteca de JAVA. Dessa forma, você precisa:
 - baixar o [Connector/J](https://dev.mysql.com/downloads/connector/j/8.0.html) e extrair seus arquivos.
 - Navegar nas pastas e encontrar o arquivo JAR do connector.
 - Pegar este arquivo, levar para o seu projeto, e adicionar este jar na sua IDE como uma biblioteca.
