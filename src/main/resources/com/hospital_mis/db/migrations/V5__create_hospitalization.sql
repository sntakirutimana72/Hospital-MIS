CREATE TABLE patients (
  id SERIAL PRIMARY KEY,
  name VARCHAR(24) NOT NULL,
  surname VARCHAR(24) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone VARCHAR(16) NOT NULL,

  CONSTRAINT patients_unique_phone UNIQUE (phone)
);

CREATE TABLE admissions (
  id SERIAL PRIMARY KEY,
  patient_id INT NOT NULL REFERENCES patients(id),
  admitted_by_id INT NOT NULL REFERENCES doctors(id)
);

CREATE TABLE diagnosis (
  id SERIAL PRIMARY KEY,
  done_by_id INT NOT NULL REFERENCES doctors(id),
  admission_id INT NOT NULL REFERENCES admissions(id),
  description TEXT NOT NULL,
  results TEXT
);

CREATE TABLE ward_assignments (
  id SERIAL PRIMARY KEY,
  signed_by_id INT NOT NULL REFERENCES doctors(id),
  admission_id INT NOT NULL REFERENCES admissions(id),
  ward_id INT NOT NULL REFERENCES wards(id),
  bed_number INT NOT NULL,
  assigned_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  vacated_at TIMESTAMP,

  CONSTRAINT ward_assignments_uniqueness UNIQUE(ward_id, bed_number, assigned_at)
);