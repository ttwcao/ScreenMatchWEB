package br.com.alura.screenmatch.controller;

import br.com.alura.screenmatch.dto.EpisodioDTO;
import br.com.alura.screenmatch.dto.SerieDTO;
import br.com.alura.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//endpoints

//anotação para indicar que a classe é gerenciada pelo spring como controlador
@RestController
@RequestMapping("/series")
public class SerieController {

    //injetar o repository diretamente
    @Autowired
    private SerieService service;

    //mapear o diretório "/series" para utilizar com o método obterSeries
    @GetMapping

    //método para buscar os dados
    public List<SerieDTO> obterSeries() {
        return service.obterTodasAsSeries();
    }

    @GetMapping("/top5")
    public List<SerieDTO> obterTop5Series(){
        return service.obterTop5Series();
    }

    @GetMapping("/lancamentos")
    public List<SerieDTO> obterLancamentos(){
        return service.obterLancamentos();
    }

    @GetMapping("/{id}")
    public  SerieDTO obterPorId(@PathVariable Long id){
        return service.obterPorId(id);
    }

    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDTO> obterTodasTemporadas(@PathVariable Long id){
            return service.obterTodasTemporadas(id);
    }

    @GetMapping("/{id}/temporadas/{numero}")
    public List<EpisodioDTO> obterTemporadasPorNumero(@PathVariable Long id, @PathVariable Long numero){
        return service.obterTemporadasPorNumero(id, numero);
    }


    @GetMapping("/categoria/{generoCategoria}")
    public List<SerieDTO> obterSeriePorCategoria(@PathVariable String generoCategoria){
        return service.obterSeriePorCategoria(generoCategoria);
    }


    //se quiser adicionar outro diretório, basta mapear
//    @GetMapping("/inicio")
//    public String retornarInicio() {
//        return "Bem-vindo ao screen match";
//    }

}


