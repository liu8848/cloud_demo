package com.demo.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tb_order")
public class Order {
    private Integer id;
    private Integer userId;
    private String name;
    private Double price;
    private Integer num;
}
