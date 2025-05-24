!#/bin/bash

echo "Starting the HSQLDB server to prepare the env for the web service"

sudo /usr/local/mysql/bin/mysqld_safe --daemonize

#HSQLDB_HOME="${DB_HOME:-/Users/anoopstanley/hsqldb-2.7.4/hsqldb}"
#echo $HSQLDB_HOME
#cd $HSQLDB_HOME
#java -classpath lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:hsqldb/worklistdb --dbname.0 worklistdb
