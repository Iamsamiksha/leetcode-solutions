WITH ProductRevenue AS (
    SELECT 
        u.product_id,
        SUM(u.units * p.price) AS total_revenue,
        SUM(u.units) AS total_units
    FROM 
        UnitsSold u
    JOIN 
        Prices p
    ON 
        u.product_id = p.product_id
    AND 
        u.purchase_date BETWEEN p.start_date AND p.end_date
    GROUP BY 
        u.product_id
)

SELECT 
    p.product_id,
    ROUND(COALESCE(pr.total_revenue / pr.total_units, 0), 2) AS average_price
FROM 
    Prices p
LEFT JOIN 
    ProductRevenue pr
ON 
    p.product_id = pr.product_id
GROUP BY 
    p.product_id;
