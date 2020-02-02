# Volume Network

Proof-of-Capacity (PoC) consensus algorithm based blockchain.

### Software Installation

#### Linux (Debian, Ubuntu)

- fetch the newest release ZIP file

If running for the first time,

- install Java
- install MariaDB
- run ```volume.sh help```
- probably you want to do ```volume.sh import mariadb```


if upgrading your wallet config from 1.3.6cg

```
volume.sh upgrade
```
will take the old `nxt-default.properties`/`nxt.properties` files and
create `vlm-default.properties.converted`/`vlm.properties.converted`
files in the conf directory. This should give you a headstart with the
new option naming system.

#### Windows

###### MariaDb

In the conf directory, copy `vlm-default.properties` into a new file named `vlm.properties`.

Download and install MariaDB <https://mariadb.com/downloads/mariadb-tx>

The MariaDb installation will ask to setup a password for the root user. 
Add this password to the `vlm.properties` file created above in the following section:
```
DB.Url=jdbc:mariadb://localhost:3306/vlm_master
DB.Username=root
DB.Password=YOUR_PASSWORD
```

The MariaDB installation will also install HeidiSQL, a gui tool to administer MariaDb.
Use it to connect to the newly created mariaDb server and create a new DB called `vlm_master`. 

##### Configure and Initialize MariaDB

The Debian and Ubuntu packages provide an automatic configuration of
your local mariadb server. If you can't use the packages, you have to
initialize your database with these statements:

```
echo "CREATE DATABASE vlm_master; 
      CREATE USER 'vlm_user'@'localhost' IDENTIFIED BY 'yourpassword';
      GRANT ALL PRIVILEGES ON vlm_master.* TO 'vlm_user'@'localhost';" | mysql -uroot
mysql -uroot vlm_master < init-mysql.sql
```
