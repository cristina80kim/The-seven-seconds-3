package com.team3.prj.vo;

import lombok.Data;

@Data
public class ExecResultVO {

    String strResult;
    int numResult;
    
    public ExecResultVO() {
    }
    
    public ExecResultVO(String strResult) {
        this.strResult = strResult;
    }
    
    public ExecResultVO(int numResult) {
        this.numResult = numResult;
    }
    
}
