package lambda.style;


import java.util.function.Consumer;

class Mailer1 {
    public static void print(String msg) {
        System.out.println(msg);
    }

    public void from(String addr) {
        print("from : " + addr);
    }

    public void to(String addr) {
        print("to : " + addr);
    }

    public void subject(String line) {
        print("subject : " + line);
    }

    public void body(String msg) {
        print("body : " + msg);
    }

    public void send() {
        System.out.println("sending...");
    }
}

class Mailer2 {
    public static void print(String msg) {
        System.out.println(msg);
    }

    public Mailer2 from(String addr) {
        print("from : " + addr);
        return this;
    }

    public Mailer2 to(String addr) {
        print("to : " + addr);
        return this;
    }

    public Mailer2 subject(String line) {
        print("subject : " + line);
        return this;
    }

    public Mailer2 body(String msg) {
        print("body : " + msg);
        return this;
    }

    public void send() {
        System.out.println("sending...");
    }
}

class Mailer3 {
    public static void print(String msg) {
        System.out.println(msg);
    }

    public Mailer3 from(String addr) {
        print("from : " + addr);
        return this;
    }

    public Mailer3 to(String addr) {
        print("to : " + addr);
        return this;
    }

    public Mailer3 subject(String line) {
        print("subject : " + line);
        return this;
    }

    public Mailer3 body(String msg) {
        print("body : " + msg);
        return this;
    }

    static public void send(Consumer<Mailer3> block) {
        Mailer3 mailer = new Mailer3();
        block.accept(mailer);
        System.out.println("sending...");
    }
}

/*
    Creating Fluent interfaces using Lambdas - cascade method
 */
public class FluentInterfaceLambdaSample {

    public static void main(String[] args) {

        mailer1();  // normal style
        System.out.println();

        mailer2();  // 아직은 cascade형태로 변경되었지만 굳이 매력이 없다.
        System.out.println();

        mailer3();  // 이런 형태는 어떨까? consumer 를 받는 static
    }

    public static void mailer1() {
        Mailer1 mailer = new Mailer1();
        mailer.from("builder@mail.com");
        mailer.to("java@mail.com");
        mailer.subject("Your code sucks");
        mailer.body("... here you go ...");
        mailer.send();
    }

    public static void mailer2() {
        new Mailer2()
                .from("builder@mail.com")
                .to("java@mail.com")
                .subject("Your code sucks")
                .body("... here you go ...")
                .send();
    }

    public static void mailer3() {
        Mailer3.send(mailer -> mailer
                .from("builder@mail.com")
                .to("java@mail.com")
                .subject("Your code sucks")
                .body("... here you go ...")
        );
    }
}
