package com.controle_veiculos.controller;

import com.controle_veiculos.model.Veiculo;
import com.controle_veiculos.service.VeiculoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
    private VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService){
        this.veiculoService = veiculoService;
    }

    @PostMapping
    public ResponseEntity<Veiculo> cadastrarVeiculo(@RequestBody Veiculo veiculo){
        veiculoService.cadastrarVeiculo(veiculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculo);
    }

    @GetMapping
    public ResponseEntity<List<Veiculo>> listarTodos(@RequestParam(required = false)String marca){
        if(marca != null){
            List<Veiculo> veiculoPorMarca = veiculoService.listarPorMarca(marca);
            return ResponseEntity.status(HttpStatus.OK).body(veiculoPorMarca);
        } else {
            List<Veiculo> veiculos = veiculoService.listarTodos();
            return ResponseEntity.status(HttpStatus.OK).body(veiculos);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> listarPorId(@PathVariable String id){
        try {
            Veiculo listarPorId = veiculoService.listarPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(listarPorId);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/ano/{ano}")
    public ResponseEntity<List<Veiculo>> listarPorAno(@PathVariable int ano){
        try {
            List<Veiculo> veiculoPorAno = veiculoService.veiculoPorAno(ano);
            return ResponseEntity.status(HttpStatus.OK).body(veiculoPorAno);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable String id, @RequestBody Veiculo veiculo){
        try {
            Veiculo veiculoAtualizado =veiculoService.atualizarVeiculo(id, veiculo);
            return ResponseEntity.status(HttpStatus.OK).body(veiculoAtualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable String id){
        try {
            veiculoService.deletarVeiculo(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
