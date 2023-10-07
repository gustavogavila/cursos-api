CREATE SEQUENCE curso_seq MAXVALUE 9223372036854775807 NO CYCLE;
CREATE TABLE curso  (
	id BIGINT not null,
	descricao VARCHAR(255) not null,
	data_criacao TIMESTAMP not null,
	primary key (id)
) ;

CREATE SEQUENCE estudante_seq MAXVALUE 9223372036854775807 NO CYCLE;
CREATE TABLE estudante  (
	id BIGINT not null,
	email VARCHAR(100) not null,
	nome VARCHAR(255) not null,
	data_criacao TIMESTAMP not null,
	primary key (id)
) ;

CREATE TABLE curso_estudante  (
	id_curso BIGINT not null,
	id_estudante BIGINT not null,
	primary key (id_curso, id_estudante),
	foreign key (id_curso) references curso (id),
	foreign key (id_estudante) references estudante (id)
) ;

