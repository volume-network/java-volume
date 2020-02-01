mysql -u root <<EOF
drop schema if exists vlm_master;
CREATE DATABASE vlm_master CHARACTER SET = 'utf8mb4' COLLATE = 'utf8mb4_unicode_ci';
CREATE USER 'vlm_user'@'localhost' IDENTIFIED BY ''; 
GRANT ALL PRIVILEGES ON vlm_master.* TO 'vlm_user'@'localhost';
use vlm_master;
source init-mysql.sql;
EOF
