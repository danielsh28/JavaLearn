package com.DanielShely;
import java.util.HashMap;

import static com.DanielShely.VendingMachine.PRODUCTS.*;


interface Output{
    public void printToOutput(String messege);
}

class ConsoleOutput implements Output{

    public void printToOutput(String messege) {
        System.out.println(messege);
    }
}

public class VendingMachine {

    static HashMap<PRODUCTS, Double> menu;
    State state;
    double money;
    Output outMessege;


    static {
        menu.put(COLA, 5.5);
        menu.put(SPRITE, 7d);
        menu.put(WATER, 4d);
        menu.put(BEER, 8d);
        menu.put(FLAVOURED_WATER, 4.5);
        menu.put(ORANGE_JUICE, 5.8);
    }


    public VendingMachine() {
        state = State.IDLE;
    }

    public void insertCoin(double coins) {
        this.money = this.money + coins;
       state= state.insertCoin();
    }


    public enum PRODUCTS {COLA, SPRITE, WATER, BEER, FLAVOURED_WATER, ORANGE_JUICE}

    enum State {
        IDLE {
            @Override
            public State insertCoin() {

                return State.MONEY_INSERTED;
            }


            public State chooseItem(double money, PRODUCTS product) {
                if (menu.get(product) >= money) {

                    return State.SUPPLY_DRINK;

                } else {
                    return State.MONEY_INSERTED;
                }
            }

            @Override
            public State cancle() {

            }

            @Override
            public State timeout() {

            }
        }, MONEY_INSERTED {
            @Override
            public State insertCoin() {

            }

            @Override
            public State chooseItem(double money, String product) {

            }

            @Override
            public State cancle() {

            }

            @Override
            public State timeout() {

            }

        }, SUPPLY_DRINK {
            @Override
            public State insertCoin() {


            }

            @Override
            public State chooseItem(double money, String product) {

            }

            @Override
            public State cancle() {

            }

            @Override
            public State timeout() {

            }

        }, CANCEL {
            @Override
            public State insertCoin() {

            }

            @Override
            public State chooseItem(double money, String product) {

            }

            @Override
            public State cancle() {

            }

            @Override
            public State timeout() {

            }


        };


        abstract public State insertCoin();

        abstract public State chooseItem(double money, String product);

        abstract public State cancle();

        abstract public State timeout();


    }
}







