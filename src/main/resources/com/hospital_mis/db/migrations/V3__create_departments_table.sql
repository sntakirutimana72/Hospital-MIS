CREATE TABLE buildings (
  id SERIAL PRIMARY KEY,
  name VARCHAR(16) NOT NULL,

  CONSTRAINT buildings_unique_name UNIQUE (name)
);

CREATE TABLE departments (
  id SERIAL PRIMARY KEY,
  name VARCHAR(16) NOT NULL,
  director_id INT NOT NULL REFERENCES doctors(id),
  building_id INT NOT NULL REFERENCES buildings(id),

  CONSTRAINT departments_unique_name UNIQUE (name)
);