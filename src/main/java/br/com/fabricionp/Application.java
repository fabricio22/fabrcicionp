package br.com.fabricionp;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.fabricionp.domain.Categoria;
import br.com.fabricionp.domain.Cidade;
import br.com.fabricionp.domain.Cliente;
import br.com.fabricionp.domain.Endereco;
import br.com.fabricionp.domain.Estado;
import br.com.fabricionp.domain.Pagamento;
import br.com.fabricionp.domain.PagamentoComBoleto;
import br.com.fabricionp.domain.PagamentoComCartao;
import br.com.fabricionp.domain.Pedido;
import br.com.fabricionp.domain.Produto;
import br.com.fabricionp.domain.enums.EstadoPagamento;
import br.com.fabricionp.domain.enums.TipoCliente;
import br.com.fabricionp.repositories.CategoriaRepository;
import br.com.fabricionp.repositories.CidadeRepository;
import br.com.fabricionp.repositories.ClienteRepository;
import br.com.fabricionp.repositories.EnderecoRepository;
import br.com.fabricionp.repositories.EstadoRepositoy;
import br.com.fabricionp.repositories.PagamentoRepository;
import br.com.fabricionp.repositories.PedidoRepository;
import br.com.fabricionp.repositories.ProdutoRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private EstadoRepositoy estadoRepositoy;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);

		// Associações entre categoria e produtos
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado estado = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlandia", estado);
		Cidade c2 = new Cidade(null, "São Paulo", estado2);
		Cidade c3 = new Cidade(null, "Campinas", estado2);

		estado.getCidades().addAll(Arrays.asList(c1));
		estado2.getCidades().addAll(Arrays.asList(c2, c3));

		estadoRepositoy.saveAll(Arrays.asList(estado, estado2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		Cliente cli1 = new Cliente(null, "Fabrício", "fabricio@email.com.br", "35185951899", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("123456789", "647839304"));

		Endereco e1 = new Endereco(null, "Rua Flores", "34", "Apto 303", "Jardim", "08823130", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Matos", "002", null, "Amazonia", "4935303", cli1, c2);

		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));

		clienteRepository.save(cli1);
		enderecoRepository.saveAll(Arrays.asList(e1, e2));

		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		Pedido ped1 = new Pedido(null, simpleDate.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, simpleDate.parse("10/10/2017 19:35"), cli1, e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, simpleDate.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		 
	}
}
