CREATE TABLE IF NOT EXISTS ms_users.tb_users(
    id_user SERIAL PRIMARY KEY,
    full_name VARCHAR NOT NULL,
    tax_number VARCHAR NOT NULL UNIQUE,
    email VARCHAR NOT NULL UNIQUE,
    password VARCHAR NOT NULL,
    vl_balance DECIMAL(18, 2) DEFAULT 0.0 NOT NULL,
    is_shopkeeper BOOLEAN NOT NULL DEFAULT FALSE,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    is_active BOOLEAN NOT NULL DEFAULT TRUE
);

INSERT INTO ms_users.tb_users(full_name, tax_number, email, password)
VALUES ('Lucas Martins', '12345678901', 'lm@mailinator.com', 'teste123')
ON CONFLICT DO NOTHING;

INSERT INTO ms_users.tb_users(full_name, tax_number, email, password, is_shopkeeper)
VALUES ('Lucas Vendedor', '10987654321', 'lm_vendedor@mailinator.com', 'teste123', true)
ON CONFLICT DO NOTHING;