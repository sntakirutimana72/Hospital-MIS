CREATE TABLE employees (
  id SERIAL PRIMARY KEY,
  firstname VARCHAR(24) NOT NULL,
  surname VARCHAR(24) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone VARCHAR(16) NOT NULL,

  CONSTRAINT employees_unique_phone UNIQUE (phone)
);
