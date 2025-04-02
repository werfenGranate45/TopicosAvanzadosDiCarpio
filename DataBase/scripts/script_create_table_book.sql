CREATE TABLE book (
    id_book INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    publisher VARCHAR(255),
    year_publish INT,
    price DECIMAL(10,2),
    created_at DATE NOT NULL,
    updated_at DATE NOT NULL,
    deleted_at SMALLINT DEFAULT 0
);
