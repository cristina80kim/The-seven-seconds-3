package com.team3.prj.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class PaymentVO {
    
    
    private Long id;   // ID
    private String name; // 숙소이름
    private int amount; //결제가격
    private String buyer_email; //구매자이메일
    private String buyer_name; //구매자이름
    
}
