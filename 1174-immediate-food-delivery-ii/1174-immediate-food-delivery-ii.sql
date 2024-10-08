# Write your MySQL query statement below
WITH FirstOrders AS (
    -- Find the first order of each customer
    SELECT 
        customer_id, 
        MIN(order_date) AS first_order_date
    FROM 
        Delivery
    GROUP BY 
        customer_id
),
ImmediateOrders AS (
    -- Join with the Delivery table to get the details of the first orders
    SELECT 
        d.customer_id, 
        d.order_date, 
        d.customer_pref_delivery_date
    FROM 
        Delivery d
    JOIN 
        FirstOrders f
    ON 
        d.customer_id = f.customer_id 
        AND d.order_date = f.first_order_date
)
-- Calculate the percentage of immediate first orders
SELECT 
    ROUND(SUM(CASE WHEN order_date = customer_pref_delivery_date THEN 1 ELSE 0 END) * 100.0 / COUNT(*), 2) AS immediate_percentage
FROM 
    ImmediateOrders;
