package kr.or.dgit.erp.content;

import java.awt.Component;

import javax.swing.JPanel;

import erp_myframework.TextFieldPanel;


@SuppressWarnings("serial")
public abstract class AbsContentPanel<T> extends JPanel {
	public abstract TextFieldPanel getpNo(); 
	public abstract TextFieldPanel getpName();
	public abstract T getObject();
	public abstract void setObject(T item);
	public abstract void clear();
	
	public boolean isEmpty(){
		for(Component c: getComponents()){
			if(c instanceof TextFieldPanel){
				TextFieldPanel tfp= (TextFieldPanel) c;
				if(tfp.isEmptyCheck()){
					return true;
				}
			}
		}return false;
		
	}
}
