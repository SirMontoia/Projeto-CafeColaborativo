import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Colaborador } from '../model/Colaborador';
import { ColaboradorService } from '../service/colaborador.service';

@Component({
  selector: 'app-inicial',
  templateUrl: './inicial.component.html',
  styleUrls: ['./inicial.component.css']
})
export class InicialComponent implements OnInit {


  cadastroColaborador : Colaborador = new Colaborador
  tipoUsuario : string

  constructor(
    private colaboradorservice: ColaboradorService,
    private router: Router
  ) { }

  ngOnInit() {
  
    window.scroll (0,0)
  }


  cadastrar(){
    this.colaboradorservice.cadastrar(this.cadastroColaborador).subscribe((resp: Colaborador) =>{
      this.cadastroColaborador = resp
      this.router.navigate (['/lista'])
      alert ('colaborador cadastrado com sucesso!')
    }, erro =>{
      if(erro.status == 400){
        alert('Há algum erro, digite novamente! Certifique-se que seu cpf e sua opcão ainda não foram cadastrados!')
      }
    })
  }

  teste(){
    console.log("user" + JSON.stringify(this.cadastroColaborador))
  }

}
