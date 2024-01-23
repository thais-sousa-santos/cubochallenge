CREATE TABLE clients (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    participation FLOAT NOT NULL
);