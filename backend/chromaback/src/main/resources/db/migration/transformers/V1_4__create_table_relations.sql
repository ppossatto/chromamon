ALTER TABLE transformers.transformer
    ADD FOREIGN KEY(manufacturer_id) REFERENCES transformers.manufacturer(id)
        ON UPDATE NO ACTION ON DELETE RESTRICT;
ALTER TABLE transformers.transformer
    ADD FOREIGN KEY(substation_id) REFERENCES transformers.substation(id)
        ON UPDATE NO ACTION ON DELETE RESTRICT;

CREATE INDEX idx_transformer_manufacturer_id ON transformers.transformer(manufacturer_id);
CREATE INDEX idx_transformer_substation_id ON transformers.transformer(substation_id);