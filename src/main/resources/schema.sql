DROP TABLE IF EXISTS army_unit_wave;
DROP TABLE IF EXISTS wave;
DROP TABLE IF EXISTS army_unit;
DROP TABLE IF EXISTS being;

CREATE TABLE being (
	being_id int NOT NULL AUTO_INCREMENT,
	name varchar(256) NOT NULL,
	origin varchar(256) NOT NULL,
	PRIMARY KEY (being_id)
);

CREATE TABLE army_unit (
	army_unit_id int NOT NULL AUTO_INCREMENT,
	being_id int NOT NULL,
	valkyrie_general varchar(64),
	basic_move int NOT NULL,
	basic_range int NOT NULL,
	basic_attack int NOT NULL,
	basic_defense int NOT NULL,
	PRIMARY KEY (army_unit_id),
	FOREIGN KEY (being_id) REFERENCES being (being_id) ON DELETE CASCADE
);

CREATE TABLE wave (
	wave_id int NOT NULL AUTO_INCREMENT,
	wave_name varchar(256) NOT NULL,
	copyright_year varchar(4) NOT NULL,
	version varchar(32) NOT NULL,
	PRIMARY KEY (wave_id)
);

CREATE TABLE army_unit_wave (
	army_unit_id int NOT NULL,
	wave_id int NOT NULL,
	FOREIGN KEY (army_unit_id) REFERENCES army_unit (army_unit_id) ON DELETE CASCADE,
	FOREIGN KEY (wave_id) REFERENCES wave (wave_id) ON DELETE CASCADE
);