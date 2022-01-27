CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    Declare toSkip int;
    Set toSkip = N-1;
  RETURN (
      # Write your MySQL query statement below.
      # Write your MySQL query statement below
select (select distinct salary from employee order by salary desc limit 1 offset toSkip) );
END