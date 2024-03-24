INSERT INTO ms_transactions.tb_transactions(id_payer, id_payee, status, vl_transaction)
VALUES (1, 2, 'PENDING', 50)
ON CONFLICT DO NOTHING;