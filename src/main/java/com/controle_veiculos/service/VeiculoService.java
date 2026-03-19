package com.controle_veiculos.service;

import com.controle_veiculos.model.Veiculo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoService {
    private List<Veiculo> veiculos;

    public VeiculoService(){
        this.veiculos = new ArrayList<>();
    }

    public Veiculo cadastrarVeiculo(Veiculo veiculo){
        this.veiculos.add(veiculo);
        return veiculo;
    }

    public List<Veiculo> listarTodos(){
        return this.veiculos;
    }

    public Veiculo listarPorId(String id){
        for (Veiculo veiculo : veiculos){
            if(veiculo.getId().equals(id)){
                return veiculo;
            }
        } throw new IllegalArgumentException("Veiculo não encontrado");
    }

    public List<Veiculo> listarPorMarca(String marca){
        List<Veiculo> veiculosPorMarca = new ArrayList<>();
        for (Veiculo veiculo : veiculos){
            if(veiculo.getMarca().toLowerCase().equals(marca.toLowerCase())){
                veiculosPorMarca.add(veiculo);
            }
        }
        return veiculosPorMarca;
    }

    public List<Veiculo> veiculoPorAno(int ano){
        List<Veiculo> veiculosPorAno = new ArrayList<>();
        for(Veiculo veiculo : veiculos){
            if(veiculo.getAno() >= ano){
                veiculosPorAno.add(veiculo);
            }
        }
        return veiculosPorAno;
    }

    public Veiculo atualizarVeiculo(String id, Veiculo veiculo){
        Veiculo veiculoAtualizado = listarPorId(id);
        veiculoAtualizado.setPlaca(veiculo.getPlaca());
        veiculoAtualizado.setMarca(veiculo.getMarca());
        veiculoAtualizado.setModelo(veiculo.getModelo());
        veiculoAtualizado.setAno(veiculo.getAno());
        veiculoAtualizado.setValorDiario(veiculo.getValorDiario());
        return veiculoAtualizado;
    }

    public void deletarVeiculo(String id){
        Veiculo veiculoDeletado = listarPorId(id);
        this.veiculos.remove(veiculoDeletado);
    }
}

