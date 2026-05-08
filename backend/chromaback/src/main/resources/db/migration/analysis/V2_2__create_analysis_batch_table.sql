CREATE TABLE IF NOT EXISTS analyses.analysis_batch
(
    id                  SERIAL,
    external_identifier UUID         NOT NULL UNIQUE,
    submitted_by        VARCHAR(100) NOT NULL,
    submitted_at        TIMESTAMPTZ  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    total_rows          INTEGER      NOT NULL,
    processed_rows      INTEGER               DEFAULT 0,
    skipped_rows        INTEGER               DEFAULT 0,
    status              VARCHAR(25)  NOT NULL,
    status_updated_at   TIMESTAMPTZ,
    error_message       TEXT,
    enriched_csv_url    VARCHAR(500),
    created_at          TIMESTAMPTZ  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at          TIMESTAMPTZ  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    deleted_at          TIMESTAMPTZ,
    deleted_by          VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE INDEX idx_batch_status ON analyses.analysis_batch(status);
CREATE INDEX idx_batch_submitted_by ON analyses.analysis_batch(submitted_by);

COMMENT ON COLUMN analyses.analysis_batch.id IS 'The internal unique identifier for the batch';
COMMENT ON COLUMN analyses.analysis_batch.external_identifier IS 'The external unique identifier for the batch, exposed in the API for status polling';
COMMENT ON COLUMN analyses.analysis_batch.submitted_by IS 'The subject from the JWT token of who submitted the batch';
COMMENT ON COLUMN analyses.analysis_batch.submitted_at IS 'When the batch was submitted';
COMMENT ON COLUMN analyses.analysis_batch.total_rows IS 'Total number of rows in the CSV file after pre-validation';
COMMENT ON COLUMN analyses.analysis_batch.processed_rows IS 'Number of rows successfully processed';
COMMENT ON COLUMN analyses.analysis_batch.skipped_rows IS 'Number of rows skipped due to errors';
COMMENT ON COLUMN analyses.analysis_batch.status IS 'Current status of the batch job: STARTING, VALIDATING, PROCESSING, EXPORTING, COMPLETED, COMPLETED_WITH_ERRORS, FAILED';
COMMENT ON COLUMN analyses.analysis_batch.status_updated_at IS 'When the batch status was last updated';
COMMENT ON COLUMN analyses.analysis_batch.error_message IS 'Error message if the batch status is FAILED';
COMMENT ON COLUMN analyses.analysis_batch.enriched_csv_url IS 'URL of the enriched CSV file stored in RustFS';
COMMENT ON COLUMN analyses.analysis_batch.created_at IS 'When the registry was created';
COMMENT ON COLUMN analyses.analysis_batch.updated_at IS 'When the registry was last updated';
COMMENT ON COLUMN analyses.analysis_batch.deleted_at IS 'Registry deletion date-time';
COMMENT ON COLUMN analyses.analysis_batch.deleted_by IS 'Who deleted the registry, from the JWT';