package com.DanielShely;

import java.net.UnknownHostException;

public  class Singeltons{



}

/*using eager initilazation singlton to open some session with some fixed-application host  address*/
class EagarInit{
    private static final  Object eagerInitSingelton= new EagarInit("fixedhost.ilrd.co.il");
    String fixedHost;
    EagarInit(String fixedHost){
        this.fixedHost=fixedHost;
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
class staticBlockSingle{
    static{
        try{
            String fixedAdress= "fixedhost.ilrd.co.il";
            //try to connect to host
        }
        catch(Exception e){

            e.printStackTrace();

        }
    }
}


