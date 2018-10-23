package lambda.style;

import java.util.function.Consumer;

class Resource {
    public Resource() {
        System.out.println("Construct");
    }

    public void op1() {
        System.out.println("op1");
    }

    public void op2() {
        System.out.println("op2");
    }

    public void close() {
        System.out.println("cleanup");
    }
}

class Resource2 {
    public Resource2() {
        System.out.println("Construct");
    }

    public void op1() {
        System.out.println("op1");
    }

    public void op2() {
        System.out.println("op2");
    }

    public void close() {
        System.out.println("cleanup");
    }
}

class Resource3 implements AutoCloseable {
    public Resource3() {
        System.out.println("Construct");
    }

    public void op1() {
        System.out.println("op1");
    }

    public void op2() {
        System.out.println("op2");
    }

    public void close() {
        System.out.println("cleanup");
    }
}

class Resource4 {
    public Resource4() {
        System.out.println("Construct");
    }

    public Resource4 op1() {
        System.out.println("op1");
        return this;
    }

    public Resource4 op2() {
        System.out.println("op2");
        return this;
    }

    private void close() {
        System.out.println("cleanup");
    }

    static public void use(Consumer<Resource4> block) {
        Resource4 res = new Resource4();
        try {
            block.accept(res);
        } finally {
            res.close();
        }
    }
}

// Execute Around Method Pattern
public class AroundMethodPatternSample {

    public static void main(String[] args) {
        execute1();
        System.out.println();
        execute2();
        System.out.println();
        execute3();
        System.out.println();
        execute4();     // 최종....
    }

    public static void execute1() {
        Resource res = new Resource();
        res.op1();
        res.op2();
        res.close();    // 까먹기 쉽다.
    }

    public static void execute2() {
        Resource2 res = new Resource2();
        try {
            res.op1();
            res.op2();
        } finally {
            res.close();
        }
    }

    // java 7 auto close
    public static void execute3() {
        try (Resource3 res = new Resource3()) {
            res.op1();
            res.op2();
        }
    }

    // java 7 auto close
    public static void execute4() {
        Resource4.use(resource ->
                resource.op1()
                        .op2());
    }
}
