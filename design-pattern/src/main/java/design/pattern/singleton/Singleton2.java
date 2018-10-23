package design.pattern.singleton;

import java.io.Serializable;

// sigleton1에서 역직렬화시 싱글톤이 깨질 수 있는 경우를 방지하려면 아래처럼
// transient와 readResolve()를 추가해준다.
// [백기선의 Effective Java|https://youtu.be/xBVPChbtUhM] 참조
// [Discover the secrets of the Java Serialization API|http://www.oracle.com/technetwork/articles/java/javaserial-1536170.html] 문서도 참
public class Singleton2 implements Serializable {

    private static final transient Singleton2 instance = new Singleton2();

    private Singleton2 () {}

    public static Singleton2 getInstance() {
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }
}
