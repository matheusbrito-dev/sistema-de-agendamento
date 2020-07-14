package br.com.srcsoftware.agenda.moduloagenda.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.srcsoftware.agenda.moduloagenda.agenda.model.AgendaPO;
import br.com.srcsoftware.manager.connection.HibernateConnection;
import br.com.srcsoftware.manager.exceptions.BackendException;

public class AgendaDAO {


	public void inserir( HibernateConnection hibernate, AgendaPO po ) throws BackendException {
		/**
		 * Invocando o método inserir do nosso
		 * componente de Conexão HibernateConnection
		 */

		AgendaPO poInserido = (AgendaPO) hibernate.inserir( po );

		/** Pegando o ID do Agenda Recem inserida */
		po.setId( poInserido.getId() );
	}

	public void alterar( HibernateConnection hibernate, AgendaPO po ) throws BackendException {

		hibernate.alterar( po );
	}

	public void excluir( HibernateConnection hibernate, AgendaPO po ) throws BackendException {

		hibernate.excluir( po );
	}

	public AgendaPO filtrarPorId( Long id ) throws BackendException {
		return (AgendaPO) new HibernateConnection().filtrarPorId( id, AgendaPO.class );
	}

	public List< AgendaPO > filtrar( AgendaPO poFiltrar ) throws BackendException {

		HibernateConnection hibernate = new HibernateConnection();

		try {
			hibernate.iniciarTransacao();

			//Fazer o que tem que fazer
			/** utilizando CriteriaBuilder para a confecção de nossas Queries */
			//Criando a Criteria com base na CriteriaBuilder
			CriteriaBuilder builder = hibernate.getCurrentSession().getCriteriaBuilder();
			CriteriaQuery criteria = builder.createQuery( AgendaPO.class );

			//Definindo o FROM
			Root root = criteria.from( AgendaPO.class );

			//Deixando a Criteria preparada para a consulta
			criteria.select( root );

			//Definindo os Parametros(Predicados) para a consulta(WHERE)
			ArrayList< Predicate > predicados = new ArrayList< Predicate >();

			if ( poFiltrar != null ) {
				if ( poFiltrar.getNomeExecutor() != null && poFiltrar.getNomeExecutor().isEmpty() ) {
					Predicate nomeParam = builder.like( root.get( "nome" ), poFiltrar.getNomeExecutor().concat( "%" ) );
					predicados.add( nomeParam );
				}
			}

			//Adicionando o Predicado no WHERE
			criteria.where( predicados.toArray( new Predicate[ predicados.size() ] ) );

			List< AgendaPO > encontrados = hibernate.getCurrentSession().createQuery( criteria ).getResultList();

			hibernate.commitTransacao();

			return encontrados;

		} catch ( BackendException e ) {
			hibernate.rollbackTransacao();
			throw e;
		} catch ( Throwable e ) {
			hibernate.rollbackTransacao();
			throw new BackendException( "Erro ao filtrar", e );
		}

	}
	
}
