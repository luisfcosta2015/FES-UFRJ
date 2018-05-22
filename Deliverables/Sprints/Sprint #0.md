## Sobre a Sprint #0

Por mais que para a maioria dos grupos a questão do projeto já estivesse definido, isso ainda era considerado um 'embate' interno dentro da nossa equipe. A questão de estar desenvolvendo algo similar ao que já existe e já é bom (iReport), na forma de 'curativo' para problemas de desenvolvimento do i-Educar (que está sendo reescrito e não pode ser modificado) foi um tanto quanto desistimulante. Levantamos também a questão de viabilidade, visto que o prazo é curto e o nível de construção desse projeto é relevante; também questionamos se o plugin seria externo ao iReport ou se seria uma modificação no próprio código fonte do programa a fim de modelá-lo à maneira que precisávamos na situação. Em resumo, não havia ânimo e boas ideias para desenvolver esse componente para o i-Educar e a discussão que foi levantada em aula, aliada à possibilidade de um novo projeto, foi agradável e ajudou a compreender a partir dalí como seria a forma correta de se trabalhar em Scrum.

Mais sobre a discussão acalorada que tivemos na aula, os times avaliaram em conjunto qual era a viabilidade e os pontos que cada um consideravam relevantes para sustentar suas respectivas opiniões, que variaram desde a complexidade que seria desenvolver esse tipo de projeto desde um simples "é possível". Os Scrum Masters tiveram uma breve fala pra representar o time e explicar o que cada um estava achando do projeto, foi muito falado sobre a péssima modelagem e os erros presentes no banco de dados, levantando a questão de que isso também pode ser um dos motivos das dificuldades que são enfrentadas no processo de geração de relatórios personalizados. Um dos times apresentou um projeto em estágio avançado em relação aos outros, já mostrando qual seria a ideia que tiveram para interface e um breve levantamento de informações que fizeram com uma olhada no banco.

Aos grupos que estavam desmotivados com o plugin para os relatórios do i-Educar, o professor propôs que se dispusessem a desenvolver um projeto voltado ao gerenciamento da merenda escolar no município de Caxias. Explicando a situação: atualmente o gerenciamento da quantidade de refeições diárias, do tipo de alimento consumido e todas as informações adicionais são gerenciadas por uma planilha online (Google Docs). Embora isso seja uma solução que permite um gerenciamento das informações, deve-se concordar que não é feito da melhor maneira. Não há um sistema decente de permissões, não é interessante entregar uma planilha a uma grande quantidade de pessoas para que gerenciem juntas, assim como também não é prático que poucas pessoas tenham acesso a essas planilhas e as escolas enviem separadamente a quantidade de alimento consumido, pois coloca na mão do 'gerente' a responsabilidade de computar as informações de todas as escolas. Nosso plano de projeto é desenvolver um ambiente integrado que irá permitir que todas as escolas tenham autonomia para inserir suas próprias informações no banco de dados, entretanto não podem visualizar e nem alterar informações referentes a outras escolas. Os responsáveis da prefeitura por visualizar essas informações e gerenciar a 'lista de compras' terão todas as informações reunidas de forma clara e detalhada, podendo consultar informações das escolas individualmente tanto quanto as informações gerais. Também estamos planejando permitir ao software um bom detalhamento de dados, permitindo levantar informações e gráficos acerca da quantidade de alimento consumida mensalmente, qual é a média de demanda, média de alunos se alimentando diariamente, semanalmente, mensalmente e quem sabe anualmente. Escrevemos com base nisso todas as nossas histórias.

Em tese, a mudança de projeto nos permitiu enxergar de forma mais clara o que queremos e iremos fazer, tanto quanto nos motivou a pensar nas variadas formas de construir isso utilizando a metodologia ágil. Acreditamos que a partir daqui já temos a motivação necessária para iniciar o desenvolvimento rumo a Sprint #1.

***

## Recomeço e Sprint Review

Após uma reunião e discussão entre o grupo sobre a falta de responsabilidade de cada um com suas tarefas, finalmente iniciamos o nosso desenvolvimento e buscamos superar as dificuldades iniciais.

## Sprint Review
  
  ### Retrospectiva:

Conseguimos criar as histórias que eram o objetivo da Sprint. Foram elas:

* Eu quero gerar relatórios (épico):
  * Eu como USUÁRIO quero gerar relatórios
  * Eu como ESCOLA quero gerar relatórios sobre a minha escola
  * Eu como PREFEITURA quero gerar gráficos
  * Eu como PREFEITURA quero enviar o relatório diretamente para o fornecedor
* Eu como PREFEITURA registro as escolas.
* Eu como PREFEITURA registro usuários admin.
* Eu como ESCOLA registro a quantidade de alunos e alimento consumido
* Eu como USUÁRIO quero ter um layout agradável aos olhos
      
  ###  Revisão:
  
  A sprint acabou sendo atrasada por questões de entrosamento do grupo, mas depois das dificuldades conseugimos recuperar o atraso e colocamos o nosso barco de volta ao seu rumo.

  ### Sprint Planning
  
  Na próxima sprint desejamos criar o Banco de Dados e integrar com o Backend do projeto.
