INSERT INTO transformers.manufacturer (external_identifier, name, country, website, is_active, contact_email,
                                       created_at, updated_at)
VALUES ('43568176-eabc-481a-9b47-cb4fc9dc06e2',
        'Siemens',
        'DE',
        'https://www.siemens.com',
        TRUE,
        'somebody@siemens.com',
        '2019-12-12T12:00:00+00:00',
        '2019-12-12T12:00:00+00:00');

INSERT INTO transformers.substation (external_identifier, name, location, coverage_area, affected_area, address,
                                     operator, voltage_level_kv, created_at, updated_at)
VALUES ('bf5c0baa-9362-4ebc-908b-94c0506607f6',
        'Substation A',
        ST_SetSRID(ST_MakePoint(38.19, 13.56), 4326),
        ST_SetSRID(ST_GeomFromText('POLYGON((38.00 13.00, 38.00 14.00, 39.00 14.00, 39.00 13.00, 38.00 13.00))'), 4326),
        ST_SetSRID(ST_GeomFromText('POLYGON((39.00 15.00, 39.00 16.00, 40.00 16.00, 40.00 15.00, 39.00 15.00))'), 4326),
        'Substation street, 1',
        'Iberdrola',
        150,
        '2024-05-10T09:00:00+00:00',
        '2025-11-20T16:30:00+00:00');

INSERT INTO transformers.transformer (external_identifier, serial_number, manufacturer_id, substation_id,
                                      power_input_kva, efficiency_percent, power_factor, phase,
                                      primary_voltage_kv, secondary_voltage_kv, importance,
                                      unique_properties, images_urls, documents_urls, condition,
                                      created_at, updated_at)
VALUES ('07c7144b-912d-4bd3-8a87-d556b565510d',
        'TRF-2025-001',
        1, 1,
        100.00, 98.50, 0.95, 3,
        138.000, 13.800,
        'CR',
        '{
          "cooling": "ONAN",
          "oil_volume_l": 1500
        }'::jsonb,
        ARRAY ['http://rustfs/chromamon-images/trf-001-front.jpg'],
        ARRAY ['http://rustfs/chromamon-docs/trf-001-manual.pdf'],
        'AC',
        '2024-01-15T10:30:00+00:00',
        '2025-06-20T14:00:00+00:00');

INSERT INTO transformers.transformer (external_identifier, serial_number, manufacturer_id, substation_id,
                                      power_input_kva, efficiency_percent, power_factor, phase,
                                      primary_voltage_kv, secondary_voltage_kv, importance,
                                      unique_properties, images_urls, documents_urls, condition,
                                      created_at, updated_at)
VALUES ('539c7693-fdb8-4fb3-94dd-feae3c1c4199',
        'TRF-2025-002',
        1, 1,
        50.00, 99.10, 0.88, 1,
        69.000, 4.160,
        'MD',
        '{
          "mounting": "pad-mounted"
        }'::jsonb,
        ARRAY []::TEXT[],
        ARRAY []::TEXT[],
        'WN',
        '2025-03-10T08:00:00+00:00',
        '2025-09-05T11:45:00+00:00');

INSERT INTO transformers.transformer (external_identifier, serial_number, manufacturer_id, substation_id,
                                      power_input_kva, efficiency_percent, power_factor, phase,
                                      primary_voltage_kv, secondary_voltage_kv, importance,
                                      unique_properties, images_urls, documents_urls, condition,
                                      created_at, updated_at)
VALUES ('e460e2fb-0f0e-42b3-9fb7-703763ebf8ff',
        'TRF-2025-003',
        1, 1,
        200.00, 97.80, 0.92, 3,
        230.000, 69.000,
        'HI',
        '{
          "cooling": "OFAF",
          "weight_kg": 25000
        }'::jsonb,
        ARRAY ['http://rustfs/chromamon-images/trf-003-front.jpg', 'http://rustfs/chromamon-images/trf-003-side.jpg'],
        ARRAY ['http://rustfs/chromamon-docs/trf-003-datasheet.pdf'],
        'DG',
        '2024-11-20T09:15:00+00:00',
        '2025-12-01T10:00:00+00:00');