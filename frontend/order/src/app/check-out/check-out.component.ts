import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { ProcessService } from '../process.service';
import { OrderProcess } from '../process.model';

@Component({
  selector: 'app-check-out',
  templateUrl: './check-out.component.html',
  styleUrls: ['./check-out.component.css']
})
export class CheckOutComponent implements OnInit {

  private checkOutId: String;
  constructor(private route: ActivatedRoute, private router: Router, private processService: ProcessService) { }

  ngOnInit() {
    const checkOutId = this.route.snapshot.paramMap.get('checkOutId');
    this.processService.init(checkOutId).subscribe(orderProcess => console.log(orderProcess));
  }

  setProcessRoute(orderProcess: OrderProcess) {
    const currentTask: String = orderProcess.taskDefinitionKey;
    console.log('Navigating to ' + '/' + currentTask);
    this.router.navigate(['/' + currentTask]);
  }
}
