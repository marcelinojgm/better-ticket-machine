/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // Añade la posivilidad de crear tikect con descuento
    private boolean reduction;

    /**
     * Create a machine that issues tickets of the given price.
     * indica si la maquina puede (true) o no (false) dar ticket con reducicon de precio.
     */
    public TicketMachine(int cost, boolean reductionTicket)
    {
        price = cost;
        reduction = reductionTicket;
        balance = 0;
        total = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }
    
    /**devuelve el dinero que hace falta meter
     * para poder imprimir un ticket
     */
    public int getAmoungLeftToPay()
    {
         int amoungLeftToPay;
         amoungLeftToPay = price - balance;
         return amoungLeftToPay;    
        
    }
    
    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
        /**
         *  if(amount <= 0) 
         *  {
            
         *      System.out.println("Use a positive amount rather than: " +
                               amount);
         * }
         *  else {
         *      balance = balance + amount;
         *      }
         */
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the prince.
            balance = balance - price;
        }
        else {
            int amountLeftToPay = price - balance;
            System.out.println("You must insert at least: " +
                               amountLeftToPay + " more cents.");
                    
        }
    }
 
    /**
     * vacia la maquina de las monedas almacenadas
     */
    public int emptyMachine()
    {
        int dineroSacado = total;
        total = 0;
        return dineroSacado;        
    }
    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
}
