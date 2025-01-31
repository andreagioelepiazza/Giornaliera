import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-jumbotron',
  templateUrl: './jumbotron.component.html',
  styleUrl: './jumbotron.component.css'
})
export class JumbotronComponent {

  @Input ()
  Titolo: string = "";

  @Input()
  SottoTitolo: string = "";

  @Input()
  Show: boolean = true;
}
