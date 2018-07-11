# Como instalar o SSLRel junto ao i-educar no Linux

* Você precisará ter o programa Vim (ou outro editor de textos para terminal) instalado e precisará saber seus comandos básicos.

## Instalação e configuração do Tomcat 9

### Instalando o Java JRE 8
```bash
sudo su
cd /usr/local/
wget --header 'Cookie: oraclelicense=a' http://download.oracle.com/otn-pub/java/jdk/8u131-b11/d54c1d3a095b4ff2b6607d096fa80163/jre-8u131-linux-x64.tar.gz
tar -xf jre-8u131-linux-x64.tar.gz && rm -f jre-8u131-linux-x64.tar.gz
mv jre1.8.0_131 java
echo 'JAVA_HOME=/usr/local/java
export JAVA_HOME
PATH=$PATH:$JAVA_HOME/bin
export PATH' >> /etc/profile
source /etc/profile
java -version
```
Criando o grupo/usuário para o Tomcat
```bash
groupadd tomcat
useradd -M -s /bin/nologin -g tomcat -d /usr/local/tomcat tomcat
```
### Baixando e instalando o Tomcat 9

```bash
cd /usr/local/
wget http://ftp.unicamp.br/pub/apache/tomcat/tomcat-9/v9.0.10/bin/apache-tomcat-9.0.10.tar.gz
tar -xvf apache-tomcat-9.0.10.tar.gz
mv apache-tomcat-9.0.10 tomcat
rm -f apache-tomcat-9.0.10.tar.gz
cd /usr/local/tomcat
chgrp -R tomcat conf
chmod g+rwx conf
chmod g+r conf/*
chown -R tomcat webapps/ work/ temp/ logs/
chown -R tomcat:tomcat *
chown -R tomcat:tomcat /usr/local/tomcat
```
### Criando o serviço do Tomcat
```bash
echo '# Systemd unit file for tomcat
[Unit]
Description=Apache Tomcat Web Application Container
After=syslog.target network.target
[Service]
Type=forking
Environment=JAVA_HOME=/usr/local/java
Environment=CATALINA_PID=/usr/local/tomcat/temp/tomcat.pid
Environment=CATALINA_HOME=/usr/local/tomcat
Environment=CATALINA_BASE=/usr/local/tomcat
Environment='CATALINA_OPTS=-Xms512M -Xmx1024M -server -XX:+UseParallelGC'
Environment='JAVA_OPTS=-Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom'
ExecStart=/usr/local/tomcat/bin/startup.sh
ExecStop=/bin/kill -15 $MAINPID
User=tomcat
Group=tomcat
[Install]
WantedBy=multi-user.target' > /etc/systemd/system/tomcat.service
```

Observação: Pode ser que em algumas distribuições o caminho da pasta do systemd seja diferente, para isso na última linha do código acima, troque o caminho (depois do simbolo ">") pelo caminho correto de sua pasta do systemd mais o nome do serviço (tomcat.service).

### Tomcat no Boot (Etapa opcional)
Esta etapa deve ser realizada se você quiser que sempre ao iniciar seu sistema operacional, o tomcat inicie junto, caso contrário ela é desnecessária.

```bash
systemctl daemon-reload
systemctl start tomcat
systemctl enable tomcat
```

Observação: caso você tenha optado por não executar esta etapa, sempre que você iniciar o sistema operacional, o serviço do tomcat deve ser iniciado com o comando ``sudo service tomcat start``

### Configuração de usuários do Tomcat
Entre na pasta do tomcat e depois em /conf. e depois abra com o vim, nano, vi ou outro app de texto o arquivo tomcat-users.xml em modo superuser.(comandos abaixo)
```bash
cd /usr/local/tomcat/conf
sudo vim tomcat-users.xml
```
Você verá as configurações de usuários e permissões do Tomcat. Altere conforme desejar. Você precisará saber o usuário e senha do usuário admin. O arquivo deverá ter, alem de outras coisas, o conteúdo abaixo.
```xml
<tomcat-users . . .>
  . . .
    <role rolename="manager-gui"/>
    <role rolename="admin-gui"/>
    <user username="admin" password="password" roles="manager-gui,admin-gui"/>
  . . .
</tomcat-users>
```
Altere ou adicione usuários como achar necessário, mas não esqueça das credenciais do administrador. No final, salve suas alterações.

