package com.aiit.hexlab.common.core.domain;

import lombok.Data;

@Data
public class AjaxNewResult<T> {

    private Integer code = 200;

    private T data;

    private String msg = "success";

    public AjaxNewResult(T data) {
        this.data = data;
    }

    public AjaxNewResult() {
    }

    public static <T> AjaxNewResult<T> success(T data) {
        return new AjaxNewResult<T>(data);
    }

    public static <T> AjaxNewResult<T> success() {
        return new AjaxNewResult<T>();
    }
}
