WITH RECURSIVE TreeCTE AS (
    SELECT id, p_id
    FROM Tree
    WHERE p_id IS NULL
    UNION ALL
    SELECT t.id, t.p_id
    FROM Tree t
    JOIN TreeCTE tc
      ON t.p_id = tc.id
)
SELECT
    tc.id,
    CASE
        WHEN tc.p_id IS NULL THEN 'Root'
        WHEN EXISTS (
            SELECT 1
            FROM TreeCTE child
            WHERE child.p_id = tc.id
        ) THEN 'Inner'
        ELSE 'Leaf'
    END AS type
FROM TreeCTE tc
ORDER BY tc.id;