# Instalando o mySQL
Podemos dividir o processo em duas partes, instalar
o mysql, e instalar o mySQL workbench.

## Ubuntu:
O tutorial que utilizei e funcionou foi este [aqui](http://cursosdeprogramacao.com.br/blog/instalando-o-mysql-server-e-mysql-workbench-ubuntu/).


# Levantando o Servidor

Basicamente é preciso utilizar dois comandos, um para deixá-lo online, e outro para offline.

## Ubuntu
Para levantar o servidor:
```
sudo service mysql start

```

Para desligar o servidor:
```
sudo service mysql stop

```


# Problemas com a senha root
Para estabelecer a conexão entre o workbench e o server,
é preciso utilizar a senha. Como eu havia esquecido,
pois havia instalado isso faz um tempão, tive que resetar
a senha. [Aqui](https://coderwall.com/p/j9btlg/reset-the-mysql-5-7-root-password-in-ubuntu-16-04-lts) tem um tutorial que funcionou comigo.

# Algumas dicas:
Para ver o status do server:
```
sudo service mysql status

```
Para acessar o banco de dados como servidor:  
(É possível configurar o BD por aqui também)
```
mysql -u <username> -p
(Ele vai pedir e ai você digita sua senha).

```
