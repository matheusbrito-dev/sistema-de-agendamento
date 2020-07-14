package br.com.srcsoftware.agenda.moduloagenda.agenda.dao.testadao;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Test;

import br.com.srcsoftware.agenda.moduloagenda.agenda.dao.AgendaDAO;
import br.com.srcsoftware.agenda.moduloagenda.agenda.model.AgendaPO;
import br.com.srcsoftware.manager.abstracts.AbstractPO;
import br.com.srcsoftware.manager.connection.HibernateConnection;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class TestaDAO {

	@Test
	public void executar() throws BackendException {
		HibernateConnection hibernate = new HibernateConnection();

		try {

			/** Testando o componente de Conexão no contexto do AgendaDAO */
			AgendaDAO dao = new AgendaDAO();

			/** Inserindo ocom base no componente */

			/** Inserindo com base no componente */
			hibernate.iniciarTransacao();

			AgendaPO po = new AgendaPO();
			po.setNomeServico("Jardinagem");
			po.setNomeCliente("Luane");
			po.setNomeExecutor("Pedro e José");
			po.setId(new Long("2"));
			po.setHora("14 horas");
			po.setDataHoraCadrastro(LocalDateTime.now());
			po.setDataToString("31/02/2018");

			System.out.println( po );
			po = (AgendaPO) hibernate.inserir( po );
			System.out.println( po );

			hibernate.commitTransacao();

			/** Alterando com base no componente */
			hibernate.iniciarTransacao();
			po.setNomeExecutor( "Pedro Alterado" );
			hibernate.alterar( po );
			System.out.println( po );
			hibernate.commitTransacao();

			/** Testando o filtrar por ID */
			AbstractPO encontrado = hibernate.filtrarPorId( Long.valueOf( "0" ), AgendaPO.class );
			System.out.println( "XXXXXXXXXXXXXXXX" + encontrado );

			/** Testando o Filtrar */
			AgendaPO poFiltrar = new AgendaPO();
			poFiltrar.setNomeExecutor( "Pedro" );
			List< AgendaPO > encontrados = dao.filtrar( poFiltrar );
			System.out.println( "************Filtrar" + encontrados );

			/** Excluindo baseado no Componente */
			/*hibernate.iniciarTransacao();
			hibernate.excluir( po );
			hibernate.commitTransacao();*/

		} catch ( BackendException e ) {
			e.printStackTrace();
			hibernate.rollbackTransacao();

		}
	}
	
	
}
