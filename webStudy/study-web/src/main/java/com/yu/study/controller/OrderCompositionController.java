package com.yu.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yu.study.bo.OrderBo;
import com.yu.study.common.web.BaseController;

@Controller
@RequestMapping("/orders/composition")
public class OrderCompositionController extends BaseController<OrderBo, OrderBo>{
	
}
