CREATE TABLE IF NOT EXISTS transformers.transformer (
    id SERIAL,
    external_identifier UUID NOT NULL UNIQUE,
    serial_number VARCHAR(100) NOT NULL UNIQUE,
    manufacturer_id INTEGER NOT NULL,
    substation_id INTEGER NOT NULL,
    power_input_kva NUMERIC(10,2) NOT NULL,
    efficiency_percent NUMERIC(5,2) NOT NULL CHECK ( efficiency_percent BETWEEN 0 AND 100),
    power_factor NUMERIC(3,2) NOT NULL,
    phase SMALLINT NOT NULL CHECK ( phase = 1 OR phase = 3 ),
    primary_voltage_kv NUMERIC(8,3) NOT NULL,
    secondary_voltage_kv NUMERIC(8,3) NOT NULL,
    importance CHAR(2) NOT NULL,
    unique_properties JSONB,
    images_urls TEXT[],
    documents_urls TEXT[],
    condition CHAR(2) NOT NULL DEFAULT 'AC',
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMPTZ,
    deleted_by VARCHAR(100),
    PRIMARY KEY(id)
);


COMMENT ON COLUMN transformers.transformer.id IS 'The transformer internal identifier';
COMMENT ON COLUMN transformers.transformer.external_identifier IS 'The external identifier that will show in the URL instead of the serial number';
COMMENT ON COLUMN transformers.transformer.serial_number IS 'The transformer serial number for external identification';
COMMENT ON COLUMN transformers.transformer.manufacturer_id IS 'References the manufacturer';
COMMENT ON COLUMN transformers.transformer.substation_id IS 'References the substation';
COMMENT ON COLUMN transformers.transformer.power_input_kva IS 'Input power in kVA';
COMMENT ON COLUMN transformers.transformer.efficiency_percent IS 'The transformer efficiency in percent';
COMMENT ON COLUMN transformers.transformer.power_factor IS 'The transformer power factor';
COMMENT ON COLUMN transformers.transformer.phase IS 'The transformer phase, that can be 1 or 3';
COMMENT ON COLUMN transformers.transformer.primary_voltage_kv IS 'The voltage in the primary coil in kV';
COMMENT ON COLUMN transformers.transformer.secondary_voltage_kv IS 'The voltage in the secondary coil in kV';
COMMENT ON COLUMN transformers.transformer.importance IS 'Importance level: CRITICAL(CR), HIGH(HI), MEDIUM(MD), LOW(LO)';
COMMENT ON COLUMN transformers.transformer.unique_properties IS 'Unique technical properties for the transformer';
COMMENT ON COLUMN transformers.transformer.images_urls IS 'The URLs of the transformer images stored in RustFS';
COMMENT ON COLUMN transformers.transformer.documents_urls IS 'The URLs of the transformer documents stored in RustFS';
COMMENT ON COLUMN transformers.transformer.condition IS 'The current transformer condition: ACTIVE(AC), WARNING(WN), DANGER(DG), MAINTENANCE(MN)';
COMMENT ON COLUMN transformers.transformer.created_at IS 'When the registry was created';
COMMENT ON COLUMN transformers.transformer.updated_at IS 'When the registry was last updated';
COMMENT ON COLUMN transformers.transformer.deleted_at IS 'Registry deletion date-time';
COMMENT ON COLUMN transformers.transformer.deleted_by IS 'Who deleted the registry, from the JWT';
