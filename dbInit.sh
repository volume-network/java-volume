#!/bin/bash -x


function create_brs_db {
    echo "\n[+] Please enter your MariaDB connection details"
    read -rp  "     Host     (localhost) : " P_HOST
    read -rp  "     Database (vlm_master): " P_DATA
    read -rp  "     Username (vlm_user)  : " P_USER
    read -rsp "     Password empty       : " P_PASS
    [ -z $P_HOST ] && P_HOST="localhost"
    [ -z $P_USER ] && P_USER="vlm_user"
    [ -z $P_DATA ] && P_DATA="vlm_master"
    [ -z $P_PASS ] || P_PASS="$P_PASS"
    echo

    echo "[+] Creating volume wallet db ($P_DATA)..."
    mysql << EOF
CREATE DATABASE $P_DATA CHARACTER SET = 'utf8mb4' COLLATE = 'utf8mb4_unicode_ci';
CREATE USER '$P_USER'@'$P_HOST' IDENTIFIED BY '$P_PASS'; 
GRANT ALL PRIVILEGES ON $P_DATA.* TO '$P_USER'@'$P_HOST';
EOF

    # Verify mariadb setup
    if mysql -u$P_USER -p$P_PASS -h$P_HOST -e "\q" ; then
        echo "[+] $P_DATA Database created successfully."
    else
        echo "[!] Database creation failed. Exiting..."
        exit 1
    fi

    echo "DB.Url=jdbc:mariadb://$P_HOST:3306/$P_DATA" >> ./conf/vlm.properties
    echo "DB.Username=$P_USER" >> ./conf/vlm.properties
    echo "DB.Password=$P_PASS" >> ./conf/vlm.properties
}

create_brs_db
