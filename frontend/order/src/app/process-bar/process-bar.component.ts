import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { ProcessService } from '../process.service';

@Component({
  selector: 'app-process-bar',
  templateUrl: './process-bar.component.html',
  styleUrls: ['./process-bar.component.css']
})
export class ProcessBarComponent implements OnInit {

  private checkOutId: String;
  constructor(private route: ActivatedRoute, private processService: ProcessService) { }

  ngOnInit() {
    this.checkOutId = this.route.snapshot.paramMap.get('checkOutId');
  }

}
