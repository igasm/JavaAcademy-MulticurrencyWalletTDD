public class Money implements Expression{

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

    public Expression plus(Money addend){
        return new Sum(this, addend);
    }

    public Money reduce(String to){
        return this;
    }

    public String currency(){
        return this.currency;
    }

    public String toString(){
        return this.amount + " " + this.currency;
    }

}
