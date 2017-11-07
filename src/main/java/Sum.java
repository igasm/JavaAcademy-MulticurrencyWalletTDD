public class Sum implements Expression {
    Expression augend;
    Expression addend;

    Sum(Expression augend, Expression addend){
        this.augend = augend;
        this.addend = addend;
    }

    public Money reduce(Bank bank, String to){
        int augend_reduced = augend.reduce(bank, to).amount;
        int addend_reduced = addend.reduce(bank, to).amount;
        int amount = augend_reduced + addend_reduced;
        return new Money(amount, to);
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }

    public Expression times(int multiplier){
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }
}
