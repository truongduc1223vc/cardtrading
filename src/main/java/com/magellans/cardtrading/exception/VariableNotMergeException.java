package com.magellans.cardtrading.exception;

import com.magellans.cardtrading.common.MsgsResource;
import lombok.Data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Data
public class VariableNotMergeException extends Exception {
    private String code;
    private String message;
    private List<String> missingParams;
    private transient Map<String, Object> passingParams;

    public VariableNotMergeException(String code) {
        super();
        this.code = code;
        this.message = MsgsResource.getI18N(code);
    }

    public VariableNotMergeException(String code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
    public VariableNotMergeException(String code, String message, List<String> missingParams, Map<String, Object> passingParams) {
        super();
        this.code = code;
        this.message = message;
        this.missingParams = missingParams;
        this.passingParams = passingParams;
    }

    public Map<String, Object> getExceptionData(){
        Map<String, Object> map = new HashMap<>();
        map.put("missingParams", getMissingParams());
        map.put("passingParams", getPassingParams());
        return map;
    }
}
