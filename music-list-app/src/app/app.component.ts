import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

// Angular Material Modules
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatInputModule } from '@angular/material/input';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';

interface Song {
  id: number;
  name: string;
  artist: string;
  album: string;
  duration: string;
  rating: number;
  language: string;
  image: string;
}

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    MatToolbarModule,
    MatIconModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    MatCardModule,
    MatButtonModule
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Music Playlist App';


  songs: Song[] = [
    { id: 1, name: 'Hey Rangule', artist: 'Anurag Kulkarni and Ramya Behara', album: 'Amaran', duration: '4:00', rating: 4.6, language: 'Telugu', image: 'assets/music/Amaran.jpg' },
    { id: 2, name: 'Megham Karigena', artist: ' Anudeep Dev, Anirudh Ravichander, Krishna Kanth', album: 'Thiru', duration: '4:48', rating: 4.7, language: 'Telugu', image: 'assets/music/Thiru.jpg' },
    { id: 3, name: 'Na Gundello', artist: 'Yazin Nizar and Nikhita Gandhi', album: 'Majili', duration: '4:30', rating: 4.5, language: 'Telugu', image: 'assets/music/Majili.jpeg' },
    { id: 4, name: 'Nuv Navvukuntu', artist: ' Kapil Kapilan', album: 'MAD', duration: '4:28', rating: 4.4, language: 'Telugu', image: 'assets/music/MAD.jpg' }
  ];


  selectedArtist: string = '';
  selectedAlbum: string = '';


  get artists() {
    return [...new Set(this.songs.map(s => s.artist))];
  }


  get albums() {
    return [...new Set(this.songs.map(s => s.album))];
  }


  get filteredSongs() {
    return this.songs.filter(song => {
      return (
        (!this.selectedArtist || song.artist === this.selectedArtist) &&
        (!this.selectedAlbum || song.album === this.selectedAlbum)

      );
    });
  }




  isTopRated(rating: number): boolean {
    return rating >= 4.5;
  }
}
