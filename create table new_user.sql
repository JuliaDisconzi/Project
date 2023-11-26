-- create table new_user
create table new_user (
    user_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(60) NOT NULL,
    email VARCHAR(30),
    password_hash VARCHAR(255) NOT NULL,
    PRIMARY KEY (user_id)
);

-- Tabela de Livros
create table new_book (
    book_id INT NOT NULL AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    author VARCHAR(50),
    category VARCHAR(30),
    `condition` VARCHAR(20),
    price DECIMAL(10, 2) NOT NULL,
    user_id INT,
    PRIMARY KEY (book_id),
    FOREIGN KEY (user_id) REFERENCES new_user(user_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Tabela de Mensagens (Chat)
create table new_chat (
    chat_id INT NOT NULL AUTO_INCREMENT,
    sender_id INT NOT NULL,
    receiver_id INT NOT NULL,
    message_text TEXT,
    timestamp DATETIME NOT NULL,
    PRIMARY KEY (chat_id),
    FOREIGN KEY (sender_id) REFERENCES new_user(user_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (receiver_id) REFERENCES new_user(user_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Tabela de Configurações do Usuário
create table new_user_settings (
    setting_id INT NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    notification_preference BOOLEAN,
    PRIMARY KEY (setting_id),
    FOREIGN KEY (user_id) REFERENCES new_user(user_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Tabela de Feed (Atividades/Anúncios)
create table new_feed (
    feed_id INT NOT NULL AUTO_INCREMENT,
    book_id INT NOT NULL,
    action_type VARCHAR(20),
    timestamp DATETIME NOT NULL,
    PRIMARY KEY (feed_id),
    FOREIGN KEY (book_id) REFERENCES new_book(book_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);

-- Tabela de Pesquisa por Categorias
create table new_category (
    category_id INT NOT NULL AUTO_INCREMENT,
    category_name VARCHAR(30) NOT NULL,
    PRIMARY KEY (category_id)
);

create table new_book_category (
    book_id INT NOT FULL,
    category_id INT NOT NULL,
    PRIMARY KEY (book_id, category_id),
    FOREIGN KEY (book_id) REFERENCES new_book(book_id) ON DELETE NO ACTION ON UPDATE NO ACTION,
    FOREIGN KEY (category_id) REFERENCES new_category(category_id) ON DELETE NO ACTION ON UPDATE NO ACTION
);
