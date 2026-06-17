-- Write your query below
SELECT w.name AS warehouse_name,
    SUM(CASE
        WHEN w.product_id = p.product_id THEN w.units * p.width * p.length * p.height
    END) AS volume
FROM warehouse w
LEFT JOIN products p ON w.product_id = p.product_id
GROUP BY w.name