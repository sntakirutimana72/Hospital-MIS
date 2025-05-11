CREATE TABLE "specialties"(
  id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,

  CONSTRAINT specialties_unique_name UNIQUE (name)
);


CREATE TABLE "doctors" (
  id SERIAL PRIMARY KEY,
  employee_id INT NOT NULL REFERENCES employees(id),
  specialty_id INT NOT NULL REFERENCES specialties(id),

  CONSTRAINT doctors_unique_employee_id UNIQUE (employee_id)
);