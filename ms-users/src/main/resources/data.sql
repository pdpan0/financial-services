CREATE TABLE IF NOT EXISTS ms_users.tb_users(
    id_user SERIAL PRIMARY KEY,
    full_name VARCHAR NOT NULL,
    tax_number VARCHAR NOT NULL UNIQUE,
    email VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    vl_balance DECIMAL(18, 2) DEFAULT 0.0 NOT NULL
);


INSERT INTO ms_users.tb_users(full_name, tax_number, email, password)
VALUES ('Lucas Martins', '12345678901', 'lm@mailinator.com', 'teste123')
ON CONFLICT DO NOTHING;
