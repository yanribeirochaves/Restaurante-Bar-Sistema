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
descricao varchar(80),
volume float, -- para bebidas
peso float, -- para comidas
unidades int, -- para porções
valor double
)default charset = utf8 ENGINE = innodb;

create table mesas(
id_mesa int primary key,
status_mesa boolean -- false para mesa sem cliente e true para mesa com cliente
)default charset = utf8 ENGINE = innodb;

create table usuario(
id_usuario int auto_increment primary key,
username varchar(30) unique,
senha varchar(50),
id_acesso int,
id_mesa int unique,
CONSTRAINT fk_UserAcesso FOREIGN KEY (id_acesso) REFERENCES nivelAcessoUsuario (id_acesso),
CONSTRAINT fk_UserMesa FOREIGN KEY (id_mesa) REFERENCES mesas (id_mesa)
)default charset = utf8 ENGINE = innodb;

create table pedidos(
id_pedido int primary key auto_increment,
id_produto int,
quantidade_produto int,
observacao varchar(90),
id_mesa int,
status_pedido boolean, -- false quando um pedido ainda não foi entregado e true para pedido entregado
CONSTRAINT fk_ProdPed FOREIGN KEY (id_produto) REFERENCES produtos (id_produto),
CONSTRAINT fk_MesaPed FOREIGN KEY (id_mesa) REFERENCES mesas (id_mesa)
)default charset = utf8 ENGINE = innodb;

-- dados testes iniciais
-- produtos
insert into produtos (nome, tipo, descricao, valor) values ('bolinho caipira', 'comida', 'ingredientes ....', 3.50);
insert into produtos (nome, tipo, descricao, valor) values ('Porção batata frita', 'porção', 'porção para duas pessoas', 20.50);
insert into produtos (nome, tipo, descricao, volume, valor) values ('Imperio', 'cerveja', 'puro malte', 0.6, 7.00);

-- mesas
insert into mesas (id_mesa, status_mesa) values (1,false);
insert into mesas (id_mesa, status_mesa) values (2,false);
insert into mesas (id_mesa, status_mesa) values (3,false);
insert into mesas (id_mesa, status_mesa) values (4,false);
insert into mesas (id_mesa, status_mesa) values (5,false);
insert into mesas (id_mesa, status_mesa) values (6,false);
insert into mesas (id_mesa, status_mesa) values (7,true);
insert into mesas (id_mesa, status_mesa) values (8,true);

-- nivelDeAcesso
insert into nivelAcessoUsuario (id_acesso, nivel) values (1, 'Garçom');
insert into nivelAcessoUsuario (id_acesso, nivel) values (2, 'Gerente');
insert into nivelAcessoUsuario (id_acesso, nivel) values (3, 'Cliente');

-- usuario
insert into usuario (username, senha, id_acesso) values ('junior', 'junior', 2);
insert into usuario (username, senha, id_acesso) values ('carlos', 'carlos', 1);
insert into usuario (username, senha, id_acesso) values ('joao', 'joao', 1);
insert into usuario (username, senha, id_acesso, id_mesa) values ('cliente', 'cliente', 3, 7);
insert into usuario (username, senha, id_acesso, id_mesa) values ('cli', 'cli', 3, 8);

-- pedidos
-- simulação de um pedido que ainda não foi entregado
insert into pedidos (id_produto, quantidade_produto, id_mesa, status_pedido) values (1,2,7,false);
insert into pedidos (id_produto, quantidade_produto, observacao, id_mesa, status_pedido) values (2, 1, 'sem sal', 7, false);
insert into pedidos (id_produto, quantidade_produto, observacao, id_mesa, status_pedido) values (3, 4, 'no balde de gelo', 7, false);
-- simulação de pedido entregado
insert into pedidos (id_produto, quantidade_produto, id_mesa, status_pedido) values (1,2,8,true);

SELECT id_usuario from usuario WHERE username LIKE 'junior' and senha LIKE 'junior';
