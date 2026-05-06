CREATE TABLE IF NOT EXISTS transformers.manufacturer (
    id SERIAL,
    external_identifier UUID NOT NULL UNIQUE,
    name VARCHAR(100) NOT NULL,
    country CHAR(2) NOT NULL,
    website VARCHAR(255),
    is_active BOOLEAN NOT NULL DEFAULT TRUE,
    contact_email VARCHAR(255),
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMPTZ,
    deleted_by VARCHAR(100),
    PRIMARY KEY(id),
    UNIQUE(name, country)
);


COMMENT ON COLUMN transformers.manufacturer.id IS 'The transformer manufacturer ID';
COMMENT ON COLUMN transformers.manufacturer.external_identifier IS 'The manufacturer UUID to be exposed externally';
COMMENT ON COLUMN transformers.manufacturer.name IS 'The manufacturer name';
COMMENT ON COLUMN transformers.manufacturer.country IS 'The manufacturer country of origin';
COMMENT ON COLUMN transformers.manufacturer.website IS 'The manufacturer official website';
COMMENT ON COLUMN transformers.manufacturer.is_active IS 'A flag that indicates if the manufacturer is still active';
COMMENT ON COLUMN transformers.manufacturer.contact_email IS 'The manufacturer email to get in contact if needed';
COMMENT ON COLUMN transformers.manufacturer.created_at IS 'Registry creation date';
COMMENT ON COLUMN transformers.manufacturer.updated_at IS 'When the registry was last modified';
COMMENT ON COLUMN transformers.manufacturer.deleted_at IS 'When the registry was deleted';
COMMENT ON COLUMN transformers.manufacturer.deleted_by IS 'Who deleted the registry, from the JWT token';
