package edu.uic.ids.action;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.uic.ids.model.LoanBean;
@ManagedBean
@SessionScoped
public class ActionBeanLoan {
private LoanBean loanBean;
private List<LoanBean> loanBeanList;
private boolean renderLoanList;
public ActionBeanLoan() {
// TODO Auto-generated constructor stub
	/* following can be here or via init() PostConstruct
	setloanBeanList(new ArrayList<LoanBean>());
	renderLoanList = false;
	*/
	}
	@PostConstruct
	public void init() {
//		loanBeanList = new ArrayList<LoanBean>();
//		renderLoanList = false;
		}
	public String computeLoan() throws CloneNotSupportedException {
		String status = loanBean.computeLoan();
		LoanBean loan = loanBean.clone();
		loanBeanList.add(loan);
		renderLoanList = true;
		return status;
		}
		public String reset() {
		loanBean.reset();
		loanBeanList.clear();
		renderLoanList = false;
		return "SUCCESS";
		}
		public LoanBean getLoanBean() { return loanBean; }
		public void setLoanBean(LoanBean loanBean) {
		// used by faces-config.xml managed bean
			this.loanBean = loanBean;
		}
		public List<LoanBean> getLoanBeanList() { return loanBeanList; }
		public boolean isRenderLoanList() { return renderLoanList; }
		public void setRenderLoanList(boolean renderLoanList) {
		this.renderLoanList = renderLoanList;
		}
		}
