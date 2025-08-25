import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

interface Movie {
  title: string;
  genre: string;
  rating: number;
  image: string;
}

@Component({
  selector: 'app-movie-list',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent {
  genres: string[] = ['All', 'Comedy', 'Horror', 'Love', 'Action-Drama'];
  selectedGenre: string = 'All';

  movies: Movie[] = [
    {
      title: 'Sita Ramam',
      genre: 'Love',
      rating: 4.5,
      image: 'https://assets-in.bmscdn.com/discovery-catalog/events/et00329656-jsszpmwnqt-landscape.jpg'
    },
    {
      title: 'The Scary Film',
      genre: 'Horror',
      rating: 4.0,
      image: 'https://t4.ftcdn.net/jpg/08/23/87/77/360_F_823877778_or3Cy0AYyslEpsSCu4E0Ze1mNgkQnRuf.jpg'
    },
    {
      title: 'RRR',
      genre: 'Action-Drama',
      rating: 4.7,
      image: 'https://multilingual.com/wp-content/uploads/2022/06/RRR-Movie-Review_1648825470847_1648825479894.jpg'
    },
    {
      title: 'MAD',
      genre: 'Comedy',
      rating: 4.3,
      image: 'https://assets-in.bmscdn.com/discovery-catalog/events/et00370942-wlwqftxzjr-landscape.jpg'
    }
  ];

  get filteredMovies() {
    if (this.selectedGenre === 'All') {
      return this.movies;
    }
    return this.movies.filter(movie => movie.genre === this.selectedGenre);
  }

  getAverageRating(): number {
    if (this.filteredMovies.length === 0) return 0;
    const total = this.filteredMovies.reduce((sum, movie) => sum + movie.rating, 0);
    return total / this.filteredMovies.length;
  }
}