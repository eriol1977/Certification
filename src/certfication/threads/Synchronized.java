/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package certfication.threads;

/**
 *
 * @author f.bertolino
 */
public class Synchronized implements Runnable {

    private final Account acct = new Account();

    public static void main(String[] args) {

        Synchronized r = new Synchronized();
        // the two threads share the same runnable instance, and that's why
        // the lock works on the synchronized method
        Thread one = new Thread(r);
        Thread two = new Thread(r);
        one.setName("Fred");
        two.setName("Lucy");
        one.start();
        two.start();
    }

    @Override
    public void run() {
        for (int x = 0; x < 5; x++) {
            makeWithdrawal(10);
            if (acct.getBalance() < 0) {
                System.out.println("account is overdrawn!");
            }
        }
    }

    // remove synchronized to see bad behaviour
    private synchronized void makeWithdrawal(int amt) {
        // 'synchronized' in the method declaration is equivalent to 
        // synchronized(this) {} inside the method
        if (acct.getBalance() >= amt) {
            System.out.println(Thread.currentThread().getName()
                    + " is going to withdraw");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            acct.withdraw(amt);
            System.out.println(Thread.currentThread().getName()
                    + " completes the withdrawal");
        } else {
            System.out.println("Not enough in account for "
                    + Thread.currentThread().getName()
                    + " to withdraw " + acct.getBalance());
        }
    }

    static class Account {

        private int balance = 50;

        public int getBalance() {
            return balance;
        }

        public void withdraw(int amount) {
            balance = balance - amount;
        }
    }
}
