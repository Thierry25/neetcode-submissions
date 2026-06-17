-- Write your query below
SELECT e.left_operand,
       e.operator,
       e.right_operand,
       CASE
          WHEN e.operator = '>' AND lo.value > ro.value THEN 'true'
          WHEN e.operator = '<' AND lo.value < ro.value THEN 'true'
          WHEN e.operator = '=' AND lo.value = ro.value THEN 'true'
          ELSE 'false'
        END AS value
FROM expressions e
LEFT JOIN variables lo ON lo.name = e.left_operand
LEFT JOIN variables ro ON ro.name = e.right_operand