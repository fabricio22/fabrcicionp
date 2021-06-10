package br.com.fabricionp.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fabricionp.domain.Cliente;
import br.com.fabricionp.repositories.ClienteRepository;
import br.com.fabricionp.services.ClienteService;
import br.com.fabricionp.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository ClienteRepository;

	@Override
	public Cliente buscar(Integer id) {

		Optional<Cliente> clienteOptional = ClienteRepository.findById(id);

		if (!clienteOptional.isPresent()) {
			throw new ObjectNotFoundException(
					"Cliente não localizado com o código " + id + " Tipo: " + Cliente.class.getName());
		}

		return clienteOptional.get();
	}

}
