# Write your MySQL query statement below

select unique_id, name 
from employees e
left join employeeUNI euni on euni.id = e.id