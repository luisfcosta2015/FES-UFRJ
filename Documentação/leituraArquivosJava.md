Segue abaixo um trecho que permite a leitura de arquivos em Java
 Observe que a pasta root do netbeans, ou seja, de onde o FileReader parte para navegar entre os arquivos se encontra no diretório que possui as pastas **src, build**...
```Java
try {
  FileReader arq = new FileReader("../data/teste.txt");
  BufferedReader lerArq = new BufferedReader(arq);

  String temp_linha = lerArq.readLine();
  String linha = temp_linha + "\n"; // lê a primeira linha
  while (true) {
    temp_linha = lerArq.readLine(); // lê da segunda até a última linha
    if(temp_linha==null){break;}
    linha+= temp_linha+ "\n";
  }

  System.out.printf("%s", linha);

    arq.close();
} catch (IOException e) {
    System.err.printf("Erro na abertura do arquivo: %s.\n",
    e.getMessage());
}

```
