import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Colaborador } from '../model/Colaborador';
import { ColaboradorService } from '../service/colaborador.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  colaborador: Colaborador = new Colaborador()
  idColaborador :number

  constructor(
  private router: Router,
  private route: ActivatedRoute,
  private service: ColaboradorService
  ) { }
  
  ngOnInit() {
    window.scroll(0,0)

    this.idColaborador = this.route.snapshot.params['id']
    this.findColaboradorById(this.idColaborador)
    


  }

  findColaboradorById(id:number){
    this.service.getColaboradorbyId(id).subscribe((resp: Colaborador) =>{
      this.colaborador = resp
    })
  }

  atualizar(){
    this.service.atualizarColaborador(this.colaborador).subscribe((resp: Colaborador) =>{
      this.colaborador = resp
      this.router.navigate (['/lista'])
      alert ('colaborador atualizado com sucesso!')
    }, erro =>{
      if(erro.status == 400){
        alert('Há algum erro, digite novamente! Certifique-se que o cpf é valido!')
      }
    })
  }

  teste(){
    console.log("user" + JSON.stringify(this.colaborador))
  }

}

  




