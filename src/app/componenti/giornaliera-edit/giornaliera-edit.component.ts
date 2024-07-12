import { Component } from '@angular/core';
import { GiornalieraServiceService } from '../../service/giornaliera-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { GiornalieraDto } from '../../models/giornaliera-dto';

@Component({
  selector: 'app-giornaliera-edit',
  templateUrl: './giornaliera-edit.component.html',
  styleUrl: './giornaliera-edit.component.css'
})
export class GiornalieraEditComponent {

  currentGiornaliera!: GiornalieraDto;
  message = '';
  idGiornaliera: number = 0;
  

  constructor(
    private giornalieraService: GiornalieraServiceService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit() {
    this.route.queryParams.subscribe({
      next: (params) => {
        if(params['idGiornaliera']) {
          this.idGiornaliera = JSON.parse(params['idGiornaliera']);
          this.giornalieraService.get(this.idGiornaliera).subscribe({
            next: (data) => {
              this.currentGiornaliera = data;
            },
            error: (e) => {
              console.error(e.message);
            }
          })
        }
      },
      error: (e) => {
        console.error(e.message);
      }
    })
    this.message = '';
  }


  // getGiornaliera(id:number) {
  //   this.giornalieraService.get(id)
  //     .subscribe(
  //       data => {
  //         this.currentGiornaliera = data;
  //         console.log(data);
  //       },
  //       error => {
  //         console.log(error);
  //       });
  // }



  updateGiornaliera() {
    console.log(this.idGiornaliera);
    this.giornalieraService.update(this.idGiornaliera, this.currentGiornaliera)
    .subscribe(
        (        response: any) => {
          console.log(response);
          this.message = 'The tutorial was updated successfully!';
          this.router.navigate(['/giornaliera'])
        },
        (        error: any) => {
          console.log(error);
        });
}

}
