package model.entitites;

import model.exceptions.DomainException;


public class Account {
private Integer number;
private String holder;
private Double balance;
private Double withDrawLimit;

public Account() {
	
}

public Account(Integer number, String holder,  Double balance, Double withDrawLimit) {
	this.number = number;
	this.holder = holder;
	this.balance = balance;
	this.withDrawLimit = withDrawLimit;
}

public String getHolder() {
	return holder;
}

public void setHolder(String holder) {
	this.holder = holder;
}

public Integer getNumber() {
	return number;
}

public void setNumber(Integer number) {
	this.number = number;
}

public Double getBalance() {
	return balance;
}

public void setBalance(Double balance) {
	this.balance = balance;
}
public Double getWithdraw() {
	return withDrawLimit;
}

public void withDraw(double withDraw) {
	
	if(withDraw > this.withDrawLimit)
		throw new DomainException("Withdraw error: The amount exceeds withdraw limit");
	
	if(withDraw > this.balance && withDraw <= this.withDrawLimit)
		throw new DomainException("Withdraw error: Not enough balance");
	
	balance -= withDraw;
}

public void deposit(double deposit) {
	
	balance += deposit;
	
}
@Override
public String toString() {
	
	return String.format("%.2f", this.balance);
}


}
