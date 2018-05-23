CREATE TABLE `escola` (
 
 `inep` int(10) unsigned NOT NULL,

 `unidade` varchar(80) DEFAULT NULL,
 
 `telefone` varchar(20) DEFAULT NULL,
 
 `estado` varchar(80) DEFAULT NULL,
 
 `prefeitura` varchar(80) DEFAULT NULL,
 
 `secretaria` varchar(80) DEFAULT NULL,
 
 `subSecretaria` varchar(80) DEFAULT NULL,
 
 `departamento` varchar(80) DEFAULT NULL,
 
 PRIMARY KEY (`inep`),
 
 UNIQUE KEY `inep_UNIQUE` (`inep`)

) ENGINE=InnoDB DEFAULT CHARSET=latin1