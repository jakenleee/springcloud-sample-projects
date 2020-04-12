package io.twostepsfromjava.cloud.consumer.hello.controller.entity;

interface IEat {
    String eat();
}

class RealEat implements IEat {

    @Override
    public String eat() {
        System.out.println("真正执行业务动作:lizj吃美味食品");
        return "--lizj";
    }
}

class ProxyEat implements IEat {
    private IEat iEat;
    public ProxyEat (IEat iEat) {
        this.iEat = iEat;
    }

    @Override
    public String eat() {
        this.ready();
        this.iEat.eat();
        this.close();
        return "--end";
    }

    public String ready () {
        System.out.println("代理业务执行动作:lll买菜");
        return "--lll";
    }

    public String close () {
        System.out.println("代理业务执行动作:lll收拾");
        return "--lll";
    }
}
public class ProxyModel {
    public static void main(String[] args) {
        IEat iEat  = new ProxyEat(new RealEat());
        iEat.eat();
    }
}
