package omp;

import omp.pms.action.*;

public class Testor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Testor testor = new Testor();
		testor.TestActionFactory();
	}
	public void TestActionFactory(){
		ActionFactory factory = new ActionFactory();
		IAction action = factory.Instance("ValueUpate");
		if(null != action){
			action.Do();
		}
		else{
			System.out.println(this.getClass().getName());
		}
	}
}
