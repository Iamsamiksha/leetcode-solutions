WITH TotalProducts AS (
    -- Count total distinct products from the Product table
    SELECT COUNT(DISTINCT product_key) AS total_product_count
    FROM Product
),
CustomerProductCount AS (
    -- Count distinct products bought by each customer
    SELECT customer_id, COUNT(DISTINCT product_key) AS product_count
    FROM Customer
    GROUP BY customer_id
)
-- Select customers whose distinct product count matches the total product count
SELECT customer_id
FROM CustomerProductCount cpc
JOIN TotalProducts tp
ON cpc.product_count = tp.total_product_count;
