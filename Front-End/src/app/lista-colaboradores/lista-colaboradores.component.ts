import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Colaborador } from '../model/Colaborador';
import { ColaboradorService } from '../service/colaborador.service';

@Component({
  selector: 'app-lista-colaboradores',
  templateUrl: './lista-colaboradores.component.html',
  styleUrls: ['./lista-colaboradores.component.css']
})
export class ListaColaboradoresComponent implements OnInit {

  listaColaboradores: Colaborador[]
  nomeColaborador: string


  constructor(
    private colaboradorservice: ColaboradorService,
    private router: Router
  ) { }

  ngOnInit() {

    window.scroll (0,0)
    
    this.findAllColaboradores()
  }

  findAllColaboradores(){
    this.colaboradorservice.getAllColaboradores().subscribe((resp: Colaborador[]) =>{
      this.listaColaboradores = resp
    })
  }

  findColaboradorPorNome(){
    this.colaboradorservice.getColaboradorbyNome(this.nomeColaborador).subscribe((resp:Colaborador[]) =>{
      this.listaColaboradores = resp
    })
  }


}
