### Semana 11 - 04/06, 06/06

Passada a crise que assolou o país devido a Greve dos Caminhoneiros, retornamos para aula após um breve recesso e com isso o professor Eber fez uma revisão geral em casos de teste.

Dentre os tópicos abordados, os mais relevantes são o método da Caixa Branca (continuação do que já havia explicado na última aula que havíamos tido pré-recesso) e o Teste da Caixa Preta, que ainda não havia sido formalmente explicado. A grosso modo, a diferença entre os dois é que o Teste de Caixa Branca é feito em cima do código fonte, enquanto o outro é de acordo com as especificações.

Em certo momento da aula, o professor nos questionou acerca de como poderíamos especificar um software, e pontuou algumas questões relevantes a serem utilizadas nesse momento, sendo elas:

   * Nomes dos métodos, parâmetros e saída

   * Utilização da ferramenta OCL (*Object Constraint Language*, que significa *Linguagem para Especificação de Restrições em Objetos*). Por definição do [Wikipedia](https://pt.wikipedia.org/wiki/OCL), é uma linguagem declarativa para descrever as regras que se aplicam aos modelos **UML**. Aparentemente, a grande vantagem é que o "OCL, por fornecer expressões livres das ambiguidades das linguagens naturais e menos difíceis que os métodos formais tradicionais, complementa os modelos UML".

**Observação:** Embora tenha recomendado a OCL, também pode ser feito escrito em português convencional.

No que poderíamos chamar de segunda parte da aula, falamos sobre os casos de uso, que funciona como um roteiro. São os passos para que o usuário (ou algum determinado autor) siga para realizar determinada ação no software. No relatório que foi mostrado em sala, temos as seguintes seções:

   * Caso de Utilização: O que o usuário realiza no software seguindo os passos listados

   * Pré - Condição: Condições iniciais para que o sistema atenda e execute a função desejada

   * Pós - Condição: Qual é o resultado esperado ao final da execução/procedimento

   * Fluxo de sucesso: O que deve ocorrer caso tenhamos uma situação de sucesso, sem saltos no código

   * Fluxo alternativo: Condições e repetições caso hajam as condicionais
 
 Nessa aula, o professor pediu para que fizéssemos alguns casos de uso passa nosso software, e também questionou sobre ter sido um dos primeiros procedimentos a realizarmos assim que começamos o desenvolvimento do projeto. Os casos de uso feitos em sala e posteriormente já estão disponíveis na pasta *Deliverables* do nosso repositório. 