package edu.uic.ids.model;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.annotation.PostConstruct;
@ManagedBean
@SessionScoped
public class LoanBean implements Serializable, Cloneable {
/**
*
*/
private static final long serialVersionUID = 1L;
// inputs
private double loanAmount;
private double downPayment;
private int loanTerm;
private double interestRate;
// outputs
private double monthlyPayment;
private double totalPayments;
private double totalInterest;
private double totalCost;
public LoanBean() {
}
public LoanBean clone() throws CloneNotSupportedException {
LoanBean cloned = (LoanBean) super.clone();
return cloned;
}
@PostConstruct
public void init() {
loanAmount = 0.0;
downPayment = 0.0;
loanTerm = 0;
interestRate = 0.0;
monthlyPayment = 0.0;
totalPayments = 0.0;
totalInterest = 0.0;
totalCost = 0.0;
}
public String computeLoan() {
double c = interestRate / 1200;
int term = loanTerm * 12;
double financeAmount = loanAmount - downPayment;
double x = Math.pow(1.0 + c, term);
monthlyPayment = financeAmount * c * x / (x - 1.0);
monthlyPayment = Math.round(monthlyPayment * 100.0) / 100.0;
totalPayments = MathUtil.round(term * monthlyPayment, 100.0);
totalInterest = MathUtil.round(totalPayments - financeAmount, 100.0);
totalCost = MathUtil.round(totalPayments + downPayment, 100.0);
return "SUCCESS";
}
public String reset() {
	loanAmount = 0.0;
	downPayment = 0.0;
	loanTerm = 0;
	interestRate = 0.0;
	monthlyPayment = 0.0;
	totalPayments = 0.0;
	totalInterest = 0.0;
	totalCost = 0.0;
	return "SUCCESS";
}
public double getLoanAmount() { return loanAmount; }
public void setLoanAmount(double loanAmount) {this.loanAmount = loanAmount;}
public double getDownPayment() { return downPayment; }
public void setDownPayment(double downPayment) {
this.downPayment = downPayment;
}
public int getLoanTerm() {return loanTerm;}
public void setLoanTerm(int loanTerm) { this.loanTerm = loanTerm; }
public double getInterestRate() {return interestRate;}
public void setInterestRate(double interestRate) {
this.interestRate = interestRate; }
public double getMonthlyPayment() {return monthlyPayment; }
public double getTotalPayments() {return totalPayments; }
public double getTotalInterest() {return totalInterest; }
public double getTotalCost() { return totalCost; }
}