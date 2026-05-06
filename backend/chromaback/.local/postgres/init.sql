DO $$
    BEGIN
        IF NOT EXISTS (SELECT FROM pg_catalog.pg_roles WHERE rolname = 'keycloakuser') THEN
            CREATE ROLE keycloakuser WITH LOGIN PASSWORD 'keycloakpassword';
        END IF;
    END
$$;

CREATE SCHEMA IF NOT EXISTS keycloak AUTHORIZATION keycloakuser;
CREATE SCHEMA IF NOT EXISTS metadata;

GRANT ALL PRIVILEGES ON DATABASE chromamon TO keycloakuser;
GRANT ALL PRIVILEGES ON SCHEMA keycloak TO keycloakuser;

CREATE EXTENSION IF NOT EXISTS postgis;