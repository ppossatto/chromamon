CREATE TABLE IF NOT EXISTS analyses.input_source_type(
    id SERIAL,
    name VARCHAR(50) UNIQUE NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
);

COMMENT ON COLUMN analyses.input_source_type.id IS 'The identifier of the input type';
COMMENT ON COLUMN analyses.input_source_type.name IS 'The name of the input type';
COMMENT ON COLUMN analyses.input_source_type.created_at IS 'When the registry was created';
COMMENT ON COLUMN analyses.input_source_type.updated_at IS 'When the registry was last updated';

INSERT INTO analyses.input_source_type (name) VALUES ('CSV'), ('MANUAL'), ('API');