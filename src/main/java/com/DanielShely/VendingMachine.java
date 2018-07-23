package com.DanielShely;
import java.util.HashMap;

import static com.DanielShely.VendingMachine.PRODUCTS.*;


interface Output{
    public void printToOutput(String messege);
}

 class ConsoleOutput implements Output{

    public void printToOutput(String messege) {
        System.out.println(messege);
    }}


public class VendingMachine  implements Runnable {

    private static HashMap<PRODUCTS, Double> menu;
    private State state;
    private double money;
    private Output outMessege;
    private boolean isOn;
    long lastTimeInvoked;



    static {
        menu=new HashMap<PRODUCTS, Double>();
        menu.put(COLA, 5.5);
        menu.put(SPRITE, 7d);
        menu.put(WATER, 4d);
        menu.put(BEER, 8d);
        menu.put(FLAVOURED_WATER, 4.5);
        menu.put(ORANGE_JUICE, 5.8);
    }

    public  void  shutDown(){
        this.isOn=false;
    }
    public VendingMachine(Output out) {

        state = State.IDLE;
        isOn=true;
        outMessege=out;
        lastTimeInvoked=System.currentTimeMillis();

    }

    public void insertCoin(double coin) {
        synchronized (this) {
            if (coin < 0) {
                throw new IllegalArgumentException("negative money is unreal, check coin recognition system!");
            }
            state.insertCoin(this, coin);
            lastTimeInvoked=System.currentTimeMillis();

        }

    }
    public void chooseItem(PRODUCTS prod){
        synchronized (this) {

            state.chooseItem(this, prod);
            lastTimeInvoked=System.currentTimeMillis();
        }


    }

    public  void cancle() {
        synchronized (this) {
            state.cancel(this);
            lastTimeInvoked=System.currentTimeMillis();
        }
    }

    public void run() {
        long delta=0;
        System.out.println("Starting run loop...");
        while (true) {
            try {

                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
            delta=System.currentTimeMillis() - lastTimeInvoked;
                System.out.println("delta= " + delta);
                if (delta >= 3000) {


                    outMessege.printToOutput("going to timeout from " + state.toString());
                    state.timeout(this);

                }

            }
        }
    }


    public enum PRODUCTS {COLA, SPRITE, WATER, BEER, FLAVOURED_WATER, ORANGE_JUICE}

    private enum State {
        IDLE {
            @Override
            public void insertCoin(VendingMachine machine, double coin) {

                machine.money= machine.money + coin;
                machine.outMessege.printToOutput(String.format("%.2f added",coin));
                machine.outMessege.printToOutput(String.format("%.2f money in the machine", machine.money));
                machine.state= State.MONEY_INSERTED;
            }


            public void chooseItem(VendingMachine machine, PRODUCTS product) {
                machine.outMessege.printToOutput("Please insert money First and then choose " +
                        "your product!");
                machine.state= State.IDLE;

            }

            @Override
            public void cancel(VendingMachine machine) {

                machine.outMessege.printToOutput("Cancel is irrelevant in Idle mode!");
                machine.state= State.IDLE;

            }

            @Override
            public void timeout(VendingMachine machine) {

                machine.state= State.IDLE;

            }
        }, MONEY_INSERTED {
            @Override
            public void insertCoin(VendingMachine machine, double coin) {
                machine.money= machine.money + coin;
                machine.outMessege.printToOutput(String.format("%.2f added",coin));
                machine.outMessege.printToOutput(String.format("%.2f money in the machine", machine.money));
                machine.state= State.MONEY_INSERTED;

            }

            @Override
            public void chooseItem(VendingMachine machine ,PRODUCTS product) {
                
                double price= menu.get(product);
                if (price  <= machine.money) {
                     machine.outMessege.printToOutput("supplying " + product.toString());
                    machine.money= machine.money- price;
                    if(machine.money>0){
                        machine.outMessege.printToOutput(String.format("return %.2f to costumer",machine.money));
                        machine.money=0;
                    }

                    machine.state= State.SUPPLY_DRINK;
                    machine.state=State.IDLE;


                }
                else {
                    machine.outMessege.printToOutput(String.format("Not enough money! need to add " +
                            "%.2f",price-machine.money));

                    machine.state= State.MONEY_INSERTED;
                }
            }

            @Override
            public void cancel(VendingMachine machine) {
                machine.outMessege.printToOutput(String.format("return %.2f to client",machine.money ));
                machine.money=0;
                machine.state= State.IDLE;

            }

            @Override
            public void timeout(VendingMachine machine) {
                machine.outMessege.printToOutput(String.format("return %.2f to customer due to time out",
                        machine.money));
                machine.money=0;
                machine.state= State.IDLE;
                
            }

        }, SUPPLY_DRINK {
            @Override
            public void insertCoin(VendingMachine machine, double coin) {
                machine.outMessege.printToOutput(String.format("cant take money supplying Drink!" +
                        "\n return  %.2f to Shekels to costumer",coin) );
                machine.state= State.IDLE;

            }

            @Override
            public void chooseItem(VendingMachine machine, PRODUCTS product) {

                    machine.outMessege.printToOutput("Supplying Drink");
                    machine.state = State.IDLE;

            }

            @Override
            public void cancel(VendingMachine machine) {
                machine.outMessege.printToOutput("Cant Cancle while supplying item!");
                machine.state= State.SUPPLY_DRINK;
            }

            @Override
            public void timeout(VendingMachine machine) {
                machine.state= State.IDLE;

            }

        }, CANCEL {
            @Override
            public void insertCoin(VendingMachine machine, double coin) {
                machine.outMessege.printToOutput(String.format("Cant insert coiins while canceling!" +
                        "\n return %.2f Shekels to costumer",coin));
                machine.state= State.CANCEL;
                

            }

            @Override
            public void chooseItem(VendingMachine machine, PRODUCTS product) {

                machine.outMessege.printToOutput("Cancel in progress! be patience!");


            }

            @Override
            public void cancel(VendingMachine machine) {
                machine.outMessege.printToOutput("Cancel in progress! be patience!");
                machine.state=State.IDLE;

            }

            @Override
            public void timeout(VendingMachine machine) {
                machine.state= State.IDLE;
            }


        };


        abstract public void insertCoin(VendingMachine machine, double coin);

        abstract public void chooseItem(VendingMachine machine, PRODUCTS product);

        abstract public void cancel(VendingMachine machine);

        abstract public void timeout(VendingMachine machine);


    }
}







