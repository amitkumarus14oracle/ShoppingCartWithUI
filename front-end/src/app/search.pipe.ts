import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(details: any, term: any): any {
   if(term===undefined) return details;

   return details.filter(detail=>detail.name.toLowerCase().includes(term.toLowerCase()));
  }

}
