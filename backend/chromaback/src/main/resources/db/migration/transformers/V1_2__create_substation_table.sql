CREATE TABLE IF NOT EXISTS transformers.substation (
    id SERIAL,
    external_identifier UUID NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL UNIQUE,
    location GEOMETRY(POINT, 4326) NOT NULL,
    coverage_area GEOMETRY(POLYGON, 4326) NOT NULL,
    affected_area GEOMETRY(POLYGON, 4326) NOT NULL,
    address VARCHAR(255) NOT NULL,
    operator VARCHAR(150) NOT NULL,
    voltage_level_kv INTEGER NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMPTZ,
    deleted_by VARCHAR(100),
    PRIMARY KEY(id)
);


COMMENT ON COLUMN transformers.substation.id IS 'The substation unique identifier';
COMMENT ON COLUMN transformers.substation.external_identifier IS 'The substation UUID to be exposed externally';
COMMENT ON COLUMN transformers.substation.name IS 'The substation name';
COMMENT ON COLUMN transformers.substation.location IS 'The GPS coordinates for the substation location';
COMMENT ON COLUMN transformers.substation.coverage_area IS 'The substation coverage area';
COMMENT ON COLUMN transformers.substation.affected_area IS 'The affected area in case of a failure';
COMMENT ON COLUMN transformers.substation.address IS 'The textual address for the substation';
COMMENT ON COLUMN transformers.substation.operator IS 'The company that operates the substation';
COMMENT ON COLUMN transformers.substation.voltage_level_kv IS 'The nominal voltage of the substation in kV';
COMMENT ON COLUMN transformers.substation.created_at IS 'Registry creation date';
COMMENT ON COLUMN transformers.substation.updated_at IS 'When the registry was last modified';
COMMENT ON COLUMN transformers.substation.deleted_at IS 'When the registry was deleted';
COMMENT ON COLUMN transformers.substation.deleted_by IS 'Who deleted the registry, from the JWT token';
