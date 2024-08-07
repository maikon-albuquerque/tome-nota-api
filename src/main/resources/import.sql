

insert into category (name, description, created_at, updated_at, is_active) values ( 'Pessoal', 'aqui ficarão as notas ', now(), now(), true );
insert into category (name, description, created_at, updated_at, is_active) values ( 'Trabalho', 'aqui ficarão as notas do trabalho', now(), now(), true );



insert into note (title, description, created_at, updated_at, is_active, category_id) values ( 'Comprar mesa', 'Lembrar de comprar mesa para notebook', now(), now(), true, 1 );
insert into note (title, description, created_at, updated_at, is_active, category_id) values ('Lavar roupas', 'Lavar roupa na casa da Flávia', now(), now(), true, 2 );
insert into note (title, description, created_at, updated_at, is_active, category_id) values ('Estudar', 'Ler o livro progamando em go', now(), now(), true, 1 );
insert into note (title, description, created_at, updated_at, is_active, category_id) values ('Limpar gaveta', 'Retirar coisa da gaveta do trabalho', now(), now(), true, 2 );