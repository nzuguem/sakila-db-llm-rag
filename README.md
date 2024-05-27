# sakila-db-llm-rag
## Késako ?
Rest API that implements RAG on the datasource linked to the Sakila database. The Sakila database models the DVD rental store business, which contains content such as films, actors, inventory, stores, customers and staffs.

[To navigate Sakila's SQL schema][sakila-schema-sql].

The API lets you query the Sakila database using natural language.



## Prerequisites

- [Install Ollama on your computer][ollama-install-guide] : To run an LLM model locally
    - Run ***[gemma][ollama-gemma]***
- Have docker installed on your computer : For devservices based on Testcontainers

## Launch the application

- Start Application
```bash
./mvnw quarkus:dev
```
- Open Swagger UI on the URL http://localhost:8080/q/swagger-ui/

## Test

> ℹ️ The `scripts/run-sql.sh` script is used to check API responses.
>
> Usage : `scripts/run-sql.sh "<SQL QUERY>"`

Example of SQL queries to insert into Swagger UI :

- *Which actors have the first name Scarlett ?*
```bash
scripts/run-sql.sh "select * from actor where first_name = 'Scarlett'"
```

- *Which actor has appeared in the most films ?*
```bash
scripts/run-sql.sh "select actor.actor_id, actor.first_name, actor.last_name,
       count(actor_id) as film_count
from actor join film_actor using (actor_id)
group by actor_id
order by film_count desc
limit 1"
```

- *What is the average length of films by category ?*
```bash
scripts/run-sql.sh "select category.name, avg(length)
from film join film_category using (film_id) join category using (category_id)
group by category.name
order by avg(length) desc"
```
- *Which actors have the last name BALL ?*
```bash
scripts/run-sql.sh "select * from actor where last_name like 'BALL'"
```

<!-- Links -->
[ollama-install-guide]: https://ollama.com/download
[ollama-gemma]: https://ollama.com/library/gemma
[sakila-schema-sql]: https://dataedo.com/samples/html/Sakila/