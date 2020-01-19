package com.mybatis.plus.utils;

public enum TypeEnum {

    VAT("3f2cee49-6266-4ff4-a017-e3ff4c64a5ab", "增值税"),
    TOC("8275b1b4-6162-449f-aab0-379affaaa0f7", "消费税"),
    BT("003ef531-370e-4dda-9e2f-3129a88bc110", "营业税"),
    CT("070ef004-f79b-4b29-8035-4bc90115f656", "企业所得税"),
    PIT("c8289522-8b30-4cde-9eb7-6b528a0707ff", "个人所得税"),
    RT("d6835858-0340-4c24-91a3-f8238a7025ce", "资源税"),
    CMT("13e1a278-f577-4726-9528-0334687b6795", "城市维护建设税"),
    HDT("4b82019b-816d-43e4-aa5b-427b513acb2a", "房产税"),
    ST("e6702ec6-f5b6-4dd3-a350-1c6a96bbc695", "印花税"),
    UIUT("a77d25a8-98f1-45a2-a945-8edaaa4d09a4", "城镇土地使用税"),
    LAT("9fc48372-3fdb-4bb5-9d8d-183e65f7c1e0", "土地增值税"),
    TT("e954a38f-755a-47b5-80fe-ecb2f87cdfdb", "车船税"),
    VPT("11966441-27d3-4792-ba2c-dbd2e9d12403", "车辆购置税"),
    TOT("13428ec9-11ab-43f1-b328-6f0d6c9f06f3", "烟叶税"),
    LAOT("b4eb396c-2b4c-413d-b1d0-6802d991f2b9", "耕地占用税"),
    DET("79a11c76-9871-4455-8ebf-52873e1f1368", "契税"),
    EPT("d3a844b3-10cb-4a20-8b25-bc38368deb89", "环境保护税"),
    IET("dcc0d4cb-0231-4d21-bcd1-af01e4503cc6", "进出口税收"),
    OTHER("9394ce12-cf8c-4b00-910c-1ff02a090e0b", "其他"),
    FREET("92f7919a-f9e8-43a0-bac1-e32e69665471", "税收优惠");



    TypeEnum(String id, String name) {
        this.id = id;
        this.name = name;
    }

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
