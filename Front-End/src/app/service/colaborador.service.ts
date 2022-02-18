import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Colaborador } from '../model/Colaborador';

@Injectable({
  providedIn: 'root'
})
export class ColaboradorService {

  constructor(

    private http: HttpClient


  ) { }


    getColaboradorbyId(id: number): Observable<Colaborador> {
      return this.http.get<Colaborador>(`https://cafecolab.herokuapp.com/testecafe/colaborador/pegarid/${id}`)
    }
    
    getAllColaboradores(): Observable<Colaborador[]>{
      return this.http.get<Colaborador[]>('https://cafecolab.herokuapp.com/testecafe/colaborador/todescolaboradores')
    }

    getColaboradorbyNome (nome: string): Observable <Colaborador[]> {

      return this.http.get<Colaborador[]> (`https://cafecolab.herokuapp.com/testecafe/colaborador/pegarcolaborador/${nome}`)

    }

    cadastrar(colaborador: Colaborador): Observable<Colaborador>{
    return this.http.post<Colaborador> ('https://cafecolab.herokuapp.com/testecafe/colaborador/salvar', colaborador)
  }

  


  atualizarColaborador(colaborador: Colaborador): Observable<Colaborador>{

    return this.http.put<Colaborador>('https://cafecolab.herokuapp.com/testecafe/colaborador/atualizar', colaborador)
  }

  deletarColaborador(id: number){
    return this.http.delete(`https://cafecolab.herokuapp.com/testecafe/colaborador/deletar/${id}`)
  }




}

