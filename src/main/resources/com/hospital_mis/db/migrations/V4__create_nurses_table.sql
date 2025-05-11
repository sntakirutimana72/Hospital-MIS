CREATE TABLE rotations (
  id SERIAL PRIMARY KEY,
  start_time TIMESTAMP NOT NULL,
  end_time TIMESTAMP NOT NULL,

  CONSTRAINT rotations_unique_timestamp UNIQUE (start_time, end_time)
);

CREATE TABLE nurses (
  id SERIAL PRIMARY KEY,
  employee_id INT NOT NULL REFERENCES employees(id),
  rotation_id INT NOT NULL REFERENCES rotations(id),
  department_id INT NOT NULL REFERENCES departments(id),
  salary FLOAT NOT NULL,

  CONSTRAINT nurses_unique_employee_id UNIQUE (employee_id)
);

CREATE TYPE wards_status AS ENUM ('ready', 'full');

CREATE TABLE wards (
  id SERIAL PRIMARY KEY,
  ward_number INT NOT NULL,
  department_id INT NOT NULL REFERENCES departments(id),
  supervisor_id INT NOT NULL REFERENCES nurses(id),
  num_of_beds INT NOT NULL DEFAULT '1',
  status wards_status NOT NULL DEFAULT 'ready',

  CONSTRAINT wards_unique_department_ward_number UNIQUE (department_id, ward_number)
);