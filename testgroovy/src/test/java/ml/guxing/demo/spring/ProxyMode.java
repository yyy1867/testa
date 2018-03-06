package ml.guxing.demo.spring;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * 代理模式测试
 */
public class ProxyMode {

    public static void main(String[] args) {
        // 对象本身
        PrintlnService printlnService = new PrintlnServiceImpl();

        ProxyFactory factory = new ProxyFactory(printlnService);
        // 添加通知
        factory.addAdvice(new MyMethodBeforeAdvice());
        factory.addInterface(PrintlnService.class);
//        factory.setExposeProxy(true);
        // 获得代理对象
        PrintlnService proxy = (PrintlnService) factory.getProxy();
        // 使用原始对象调用
        printlnService.println();
        System.out.println("=============");
        // 使用代理对象调用
        proxy.println();
    }

    private static interface PrintlnService {
        void println();
    }

    private static class PrintlnServiceImpl implements PrintlnService {

        @Override
        public void println() {
            System.out.println("服务自身的println方法------------");
        }
    }

    private static class MyMethodBeforeAdvice implements MethodBeforeAdvice {

        @Override
        public void before(Method method, Object[] args, Object target) throws Throwable {
            System.out.println("即将执行方法:" + method.getName());
            System.out.println("参数个数" + args.length);
            System.out.println("执行对象:" + target);
        }
    }

}