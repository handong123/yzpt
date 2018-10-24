package com.tasly.yzpt.common.yzEnum;

public enum ExpressEnum {
    STO("1", "STO"), YUNDA("4", "YUNDA"), ZJS("25", "ZJS");

    private String yzExpressCode;
    private String yzExpressName;

    // 构造方法
    private ExpressEnum(String yzExpressCode, String yzExpressName) {
        this.yzExpressName = yzExpressName;
        this.yzExpressCode = yzExpressCode;
    }

    public String getYzExpressCode() {
        return yzExpressCode;
    }

    public String getYzExpressName() {
        return yzExpressName;
    }


    public static String getYzExpressCode(String expressName) {
        for (ExpressEnum expressEnum : ExpressEnum.values()) {
            if (expressEnum.getYzExpressName().equals(expressName)) {
                return expressEnum.yzExpressCode;
            }
        }
        return null;
    }

}
