/**
 * Author:  rogerio
 * Created: Mar 13, 2020
 */

CREATE TABLE farmacia(
id INTEGER PRIMARY KEY AUTOINCREMENT,
nome_remedio VARCHAR(255) NOT NULL,
bula VARCHAR(255) NOT NULL,
quantidade INT NOT NULL,
preco FLOAT NOT NULL);

INSERT INTO farmacia (nome_remedio, bula, quantidade, preco) VALUES 
('Dorflex', 'relaxante muscular', 500, 10.99),
('Xarelto', 'anticoagulante', 322, 12.00),
('Selozok', 'redução da pressão arterial', 300, 1.50),
('Neosaldina', 'analgesico', 350, 5.98),
('Torsilax', 'relaxante muscular', 40, 35.00),
('Aradois', 'anti-hipertensivo', 430, 52.25),
('Glifage XR', 'antidiabetico', 242, 41.00),
('Addera D3', 'suplemento de vitamina D', 35, 70.00),
('Anthelios', 'protetor solar', 40, 45.00),
('Buscopan composto', 'reduz sintomas de colicas menstruais', 62, 8.90);

SELECT * FROM farmacia;