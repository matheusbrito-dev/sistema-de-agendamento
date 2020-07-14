package br.com.srcsoftware.agenda.moduloagenda.agenda.model;

import java.text.Collator;
import java.time.LocalDate;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import br.com.srcsoftware.manager.abstracts.AbstractPO;
import br.com.srcsoftware.manager.utilidades.Utilidades;


@Entity
@Table( name = "agendas", uniqueConstraints = @UniqueConstraint( columnNames = { "nomeExecutor", "data", "hora" }, name = "UKAgendas" ) )
public class AgendaPO extends AbstractPO implements Comparable< AgendaPO >  {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	@Column( length = 50, nullable = false )
	private LocalDate data;
	
	@Column( length = 50, nullable = false )
	private String hora;
	
	@Column( length = 50, nullable = false )
	private String nomeExecutor;
	
	@Column( length = 50, nullable = false)
	private String nomeCliente;
	
	@Column( length = 50, nullable = false)
	private String nomeServico;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	
	@Transient
	public String getDataToString() {
		if ( getData() != null ) {
			return Utilidades.parseLocalDate(getData());
		}
		return null;
	}

	public void setDataToString( String data ) {
		if ( data != null && !data.isEmpty() ) {
			setData( Utilidades.parseLocalDate(data));
			return;
		}
		setData( null );
	}
	
	@Transient
	public String getIdToString() {
		if ( getId() != null ) {
			return getId().toString();
		}
		return null;
	}

	public void setIdToString( String id ) {
		if ( id != null && !id.isEmpty() ) {
			setId( Long.valueOf( id ) );
			return;
		}
		setId( null );
	}
	
	public void setHora(String hora) {
		this.hora = hora;
	}
	public String getNomeExecutor() {
		return nomeExecutor;
	}
	public void setNomeExecutor(String nomeExecutor) {
		this.nomeExecutor = nomeExecutor;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getNomeServico() {
		return nomeServico;
	}
	public void setNomeServico(String nomeServico) {
		this.nomeServico = nomeServico;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + ((nomeExecutor == null) ? 0 : nomeExecutor.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendaPO other = (AgendaPO) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (nomeExecutor == null) {
			if (other.nomeExecutor != null)
				return false;
		} else if (!nomeExecutor.equals(other.nomeExecutor))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		
		StringBuilder builder = new StringBuilder();
		builder.append( "AgendaPO [id=" );
		builder.append( id );
		builder.append( ",\n\t  data=" );
		builder.append( data );
		builder.append( ",\n\t  hora=" );
		builder.append( hora );
		builder.append( ",\n\t  nomeExecutor=" );
		builder.append( nomeExecutor );
		builder.append( ",\n\t  nomeCliente=" );
		builder.append( nomeCliente );
		builder.append( ",\n\t  nomeServiço=" );
		builder.append( nomeServico );
		builder.append( ",\n\t  getDataHoraCadastro()=" );
		builder.append( getDataHoraCadastro() );
		builder.append( "]\n " );
		return builder.toString();
	}

	@Override
	public int compareTo( AgendaPO comparar ) {
		Collator ignoraAcentos = Collator.getInstance( new Locale( "pt", "BR" ) );

		return ignoraAcentos.compare( this.getNomeServico(), comparar.getNomeServico() );
	}
	

}
