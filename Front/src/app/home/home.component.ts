import { Component, inject, OnInit } from '@angular/core';
import { ContactService } from '../Service/contact.service';
import { RouterModule } from '@angular/router';
import { contact } from '../Model/Contact.interface';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export   class HomeComponent implements OnInit{

  private contactservise = inject(ContactService);

  contacts: contact[] = [];

  ngOnInit(): void {
    this.loadAll();
  }
  loadAll(){
    this.contactservise.list()
    .subscribe(contacts =>
      {
        this.contacts = contacts;
      });
  }
  delete(contact:contact){
    this.contactservise.delete(contact.id).subscribe(()=>{
      this.loadAll();
    })
  }
}
