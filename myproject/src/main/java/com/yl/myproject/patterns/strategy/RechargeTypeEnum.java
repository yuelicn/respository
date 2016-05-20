package com.yl.myproject.patterns.strategy;

public enum RechargeTypeEnum {
	
	E_BANK(1, "����"),
	   
    BUSI_ACCOUNTS(2, "�̻��˺�");
   
   
    private int value;
   
   
    private String description;
   
   
   
    private RechargeTypeEnum(int value, String description) {
       this.value = value;
       this.description = description;
    }
      
    public int value() {
       return value;
    }
    public String description() {
       return description;
    }
   
 
    public static RechargeTypeEnum valueOf(int value) {
        for(RechargeTypeEnum type : RechargeTypeEnum.values()) {
            if(type.value() == value) {
                return type;
            }
        }
        return null;
    }
	
	

}
