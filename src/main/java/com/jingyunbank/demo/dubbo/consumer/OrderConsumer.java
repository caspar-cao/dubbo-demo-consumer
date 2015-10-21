package com.jingyunbank.demo.dubbo.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jingyunbank.demo.dubbo.api.IOrderService;
import com.jingyunbank.demo.dubbo.api.Order;

/**
 * Hello world!
 *
 */
public class OrderConsumer 
{
	private IOrderService orderService;

    public void setOrderService(IOrderService orderService) {
        this.orderService = orderService;
    }

	public void start() throws Exception {
        try {
        	orderService.order(new Order());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"/META-INF/spring/dubbo-demo-action.xml", "/META-INF/spring/dubbo-demo-consumer.xml"});  
		OrderConsumer orderConsumer = (OrderConsumer)context.getBean("orderConsumer"); // 获取远程服务代理  
        orderConsumer.start();
	}
}
