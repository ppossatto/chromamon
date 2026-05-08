CREATE TABLE IF NOT EXISTS analyses.analysis (
    id SERIAL,
    external_identifier UUID NOT NULL UNIQUE,
    transformer_serial_number VARCHAR(100) NOT NULL,
    input_source_id BIGINT NOT NULL,
    batch_id BIGINT,
    collected_by VARCHAR(100) NOT NULL,
    collected_at TIMESTAMPTZ NOT NULL,
    status CHAR(2) NOT NULL,
    status_updated_at TIMESTAMPTZ,
    h2_ppm NUMERIC(10,3) NOT NULL,
    ch4_ppm NUMERIC(10,3) NOT NULL,
    c2h6_ppm NUMERIC(10,3) NOT NULL,
    c2h4_ppm NUMERIC(10,3) NOT NULL,
    c2h2_ppm NUMERIC(10,3) NOT NULL,
    o2_ppm NUMERIC(10,3) NOT NULL,
    co_ppm NUMERIC(10,3) NOT NULL,
    co2_ppm NUMERIC(10,3) NOT NULL,
    n2_ppm NUMERIC(10,3) NOT NULL,
    observations JSONB,
    created_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at TIMESTAMPTZ,
    deleted_by VARCHAR(100),
    PRIMARY KEY (id),
    FOREIGN KEY (input_source_id) REFERENCES analyses.input_source_type(id),
    FOREIGN KEY (batch_id) REFERENCES analyses.analysis_batch(id)
);

COMMENT ON COLUMN analyses.analysis.id IS 'The internal unique identifier for the analysis';
COMMENT ON COLUMN analyses.analysis.external_identifier IS 'The external unique identifier for the analysis';
COMMENT ON COLUMN analyses.analysis.transformer_serial_number IS 'The serial number of the transformer analyzed';
COMMENT ON COLUMN analyses.analysis.input_source_id IS 'The FK for the way the analysis was inserted';
COMMENT ON COLUMN analyses.analysis.batch_id IS 'The FK for the batch analysis information, null if the analysis was added manually or with an API';
COMMENT ON COLUMN analyses.analysis.collected_by IS 'The subject from the JWT token of who analyzed';
COMMENT ON COLUMN analyses.analysis.collected_at IS 'When the sample was collected';
COMMENT ON COLUMN analyses.analysis.status IS 'The status of the analysis: PB(PENDING_BATCH), AN(ANALYZING), PD(PENDING_DIAGNOSTICS), DC(DIAGNOSTICS_COMPLETED), FN(FINISHED), RJ(REJECTED)';
COMMENT ON COLUMN analyses.analysis.status_updated_at IS 'When the status was updated';
COMMENT ON COLUMN analyses.analysis.h2_ppm IS 'The ppm value of the hydrogen gas concentration';
COMMENT ON COLUMN analyses.analysis.ch4_ppm IS 'The ppm value of the methane gas concentration';
COMMENT ON COLUMN analyses.analysis.c2h6_ppm IS 'The ppm value of the ethane gas concentration';
COMMENT ON COLUMN analyses.analysis.c2h4_ppm IS 'The ppm value of the ethylene gas concentration';
COMMENT ON COLUMN analyses.analysis.c2h2_ppm IS 'The ppm value of the acetylene gas concentration';
COMMENT ON COLUMN analyses.analysis.o2_ppm IS 'The ppm value of the oxygen gas concentration';
COMMENT ON COLUMN analyses.analysis.co_ppm IS 'The ppm value of the carbon monoxide gas concentration';
COMMENT ON COLUMN analyses.analysis.co2_ppm IS 'The ppm value of the carbon dioxide gas concentration';
COMMENT ON COLUMN analyses.analysis.n2_ppm IS 'The ppm value of the nitrogen gas concentration';
COMMENT ON COLUMN analyses.analysis.observations IS 'Additional information about the analysis';
COMMENT ON COLUMN analyses.analysis.created_at IS 'When the registry was created';
COMMENT ON COLUMN analyses.analysis.updated_at IS 'When the registry was last updated';
COMMENT ON COLUMN analyses.analysis.deleted_at IS 'Registry deletion date-time';
COMMENT ON COLUMN analyses.analysis.deleted_by IS 'Who deleted the registry, from the JWT';