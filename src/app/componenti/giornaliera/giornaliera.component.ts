import { Component } from '@angular/core';
import { GiornalieraServiceService } from '../../service/giornaliera-service.service';
import { GiornalieraDto } from '../../models/giornaliera-dto';
import { Router } from '@angular/router';






@Component({
  selector: 'app-giornaliera',
  templateUrl: './giornaliera.component.html',
  styleUrl: './giornaliera.component.css'
})
export class GiornalieraComponent {
  giornaliere!: GiornalieraDto[];
  currentGiornaliera = null;
  username= "";

  clickCount: number = 0;
  timerId: any = null;

  constructor(private giornalieraService: GiornalieraServiceService, private route: Router
  ){}

  ngOnInit(){
    this.findByUsername();
   
  }

  incrementCount(): void {
    this.clickCount--;
  }

  decrementCount(): void {
    this.clickCount++;
  }

  findByUsername(){
    this.giornalieraService.findUsername(sessionStorage.getItem('Utente')!, this.clickCount)
    .subscribe(
      (data : GiornalieraDto[]) => {
        this.giornaliere = data;
        console.log(data);
      },
      error => {console.log(error)

      });
  }


  navigateTo(idGiornaliera: number) {
    this.route.navigate(['/giornalieraEdit'], { queryParams: {
      idGiornaliera: JSON.stringify(idGiornaliera)
    }});
  }


  onEditClicked(id: number){
    this.route.navigate(['/giornalieraEdit'], {})

  }
 
  // onRowClick(item: GiornalieraDto) {
  //   this.id = item.id;
  //   this.giornalieraEdit.updateGiornaliera();

  // }

  










  // incrementEvent(){
  //   setTimeout(() => {
  //   this.incrementCount();
  //   this.findByUsername();
  // }, 1000);
  // }

  incrementEvent(){
    this.incrementCount();
    this.findByUsername();
  }

  decrementEvent(){
    this.decrementCount();
    this.findByUsername();
  }
  }

  
  // ngOnDestroy(): void {
  //   // Cancella il timer se il componente viene distrutto
  //   if (this.timerId) {
  //     clearTimeout(this.timerId);
  //   }
  // }
 


