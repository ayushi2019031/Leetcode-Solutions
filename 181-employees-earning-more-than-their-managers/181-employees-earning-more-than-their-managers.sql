# Write your MySQL query statement below
select a.Name as 'Employee'
From
Employee as a, 
Employee as b
Where 
a.ManagerId = b.Id AND a.Salary > b.Salary;