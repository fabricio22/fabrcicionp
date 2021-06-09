package br.com.fabricionp.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa F�sica"), PESSOAJURIDICA(2, "Pessoa Juridica");

	private int codigo;
	private String descricao;

	private TipoCliente(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer codigo) {
		if (null == codigo) {
			return null;
		}

		for (TipoCliente tipocliente : TipoCliente.values()) {
			if (codigo.equals(tipocliente.getCodigo())) {
				return tipocliente;
			}
		}

		throw new IllegalArgumentException("Id Inv�lido: " + codigo);
	}

}
