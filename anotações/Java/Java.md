# Enumeração


```
public enum OrderStatus {  
  
    PENDING_PAYMENT,  
    PROCESSING,  
    SHIPPED,  
    DELIVERED;  
}	
```

>[!info]
>enum é um objeto que enumera uma lista


```
public class Main {  
    public static void main(String[] args) {  
  
        Order order = new Order(1080,new Date(), OrderStatus.PENDING_PAYMENT);  
        System.out.println(order);  
  
        OrderStatus os1 = OrderStatus.DELIVERED;  
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");  
        System.out.println(os1);  
        System.out.println(os2);  
    }  
}
```

>[!info]
>posso usa .DELIVERED que é um objeto ou uma String através da função .valueOF("String")



![[img.png]]

