package com.ppossatto.chromaback.transformers;

import java.util.List;

/**
 * Interface containing methods that can be used by other modules for synchronous communication.
 */
public interface TransformerPublicApi {

  /**
   * <p>Method for returning all serial numbers of transformers that was not found in the database.</p>
   * </br>
   * <p>Example 1:</p>
   * <p>Some serial number was not found in the database</p>
   * {@snippet :
   * private final TransformerPublicApi transformerPublicApi; //Injected in the other module with a constructor.
   *
   * List<String> transformerPublicApi.findMissingSerialNumbers(List.of("ABC-123-DEF", "987-ZYX-654"));
   * }
   * <p>If the <strong>ABC-123-DEF</strong> serial number was <strong>NOT</strong> found, the return of this method will be:</p>
   * {@snippet : List<String> result = List.of("ABC-123-DEF")}
   * </br>
   * <p>Example 2:</p>
   * <p>All serial numbers were found in the database</p>
   * {@snippet :
   * private final TransformerPublicApi transformerPublicApi; //Injected in the other module with a constructor.
   *
   * List<String> transformerPublicApi.findMissingSerialNumbers(List.of("ABC-123-DEF", "987-ZYX-654"));
   * }
   * <p>If all the serial numbers were found, the return of this method will be:</p>
   * {@snippet :
   * import java.util.Collections;
   * List<String> result = Collections.emptyList();
   *}
   * </br>
   * <p></p>
   *
   * @param serialNumbers A list of serial numbers to be checked in the database.
   * @return a list of serial numbers not found in the database or an empty list if all serial numbers were found.
   */
  List<String> findMissingSerialNumbers(List<String> serialNumbers);
}
