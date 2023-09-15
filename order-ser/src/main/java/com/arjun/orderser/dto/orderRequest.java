package com.arjun.orderser.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class orderRequest {


    private List<orderLineItemsDto> orderLineItemsDtoList;


}
