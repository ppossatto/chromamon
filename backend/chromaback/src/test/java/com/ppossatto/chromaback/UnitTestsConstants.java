package com.ppossatto.chromaback;

import com.ppossatto.chromaback.analyses.internal.domain.enums.AnalysisStatus;
import com.ppossatto.chromaback.analyses.internal.domain.enums.BatchStatusType;
import com.ppossatto.chromaback.analyses.internal.domain.enums.InputSourceType;
import com.ppossatto.chromaback.transformers.internal.domain.enums.ConditionCode;
import com.ppossatto.chromaback.transformers.internal.domain.enums.CountryCode;
import com.ppossatto.chromaback.transformers.internal.domain.enums.ImportanceCode;
import com.ppossatto.chromaback.transformers.internal.domain.model.Coordinates;
import com.ppossatto.chromaback.transformers.internal.domain.model.PolygonCoordinates;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class UnitTestsConstants {

  public static class Transformers {

    public static final UUID TRANSFORMER_1_EXTERNAL_IDENTIFIER =
       UUID.fromString("07c7144b-912d-4bd3-8a87-d556b565510d");

    public static final String TRANSFORMER_1_SERIAL_NUMBER = "TRF-2026-001";

    public static final BigDecimal TRANSFORMER_1_POWER_INPUT = BigDecimal.valueOf(100);

    public static final BigDecimal TRANSFORMER_1_EFFICIENCY_PERCENT = BigDecimal.valueOf(0.9);

    public static final BigDecimal TRANSFORMER_1_POWER_FACTOR = BigDecimal.valueOf(-0.9);

    public static final int TRANSFORMER_1_PHASE = 3;

    public static final BigDecimal TRANSFORMER_1_PRIMARY_VOLTAGE = BigDecimal.valueOf(10);

    public static final BigDecimal TRANSFORMER_1_SECONDARY_VOLTAGE = BigDecimal.valueOf(1.2);

    public static final ImportanceCode TRANSFORMER_1_IMPORTANCE_CODE = ImportanceCode.HI;

    public static final Map<String, Object> TRANSFORMER_1_UNIQUE_PROPERTIES = null;

    public static final List<String> TRANSFORMER_1_IMAGES_URLS = null;

    public static final List<String> TRANSFORMER_1_DOCUMENTS_URLS = null;

    public static final ConditionCode TRANSFORMER_1_CONDITION = ConditionCode.AC;

    public static final LocalDateTime TRANSFORMER_1_CREATED_AT =
       LocalDateTime.of(2024, 11, 22, 15, 30);

    public static final LocalDateTime TRANSFORMER_1_UPDATED_AT =
       LocalDateTime.of(2024, 11, 22, 15, 30);
  }

  public static class Substation {

    public static final String SUBSTATION_NAME = "Substation A";
    public static final String SUBSTATION_ADDRESS = "Substation street, 1";
    public static final String OPERATOR = "Iberdrola";
    public static final int VOLTAGE_LEVEL_KV = 150;
    public static final Coordinates LOCATION = new Coordinates(13.56, 38.19);
    public static final PolygonCoordinates COVERAGE_AREA_CLOSED = new PolygonCoordinates(List.of(
       new Coordinates(13.00, 38.00),
       new Coordinates(14.00, 38.00),
       new Coordinates(14.00, 39.00),
       new Coordinates(13.00, 39.00),
       new Coordinates(13.00, 38.00)
    ));
    public static final PolygonCoordinates AFFECTED_AREA_CLOSED = new PolygonCoordinates(List.of(
       new Coordinates(15.00, 39.00),
       new Coordinates(16.00, 39.00),
       new Coordinates(16.00, 40.00),
       new Coordinates(15.00, 40.00),
       new Coordinates(15.00, 39.00)
    ));
    public static final LocalDateTime CREATED_AT =
       LocalDateTime.of(2024, 5, 10, 9, 0);
    public static final LocalDateTime UPDATED_AT =
       LocalDateTime.of(2025, 11, 20, 16, 30);
    public static final UUID EXTERNAL_IDENTIFIER =
       UUID.fromString("bf5c0baa-9362-4ebc-908b-94c0506607f6");

  }

  public static class Manufacturer {

    public static final UUID MANUFACTURER_1_EXTERNAL_IDENTIFIER =
       UUID.fromString("43568176-eabc-481a-9b47-cb4fc9dc06e2");

    public static final String MANUFACTURER_1_NAME = "Siemens";

    public static final String MANUFACTURER_1_COUNTRY = "Germany";

    public static final CountryCode MANUFACTURER_1_COUNTRY_CODE = CountryCode.DE;

    public static final String MANUFACTURER_1_WEBSITE = "https://www.siemens.com";

    public static final String MANUFACTURER_1_CONTACT_EMAIL = "somebody@siemens.com";

    public static final boolean MANUFACTURER_1_IS_ACTIVE = true;

    public static final LocalDateTime MANUFACTURER_1_CREATED_AT =
       LocalDateTime.of(2024, 5, 10, 9, 0);

    public static final LocalDateTime MANUFACTURER_1_UPDATED_AT =
       LocalDateTime.of(2025, 11, 20, 16, 30);

  }

  public static class AnalysisBatch {

    public static final UUID EXTERNAL_IDENTIFIER =
       UUID.fromString("539c7693-fdb8-4fb3-94dd-feae3c1c4199");

    public static final String SUBMITTED_BY = "Myself";

    public static final LocalDateTime SUBMITTED_AT =
       LocalDateTime.of(2025, 4, 12, 10, 15);

    public static final int TOTAL_ROWS = 150;

    public static final int PROCESSED_ROWS = 150;

    public static final int SKIPPED_ROWS = 0;

    public static final BatchStatusType STATUS_TYPE = BatchStatusType.COMPLETED;

    public static final LocalDateTime STATUS_UPDATED_AT =
       LocalDateTime.of(2025, 4, 12, 11, 0);

    public static final String ENRICHED_CSV_URL =
       "http://rustfs.com/batch-csv-doc/7235089327052.csv";

    public static final Set<UUID> ANALYSIS_EXTERNAL_IDENTIFIERS =
       Set.of(
          UnitTestsConstants.Analysis.ANALYSIS_1_EXTERNAL_IDENTIFIER
       );

    public static final LocalDateTime CREATED_AT =
       LocalDateTime.of(2025, 4, 13, 12, 0);

    public static final LocalDateTime UPDATED_AT =
       LocalDateTime.of(2025, 4, 13, 12, 0);
  }

  public static class Analysis {

    public static final UUID ANALYSIS_1_EXTERNAL_IDENTIFIER =
       UUID.fromString("539c7693-fdb8-4fb3-94dd-feae3c1c4199");

    public static final UUID ANALYSIS_2_EXTERNAL_IDENTIFIER =
       UUID.fromString("e460e2fb-0f0e-42b3-9fb7-703763ebf8ff");

    public static final String TRANSFORMER_SERIAL_NUMBER = "ABC-123-DEF";

    public static final InputSourceType INPUT_SOURCE_TYPE = InputSourceType.MANUAL;

    public static final String COLLECTED_BY = "myself";

    public static final LocalDateTime COLLECTED_AT =
       LocalDateTime.of(2026, 2, 10, 12, 0);

    public static final AnalysisStatus ANALYSIS_STATUS = AnalysisStatus.PD;

    public static final LocalDateTime STATUS_UPDATED_AT =
       LocalDateTime.of(2027, 2, 10, 12, 0);

    public static final BigDecimal H2_PPM = BigDecimal.valueOf(8.2);

    public static final BigDecimal CH4_PPM = BigDecimal.valueOf(10.6);

    public static final BigDecimal C2H6_PPM = BigDecimal.valueOf(9.5);

    public static final BigDecimal C2H4_PPM = BigDecimal.valueOf(14.3);

    public static final BigDecimal C2H2_PPM = BigDecimal.valueOf(2.2);

    public static final BigDecimal O2_PPM = BigDecimal.valueOf(1.45);

    public static final BigDecimal CO_PPM = BigDecimal.valueOf(0.24);

    public static final BigDecimal CO2_PPM = BigDecimal.valueOf(100.96);

    public static final BigDecimal N2_PPM = BigDecimal.valueOf(112.14);

    public static final LocalDateTime CREATED_AT =
       LocalDateTime.of(2026, 5, 8, 14, 30);

    public static final LocalDateTime UPDATED_AT =
       LocalDateTime.of(2026, 5, 8, 14, 30);
  }
}
