package br.com.radames.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;

public class AprenderCucumberSteps {

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
	
	Date entrega = new Date();
	
	@Dado("^que a entrega é dia (\\d+)/(\\d+)/(\\d+)$")
	public void queAEntregaÉDia(Integer dia, Integer mes, Integer ano) throws Throwable {
	    Calendar calen = Calendar.getInstance();
	    calen.set(Calendar.DAY_OF_MONTH, dia);
	    calen.set(Calendar.MONTH, mes - 1);
	    calen.set(Calendar.YEAR, ano);
	    entrega = calen.getTime();
	}

	@Quando("^a entrega atrasar em (\\d+) (dia|dias|mes|meses)$")
	public void aEntregaAtrasarEmDias(Integer dia, String tempo) throws Throwable {
		Calendar calen = Calendar.getInstance();
		calen.setTime(entrega);
		if (tempo.equals("dias")) {
			calen.add(Calendar.DAY_OF_MONTH, dia);
		} else {
			calen.add(Calendar.MONTH, dia);
		}
	    entrega = calen.getTime();
	}

	@Então("^a entrega será efetuada em (\\d{2}\\/\\d{2}\\/\\d{4})$")
	public void aEntregaSeráEfetuadaEm(String data) throws Throwable {
	    DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
	    String dataFormatada = format.format(entrega);
	    Assert.assertEquals(data, dataFormatada);
	}
	
	//String ticket = "";

	@Dado("^que o ticket é AF(\\d+)$")
	public void queOTicketÉAF(int tkt) throws Throwable {
		//ticket = tkt;
	}

	@Dado("^que o valor da passagem é R\\$ (\\d+),(\\d+)$")
	public void queOValorDaPassagemÉR$(Double double1) throws Throwable {
	}

	@Dado("^que o nome do passageiro é \"(.*)\"$")
	public void queONomeDoPassageiroÉ(String string) throws Throwable {
	    
	}

	@Dado("^que o telefone do passageiro é (\\d+)(\\d+)$")
	public void queOTelefoneDoPassageiroÉ(Integer int1, Integer int2) throws Throwable {
	    
	}

	@Quando("^criar os steps$")
	public void criarOsSteps() throws Throwable {
	    
	}

	@Então("^o teste vai funcionar$")
	public void oTesteVaiFuncionar() throws Throwable {
	    
	}
}
