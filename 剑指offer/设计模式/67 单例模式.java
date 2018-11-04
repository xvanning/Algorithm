//https://edu.aliyun.com/lesson_471_4545?spm=5176.10731542.0.0.eBZjY0#_4545

//懒汉模式 -- 线程安全(双重锁加volatile （防止指令重排）)
//单例实例在第一次使用时进行创建

//指令重排
/**
 * 为 uniqueInstance 分配内存空间 初始化 uniqueInstance 将 uniqueInstance
 * 向分配的内存地址*/


public class Singleton {

    // 私有构造函数
    private Singleton() {

    }

    // 单例对象
    private static volatile Singleton instance = null;

    public static Singleton getSingleton() {
        if (instance == null) {
            synchronized (Singleton.class) { // 如果不加双重锁，当下一个线程获取锁的时候，还是会创建一个新的
                if (instance == null) { // 双重检测
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}

// 饿汉模式 -- 线程安全
// 单例实例在初始化时进行创建
public class Singleton {

    // 私有构造函数
    private Singleton() {

    }

    // 单例对象
    private static Singleton instance = new Singleton();

    public static Singleton getSingleton() {
        return instance;
    }

}

// 静态内部类实现 - 线程安全
public class Singleton {
    // 私有构造函数
    private Singleton() {

    }

    // 静态内部类
    private static class SingletonHolder{
        private static final Singleton.INSTANCE = new Singleton();
    }

    public static Singleton getSingleton() {
        return Singleton.INSTANCE;
    }

}

// 枚举实现
public class Singleton {
    // 私有构造函数
    private Singleton() {

    }

    public static Singleton getSingleton() {
        return Singletonenum.INSTANCE.getSingleton();
    }

    // 内部枚举类
    public enum Singletonenum {

        INSTANCE;

        private Singleton Singleton;

        // jvm保证这个函数只执行一次
    private Singletonenum(){
        Singleton = new Singleton;
    }

        public Singleton getSingleton() {
            return Singleton;
        }
    }
}