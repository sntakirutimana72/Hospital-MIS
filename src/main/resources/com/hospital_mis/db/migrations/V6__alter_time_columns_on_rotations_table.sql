ALTER TABLE rotations
  ALTER COLUMN start_time TYPE TIME NOT NULL,
  ALTER COLUMN end_time TYPE TIME NOT NULL;

ALTER TABLE rotations
  DROP CONSTRAINT rotations_unique_timestamp;

ALTER TABLE rotations
  ADD CONSTRAINT rotations_unique_time UNIQUE (start_time, end_time);
