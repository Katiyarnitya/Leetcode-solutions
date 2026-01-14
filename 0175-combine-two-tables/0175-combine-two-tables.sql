# Write your MySQL query statement below
SELECT p.firstName, p.lastName, a.city, a.state from Person as p LEFT JOIN Address AS a
ON p.personId = a.personId;