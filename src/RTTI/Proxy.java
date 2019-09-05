package RTTI;

public class Proxy implements ProxyInterface{

    private ProxyInterface proxiedObject;

    public Proxy(ProxyInterface obj) {
        this.proxiedObject = obj;
    }

    @Override
    public void doSth() {
        System.out.println("doSth: Proxy");
        proxiedObject.doSth();
        proxiedObject.doSthElse(2);
    }

    @Override
    public void doSthElse(int nTimes) {

    }

    public static void main(String[] args) {
        RealObject realObject = new RealObject();
        realObject.doSth();
        realObject.doSthElse(1);

        Proxy p = new Proxy(new RealObject());
        p.doSth();
    }

}




interface ProxyInterface {
    void doSth();

    void doSthElse(int nTimes);
}


class RealObject implements ProxyInterface {

    @Override
    public void doSth() {
        System.out.println("doSth: RealObject");
    }

    @Override
    public void doSthElse(int nTimes) {
        System.out.println("doSthElse: RealObject " + nTimes);
    }
}

