-- Tabela de Usuários
create table usr (
    user_id int not null auto_increment,
    username varchar (60) NOT NULL,
    email varchar (30),
    password_hash varchar (255) NOT NULL,
    primary key (user_id)
);

-- Tabela de Livros
create table book (
    book_id int not null auto_increment,
    title varchar (100) not null,
	author VARCHAR(50),
    category varchar (100),
    condit varchar (20),
    price decimal(10, 2) not null ,
    user_id int,
    primary key (book_id)
);

-- Tabela de Mensagens (Chat)
create table chat (
    chat_id int not null auto_increment,
    sender_id int not null,
    receiver_id int not null,
    message_text text,
    timestamp datetime not null,
    primary key (chat_id)
);

-- Tabela de Configurações do Usuário
create table user_settings (
    setting_id int not null auto_increment,
    user_id int not null,
    notification_preference boolean,
	primary key (setting_id)
);

-- Tabela de localização
create table localizacao (
	loc_id int not null auto_increment,
	loc_concelhos varchar(60) not null, 		
	primary key (loc_id)
);	     

-- Tabela de Feed (Atividades/Anúncios)
create table feed (
    feed_id int not null auto_increment,
    book_id int not null,
    action_type varchar (20),
    timestamp datetime not null,
    primary key (feed_id)
);

-- Tabela de classificações
create table avaliacao_usuario (
    id_avaliacao int not null auto_increment,
    id_usuario_avaliado int,
    id_usuario_avaliador int,
    id_livro int,
    classificacao int,
    comentario text,
    data_avaliacao timestamp default current_timestamp,
    primary key (id_avaliacao)
);



create table anuncio (
id_anu int not null auto_increment
	user_id int
    title varchar (100) not null,
	author VARCHAR(50),
    category varchar (30),
    condit varchar (20),
    price decimal(10, 2) not null 
    descr varchar (200) not null
    numbr decimal (10, 2)
   anuncio loc_id varchar (60)
    primary key (id_anu)
);

-- Tabela de Compras
create table compra (
    compra_id int not null auto_increment,
    user_id int,
    compra_estrela decimal(10, 2),
    primary key (compra_id)
);


 
    create table categoria (
	catg_id int not null auto_increment,
    category varchar (45),
    catg_temas varchar(100) not null, 		
	primary key (catg_id)
 );



alter table anuncio 
add constraint anuncio_fk_usr
foreign key (anu_user_id) references usr(user_id) 

alter table anuncio 
add constraint anuncio_fk_usr
foreign key (user_id) references usr(user_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;


alter table compra
add constraint compra_fk_usr
foreign key (user_id) references usr(user_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;


alter table avaliacao_usuario
add constraint avaliacao_usuario_fk_usuario_avaliado
foreign key (id_usuario_avaliado) references usr(user_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table avaliacao_usuario
add constraint avaliacao_usuario_fk_usuario_avaliador
foreign key (id_usuario_avaliador) references usr(user_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table avaliacao_usuario
add constraint avaliacao_usuario_fk_livro
foreign key (id_livro) references book(book_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;


alter table chat
add constraint chat_fk_sender
foreign key (sender_id) references usr(user_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;

alter table chat
add constraint chat_fk_receiver
foreign key (receiver_id) references usr(user_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;


alter table feed
add constraint feed_fk_book
foreign key (book_id) references book(book_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;


alter table book
add constraint book_fk_user
foreign key (user_id) references usr(user_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;


alter table user_settings
add constraint user_settings_fk_usr
foreign key (user_id) references usr(user_id) 
ON DELETE NO ACTION ON UPDATE NO ACTION;




