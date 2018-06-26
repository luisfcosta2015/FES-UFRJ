# Casos de Teste e Casos de Uso

_Na Engenharia de Software, um caso de uso (do inglês use case) é um tipo de classificador representando uma unidade funcional coerente provida pelo sistema, subsistema, ou classe manifestada por sequências de mensagens intercambiáveis entre os sistemas e um ou mais atores._ - [Caso de Uso](https://pt.wikipedia.org/wiki/Caso_de_uso)

_Em engenharia de software, caso de teste é um conjunto de condições usadas para teste de software. Ele pode ser elaborado para identificar defeitos na estrutura interna do software por meio de situações que exercitem adequadamente todas as estruturas utilizadas na codificação; ou ainda, garantir que os requisitos do software que foi construído sejam plenamente atendidos. Podemos utilizar a ferramenta de casos de uso para criar e rastrear um caso de teste, facilitando assim identificação de possíveis falhas. O caso de teste deve especificar a saída esperada e os resultados esperados do processamento. Numa situação ideal, no desenvolvimento de casos de teste, se espera encontrar o subconjunto dos casos de teste possíveis com a maior probabilidade de encontrar a maioria dos erros._ - [Caso de Teste](https://pt.wikipedia.org/wiki/Caso_de_teste)

Durante a aula do dia 18/06, o professor Éber questionou acerca dos grupos terem criado os seus respectivos casos de teste e de uso. Na discussão, foi explicado tanto do que se tratava e qual era a sua importância no processo de desenvolvimento de software, e o mesmo pediu para que os grupos fizessem em sala alguns desses casos. Aqui estarei colocando alguns dos casos de teste e de uso no nosso modelo de software.


## Casos de Uso

 * Acessar o sistema
 * Recuperação de senha
 * Cadastramento de usuários
 * Cadastramento de escolas
 * Cadastramento de alimentos
 * Geração de Relatório

### 1- Acessar o sistema:

  **Pré - Condições:** O usuário precisa estar cadastrado no sistema.
  
  **Pós - Condições:** O usuário conseguiu acessar o sistema e as opções existentes.

| Passos | Descrição |
|--------|-----------|
|   1    |O usuário acessa o endereço web da aplicação|
|   2    |O usuário digita o _login_ e a _senha_ de acesso|
|   3    |O usuário clica no botão **Entrar**|
|   4    |O usuário já está logado no sistema e uma tela com todas as possibilidades de ação para o mesmo é exibida|


### 2 - Recuperação de senha:

  **Pré - Condições:** O usuário precisa estar cadastrado no sistema.
  
  **Pós - Condições:** O usuário recebe as instruções para redefinição de senha por email.

| Passos | Descrição |
|--------|-----------|
|   1    |O usuário acessa o endereço web da aplicação|
|   2    |O usuário clica no botão **Esqueci minha senha**|
|   3    |O usuário digita o endereço de email|
|   4    |O usuário clica no botão **Recuperar senha**|
|   5    |O usuário recebe as instruções para redefinição de senha de acordo com o email digitado|


### 3 - Cadastrar usuários

  **Pré - Condições:** O usuário precisa de permissões de _sysadmin_ para cadastrar qualquer tipo de usuário; permissões de _prefeitura_ para cadastrar qualquer tipo de usuário, com exceção de _sysadmin_; permissões de _diretor_ para cadastrar usuários do tipo _secretaria_ (alguém que trabalhe nas secretarias de ensino e auxilie na inserção de informações diariamente).
  
  **Pós - Condições:** O usuário recebe uma mensagem de sucesso no cadastramento e já é possível realizar _login_ com o novo usuário cadastrado.

| Passos | Descrição |
|--------|-----------|
|   1    |O usuário acessa o endereço web da aplicação|
|   2    |O usuário realiza _login_ com uma conta que possua permissões de cadastro de usuários|
|   3    |O usuário clica no botão **cadastro de usuários** para ir até a página de cadastramento|
|   4    |O usuário insere os dados do usuário que está sendo criado (Nome, endereço, telefone, email, CPF, RG, tipo de usuário, local de trabalho)| 
|   5    |O usuário clica em **finalizar cadastro**|
|   6    |O usuário recebe uma mensagem de sucesso caso o procedimento tenha sido concluído sem problemas|


### 4 - Cadastrar escolas

  **Pré - Condições:** O usuário precisa de permissão a nível de _sysadmin_ ou _prefeitura_ para cadastrar escolas.
  
  **Pós - Condições:** O usuário recebe uma mensagem de sucesso e a escola já se encontra cadastrada no banco de dados.

| Passos | Descrição |
|--------|-----------|
|   1    |O usuário acessa o endereço web da aplicação|
|   2    |O usuário realiza _login_ com uma conta com permissões de cadastrar escolas|
|   3    |O usuário clica no botão **cadastro de escolas** para ir até a página de cadastramento|
|   4    |O usuário insere os dados das escolas que está sendo criada (Nome, endereço, telefones, email, diretor(es), quantidade de alunos; caso já exista um usuário do tipo _diretor_ responsável pela escola, é possível designá-lo no momento do cadastro| 
|   5    |O usuário clica em **finalizar cadastro**|
|   6    |O usuário recebe uma mensagem de sucesso caso o procedimento tenha sido concluído sem problemas|


### 5 - Cadastrar alimentos

  **Pré - Condições:** O usuário precisa de permissão a nivel de _sysadmin_ ou _prefeitura_ para cadastrar alimentos.
  
  **Pós - Condições:** O usuário recebe uma mensagem de sucesso e o alimento já se encontra presente no banco de dados.
  
| Passos | Descrição |
|--------|-----------|
|   1    |O usuário acessa o endereço web da aplicação|
|   2    |O usuário realiza _login_ com uma conta com permissões de cadastrar alimentos_|
|   3    |O usuário clica no botão **cadastrar alimentos** para ir até a página de cadastro|
|   4    |O usuário insere as informações acerca do alimento, como nome, unidade de medida e tipo do alimento (verdura, proteína etc)| 
|   5    |O usuário clica em **finalizar cadastro**|
|   6    |O usuário recebe uma mensagem de sucesso caso o procedimento tenha sido concluído sem problemas|


### 6 - Geração de Relatórios

  **Pré - Condições:** O usuário precisa de permissões a nivel de _sysadmin_ ou _prefeitura_ para gerar qualquer relatório sobre qualquer escola; permissões a nivel _diretor_ para gerar relatórios sobre a sua respectiva escola.
  
  **Pós - Condições:** O usuário recebe uma mensagem de sucesso e também o arquivo contendo o relatório que foi gerado.

| Passos | Descrição |
|--------|-----------|
|   1    |O usuário acessa o endereço web da aplicação|
|   2    |O usuário realiza _login_ com uma conta com permissões de geração de relatórios|
|   3    |O usuário clica no botão **Gerar Relatórios** para ir até a página de geração de relatórios|
|   4    |O usuário seleciona o tipo de relatório que deseja de acordo com as opções que forem apresentadas| 
|   5    |O usuário seleciona uma escola específica (caso possua permissão) ou _geral_, que é o conjunto de todas as escolas administradas pela prefeitura|
|   6    |O usuário seleciona o tipo de arquivo que será gerado (_.pdf_ ou _.odt_)|
|   7    |O usuário clica no botão **gerar relatório**|
|   8    |O usuário recebe uma mensagem de sucesso caso o procedimento tenha sido concluído sem problemas e, em seguida, o arquivo contendo o relatório que foi gerado.|


## Casos de Teste

 * Acessar o sistema
 * Recuperação de senha
 * Cadastramento de usuários
 * Cadastramento de escolas
 * Cadastramento de alimentos
 * Geração de Relatório
