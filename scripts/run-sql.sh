#!/usr/bin/env sh

: "${1?❗Error❗: Please provide an SQL query.}"

SQL_QUERY=$1
DOCKER_IMAGE="sakiladb/postgres"
PGPASSWORD="p_ssW0rd"
PGHOST="localhost"
PGDATABASE="sakila"
PGUSER="sakila"

docker run -i --net=host --rm --entrypoint "" -e PGPASSWORD=$PGPASSWORD $DOCKER_IMAGE psql -h $PGHOST -d $PGDATABASE -U $PGUSER -c "$SQL_QUERY"