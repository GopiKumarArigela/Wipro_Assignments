import { Component } from '@angular/core';
import { FeedbackComponent } from './feedback/feedback.component';

@Component({
  selector: 'app-root',
  imports: [FeedbackComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Feedback';
}