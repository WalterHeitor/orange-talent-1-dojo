INSERT INTO PAIS(id, nome) VALUES (1, 'Brasil');
INSERT INTO PAIS(id, nome) VALUES (2, 'Argentina');
INSERT INTO PAIS(id, nome) VALUES (3, 'Chile');
INSERT INTO PAIS(id, nome) VALUES (4, 'Uruguai');

INSERT INTO AEROPORTO(id, nome, pais_id) VALUES (1, 'Aeroporto Internacional de Guarulhos', 1);
INSERT INTO AEROPORTO(id, nome, pais_id) VALUES (2, 'Aeroporto Ten. Cel. Aviador César Bombonato', 1);
INSERT INTO AEROPORTO(id, nome, pais_id) VALUES (3, 'Aeroporto Internacional Ministro Pistarini', 2);
INSERT INTO AEROPORTO(id, nome, pais_id) VALUES (4, 'Aeroporto Internacional Comodoro Arturo Merino Benítez', 3);
INSERT INTO AEROPORTO(id, nome, pais_id) VALUES (5, 'Aeroporto Internacional de Carrasco', 4);

INSERT INTO COMPANHIA(id, instante_criacao, nome, pais_id) VALUES (1, CURRENT_TIMESTAMP(), 'Zup Airlines', 1);