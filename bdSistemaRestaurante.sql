create database restaurante
default character set utf8
default collate utf8_general_ci;
use restaurante;

create table nivelAcessoUsuario(
id_acesso int primary key,
nivel varchar(30)
)default charset = utf8 ENGINE = innodb;

create table produtos(
id_produto int primary key auto_increment,
nome varchar(30),
tipo varchar(30),
volume float,
peso float,
valor double
)default charset = utf8 ENGINE = innodb;

create table mesas(
id_mesa int primary key,
status_mesa boolean -- false para mesa sem cliente e true para mesa com cliente
)default charset = utf8 ENGINE = innodb;

create table usuario(
id_usuario int auto_increment primary key,
username varchar(30),
senha varchar(50),
id_acesso int,
id_mesa int,
CONSTRAINT fk_UserAcesso FOREIGN KEY (id_acesso) REFERENCES nivelAcessoUsuario (id_acesso),
CONSTRAINT fk_UserMesa FOREIGN KEY (id_mesa) REFERENCES mesas (id_mesa)
)default charset = utf8 ENGINE = innodb;

create table pedidos(
id_pedido int primary key auto_increment,
id_produto int,
quantidade_produto int,
observacao varchar(90),
id_mesa int,
status_pedido boolean,
CONSTRAINT fk_ProdPed FOREIGN KEY (id_produto) REFERENCES produtos (id_produto),
CONSTRAINT fk_MesaPed FOREIGN KEY (id_mesa) REFERENCES mesas (id_mesa)
)default charset = utf8 ENGINE = innodb;

-- dados testes iniciais
-- produtos
insert into produtos (nome, tipo, valor) values ('bolinho caipira', 'comida', 3.50);
insert into produtos (nome, tipo, valor) values ('asa de frango', 'comida', 2);
insert into produtos (nome, tipo, volume, valor) values ('Imperio', 'cerveja', 0.6, 8.50);
insert into produtos (nome, tipo, volume, valor) values ('Imperio', 'cerveja', 360, 5);

-- mesas
insert into mesas (id_mesa, status_mesa) values (1,false);
insert into mesas (id_mesa, status_mesa) values (2,false);
insert into mesas (id_mesa, status_mesa) values (3,false);
insert into mesas (id_mesa, status_mesa) values (4,false);
insert into mesas (id_mesa, status_mesa) values (5,false);
insert into mesas (id_mesa, status_mesa) values (6,false);


-- nivelDeAcesso
insert into nivelAcessoUsuario (id_acesso, nivel) values (1, 'Garçom');
insert into nivelAcessoUsuario (id_acesso, nivel) values (2, 'Gerente');
insert into nivelAcessoUsuario (id_acesso, nivel) values (3, 'Cliente');

-- usuario
insert into usuario (username, senha, id_acesso) values ('junior', 'junior', 2);
insert into usuario (username, senha, id_acesso) values ('carlos', 'carlos', 1);
insert into usuario (username, senha, id_acesso) values ('joao', 'joao', 1);



