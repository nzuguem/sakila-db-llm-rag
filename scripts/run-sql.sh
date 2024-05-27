#!/bin/bash

DOCKER_IMAGE="sakiladb/postgres"
PGPASSWORD="p_ssW0rd"
PGHOST="localhost"
PGDATABASE="sakila"
PGUSER="sakila"

if [ -z "$1" ]; then
    echo "Erreur : Veuillez fournir une requête SQL."
    exit 1
fi

SQL_QUERY=$1

docker run -i --net=host --rm --entrypoint "" -e PGPASSWORD=$PGPASSWORD $DOCKER_IMAGE psql -h $PGHOST -d $PGDATABASE -U $PGUSER -c "$SQL_QUERY"