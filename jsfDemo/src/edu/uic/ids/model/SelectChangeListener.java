package edu.uic.ids.model;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
public class SelectChangeListener implements ValueChangeListener {
	 @Override
	   public void processValueChange(ValueChangeEvent event)
	      throws AbortProcessingException {
	      
	      //access country bean directly
	      TableSelect tableselect = (TableSelect) FacesContext.getCurrentInstance().
	      getExternalContext().getSessionMap().get("tableselect");
//	    
//	      tableselect.setArr2_select(event.getNewValue().toString());
	      tableselect.setSelectTable(event.getNewValue().toString());
	   }
}
