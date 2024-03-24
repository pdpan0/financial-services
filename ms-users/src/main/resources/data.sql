INSERT INTO ms_users.tb_users(full_name, tax_number, email, password)
VALUES ('Lucas Martins', '12345678901', 'lm@mailinator.com', 'teste123')
ON CONFLICT DO NOTHING;

INSERT INTO ms_users.tb_users(full_name, tax_number, email, password, is_shopkeeper)
VALUES ('Lucas Vendedor', '10987654321', 'lm_vendedor@mailinator.com', 'teste123', true)
ON CONFLICT DO NOTHING;