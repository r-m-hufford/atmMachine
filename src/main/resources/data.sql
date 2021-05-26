CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
);

INSERT INTO customers (first_name, last_name, email) VALUES
    ('roy', 'royson', 'roy@roymail.com'),
    ('ron', 'ronfield', 'ron@ronmail.com'),
    ('rich', 'mcrich', 'rich@richmail.com');