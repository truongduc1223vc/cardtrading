package com.magellans.cardtrading.generic.service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.github.pagehelper.PageInfo;
import com.magellans.cardtrading.common.I18NKey;
import com.magellans.cardtrading.exception.BEException;
import com.magellans.cardtrading.exception.VariableNotMergeException;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;

@Data
@Builder
@Slf4j
public class Response implements Serializable {
    @JsonInclude(Include.NON_NULL)
    private Object data;

    @JsonInclude(Include.NON_EMPTY)
    private String cause;
    @JsonInclude(Include.NON_EMPTY)
    private String description;
    @JsonInclude(Include.NON_EMPTY)
    private String message;
    @JsonInclude(Include.NON_EMPTY)
    private String error;
    @JsonInclude(Include.NON_EMPTY)
    private String code;

    @JsonInclude(Include.NON_EMPTY)
    private Integer dtOffset;
    @JsonInclude(Include.NON_EMPTY)
    private Integer dtLimit;
    @JsonInclude(Include.NON_EMPTY)
    private Integer dtPageSize;
    @JsonInclude(Include.NON_EMPTY)
    private Long dtTotalSize;


    public static ResponseEntity<Response> ok(Object data) {
        return new ResponseEntity(data, HttpStatus.OK);
    }

    public static ResponseEntity<Response> ok(PageInfo<?> pageInfo) {
        Response rs = Response.builder().data(pageInfo.getList()).dtOffset(pageInfo.getPageNum()).dtLimit(pageInfo.getPageSize()).dtPageSize(pageInfo.getPages()).dtTotalSize(pageInfo.getTotal()).build();
        return new ResponseEntity(rs, HttpStatus.OK);
    }

//    public static ResponseEntity<Response> bad(String errorCode, Object... params) {
//        Response rs = Response.builder().error(errorCode).message(MsgsResource.getI18N(errorCode, params)).build();
//        return new ResponseEntity(rs, HttpStatus.BAD_REQUEST);
//    }

    public static ResponseEntity<Response> bad(String errorCode, String message) {
        Response rs = Response.builder().error(errorCode).message(message).build();
        return new ResponseEntity(rs, HttpStatus.BAD_REQUEST);
    }
    public static ResponseEntity<Response> exception(Exception ex) {
        log.error(ex.getMessage(), ex);
        Response rs = Response.builder().message(ex.getMessage()).build();
        if (ex instanceof BEException) {
            BEException beException = (BEException) ex;
            rs.setMessage(beException.getMessage());
            rs.setCode(beException.getCode());
            return new ResponseEntity(rs, HttpStatus.BAD_REQUEST);
        } else if (ex instanceof VariableNotMergeException) {
            VariableNotMergeException variableNotMergeException = (VariableNotMergeException) ex;
            rs.setData(variableNotMergeException.getExceptionData());
            rs.setCode(I18NKey.MSG_218_400);
            return new ResponseEntity(rs, HttpStatus.BAD_REQUEST);
        } else {
            rs.setMessage(ex.getMessage());
//            rs.setCause(ex.getMessage());
            rs.setCode(I18NKey.MSG_218_500);
            return new ResponseEntity(rs, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}