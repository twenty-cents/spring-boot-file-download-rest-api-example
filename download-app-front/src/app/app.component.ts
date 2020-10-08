import { Component } from '@angular/core';
import { FileService } from './services/file.service';
import * as fileSaver from 'file-saver';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Angular File Download';
  
  constructor(private fileService: FileService) {}
  
  download() {
    this.fileService.downloadFile().subscribe(response => {
			let blob:any = new Blob([response], { type: 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet; charset=utf-8' });
			const url = window.URL.createObjectURL(blob);
			//window.open(url);
			//window.location.href = response.url;
      
      fileSaver.saveAs(blob, 'report.xlsx');
		}), error => console.log('Error downloading the file'),
                 () => console.info('File downloaded successfully');
  }
  
}