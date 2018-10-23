package design.pattern.prototype2;

public class Cat implements Cloneable {

    private String name;
    private Age age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public Cat copy() throws CloneNotSupportedException {

        Cat ret = (Cat)this.clone();
        ret.setAge(new Age(getAge().getYear(), getAge().getValue()));
        return ret;
    }

    public static void main(String[] args) throws CloneNotSupportedException {

        Cat navi = new Cat();

        navi.setName("navi");
        navi.setAge(new Age(2014, 5));

        Cat yo = (Cat) navi.copy();
        yo.setName("yo");
        yo.getAge().setYear(2017);
        yo.getAge().setValue(2);

        System.out.println(navi.getName());
        System.out.println(yo.getName());

        System.out.println(navi.getAge().getYear());
        System.out.println(yo.getAge().getYear());

        System.out.println(navi.getAge().getValue());
        System.out.println(yo.getAge().getValue());
    }
}
