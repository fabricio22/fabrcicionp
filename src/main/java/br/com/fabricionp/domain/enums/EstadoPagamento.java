package br.com.fabricionp.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1, "PENDENTE"), QUITADO(2, "QUITADO"), CANCELADO(3, "CANCELADO");

	private Integer codigo;
	private String descricao;

	private EstadoPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EstadoPagamento toEnum(Integer codigo) {
		if (null == codigo) {
			return null;
		}

		for (EstadoPagamento pagamento : EstadoPagamento.values()) {
			if (pagamento.getCodigo().equals(codigo)) {
				return pagamento;
			}
		}

		throw new IllegalArgumentException("Código de Pagamento inválido. " + codigo);
	}

}
