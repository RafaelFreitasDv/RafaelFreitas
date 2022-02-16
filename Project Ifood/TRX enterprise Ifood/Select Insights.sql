
--Restaurante melhor avaliado na categoria lanches

SELECT T2.NM_REST,(SUM(NT_AVALIACAO)/COUNT(1)) MEDIA
FROM T_AVALIACAO T1, T_REST T2
WHERE T2.ID_REST = T1.T_REST_ID_REST
AND NM_CATG = 'Lanches'
GROUP BY T2.NM_REST
ORDER BY MEDIA DESC
;

-- Rankear os 3 primeiros restaurantes com mais pedidos

    
SELECT
  RESTAURANTE.id_rest, RESTAURANTE.nm_rest, COUNT(T_PEDIDOS.id_pedido)
FROM T_REST RESTAURANTE
JOIN T_REG_PROD ON T_REG_PROD.T_REST_id_rest = RESTAURANTE.id_rest
JOIN T_PEDIDOS ON T_PEDIDOS.T_REG_PROD_id_reg_prod = T_REG_PROD.id_reg_prod
GROUP BY RESTAURANTE.id_rest, RESTAURANTE.nm_rest
ORDER BY COUNT(T_PEDIDOS.id_pedido);

---cliente que mais realizou pedidos nos restaurantes


SELECT 
  T_REST.id_rest, T_REST.nm_rest, T_CLIENTE.id_cliente, T_CLIENTE.nm_cliente, COUNT(T_PEDIDOS.id_pedido)
FROM T_CLIENTE
JOIN T_PEDIDOS ON T_PEDIDOS.T_CLIENTE_id_cliente = T_CLIENTE.id_cliente
JOIN T_REG_PROD ON T_REG_PROD.id_reg_prod = T_PEDIDOS.T_REG_PROD_id_reg_prod
JOIN T_REST ON T_REST.id_rest = T_REG_PROD.T_REST_id_rest
GROUP BY T_REST.id_rest, T_REST.nm_rest, T_CLIENTE.id_cliente, T_CLIENTE.nm_cliente
ORDER BY COUNT(T_PEDIDOS.id_pedido);