### Adicionando permissões de acesso externas
Versões mais recentes do tomcat restringem acesso de requisições externas ao manager. Para mudar isso, execute os seguintes passos:

Abra o arquivo context.xml da pasta manager
```bash
sudo vim usr/local/tomcat/webapps/manager/META-INF/context.xml
```

depois de aberto o arquivo, comente o conteúdo da tag 'Valve' usando ``<!-- -->`` (como abaixo) nele, e salve:

```xml
<Context antiResourceLocking="false" privileged="true" >
  <!--<Valve className="org.apache.catalina.valves.RemoteAddrValve"
         allow="127\.\d+\.\d+\.\d+|::1|0:0:0:0:0:0:0:1" />-->
</Context>
```
Faça exatamente o mesmo procedimento abrindo o arquivo context.xml da pasta host-manager.
```bash
sudo vim /usr/local/tomcat/webapps/host-manager/META-INF/context.xml
```
### alterando a porta do tomcat para 8081

Na pasta ``/usr/local/tomcat/conf`` abra o arquivo server.xml

```bash
sudo vim /usr/local/tomcat/conf/server.xml
```
Procure pelo trecho como escrito abaixo e troque o atributo ``port=8080`` por ``port=8081``
```xml
<Connector port="8080" protocol="HTTP/1.1"
           connectionTimeout="20000"
           redirectPort="8443" />
```
Feche o arquivo salvando-o.

Reinicie o tomcat: ``sudo service tomcat restart``

Ao abrir http://[[seu_domínio]]:8081/ você deverá ver a página de boas vindas do tomcat. Se isto não ocorrer, algo de errado aconteceu, e neste caso será necessário revisar a instalação.

## Instalando o SSLRel
### Instalação do submódulo de integração.
Faça clone do repositório do submodulo SSLRel na sua instalação do i-educar seguindo os passos abaixo.

```bash
cd /caminho/para/raiz/do/ieducar/no/servidor/
ls
```
Deverá aparecer arquivos da pasta raiz do ieducar, como o arquivo phinx.yml, o Dockerfile, a pasta ieducar, etc.

Entre na pasta ieducar
``cd ieducar``

Dê clone do submódulo.

``git clone https://github.com/filipeRmlh/SSLRel.git``

Abra o arquivo index.php que também se encontra na pasta ieducar e cole logo abaixo da linha aonde tem ``<title>Sistema de gestão escolar | i-Educar</title>`` o seguinte conteúdo:
``<script src="SSLRel/SSLRel.js"></script>``

 Feche salvando o arquivo index.php.

### Configuração do Arquivo .war
Baixe o arquivo em zip da branch SSL do repositório FES-UFRJ no github.

* Url da branch: https://github.com/luisfcosta2015/FES-UFRJ/tree/SSL

* Url do arquivo para download (este é que deverá ser baixado): https://github.com/luisfcosta2015/FES-UFRJ/archive/SSL.zip

Descompacte o arquivo zip em algum diretório de sua preferência (exemplo: pasta ``/home/seu_usuario/Downloads``).

Abra a pasta descompactada e abra o seguinte caminho dentro dela.

``Project/out/sslrel``

Abra o arquivo sslrel.war com seu gerenciador de arquivos compactados e extraia somente o arquivo .env.example que se encontra na pasta WEB-INF do arquivo compactado. 

renomeie o .env.example extraido para .env

abra o arquivo .env
Preencha com as informações do seu Banco de Dados do ieducar.

insira novamente o arquivo .env modificado dentro do arquivo compactado sslrel.war no mesmo lugar onde está o .env.example;

Ainda no seu computador, abra a seguinte url no seu navegador:

``http://[[seu_domínio]]:8081/manager/``

digite o usuário e senha determinados anteriormente na instalação do Tomcat.

Aparecerá uma lista das aplicações rodando no Tomcat (inclusive o próprio manager).

role a página para baixo até encontrar a subseção "WAR file to deploy" da seção "Deploy".

Clique no botão "Browse".

Abrirá uma janela para escolha de arquivo.

escolha o sslrel.war que foi alterado.

clique em deploy.

Ao abrir ``http://[[seu_domínio]]:8081/sslrel/`` você deverá ver uma página simples dando boas vindas ao SSLRel.
