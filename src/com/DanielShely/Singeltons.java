package com.DanielShely;

import java.net.UnknownHostException;

public  class Singeltons{



}

/*using eager initilazation singlton to open some session with some fixed-application host  address*/
class EagarInit{
    private static final  EagarInit instance= new EagarInit("fixedhost.ilrd.co.il");
    String fixedHost;
    EagarInit(String fixedHost){
        this.fixedHost=fixedHost;
    }

    public static EagarInit getEagerInitSingelton() {
        return instance;
    }
}


/*using enum  also for fixed host address */
enum EnumSingelton{
    SINGLE_INSTANCE( "fixedhost.ilrd.co.il" );
    String fixedAdress;

    EnumSingelton(String fixedAdress){
        this.fixedAdress=fixedAdress;
    }

}
/*using static block initalazation for added value of exception throwing*/
class StaticBlockSingle{
    private String fixedAddrerss;
    private  static   StaticBlockSingle instance;
    private  StaticBlockSingle(String fixedAddrerss) {
        this.fixedAddrerss = fixedAddrerss;
        //some code for trying connect to hos
    }
    static{
        try{
         instance= new StaticBlockSingle("fixedhost.ilrd.co.il");

        }
        catch(Exception e){

            e.printStackTrace();

        }

    }

    public static StaticBlockSingle getInstance() {
        return instance;
    }


}

/*using lazy init*/
class LazyBindingSingle {
    private static LazyBindingSingle instance;
    private String fixedAddress;

    private LazyBindingSingle(String fixedAddress) {

        this.fixedAddress = fixedAddress;

    }

    public static LazyBindingSingle getInstance() {

        if (instance == null) {
            instance = new LazyBindingSingle("fixedhost.ilrd.co.il");
        }
        return instance;

    }
}

/*using thread-safe lazy init*/

class ThreadSafeLazyInit{
    private static ThreadSafeLazyInit instance;
    private  String  fixedAddress;
    private ThreadSafeLazyInit(String fixedAdress){
        this.fixedAddress=fixedAdress;
    }

    public static synchronized ThreadSafeLazyInit getInstance() {

        if (instance == null) {
            instance = new ThreadSafeLazyInit("fixedhost.ilrd.co.il");
        }
        return instance;

    }


}

/*double cheked thread safe*/
class DoublecheckSingle{
    static  private  DoublecheckSingle instance ;
    private  String fixedAddress;
    private DoublecheckSingle(String fixedAdress){
        this.fixedAddress=fixedAdress;
    }

    public static DoublecheckSingle getInstance() {
        return instance;
    }
}