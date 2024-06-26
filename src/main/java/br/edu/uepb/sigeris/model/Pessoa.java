package br.edu.uepb.sigeris.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.edu.uepb.sigeris.enumerations.Estados;
import br.edu.uepb.sigeris.enumerations.VinculoServidor;
import br.edu.uepb.sigeris.validator.Email;
import br.edu.uepb.sigeris.validator.RG;
import lombok.Data;

/**
 * Classe que representa o modelo da entidade Cliente a ser persistida no banco,
 * com todos os seus atributos.
 *
 * @author Cássio Oliveira <cassio@cassioliveira.com.br>
 */
@Data
@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
		@NamedQuery(name = "Servidores.todos", query = "FROM Pessoa p WHERE p.categoria='TECNICO' OR p.categoria='PROFESSOR' ORDER BY p.nome ASC"),
		@NamedQuery(name = "Professores.todos", query = "FROM Pessoa p WHERE p.categoria='PROFESSOR' ORDER BY p.nome ASC"),
		@NamedQuery(name = "Terceirizados.todos", query = "FROM Pessoa p WHERE p.categoria='TERCEIRIZADO' ORDER BY p.nome ASC"),
		@NamedQuery(name = "TerceirizadosVigilantes.todos", query = "FROM Pessoa p WHERE p.categoria='TERCEIRIZADO' AND p.profissionalSetor='VIGILANTES' ORDER BY p.nome ASC"),
		@NamedQuery(name = "TerceirizadosApoio.todos", query = "FROM Pessoa p WHERE p.categoria='TERCEIRIZADO' AND p.profissionalSetor<>'VIGILANTES' ORDER BY p.nome ASC"),
		@NamedQuery(name = "ProfessoresContratados.todos", query = "FROM Pessoa p WHERE p.categoria='PROFESSOR' AND p.vinculo='SUBSTITUTO' ORDER BY p.nome ASC"),
		@NamedQuery(name = "ProfessoresEfetivos.todos", query = "FROM Pessoa p WHERE p.categoria='PROFESSOR' AND p.vinculo='EFETIVO' ORDER BY p.nome ASC"),
		@NamedQuery(name = "Tecnicos.todos", query = "FROM Pessoa p WHERE p.categoria='TECNICO' ORDER BY p.nome ASC"),
		@NamedQuery(name = "TecnicosContratados.todos", query = "FROM Pessoa p WHERE p.categoria='TECNICO' AND p.vinculo='SUBSTITUTO' ORDER BY p.nome ASC"),
		@NamedQuery(name = "TecnicosEfetivos.todos", query = "FROM Pessoa p WHERE p.categoria='TECNICO' AND p.vinculo='EFETIVO' ORDER BY p.nome ASC") })
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "categoria", length = 15)
	private String categoria;

	@Column(name = "nome", length = 200)
	private String nome;

	@Column(name = "matricula", length = 15)
	private String matricula;

	@Column(name = "situacao", length = 10)
	private String situacao;

	@Column(name = "nome_social", length = 100)
	private String nomeSocial;

	@Email
	@Column(name = "email", length = 100)
	private String email;

	@Column(name = "gsuite_exclusivo")
	private boolean gsuiteExclusivo;

	@Email
	@Column(name = "email2", length = 100)
	private String email2;

	@Email
	@Column(name = "email_emergencia", length = 100)
	private String contatoEmergenciaEmail;

	@RG
	@Column(name = "rg", length = 15)
	private String rg;

	@Column(name = "orgao_expedidor", length = 20)
	private String orgaoExpedidor;

//	@Temporal(TemporalType.DATE)
//	@Column(name = "rg_data_expedicao")
//	private Date rgDataExpedicao;

	@Column(name = "rg_uf", length = 10)
	private String rgUF;

	@Column(name = "telefone", length = 20)
	private String telefone;

	@Column(name = "celular", length = 20)
	private String celular;

	@Column(name = "contato_emergencia_tipo", length = 30)
	private String contatoEmergenciaTipo;

	@Column(name = "contato_emergencia_nome", length = 200)
	private String contatoEmergenciaNome;

	@Column(name = "contato_emergencia_telefone", length = 20)
	private String contatoEmergenciaTelefone;

	@Column(name = "contato_emergencia_celular", length = 20)
	private String contatoEmergenciaCelular;

	@Column(name = "sexo", length = 1)
	private String sexo;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Column(name = "estado_civil", length = 15)
	private String estadoCivil;

	@Column(name = "pis_pasep", length = 30)
	private String pisPasep;

	@Column(name = "nis_nit", length = 30)
	private String nisNit;

	@Enumerated(EnumType.STRING)
	@Column(name = "vinculo")
	private VinculoServidor vinculo;

	@Column(name = "observacoes", length = 1000)
	private String observacoes;

	@Column(columnDefinition = "text")
	private String foto;

	@Column(name = "endereco_rua", length = 200)
	private String rua;

	@Column(name = "endereco_numero", length = 10)
	private String numero;

	@Column(name = "endereco_complemento", length = 200)
	private String complemento;

	@Column(name = "endereco_bairro", length = 50)
	private String bairro;

	@Enumerated(EnumType.STRING)
	@Column(name = "endereco_estado")
	private Estados estado;

	@Column(name = "endereco_cidade", length = 70)
	private String cidade;

	@Column(name = "endereco_cep", length = 10)
	private String cep;

	@Column(name = "nacionalidade", length = 40)
	private String nacionalidade;

	@Column(name = "naturalidade", length = 70)
	private String naturalidade;

	@Column(name = "municipio_residencia", length = 70)
	private String municipioResidencia;

	@Column(name = "estado_origem", length = 70)
	private String estadoOrigem;

	@Column(name = "pais_origem", length = 70)
	private String paisOrigem;

	@Column(name = "cidade_origem", length = 70)
	private String cidadeOrigem;

//	@Column(name = "estado_residencia", length = 70)
//	private String estadoResidencia;

//	@Column(name = "profissional_escolaridade", length = 50)
//	private String profissionalEscolaridade;

	@Column(name = "profissional_setor", length = 50)
	private String profissionalSetor;

	@Column(name = "profissional_formacao", length = 50)
	private String profissionalFormacao;

	@Column(name = "profissional_cargo", length = 50)
	private String profissionalCargo;

	@Column(name = "profissional_funcao", length = 50)
	private String profissionalFuncao;

	@Column(name = "profissional_campus_lotacao", length = 50)
	private String profissionalCampusLotacao;

	@Column(name = "deficiencia", length = 100)
	private boolean deficiencia;

	@Column(name = "regime_trabalho")
	private String regimeTrabalho;

//	@Column(name = "setor")
//	private String setor;

	@Temporal(TemporalType.DATE)
	@Column(name = "profissional_data_admissao")
	private Date profissionalDataAdmissao;

	@Temporal(TemporalType.DATE)
	@Column(name = "profissional_data_final_contrato")
	private Date profissionalDataFinalContrato;

	@Temporal(TemporalType.DATE)
	@Column(name = "profissional_data_desligamento")
	private Date profissionalDataDesligamento;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_ultima_atualizacao")
	private Date dataUltimaAtualizacao;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_cadastro")
	private Date dataCadastro;

	@Column(name = "usuario")
	private String usuario;

	public Pessoa() {
		this.setGsuiteExclusivo(false);
		this.setDeficiencia(false);
	}
}