# Write your MySQL query statement below
select p1.id from Weather p1, Weather p2
where DATEDIFF(p1.RecordDate, p2.RecordDate) = 1 and p1.Temperature > p2.Temperature; 