CREATE TABLE category (
    id UUID PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    description TEXT,
    created_at TIMESTAMP NOT NULL
);