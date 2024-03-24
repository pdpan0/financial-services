CREATE SCHEMA IF NOT EXISTS ms_transactions;

CREATE TABLE IF NOT EXISTS ms_transactions.tb_transactions(
    id_transaction SERIAL PRIMARY KEY,
    id_payer BIGINT NOT NULL,
    id_payee BIGINT NOT NULL,
    status VARCHAR NOT NULL,
    vl_transaction DECIMAL(18, 2) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW()
);