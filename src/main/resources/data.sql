--Waves
--1
INSERT INTO wave (wave_name, copyright_year, version) VALUES ('Nerak''s Return', '2005', 'Classic');
--2
INSERT INTO wave (wave_name, copyright_year, version) VALUES ('Rise of the Valkyrie', '2004', 'Classic');
--3
INSERT INTO wave (wave_name, copyright_year, version) VALUES ('Sir Hawthorne''s Arrival', '2006', 'Classic');
--4
INSERT INTO wave (wave_name, copyright_year, version) VALUES ('Skahen''s Rescue', '2008', 'Classic');
--5
INSERT INTO wave (wave_name, copyright_year, version) VALUES ('Swarm of the Marro', '2007', 'Classic');
--6
INSERT INTO wave (wave_name, copyright_year, version) VALUES ('The Master''s Arrival', '2007', 'Classic');
--7
INSERT INTO wave (wave_name, copyright_year, version) VALUES ('Valkrill''s Gambit', '2009', 'Classic');
--8
INSERT INTO wave (wave_name, copyright_year, version) VALUES ('Viper''s Vengeance', '2005', 'Classic');
--9
INSERT INTO wave (wave_name, copyright_year, version) VALUES ('The Conflict Begins', '2007', 'Marvel');


--Beings
--1
INSERT INTO being (name, origin) VALUES ('Agent Carr','Earth');
--2
INSERT INTO being (name, origin) VALUES ('Airborne Elite','Earth');
--3
INSERT INTO being (name, origin) VALUES ('Deathwalker 9000','Alpha Prime');
--4
INSERT INTO being (name, origin) VALUES ('Finn the Viking Champion','Earth');
--5
INSERT INTO being (name, origin) VALUES ('Grimnak','Grut');
--6
INSERT INTO being (name, origin) VALUES ('Izumi Samurai','Earth');
--7
INSERT INTO being (name, origin) VALUES ('Krav Maga Agents','Earth');
--8
INSERT INTO being (name, origin) VALUES ('Marro Warriors','Marr');
--9
INSERT INTO being (name, origin) VALUES ('Mimring','Icaria');
--10
INSERT INTO being (name, origin) VALUES ('Ne-Gok-Sa','Marr');
--11
--Next one is spelled wrong to use as example for UPDATE operation, correct spelling is Raelin
INSERT INTO being (name, origin) VALUES ('Railen the Kyrie Warrior','Valhalla');
--12
INSERT INTO being (name, origin) VALUES ('Sgt. Drake Alexander','Earth');
--13
INSERT INTO being (name, origin) VALUES ('Syvarris','Feylund');
--14
INSERT INTO being (name, origin) VALUES ('Tarn Viking Warriors','Earth');
--15
INSERT INTO being (name, origin) VALUES ('Thorgrim the Viking Champion','Earth');
--16
INSERT INTO being (name, origin) VALUES ('Zettian Guards','Alpha Prime');
--17
INSERT INTO being (name, origin) VALUES ('Elite Onyx Vipers','Marr');
--18
INSERT INTO being (name, origin) VALUES ('Major Q10','Alpha Prime');
--19
INSERT INTO being (name, origin) VALUES ('Marrden Nagrubs','Marr');
--20
INSERT INTO being (name, origin) VALUES ('Marro Drudge','Marr');
--21
INSERT INTO being (name, origin) VALUES ('Marro Hive','Marr');
--22
INSERT INTO being (name, origin) VALUES ('Marro Stingers','Marr');
--23
INSERT INTO being (name, origin) VALUES ('Shiori','Earth');
--24
INSERT INTO being (name, origin) VALUES ('Sonlen','Feylund');
--25
INSERT INTO being (name, origin) VALUES ('Tor-Kul-Na','Marr');
--26
INSERT INTO being (name, origin) VALUES ('Granite Guardians','Valhalla');
--27
INSERT INTO being (name, origin) VALUES ('Nerak the Glacian Swig Rider','Grut');
--28
INSERT INTO being (name, origin) VALUES ('Quasatch Hunters','Valhalla');
--29
INSERT INTO being (name, origin) VALUES ('Sir Hawthorne','Earth');


--Army Units and Join Table
--1
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (1, 'Vydar', 7, 4, 4, 6);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (1, 2);

--2
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (2, 'Jandar', 4, 8, 3, 2);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (2, 2);

--3
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (3, 'Utgar', 5, 7, 4, 9);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (3, 2);

--4
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (4, 'Jandar', 5, 1, 3, 6);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (4, 2);

--5
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (5, 'Utgar', 5, 1, 6, 7);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (5, 2);

--6
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (6, 'Einar', 6, 1, 3, 6);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (6, 2);

--7
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (7, 'Vydar', 6, 7, 3, 3);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (7, 2);

--8
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (8, 'Utgar', 6, 6, 2, 4);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (8, 2);

--9
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (9, 'Utgar', 6, 6, 6, 8);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (9, 2);

--10
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (10, 'Utgar', 5, 1, 4, 7);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (10, 2);

--11
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (11, 'Jandar', 7, 1, 3, 7);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (11, 2);

--12
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (11, 'Jandar', 7, 1, 3, 7);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (12, 5);

--13
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (12, 'Jandar', 6, 1, 6, 7);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (13, 2);

--14
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (12, 'Jandar', 6, 1, 6, 8);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (14, 5);

--15
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (13, 'Ullar', 5, 9, 4, 5);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (15, 2);

--16
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (14, 'Jandar', 4, 1, 3, 4);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (16, 2);

--17
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (15, 'Jandar', 5, 1, 3, 6);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (17, 2);

--18
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (16, 'Utgar', 4, 7, 2, 7);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (18, 2);

--19
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (17, 'Ullar', 7, 1, 3, 4);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (19, 7), (19, 8);

--20
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (18, 'Vydar', 5, 8, 5, 8);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (20, 5);

--21
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (19, 'Utgar', 6, 1, 2, 2);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (21, 5);

--22
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (20, 'Utagr', 7, 5, 2, 3);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (22, 5);

--23
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (21, 'Utgar', 0, 4, 4, 9);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (23, 5);

--24
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (22, 'Utgar', 5, 5, 3, 3);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (24, 5);

--25
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (23, 'Einar', 7, 1, 4, 5);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (25, 5);

--26
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (24, 'Ullar', 5, 6, 5, 6);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (26, 5);

--27
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (25, 'Utgar', 6, 1, 6, 9);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (27, 5);

--28
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (26, 'Aquilla', 6, 1, 3, 5);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (28, 7);

--29
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (27, 'Utgar', 8, 1, 3, 6);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (29, 7), (29, 1);

--30
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (28, 'Aquilla', 4, 1, 4, 6);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (30, 7);

--31
INSERT INTO army_unit 
(being_id, valkyrie_general, basic_move, basic_range, basic_attack, basic_defense)
VALUES (29, 'Utgar', 5, 1, 5, 6);

INSERT INTO army_unit_wave
(army_unit_id, wave_id)
VALUES (31, 7), (31, 3);








