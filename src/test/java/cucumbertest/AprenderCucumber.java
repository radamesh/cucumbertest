package cucumbertest;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AprenderCucumber {

	@Dado("^que criei o arquivo corretamente$")
	public void queCrieiOArquivoCorretamente() throws Throwable {
	    System.out.println("que criei o arquivo corretamente");
	}

	@Quando("^executá-lo$")
	public void executáLo() throws Throwable {
		System.out.println("executá-lo");
	}

	@Então("^a especificação deve finalizar com sucesso$")
	public void aEspecificaçãoDeveFinalizarComSucesso() throws Throwable {
		System.out.println("a especificação deve finalizar com sucesso");
	}
	
	private int contador = 0;
	
	@Dado("^que o valor do contador é (\\d+)$")
	public void queOValorDoContadorÉ(int arg1) throws Throwable {
	    contador = arg1;
	}

	@Quando("^eu incrementar em (\\d+)$")
	public void euIncrementarEm(int arg1) throws Throwable {
		contador = contador + arg1;
	}

	@Então("^o valor do contador será (\\d+)$")
	public void oValorDoContadorSerá(int arg1) throws Throwable {
	    System.out.println(arg1);
	    System.out.println(contador);
	    System.out.println(arg1 == contador);
	    // Assert.assertTrue(arg1 == contador);
	    Assert.assertEquals(arg1, contador);
	}
}
