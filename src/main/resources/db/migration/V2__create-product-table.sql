CREATE TABLE product (
    id UUID PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(50) NOT NULL,
    description TEXT,
    price INTEGER NOT NULL,
    category_id UUID NOT NULL,
    created_at TIMESTAMP NOT NULL,
    FOREIGN KEY (category_id) REFERENCES category(id) ON DELETE CASCADE
);