drop schema vlm_master;
CREATE DATABASE vlm_master CHARACTER SET = 'utf8mb4' COLLATE = 'utf8mb4_unicode_ci';
GRANT ALL PRIVILEGES ON vlm_master.* TO 'vlm_user'@'localhost';
use vlm_master;
source init-mysql.sql;
