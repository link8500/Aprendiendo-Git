import { Component, inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ContactService } from '../Service/contact.service';
import { contact } from '../Model/Contact.interface';

@Component({
  selector: 'app-empleados-new',
  standalone: true,
  imports: [RouterModule, ReactiveFormsModule],
  templateUrl: './empleados-new.component.html',
  styleUrl: './empleados-new.component.css'
})
export class EmpleadosNewComponent implements OnInit {
  private fr = inject(FormBuilder);
  private ruta = inject(Router);
  private router = inject(ActivatedRoute);
  private contactservice = inject(ContactService);
  form?: FormGroup;
  contact?: contact;
  ngOnInit(): void {
    const id = this.router.snapshot.paramMap.get('id');
    if (id) {
      this.contactservice.get(parseInt(id)).subscribe(contact => {
        this.contact = contact;
        this.form = this.fr.group({
          nombre: [contact.nombre, [Validators.required]],
          apellido: [contact.apellido, [Validators.required]],
          email: [contact.email, [Validators.required]]
        });
      })
    } else {
      this.form = this.fr.group({
        nombre: ['', [Validators.required]],
        apellido: ['', [Validators.required]],
        email: ['', [Validators.required]]
      })
    }
  }
  save() {
    const contactform = this.form!.value;
    if (this.contact) {
      this.contactservice.uptade(this.contact.id, contactform).subscribe(() => {
        this.ruta.navigate(['/']);
      });
    }
    else {
      this.contactservice.create(contactform).subscribe(() => {
        this.ruta.navigate(['/']);
      });
    }
  }

}
