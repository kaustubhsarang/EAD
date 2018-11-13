
package edu.uic.ids.model;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
public class BmiBean implements Serializable, Cloneable {
/**
*
*/
private static final long serialVersionUID = 1L;
// inputs
private String units;
private double weight;
private double height;
private String user;
//outputs
private double bmi;
private double bmiPrime;
private String bmiCategory;
private String errorMessage;
//control
private boolean status;
//constants
private static double SI_CONSTANT = 1.0;
private static double IMPERIAL_CONSTANT = 703.0;
public static double BMI_UPPER_LIMIT = 25.0;
public static double categoryLimit [] =
{0.0, 15.0, 16.0, 18.5, 25.0, 30.0, 35.0, 40.0};
public static String CATEGORY_DESCRIPTION [] =
{ "Error",
"Very severely underweight",
"Severely underweight",
"Underweight",
"Normal (healthy weight)",
"Overweight",
"Obese Class I (Moderately obese)",
"Obese Class II (Severely obese)",
"Obese Class III (Very severely obese)" };
public BmiBean() {
// TODO Auto-generated constructor stub
errorMessage = "";
bmiCategory = "";
}
public BmiBean(String units, double weight, double height) {
super();
this.units = units;
this.weight = weight;
this.height = height;
}
@PostConstruct
public void init() {
units = "English-Imperial";
}
public BmiBean clone() throws CloneNotSupportedException {
BmiBean cloned = (BmiBean) super.clone();
return cloned;
}
public String computeBmi() {
String statusCode = "FAIL";
status = false;
// additional checking needed
if( (height <= 0.0) || (weight <= 0.0) ) {
errorMessage = "Bad input data for weight or height";
bmi = 0.0;
} // end if
else {
double constant = SI_CONSTANT;
if(!units.equalsIgnoreCase("SI"))
constant = IMPERIAL_CONSTANT;
errorMessage = "";
bmi = constant * weight / (height * height);
status = true;
statusCode = "SUCCESS";
} 
bmiPrime = bmi / BMI_UPPER_LIMIT;
bmi = MathUtil.round(bmi, 10.0);
bmiPrime = MathUtil.round(bmiPrime, 100.0);
bmiCategory =
CATEGORY_DESCRIPTION[CATEGORY_DESCRIPTION.length-1];
for(int i = 0; i < categoryLimit.length; i++) {
if(bmi <= categoryLimit[i]) {
bmiCategory = CATEGORY_DESCRIPTION[i];
break;
} // end if
} // end for
return statusCode;
}
public String reset() {
	weight = 0.0;
	height = 0.0;
	user = "";
	//outputs
	bmi = 0.0;
	bmiPrime = 0.0;
	bmiCategory = "";
	return "SUCCESS";
}
public String getUnits() {return units;}
public void setUnits(String units) {this.units = units; }
public double getWeight() {return weight;}
public void setWeight(double weight) { this.weight = weight;}
public double getHeight() {return height; }
public void setHeight(double height) { this.height = height; }
public double getBmi() { return bmi; }
public double getBmiPrime() { return bmiPrime; }
public String getBmiCategory() { return bmiCategory; }
public String getErrorMessage() {return errorMessage;}
public boolean isStatus() {return status; }
public String getUser() { return user; }
public void setUser(String user) {this.user = user; }
}