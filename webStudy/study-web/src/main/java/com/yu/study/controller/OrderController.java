package com.yu.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yu.study.common.web.BaseController;
import com.yu.study.dos.OrderDo;

@Controller
@RequestMapping("/orders")
public class OrderController extends BaseController<OrderDo, OrderDo>{

}
