import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Colaborador } from '../model/Colaborador';
import { ColaboradorService } from '../service/colaborador.service';

@Component({
  selector: 'app-delete',
  templateUrl: './delete.component.html',
  styleUrls: ['./delete.component.css']
})
export class DeleteComponent implements OnInit {

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

  deletarColaborador(){
    this.service.deletarColaborador(this.idColaborador).subscribe(() =>{
      alert ('Colaborador apagado com sucesso!')
      this.router.navigate (['/lista'])
    })
  }

  teste(){
    console.log("user" + JSON.stringify(this.colaborador))
  }

}
  


