public class Money {

    protected int amount;

    protected String currency;

    Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    static Money franc(int amount){
        return new Money(amount, "CHF");
    }

    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount && this.currency().equals(money.currency());
    }

    public Money times(int multiplier){
        return new Money(amount * multiplier, currency);
    }

    public String currency(){
        return currency;
    }

    public String toString(){
        return this.amount + " " + this.currency;
    }

}
