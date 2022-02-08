/* CHATBOT */
CREATE DATABASE chatbot;

USE chatbot;

CREATE TABLE significado (
id INT(11) AUTO_INCREMENT PRIMARY KEY,
significado VARCHAR(100)
);

CREATE TABLE frase (
id INT(11) AUTO_INCREMENT PRIMARY KEY,
frase VARCHAR(300),
id_significado int(11)
/*foreign key (id_significado) references tb_significado(id)*/
);

CREATE TABLE respostas (
id INT(11) AUTO_INCREMENT PRIMARY KEY,
id_frase INT(11)
);

ALTER TABLE frase ADD FOREIGN KEY(id_significado) REFERENCES significado(id);
ALTER TABLE respostas ADD FOREIGN KEY(id_frase) REFERENCES frase(id);

SELECT * FROM significado;
SELECT * FROM frase;
SELECT * FROM respostas;