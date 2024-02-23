package com.yashasvi.movieApi.service;

import com.yashasvi.movieApi.dto.MovieDto;
import com.yashasvi.movieApi.dto.MoviePageResponse;
import com.yashasvi.movieApi.entities.Movie;
import com.yashasvi.movieApi.exceptions.FileExistsException;
import com.yashasvi.movieApi.exceptions.MovieNotFoundException;
import com.yashasvi.movieApi.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private final FileService fileService;

    @Value("${project.poster}")
    private String path;

    public MovieServiceImpl(MovieRepository movieRepository, FileService fileService) {
        this.movieRepository = movieRepository;
        this.fileService = fileService;
    }


    @Override
    public MovieDto addMovie(MovieDto movieDto, MultipartFile file) throws IOException {

        if (Files.exists(Paths.get(path + File.separator + file.getOriginalFilename()))) {
            throw new FileExistsException("file already exists! please enter another file name");
        }

        // 1. upload the file

        String uploadedFileName = fileService.uploadFile(path, file);

        // 2. set the value of field poster as fileName
        movieDto.setPoster(uploadedFileName);

        // 3. map dto to movie object
        Movie movie = new Movie(
                null,
                movieDto.getTitle(),
                movieDto.getDirector(),
                movieDto.getStudio(),
                movieDto.getMovieCast(),
                movieDto.getReleaseYear(),
                movieDto.getPoster()
        );

        // 4. save the movie object
        Movie savedMovie = movieRepository.save(movie);

        // 5. generate the poster url
        String posterUrl = "http://localhost:8080/file/" + uploadedFileName;

        // 6. map movie object to dto object and return it
        MovieDto response = new MovieDto(
                savedMovie.getMovieId(),
                savedMovie.getTitle(),
                savedMovie.getDirector(),
                savedMovie.getStudio(),
                savedMovie.getMovieCast(),
                savedMovie.getReleaseYear(),
                savedMovie.getPoster(),
                posterUrl
        );
        return response;
    }

    @Override
    public MovieDto getMovie(Integer movieId) {

        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie not found with id =" + movieId));
        String posterUrl = "http://localhost:8080/file/" + movie.getPoster();

        MovieDto response = new MovieDto(
                movie.getMovieId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getStudio(),
                movie.getMovieCast(),
                movie.getReleaseYear(),
                movie.getPoster(),
                posterUrl
        );
        return response;
    }

    @Override
    public List<MovieDto> getAllMovies() {
        List<Movie> movie = movieRepository.findAll();

        List<MovieDto> movieDtos = new ArrayList<>();

        for (Movie movie1 : movie) {
            String posterUrl = "http://localhost:8080/file/" + movie1.getPoster();
            MovieDto movieDto = new MovieDto(
                    movie1.getMovieId(),
                    movie1.getTitle(),
                    movie1.getDirector(),
                    movie1.getStudio(),
                    movie1.getMovieCast(),
                    movie1.getReleaseYear(),
                    movie1.getPoster(),
                    posterUrl
            );
            movieDtos.add(movieDto);
        }
        return movieDtos;
    }

    @Override
    public MovieDto updateMovie(Integer movieId, MovieDto movieDto, MultipartFile file) throws IOException {
        Movie mv = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie not found with id =" + movieId));

        String fileName = mv.getPoster();
        if (file != null) {
            Files.deleteIfExists(Paths.get("http://localhost:8080/file/" + File.separator + fileName));
            fileName = fileService.uploadFile(path, file);
        }

        movieDto.setPoster(fileName);

        Movie movie = new Movie(
                mv.getMovieId(),
                movieDto.getTitle(),
                movieDto.getDirector(),
                movieDto.getStudio(),
                movieDto.getMovieCast(),
                movieDto.getReleaseYear(),
                movieDto.getPoster()
        );

        Movie upDatedMovie = movieRepository.save(movie);

        String posterUrl = "http://localhost:8080/file/" + fileName;

        MovieDto response = new MovieDto(
                movie.getMovieId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getStudio(),
                movie.getMovieCast(),
                movie.getReleaseYear(),
                movie.getPoster(),
                posterUrl
        );
        return response;
    }

    @Override
    public String deleteMovie(Integer movieId) throws IOException {
        Movie mv = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie not found with id =" + movieId));

        Integer id = mv.getMovieId();
        Files.deleteIfExists(Paths.get(path + File.separator + mv.getPoster()));

        movieRepository.delete(mv);
        return "Movie deleted with id = " + id;
    }

    @Override
    public MoviePageResponse getAllMoviesWithPagination(Integer pageNumber, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);

        Page<Movie> moviePages = movieRepository.findAll(pageable);
        List<Movie> movies = moviePages.getContent();

        List<MovieDto> movieDtos = new ArrayList<>();

        for (Movie movie1 : movies) {
            String posterUrl = "http://localhost:8080/file/" + movie1.getPoster();
            MovieDto movieDto = new MovieDto(
                    movie1.getMovieId(),
                    movie1.getTitle(),
                    movie1.getDirector(),
                    movie1.getStudio(),
                    movie1.getMovieCast(),
                    movie1.getReleaseYear(),
                    movie1.getPoster(),
                    posterUrl
            );
            movieDtos.add(movieDto);
        }
        return new MoviePageResponse(movieDtos, pageNumber, pageSize,(int) moviePages.getTotalElements(), moviePages.getTotalPages(),  moviePages.isLast());
    }

    @Override
    public MoviePageResponse getAllMoviesWithPaginationAndSorting(Integer pageNumber, Integer pageSize, String sortBy, String dir) {

        Sort sort = dir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);

        Page<Movie> moviePages = movieRepository.findAll(pageable);
        List<Movie> movies = moviePages.getContent();

        List<MovieDto> movieDtos = new ArrayList<>();

        for (Movie movie1 : movies) {
            String posterUrl = "http://localhost:8080/file/" + movie1.getPoster();
            MovieDto movieDto = new MovieDto(
                    movie1.getMovieId(),
                    movie1.getTitle(),
                    movie1.getDirector(),
                    movie1.getStudio(),
                    movie1.getMovieCast(),
                    movie1.getReleaseYear(),
                    movie1.getPoster(),
                    posterUrl
            );
            movieDtos.add(movieDto);
        }
        return new MoviePageResponse(movieDtos, pageNumber, pageSize,  (int) moviePages.getTotalElements(),moviePages.getTotalPages(), moviePages.isLast());
    }
}
