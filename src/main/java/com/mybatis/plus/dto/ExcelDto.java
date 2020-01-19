package com.mybatis.plus.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ExcelDto implements Serializable {

    private static final long serialVersionUID=1L;

    private byte[] excelFile;

}
