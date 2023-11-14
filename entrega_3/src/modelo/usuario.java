package modelo;

import java.util.List;

public abstract class usuario {
	
	private String Login;
	private String Password;
	
	
	public usuario(String log, String pword) {
		this.Login = log;
		this.Password = pword;
	}
	
	public String getLogin() {
		return this.Login;
		
	}
	
	public String getPassword() {
		return this.Password;
	}

	public static Boolean entrar(String Login, String Password, List<usuario> lista) {
		boolean enter = false; 
		
		int a = 0;
		usuario instancias = lista.get(a);
		String enter_instancia = instancias.getLogin();
		if(Login != enter_instancia) {
			a += 1;
			entrar(Login, Password, lista);
			
		}else{
			if (Password == instancias.getPassword()) {
				enter = true;
			}
			else {
				entrar(Login, Password, lista);
			}
		}
		return enter;
		
	}
	public void setPassword(String pword) {
		this.Password = pword;
	}

}
