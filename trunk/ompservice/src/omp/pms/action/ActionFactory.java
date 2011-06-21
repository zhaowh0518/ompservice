package omp.pms.action;

import java.util.Properties;
import java.io.*;

/*
 * Factory pattern:generate action object
 */
public class ActionFactory {
	static String actionConfigFile = "action.properties";
	static String actionPakageName = "omp.pms.action." ;
	/*instance action by action name*/
	public static IAction Instance(String actionName){
		IAction action = null;
		try{
			String path = ActionFactory.class.getClassLoader().getResource("").getPath();
			actionConfigFile = path + actionConfigFile;
			InputStream in = new BufferedInputStream(new FileInputStream(actionConfigFile));
			Properties p = new Properties();
			p.load(in);
			String actionClassName = p.getProperty(actionName);
			if(null != actionClassName && ""  != actionClassName){
				actionClassName = actionPakageName + actionClassName;
				Class actionClass = Class.forName(actionClassName);
				if(null != actionClass){
					action = (IAction)actionClass.getConstructor(null).newInstance(null);
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return action;
	}
}
