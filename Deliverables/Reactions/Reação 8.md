### Semana 8 - 14/05, 16/05

Essa semana o professor Eber "concluiu" o que havia ficado em aberto na próxima semana e nos apresentou tipos importantes de testes que são muito utilizados nas empresas e na área de desenvolvimento de software em si. Quanto aos conceitos levantados, falamos sobre Verificação e Validação, o quanto é importante manter a qualidade e GARANTIR a integridade do produto que está sendo desenvolvido, estratégias para realização dos testes e outros pontos mais.

Na sequência, seguimos e vimos casos e procedimentos de teste, Oráculo de Teste (um nome curioso que inclusive causa certa estranheza por ser incomum, ao menos para mim que nunca ouvia escutado essa palavra na computação. Por definição, "Oráculo de Teste" contempla a "fonte utilizada para determinar os resultados esperados e compará-los com os resultados reais produzidos pelo software que está sendo testado", definição encontrada [aqui](www.bstqb.org.br/node/11604)), os casos de teste Positivo e Negativo etc.

Nos slides estão contidos os detalhes referentes a cada conceito, embora eu tenha achado um pouco complicado de utilizar somente aquele material para compreensão de tais conceitos. 

Alguns testes relevantes:

   * **TDD - Test Driven Development** (Calma, não é TellelvisDanielDennison)**:** Em tradução literal, significa Desenvolvimento guiado por testes, que é uma técnica de desenvolvimento de software que se relaciona com o conceito de verificação e validação. Baseia-se em escrever um caso de teste que é automatizado, definindo uma melhoria desejada ou funcionalidade. É produzido um código que possa ser validado pelo teste e posteriormente esse código é refatorado para um código sob padrões aceitaveis. (Definição: [Wikipedia](https://pt.wikipedia.org/wiki/Test_Driven_Development))
   
   * **Teste de Unidade:** Tipo de teste que realiza uma verificação de uma unidade única do sistema, testando de maneira isolada e fazendo a simulação das prováveis dependências que essa unidade possui. Trazendo para um desenvolvimento orientado a objetos, é comum que a unidade que irá ser testada seja uma classe, portanto todos os testes realizados se limitarão a essa classe, ignorando as interações que possam existir com outras classes. (Definição: [Caelum](http://blog.caelum.com.br/unidade-integracao-ou-sistema-qual-teste-fazer/))
    
   * **Teste de Integração:** Responsável por verificar a integração entre duas ou mais partes do sistema. Um exemplo simples é caso seu código comece em uma classe e vá até algum serviço externo, como um banco de dados, serviços web etc. Esse teste me certifica que existe uma integração fidedigna na aplicação.

   * **Testes Alfa e Beta:** Principalmente os usuários que estão acostumados a jogar jogos online já estão acostumados com esse termo. Os testes Alfa e Beta são levemente similares, sendo um a sequência do outro. O primeiro é realizado no início, antes que esteja concluído o desenvolvimento do software. Esses testes são realizados em "laboratório", onde geralmente usuários internos simulam usuários reais na busca de problemas que possam existir durante o funcionamento da aplicação. Isso permite que problemas mais críticos sejam solucionados rapidamente pelos responsáveis pelo desenvolvimento. O Teste Beta vem logo na sequência, onde o software é liberado para o público geral utilizar e, em troca, pedem um feedback caso encontrem problemas ou *bugs*. Geralmente um número limitado de usuários é autorizado a participar desse teste, é o que chamamos de **beta fechado**. Quando é liberado para QUALQUER usuário, chamamos de **beta aberto**, muito comum em *games* como já dito. 

   * **Teste de Sistema:** Inclui no teste todos os componentes responsáveis pelo funcionamento do software, desde o código até o hardware e sistema operacional onde a aplicação está sendo executada. Esse teste me garante o funcionamento do sistema de forma completa, podendo-se incluir testes de stress, desempenho, entre outros.
     
-Daniel
