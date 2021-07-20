INSERT INTO `project`.`test`
(`memo`)
VALUES ('test memo2');
UPDATE `project`.`test`
SET
`memo` = "edit memo"
WHERE `idx` = 2;

-- 스키마 삭제후 다시 생성해도 idx 값은 back 되지않는다.
-- 식별할 수 있는 스키마 객체 
DELETE FROM project.test
WHERE idx=2;

