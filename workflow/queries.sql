-- https://stackoverflow.com/questions/1710476/how-to-print-a-query-string-with-parameter-values-when-using-hibernate
--
-- # logs the SQL statements
-- log4j.logger.org.hibernate.SQL=debug
--
-- # Logs the JDBC parameters passed to a query
-- log4j.logger.org.hibernate.type=trace
--
--


-- 1. Hiberate generate selecting user
select user0_.id as id1_4_, user0_.created_at as created_2_4_, user0_.updated_at as updated_3_4_, user0_.email as email4_4_, user0_.name as name5_4_, user0_.password as password6_4_, user0_.user_name as user_nam7_4_
from users user0_
where user0_.user_name="test";

-- 2. Selecting user role
 select roles0_.user_id as user_id1_3_0_, roles0_.role_id as role_id2_3_0_, role1_.id as id1_2_1_, role1_.name as name2_2_1_
 from user_roles roles0_
 inner join roles role1_
    on roles0_.role_id=role1_.id
 where roles0_.user_id=1;





