/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.33).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.cellsignal.cloudparameters.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-07-19T10:35:13.425641-04:00[America/New_York]")
@Validated
public interface ListApi {

    ListApiDelegate getDelegate();

    @Operation(summary = "Lists the available keys in a given store", description = "Returns a list of parameters for this account prefixed by /prefix.   Should recursively return all values under /prefix.  Limitation of path parameter is that only a single prefix can be submitted, 2 or more prefixes are not supported paramter /cellsignal/service/foo can only be queried via /cellsignal.  Should call AWS SSM get-parameters-by-path API ", tags={ "developers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Array of parameters", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = String.class)))),
        
        @ApiResponse(responseCode = "500", description = "internal error"),
        
        @ApiResponse(responseCode = "400", description = "bad input parameter") })
    @RequestMapping(value = "/list/{prefix}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<String>> listKeys(@Parameter(in = ParameterIn.PATH, description = "parameter key being queried", required=true, schema=@Schema()) @PathVariable("prefix") String prefix) {
        return getDelegate().listKeys(prefix);
    }


    @Operation(summary = "Lists the available parameters for this account", description = "Returns a list of parameters for this account. Should call the SSM describe parameters API ", tags={ "developers" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Array of parameters", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = String.class)))),
        
        @ApiResponse(responseCode = "500", description = "internal error") })
    @RequestMapping(value = "/list",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<String>> listParameters() {
        return getDelegate().listParameters();
    }

}

